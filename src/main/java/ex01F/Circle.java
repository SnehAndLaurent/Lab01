package ex01F;

import org.apache.log4j.Logger;

public class Circle
{

	protected static Logger log = Logger.getLogger(Circle.class);

	int x;
	int y;
	int radius;

	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	/**
	  *toString() method to print the values
	  */
	  
	public String toString()
	{
		return String.format("Circle with center (%d,%d) and radius %d (Perimter is %2f)", this.x, this.y, this.radius, (2 * java.lang.Math.PI * this.radius));

	}
}

	/**
	  *Que 1: What shows up? Why is the method toString() called without being named?  
	   Sol: Shows up : C1 => Circle with center (0,0) and radius 5 (Perimter is 31.415927).
			The method toString is automatically called when you try to print an Object.

	   Que 2: If you rename the method toString(), what happens? 
	   Sol: If you rename the function toString, it will call the function toString of the object it will call the method toString of the mother.
			Which is a lot uglier than our own method
	*/
