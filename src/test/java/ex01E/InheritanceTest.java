package ex01E; 

import org.apache.log4j.*;
 
import junit.framework.Test; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
import static org.junit.Assert.*;
 
/**  * Unit test for simple App.  */ 

public class InheritanceTest extends TestCase 
{     
    protected static Logger log = Logger.getLogger(InheritanceTest.class);

	/**Create the test case     
	 *    
	 * @param testName name of the test case  
         */   
	  public InheritanceTest( String testName ) 
	  {        
		 super( testName );
 	  } 
 
 	 /**     
	  * @return the suite of tests being tested  
	  */   
	  public static Test suite() 
	  {  
		 System.out.println();
		 System.out.println("Test case for Inheritance class of package ex01E");
		 log.info("Testing Inheritence Info");
	     return new TestSuite( InheritanceTest.class );  
	  } 
 
 	   /** 
	    * Rigourous Test :-)    
	    */   
	  public void testApp()   
	  {    
	     log.debug("Testing Inheritence Debug");
	     C c = new C();
		 A a = new A();
		 /**
		  *  assertTrue( a instanceof ex01E.C ); Class A object is not an of a sub class C
		  */
		 assertTrue( c instanceof ex01E.A ); //Class C is instance or sub class of Class A
		 System.out.println("Class C object is an instance of Class A");
		 assertTrue( c instanceof ex01E.B ); //Class C is instance or sub class of Class B
		 System.out.println("Class C object is an instance of Class B");
		 /**
		  * assetEquals(c.getA(), c.getSuper()); They are not equal
		  */
		 c.test();// Calling class C method test()
		 assertTrue( true ); 
		 System.out.println();
		 
	  }
	  
}