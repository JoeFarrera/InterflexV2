package es.sysmap.interflex.model.dmc.common;
import oracle.jbo.ViewObject;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public interface SgagrantuserView extends ViewObject 
{
  boolean hasRole(String idUser, String idRole);
  Object[] getRowFilterValues();

}