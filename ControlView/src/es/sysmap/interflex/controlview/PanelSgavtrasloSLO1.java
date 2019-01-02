package es.sysmap.interflex.controlview;
import es.sysmap.interflex.control.Traslo;
import es.sysmap.interflex.model.dmc.common.AppModule;
import oracle.jbo.ViewObject;

public class PanelSgavtrasloSLO1 extends PanelSgavtraslo 
{
  private static final int idTraslo = 1;
  private static final String tipTraslo = "SLO";

  public PanelSgavtrasloSLO1()
  {
  }
  
  public void jbInit() throws Exception
  {
    super.jbInit();

    ViewObject voTraslo = getPanelBinding().findIteratorBinding("SgavtrasloEntSal1Iter").getViewObject();
    voTraslo.setWhereClause("idTraslo = " + idTraslo);
    voTraslo.executeQuery();

    AppModule am = (AppModule)panelBinding.getApplication().getApplicationModule();
    traslo = new Traslo (idTraslo, idTraslo == 0 ? "MLD" : "SLO", am);
    buttonArrancar.setProcess(traslo);
  }

}