package ex01D; 

import org.apache.log4j.*;
public class C 
{
	protected static Logger log = Logger.getLogger(C.class);
	/**
	 * Main method call method1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		StringBuffer s = new StringBuffer("abc");
		i = method1(i, s);
		System.out.println("i=" + i + ", s=" + s);
	}

	/**
	 * method1()
	 */
	protected static int method1(int i, StringBuffer s) {
		// TODO Auto-generated method stub
		i++;
		s.append("d");
		return i;
	}
 }