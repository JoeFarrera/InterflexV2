package es.sysmap.interflex.control;

public interface SgaRunnable extends Runnable
{
  public void start();
  public void stopProcess();
  public boolean isAlive();
}

