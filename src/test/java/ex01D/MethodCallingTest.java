package ex01D; 
import org.apache.log4j.*;
import junit.framework.Test; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
import static org.junit.Assert.*;
 
/**  * Unit test for simple App.  */ 

public class MethodCallingTest extends TestCase 
{     
	/**Create the test case     
	 *    
	 * @param testName name of the test case  
     */   
	  protected static Logger log = Logger.getLogger(MethodCallingTest.class);
	  public MethodCallingTest( String testName ) 
	  {        
		 super( testName );
 	  } 
 
 	 /**     
	  * @return the suite of tests being tested  
	  */   
	  public static Test suite() 
	  {     
		 System.out.println();
		 System.out.println("Test case for MethodCalling class of package ex01D");
		 log.info("Testing MethodCalling Info");
	     return new TestSuite( MethodCallingTest.class );  
	  } 
 
 	   /** 
	    * Rigourous Test :-)    
	    */   
	  public void testApp()   
	  { 
		 log.debug("Testing Debug");
		 int i = 0;
		 StringBuffer s = new StringBuffer("abc");
		 C obj = new C();
		 i = obj.method1(i,s);
		 /**
		  *  assertEquals(i,0); Test will fail. If other value is not 1 because i's value is 1.
		  */
		 assertEquals(i,1);
		 System.out.println("i= "+i);
		 /**
		  * assertEquals(s.toString(),"abc"); Test will fail. If other value is not abcd.
		  */
		 assertEquals(s.toString(),"abcd");
		 System.out.println("s= "+s);
		 System.out.println();
	  }
 } 