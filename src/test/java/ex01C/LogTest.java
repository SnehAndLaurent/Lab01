package ex01C; 

import org.apache.log4j.*; 
import junit.framework.Test; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
 
/**  * Unit test for simple App.  */ 

public class LogTest extends TestCase 
{     
	/**Create the test case     
	 *    
	 * @param testName name of the test case  
     */ 
	  protected static Logger log = Logger.getLogger(LogTest.class);
	  public LogTest( String testName ) 
	  {        
		 super( testName );
 	  } 
 
 	 /**     
	  * @return the suite of tests being tested  
	  */   
	  public static Test suite() 
	  {       
	         System.out.println();
			 System.out.println("Test case for log file of package ex01C");
			 log.info("Testing log info");
			 log.info("INFO:Cool !");
	         return new TestSuite( LogTest.class );  
	  } 
 
 	   /** 
	    * Rigourous Test :-)    
	    */   
	  public void testApp()   
	  {  	  
	     log.debug("Testing log debug");
		 log.debug("DEBUG:Cool !");
		 assertTrue( true );
		 System.out.println();
	  }
 } 