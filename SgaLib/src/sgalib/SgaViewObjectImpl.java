package sgalib;
import oracle.jbo.server.ViewObjectImpl;

public class SgaViewObjectImpl extends ViewObjectImpl 
{
  /*public SgaViewObjectImpl()
  {
  }*/
  
  protected void create() {
      super.create();
      setViewCriteriaAdapter(new SgaViewCriteriaAdapter());
    }
  
}