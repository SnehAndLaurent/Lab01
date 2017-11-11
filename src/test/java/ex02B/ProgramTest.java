package ex02B;
import org.apache.log4j.*;
import junit.framework.Test; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
import static org.junit.Assert.*;
import java.sql.*;


public class ProgramTest extends TestCase {
	/**Create the test case     
	 *    
	 * @param testName name of the test case  
     */   
	  protected static Logger log = Logger.getLogger(ProgramTest.class);
	  public ProgramTest( String testName ) 
	  {        
		 super( testName );
 	  } 
 
 	 /**     
	  * @return the suite of tests being tested  
	  */   
	  public static Test suite() 
	  {     
		 System.out.println();
		 System.out.println("Test case for ProgramTest class of package ex02B");
		 log.info("Testing JDBC Info");
	     return new TestSuite( ProgramTest.class );  
	  } 
 
 	   /** 
	    * Rigourous Test :-)    
	    */   

		public void testDisplayLastName() throws Exception {
		/*
		 * Calling the main function of program1 as this is static so no need to create an object
		 */
			program1.main(new String[]{});
		}
	}
		

