package sgalib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractCollection;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import oracle.jdeveloper.layout.VerticalFlowLayout;


/**
 * Implementa un panel amb dos JList que permet efectuar seleccions a partir de 
 * les dos llistes
 */

public class SgaJSelector extends JPanel implements ActionListener
  {
    public static final  int REPARTIR = 1;
    public static final int DIVIDIR = 2;
    public static final int REAGRUPAR = 3;

    ArrayListTransferHandler arrayListHandler;
    private JList listFrom, listTo;
    private JButton afegirSel, eliminarSel, afegirTot, eliminarTot, dividirCant, rejuntarLinia, rejuntarLiniaFromTo;
    private String listFromTitol = "Disponible";
    private String listToTitol = "Seleccionat";
    private int operacio; // Operació a realitzar

    public SgaJSelector(DefaultListModel llistaAfegibles, DefaultListModel llistaOcultables)
    {
      this(llistaAfegibles, llistaOcultables, null, null, REPARTIR);
    }

    public SgaJSelector(DefaultListModel llistaAfegibles, DefaultListModel llistaOcultables, 
          String listFromTitol, String listToTitol, int operacio) 
    {
        if (listFromTitol != null)
          this.listFromTitol = listFromTitol;
        if (listToTitol != null)
          this.listToTitol = listToTitol;
        arrayListHandler = new ArrayListTransferHandler();
        this.operacio = operacio;

        //listFrom = new JList(SgaTableModel.this.getLlistaColumnesAfegibles());
        listFrom = new JList(llistaAfegibles);
        listFrom.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listFrom.setTransferHandler(arrayListHandler);
        listFrom.setDragEnabled(true);
        JScrollPane listFromView = new JScrollPane(listFrom);
        listFromView.setPreferredSize(new Dimension(200, 100));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(listFromView, BorderLayout.CENTER);
        panel1.setBorder(BorderFactory.createTitledBorder(listFromTitol));

        //listTo = new JList(SgaTableModel.this.getLlistaColumnesOcultables());
        listTo = new JList(llistaOcultables);
        listTo.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listTo.setTransferHandler(arrayListHandler);
        listTo.setDragEnabled(true);
        JScrollPane listToView = new JScrollPane(listTo);
        listToView.setPreferredSize(new Dimension(200, 100));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(listToView, BorderLayout.CENTER);
        panel2.setBorder(BorderFactory.createTitledBorder(listToTitol));

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new VerticalFlowLayout(VerticalFlowLayout.MIDDLE));

        afegirTot = new JButton(">>");
        afegirTot.setToolTipText("Afegir tot");
        afegirTot.setActionCommand("afegirTot");
        afegirTot.addActionListener(this);
        afegirSel = new JButton(">");
        afegirSel.setToolTipText("Afegir selecció");
        afegirSel.setActionCommand("afegirSel");
        afegirSel.addActionListener(this);
        eliminarSel = new JButton("<");
        eliminarSel.setToolTipText("Eliminar selecció");
        eliminarSel.setActionCommand("eliminarSel");
        eliminarSel.addActionListener(this);
        eliminarTot = new JButton("<<");
        eliminarTot.setToolTipText("Eliminar tot");
        eliminarTot.setActionCommand("eliminarTot");
        eliminarTot.addActionListener(this);

        dividirCant = new JButton("x >");
        dividirCant.setToolTipText("Dividir línia");
        dividirCant.setActionCommand("dividirCant");
        dividirCant.addActionListener(this);
        
        rejuntarLiniaFromTo = new JButton(">");
        rejuntarLiniaFromTo.setToolTipText("Rejuntar línia");
        rejuntarLiniaFromTo.setActionCommand("rejuntarLiniaFromTo");
        rejuntarLiniaFromTo.addActionListener(this);

        rejuntarLinia = new JButton("<");
        rejuntarLinia.setToolTipText("Rejuntar línia");
        rejuntarLinia.setActionCommand("rejuntarLiniaToFrom");
        rejuntarLinia.addActionListener(this);

        
        switch (operacio) 
        {
         case (REPARTIR):
        {
          panelButtons.add(afegirTot, null);
          panelButtons.add(afegirSel, null);
          panelButtons.add(eliminarSel, null);
          panelButtons.add(eliminarTot, null);
          break;
        }
        case (DIVIDIR):
        {
          panelButtons.add(dividirCant, null);
          // TODO Michael 23.01.2015 panelButtons.add(rejuntarLiniaFromTo);
          panelButtons.add(rejuntarLinia, null);
          break;
        }       
        case (REAGRUPAR): 
        {
          panelButtons.add(rejuntarLiniaFromTo);
          panelButtons.add(rejuntarLinia);
        }
        }

        
        
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.LINE_START);
        add(panelButtons, BorderLayout.CENTER);
        add(panel2, BorderLayout.LINE_END);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    public void actionPerformed(ActionEvent e)
    {
      if (e.getActionCommand().equals("afegirTot"))
        afegirTot();
      else if (e.getActionCommand().equals("afegirSel"))
        afegirSel();
        //eliminarSelCamp(listTo.getSelectedIndex());
      else if (e.getActionCommand().equals("eliminarSel"))
        eliminarSel();
        //eliminarSelCamp(listTo.getSelectedIndex());
      else if (e.getActionCommand().equals("eliminarTot"))
        eliminarTot();
      else if (e.getActionCommand().equals("dividirCant"))
        dividirCant();
       else if (e.getActionCommand().equals("rejuntarLiniaToFrom"))
        rejuntarLiniaToFrom();
       else if (e.getActionCommand().equals("rejuntarLiniaFromTo"))
        rejuntarLiniaFromTo();
       
    }
    
  private void afegirTot()
  {
      Object objFrom;

      int iSize = getFromModel().getSize();
      int iStart = getToModel().getSize();

      for( int i=0; i<iSize; i++ )
      {
          objFrom = getFromModel().getElementAt(0);
          if( !getToModel().contains(objFrom) )
              getToModel().addElement(objFrom);

          getFromModel().removeElementAt(0);
      }

      listFrom.clearSelection();
      if( iSize != 0 )
          listTo.setSelectionInterval(iStart, iStart+iSize-1);
  }

    private void afegirSel()
    {
      Object[] objFrom = listFrom.getSelectedValues();
      
      int iSize = objFrom.length;
      int iStart = getToModel().getSize();
      for( int i=0; i<iSize; i++ )
      {
          if( !getToModel().contains(objFrom[i]) )
              getToModel().addElement(objFrom[i]);

          getFromModel().removeElement(objFrom[i]);
      }

      listFrom.clearSelection();
      if( iSize != 0 )
          listTo.setSelectionInterval(iStart, iStart+iSize-1);
    }

    private void eliminarSel()
    {
      Object[] objTo = listTo.getSelectedValues();

      int iSize = objTo.length;
      int iStart = getFromModel().getSize();
      for( int i=0; i<iSize; i++ )
      {
          if( !getFromModel().contains(objTo[i]) )
              getFromModel().addElement(objTo[i]);

          getToModel().removeElement(objTo[i]);
      }

      listTo.clearSelection();
      if( iSize != 0 )
          listFrom.setSelectionInterval(iStart, iStart+iSize-1);
    }

  private void eliminarTot()
  {
      Object objTo;

      int iSize = getToModel().size();
      int iStart = getFromModel().getSize();

      for( int i=0; i<iSize; i++ )
      {
          objTo = getToModel().getElementAt(0);
          if( !getFromModel().contains(objTo) )
              getFromModel().addElement(objTo);

          getToModel().removeElementAt(0);
      }

      listTo.clearSelection();
      if( iSize != 0 )
          listFrom.setSelectionInterval(iStart, iStart+iSize-1);
  }
  /**
   * See if an item exists (first field is same) on a list
   * @return index position on list, -1 if not found
   * @param list
   * @param obj
   */
  private int getIndex(Object obj, JList list) 
  {
    int size = list.getModel().getSize(); 
    String [] strlListItem = ((String)obj).split(":");
    // Get all item objects
    for (int i=0; i<size; i++) {
      Object item = list.getModel().getElementAt(i);    
      String [] strlItem = ((String)(item)).split(":");
      
      if (strlItem[0].equals(strlListItem[0]))
      {
        return i;
      }
      
    }
    return -1;
     
  }
  
  private Object existsLinia(Object obj, JList list)
  {
   
    int size = list.getModel().getSize(); 
    String [] strlListItem = ((String)obj).split(":");
    // Get all item objects
    for (int i=0; i<size; i++) {
      Object item = list.getModel().getElementAt(i);    
      String [] strlItem = ((String)(item)).split(":");
      
      if (strlItem[0].equals(strlListItem[0]))
      {
        return item;
      }
      
    }
    return null;
    
  }
  
  
  private String changeCant (Object obj, int cant, double pes)
  {
    String [] strlBulto = ((String)(obj)).split(":");
    strlBulto [2] = String.valueOf(cant);
    strlBulto [3] = String.valueOf(pes);
    return (join(strlBulto, ":"));
  }
  
  private int getCant(Object obj) 
  {
    String [] strlBulto = ((String)(obj)).split(":");
    return Integer.parseInt(strlBulto[2]);
  }
  
  
  private double getPes(Object obj) 
  {
    String [] strlBulto = ((String)(obj)).split(":");
    Double pes = new Double(strlBulto[3]);
    return pes.doubleValue();
  }
  
  
  public static double round2(double num) {
    double result = num * 100;
    result = Math.round(result);
    result = result / 100;
    return result;
}
/**
 * addToList: Add to a list, increasing qty if necessary
 * Michael 23.01.2015
 * 
 */
  private void addToList(Object objToAdd, int newCant, JList list) 
  {
        int cantActual = 0;
        double pesActual = 0;
        String newStr;
        double pesFrom = getPes(objToAdd);
        int maxCant = getCant(objToAdd);
        DefaultListModel lm = (DefaultListModel)list.getModel();
        
        
        Object obj = existsLinia(objToAdd, list);
        if (obj != null)
          {
            
            lm.removeElement(obj);
            cantActual = getCant(obj);
            pesActual = getPes(obj);
          }
         
          double pesAfegir = pesFrom * newCant / maxCant;
          pesAfegir = round2(pesAfegir);
          
          newStr = changeCant(obj == null ? objToAdd : obj, cantActual + newCant, round2(pesActual + pesAfegir));
          lm.addElement(newStr);
    
    
  }
  
  /*
   * Dividir quantitat de un bulto en 
   * 2 línies
   */
  private void dividirCant()
  {
     
      Object[] objFrom = listFrom.getSelectedValues();
      
      int iSize = objFrom.length;
      int iStart = getToModel().getSize();
      for( int i=0; i<iSize; i++ )
      {
        String [] strlBulto = ((String)(objFrom[i])).split(":");
        int max = getCant(objFrom[i]);
        double pesFrom = getPes(objFrom[i]);
        
        String result = (String)JOptionPane.showInputDialog(null, 
                      "Quantitat a traslladar (min: 1 max: " + max + ")", 
                      "Traslladar una quantitat parcial",
                      JOptionPane.PLAIN_MESSAGE, 
                      null,
                      //options, 
                      null,
                      "0");
      if (result != null)
      {
        try
        {
          
          int newCant = Integer.parseInt((result));
          if (!(newCant > 0 && newCant <= max))
          {
            
            JOptionPane.showMessageDialog(null, "Quantitat "+ newCant + " no vàlida", "Quantitat erronea", JOptionPane.ERROR_MESSAGE);
            return;
            
          }
          
          // Put on new list
          Object obj = existsLinia(objFrom[i], listTo);
          int cantActual = 0;
          double pesActual = 0;
          String newStr;
          if (obj != null)
          {
            getToModel().removeElement(obj);
            cantActual = getCant(obj);
            pesActual = getPes(obj);
          }
         
          double pesAfegir = pesFrom * newCant / max;
          pesAfegir = round2(pesAfegir);
          
          newStr = changeCant(obj == null ? objFrom[i] : obj, cantActual + newCant, round2(pesActual + pesAfegir));
          getToModel().addElement(newStr);
          
          int fromIndex = listFrom.getSelectedIndex();

          if (newCant < max)
          {
            newStr = changeCant(objFrom[i], max - newCant, round2(pesFrom - pesAfegir));
            getFromModel().setElementAt(newStr, fromIndex);
          }
          else 
          {
            getFromModel().removeElement(objFrom[i]);
          }
            
        
  
          
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
      }
    }
  }
  
  // Michael TODO 23.01.2015 Test this funcion not working should sum up if there is already part of line..
  private void rejuntarLiniaToFrom ()
  {
    Object[] objTo = listTo.getSelectedValues();
      
      int iSize = objTo.length;
      int iStart = getToModel().getSize();
      try
      {
      for( int i = 0; i < iSize; i++ )
      {
        
        int cantTo = getCant(objTo[i]);
        double pesTo = getPes(objTo[i]);
        
      
      
        // Put on original list
        Object obj = existsLinia(objTo[i], listFrom);
        
        if (obj != null)
        {
          
          int cantFrom = getCant(obj);
          cantTo = cantFrom + cantTo;
          double pesFrom = getPes(obj);
          pesTo = round2(pesTo + pesFrom);
          // getFromModel().removeElement(obj);
        }
        
        getToModel().removeElement(objTo[i]);
        if (obj != null)
        {
          getFromModel().setElementAt(changeCant(objTo[i], cantTo, pesTo), getIndex(obj, listFrom));
        }
        else
          getFromModel().addElement(changeCant(objTo[i], cantTo, pesTo ));
        
          
      }
        
  
          
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
      }
  
  
  private void rejuntarLiniaFromTo ()
  {
    Object[] objTo = listFrom.getSelectedValues();
      
      int iSize = objTo.length;
      int iStart = getFromModel().getSize();
      try
      {
      for( int i = 0; i < iSize; i++ )
      {
        
        int cantTo = getCant(objTo[i]);
        double pesTo = getPes(objTo[i]);
        
      
      
        // Put on To list
        Object obj = existsLinia(objTo[i], listTo);
        
        if (obj != null)
        {
          int cantFrom = getCant(obj);
          cantTo = cantFrom + cantTo;
          double pesFrom = getPes(obj);
          pesTo = round2(pesTo + pesFrom);
        }
        
        getFromModel().removeElement(objTo[i]);
        if (obj != null)
        {
          getToModel().setElementAt(changeCant(objTo[i], cantTo, pesTo), getIndex(obj, listTo));
        }
        else
          getToModel().addElement(changeCant(objTo[i], cantTo, pesTo ));
        
          
      }
        
  
          
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
      }
    
  
  

  public DefaultListModel getToModel()
  {
      return (DefaultListModel)listTo.getModel();
  }

  public DefaultListModel getFromModel()
  {
      return (DefaultListModel)listFrom.getModel();
  }

  public void setEnabled(boolean editable)
  {
      listTo.setEnabled(editable);
      afegirTot.setEnabled(editable);
      afegirSel.setEnabled(editable);
      eliminarSel.setEnabled(editable);
      eliminarTot.setEnabled(editable);
      listFrom.setEnabled(editable);
      dividirCant.setEnabled(editable);
  }

  public void requestFocus(DefaultListModel model)
  {
      if( model == getToModel() )
          listTo.requestFocus();
      else if( model == getFromModel() )
          listFrom.requestFocus();
  }
  
  public void setToTitol(String titol)
  {
    listToTitol = titol;
  }

  public void setFromTitol(String titol)
  {
    listFromTitol = titol;
  }
      
  public String getFromTitol()
  {
    return listFromTitol;
  }
  
  public String getToTitol()
  {
    return listToTitol;
  }
  
  public static String join(String [] s, String delimiter) {
    if (s == null || s.length == 0) return "";
    String sb = (s[0]);
    for (int i = 1; i < s.length; i++)
    {
        sb = sb + delimiter + s [i];
    }
    return sb;
}
}
