package ex01E;

import org.apache.log4j.*;

public class A
 {
	protected static Logger log = Logger.getLogger(A.class);
	int x;
	/**
	 * Method m for displaying the value 
	 */
	void m() 
	{
		String mStr = "Je suis dans la méthode m d'une instance de A";
	}
 }