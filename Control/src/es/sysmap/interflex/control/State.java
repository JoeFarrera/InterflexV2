package es.sysmap.interflex.control;

public interface State 
{
  public boolean isEvent();
  public void onEntry ();
  public void action ();
  public void onExit ();
}