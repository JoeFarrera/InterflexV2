package es.sysmap.interflex.control.test;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests1 
{
  public static Test suite()
  {
    TestSuite suite;
    suite = new TestSuite("AllTests1");

    suite.addTestSuite(es.sysmap.interflex.control.test.TrasloTester1.class);

    return suite;
  }

  public static void main(String args[])
  {
    String args2[] = {"-noloading", "es.sysmap.interflex.control.test.AllTests1"};

    junit.swingui.TestRunner.main(args2);
  }
}