package ex01F; 

import org.apache.log4j.*;
 
import junit.framework.Test; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
import static org.junit.Assert.*;
 
/**  * Unit test for simple App.  */ 

public class StringOverloadingTest extends TestCase 
{     
    protected static Logger log = Logger.getLogger(StringOverloadingTest.class);

	/**Create the test case     
	 *    
	 * @param testName name of the test case  
         */   
	  public StringOverloadingTest( String testName ) 
	  {        
		 super( testName );
 	  } 
 
 	 /**     
	  * @return the suite of tests being tested  
	  */   
	  public static Test suite() 
	  {  
		 System.out.println();
		 System.out.println("Test case for ToStringOverloading class of package ex01F");
		 log.info("Testing StringOverloading Info");
	     return new TestSuite( StringOverloadingTest.class );  
	  } 
 
 	   /** 
	    * Rigourous Test :-)    
	    */   
	  public void testApp()   
	  {    
	     log.debug("Testing StringOverloading Debug");
	     Circle c1 = new Circle(0, 0, 5);
		 Circle c2 = new Circle(0, 0, 3);
		 /**
		  * Circle c3 = new Circle(0,0,3.5);  Take only integer value. Incompatible types possible lossy conversion from double to int
		  */
		 System.out.println(c1);
		 System.out.println(c2);
		 assertTrue( true ); 
		 System.out.println();
		 
	  }
	  
}