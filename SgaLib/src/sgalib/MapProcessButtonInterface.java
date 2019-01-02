package sgalib;

/**
 * Permitir que un proceso avise al button que lo controla d
 */
public interface MapProcessButtonInterface 
{
  public void updateButton(Object arg);
  public void setProcessStopped(Object arg);
  public void setProcessStarted();
}