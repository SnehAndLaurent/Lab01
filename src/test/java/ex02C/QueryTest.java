package ex02C; 

import org.apache.log4j.*;
import java.sql.*;
import junit.framework.Test; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
import static org.junit.Assert.*;
 
/**  * Unit test for simple App.  */ 

public class QueryTest extends TestCase 
{     
    protected static Logger log = Logger.getLogger(QueryTest.class);

	/**Create the test case     
	 *    
	 * @param testName name of the test case  
         */   
	  public QueryTest( String testName ) 
	  {        
		 super( testName );
 	  } 
 
 	 /**     
	  * @return the suite of tests being tested  
	  */   
	  public static Test suite() 
	  {  
		 System.out.println();
		 System.out.println("Test case for QueryTest class of package ex02C");
		 log.info("Testing QueryTest");
	     return new TestSuite( QueryTest.class );  
	  } 
 
 	   /** 
	    * Rigourous Test :-)    
	    */   
	  public void testApp() throws Exception
	  {    
	    log.debug("Testing QueryTest Debug");
		System.out.println();
		/*
		 * Testing Queries
		*/
		String[] args = new String[] {"jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver", "root","root","Select * from actor"}; 
		program3.main(args);
		System.out.println();
		String[] args1 = new String[] {"jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver", "root","root","Select * from city where city='Bhopal'"}; 
		program3.main(args1);
		System.out.println();
		String[] args2 = new String[] {"jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver", "root","root","Update actor set last_name='DEF' where first_name='ED'"}; 
		program3.main(args2);
		System.out.println();
		String[] args3 = new String[] {"jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver", "root","root","Update actor set last_name='DEFG' where first_name='ABC'"};
		program3.main(args3);
		System.out.println();
		String[] args4 = new String[] { "jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver", "root", "root", "INSERT INTO actor VALUES (201,'PENELOPE','GUINESS','2006-02-15 04:34:33')"};
		program3.main(args4);
		System.out.println();
		String[] args5 = new String[] {"jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver", "root", "root", "DELETE From actor where actor_id=201"};
		program3.main(args5);
		System.out.println();		
	  }
	    
	  
}