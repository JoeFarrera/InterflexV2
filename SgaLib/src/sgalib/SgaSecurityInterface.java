package sgalib;

public interface SgaSecurityInterface 
{
  public String getCurrentUser();
  public void setCurrentUser (String user);
  public String getCurrentPassword();
  public void setCurrentPassword (String password);
  
  public boolean checkUser(String user, String password);
  public boolean hasAcceso(String acceso);

  public boolean isCurrentUserBloquejat ();
  public void setCurrentUserBloquejat (boolean estat);
  
  public boolean desbloquejar(String user, String password);
}