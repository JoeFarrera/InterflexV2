package sgalib;
import oracle.jbo.Key;

public class RowSelectResult 
{
  private int result;
  private Key [] keys;

  public RowSelectResult()
  {
  
  }

  public int getResult()
  {
    return result;
  }

  public void setResult(int result)
  {
    this.result = result;
  }

  public Key [] getKeys()
  {
    return keys;
  }

  public void setKeys(Key [] keys)
  {
    this.keys = keys;
  }
}