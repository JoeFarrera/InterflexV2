package sgalib;
import oracle.jbo.AttributeDef;
import oracle.jbo.StructureDef;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.common.JboTypeMap;
import oracle.jbo.server.ViewCriteriaAdapter;
import oracle.jbo.uicli.controls.JUNavigationBar;

public class SgaViewCriteriaAdapter implements ViewCriteriaAdapter 
{
  public SgaViewCriteriaAdapter()
  {
  }
  
  /*
   * Not a very sophisticated implementation, but you get the idea...
   */
  private void addWhereClauseFragmentForColumn(AttributeDef attr,
                                               String criteria,
                                               boolean atLeastOneCriteriaAlready,
                                               StringBuffer sb) {
     String attributeName = attr.getName();

    if (atLeastOneCriteriaAlready) 
      sb.append(" AND ");
    else
      sb.append("(");
    appendStandardEqualityOrLikeClause(attr,criteria,sb);
  } 
  
  private void appendStandardEqualityOrLikeClause(AttributeDef attr,
                                       String criteria,
                                       StringBuffer sb) {
    try
    {
      StringBuffer lsb = new StringBuffer();
      String columnName = attr.getColumnNameForQuery();
      lsb.append("(").append(columnName).append(" ");
      boolean useLikeQuery = criteria.indexOf('%') >= 0;
      boolean useBetween = criteria.toUpperCase().indexOf("ENTRE") >= 0;
      StringBuffer operator = new StringBuffer();
      // Busquem l'operador 
      int offset = 0;  
      if (useLikeQuery) 
        lsb.append("LIKE ");
      else
      {
        if (useBetween)
        {
           lsb.append(">= ");
        }
        else
        {
          for (int i=0; i < criteria.length(); i++)
            switch(criteria.charAt(i))
            {
              case '=':
              case '<':
              case '>':
              case '!':
                operator.append(criteria.charAt(i));
                offset++;
                break;
              default:
                i = criteria.length();
            }
          if (operator.length() == 0)
            lsb.append("= ");
          else
            lsb.append(operator).append(" ");
        }
      }
  
      boolean isDate = JboTypeMap.isDateType(attr.getSQLType());
      if (isDate)
      {
        if(useBetween)
          {
            int indexIni1 = criteria.indexOf("(");
            int indexFin1 = criteria.indexOf(",");
            int indexFin2 = criteria.indexOf(")");
            lsb.append(" TO_DATE('" + criteria.substring(indexIni1+1, indexFin1) + "','DD/MM/YYYY HH24:MI:SS')");
            lsb.append("  AND ").append(columnName).append(" <= TO_DATE('" + criteria.substring(indexFin1+1, indexFin2) + "','DD/MM/YYYY HH24:MI:SS')");
          }
        else
          lsb.append(" TO_DATE('" + criteria.substring(offset) + "','DD/MM/YYYY HH24:MI:SS')");
        
      }
      else
      {
        boolean isNumber = JboTypeMap.isNumericType(attr.getSQLType());
        if(useBetween)
          {
            int indexIni1 = criteria.indexOf("(");
            int indexFin1 = criteria.indexOf(",");
            int indexFin2 = criteria.indexOf(")");
            if (!isNumber || useLikeQuery) 
              lsb.append("'");          
            lsb.append(criteria.substring(indexIni1+1, indexFin1));
            if (!isNumber || useLikeQuery) 
              lsb.append("'");
            lsb.append("  AND ").append(columnName).append(" <= ");
            if (!isNumber || useLikeQuery) 
              lsb.append("'");          
            lsb.append(criteria.substring(indexFin1+1, indexFin2));
            if (!isNumber || useLikeQuery) 
              lsb.append("'");
          }
        else
        {
          if (!isNumber || useLikeQuery) 
            lsb.append("'");
          lsb.append(criteria.substring(offset));
          if (!isNumber || useLikeQuery) 
            lsb.append("'");
        }
      }
      lsb.append(")");
      sb.append(lsb);
    }
    catch(Exception ex)
    {
      javax.swing.JOptionPane.showConfirmDialog (null, 
        "Filtro " + criteria + " no valido para el atributo " + attr.getName() , 
        "Error", 
        javax.swing.JOptionPane.CANCEL_OPTION,
        javax.swing.JOptionPane.ERROR_MESSAGE);
        sb.append("(").append(attr.getColumnNameForQuery()).append(" = ").append(attr.getColumnNameForQuery()).append(")");
    }
  }

/*
 * Implemeting oracle.jbo.server.ViewCriteriaAdapter
 */
 public String getViewCriteriaClause(ViewObject vo, ViewCriteria vc) 
 {
    StringBuffer sb = new StringBuffer();
    if (vc == null || vc.size() == 0) 
      return null;
    ViewCriteriaRow criteriaRow = (ViewCriteriaRow)vc.first();
    StructureDef def = criteriaRow.getStructureDef(); 
    AttributeDef[] attrs = def.getAttributeDefs();      
    boolean atLeastOneRow = false;
    boolean atLeastOneCriteria = false;
    int attrCount = attrs.length;
    while (criteriaRow != null)
    {
      if (atLeastOneRow)
        sb.append(" OR ");
      for (int j = 0; j < attrCount; j++) {
        String criteria = (String)criteriaRow.getAttribute(j);
        if (criteria != null && !criteria.equals("")) 
        {
          addWhereClauseFragmentForColumn(attrs[j],criteria,atLeastOneCriteria,sb);
          atLeastOneRow = true;
          atLeastOneCriteria = true;
        }
      }
      if (atLeastOneCriteria)
      {
        sb.append(")");
        atLeastOneCriteria = false;
      }
        
      criteriaRow = (ViewCriteriaRow)vc.next();
    }
    System.out.println(sb.toString());
    return sb.toString();
 }


/*  private String adjustStringViewCriteriaToDate(String strWhereClause) 
  { 
    if (strWhereClause != null)
    {
      StringBuffer sb = new StringBuffer(strWhereClause);
      ViewCriteria vc = getViewCriteria();
      if (vc != null) 
      {
        ViewCriteriaRow vcr = (ViewCriteriaRow)vc.first();
        AttributeDef[] attrs = vc.getViewObject().getAttributeDefs();
        int attrCount = attrs.length;
        while (vcr != null) 
        {        
          for (int z = 0; z < attrCount; z++) 
            {          
              if (attrs[z].getSQLType() == Types.DATE) 
                {            
                  String criteria = (String)vcr.getAttribute(z);            
                  if (criteria != null) 
                  { 
                    int indexIni = sb.indexOf("(" + attrs[z].getColumnNameForQuery());
                    boolean trobat = false;
                    while (indexIni != -1 && !trobat)
                    {                      
                      int indexFin = sb.indexOf(")", indexIni);
                      int indexToDate = sb.indexOf("TO_DATE", indexIni);
                      if (indexFin != -1 && (indexToDate == -1 || (indexToDate > indexFin)))
                      {
                        StringBuffer operator = new StringBuffer();
                        int offset = 0;
                        for (int i=0; i < criteria.length(); i++)
                          switch(criteria.charAt(i))
                          {
                            case '=':
                            case '<':
                            case '>':
                            case '!':
                              operator.append(criteria.charAt(i));
                              offset++;
                              break;
                            default:
                              i = criteria.length();
                          }
                        if (operator.length() == 0)
                            operator.append("=");
                        String str = "(" + attrs[z].getColumnNameForQuery() + " " +
                          operator +" TO_DATE('" + criteria.substring(offset) + "','DD/MM/YYYY HH24:MI:SS'))";
                        sb.replace(indexIni, indexFin + 1, str);
                        trobat = true;
                      }
                      indexIni = sb.indexOf("(" + attrs[z].getColumnNameForQuery(), indexFin);  
                    }
                  }
                }
            }
            vcr = (ViewCriteriaRow)vc.next();      
        }   
      }      
        return sb.toString();
    }
    else
      return null;
  
  } */
  
}