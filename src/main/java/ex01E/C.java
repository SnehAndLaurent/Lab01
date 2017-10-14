package ex01E;

import org.apache.log4j.*;

public class C extends B {
	protected static Logger log = Logger.getLogger(C.class);
	int x,a;
	/**
	 * Method m for displaying the value 
	 */
	void m()
	{
		 System.out.println("Je suis dans la méthode m d'une instance de A");
	}
	
	/**
	 * int getA()
	{
		return a;
	}
	
	int getSuper()
	{
		return super.x ;
	}
	 */
	
	/**
	 * Test method in order to demonstrate the inheritance and method overloading in Java 
	 */
	public void test()
	{
		 a = super.x;
		 //a = super.super.x; Not Possible it violates encapsulation property
		 a = ((B)this).x;
		 a = ((A)this).x;
		 super.m(); 
		 // super.super.m(); Not possible violates encapsulation property
		 ((B)this).m(); 
		 
	}
	public static void main(String[] args)
	{
		 C c = new C();
		 c.test();
	}
}

	 /**
		   *Que 1 Which m() method is called in (1)?  
			Sol: Calling itself method means method of C class.
		 
			Que 2 Is it the expected result? 
			Sol: No, it is not the expected result. It should call the class B method m
		 
			Que 3 Which OOP implementation type fits to that result? (Virtual function overloading) 
			Sol:	It is using multiple inheritance and function overloading concept.  
	  */