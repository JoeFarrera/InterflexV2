package mypackage2;

public class ThreadTest 
{
  public ThreadTest()
  {
    Threadclass myThread = new Threadclass(1);
    myThread = null;
    myThread = new Threadclass(2);
    myThread = null;
    myThread = new Threadclass(3);
    
    try 
    {
      Thread.sleep(100000);
    } catch (Exception ex) 
    {
      ex.printStackTrace();
    } 
    
    
  }
  
  public static void main(String[] args)
  {
    // ThreadTest myTest = new ThreadTest();
    char [] cars = {'a', 'b', 17, 19, 'c'};
    String charString = new String();
    for (int i = 0; i < cars.length; i++)
    {
      if (Character.isLetterOrDigit(cars[i]))
      {
        charString = charString.concat(cars[i] + " ");
      }
      else
        charString = charString.concat((int)(cars[i]) + " ");
    }
      System.out.print("charString: " + charString);
    
    
  }
  
  
  private class Threadclass implements Runnable
  {
  int threadId;

  public Threadclass (int id)
  {
    threadId = id;
    Thread myThread = new Thread (this);
    myThread.setDaemon(true);
    myThread.start();
  }
  
  public void run()
  {
    while (true)
    {
      System.out.println("soy el thread: " + threadId);
      try 
      {
        Thread.sleep(1000);
      } catch (Exception ex) 
      {
        ex.printStackTrace();
      } 
    }
  
  }
  }
}