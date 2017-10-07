package ex01E;

public class C extends B {
	int x,a;
	void m()
	{
		System.out.println("Je suis dans la méthode m d'une instance de A");
	}
	void test(){
		 a = super.x; 
		 //a = super.super.x; Not Possible it violates encapsulation property
		 a = ((B)this).x; 
		 a = ((A)this).x;
		 super.m(); 
		 // super.super.m(); Not possible
		 ((B)this).m(); 
		 
		 //Que 1 Which m() method is called in (1)?  
		 // Sol: Calling itself method means method of C class.
		 
		 //Que 2 Is it the expected result? 
		 //Sol: No, it is not the expected result. It should call the class B method m
		 
		 //Que 3 Which OOP implementation type fits to that result? (Virtual function overloading) 
		 //Sol:	It is using multiple inheritance and function overloading concept.  
		 
	}

}
