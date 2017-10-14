package ex01E;

import org.apache.log4j.*;

public class B extends A 
{
	protected static Logger log = Logger.getLogger(B.class);
	int x;
	
	/**
	 * Method m for displaying the value 
	 */
	void m()
	{
		 System.out.println("Je suis dans la méthode m d'une instance de B");
	}
}