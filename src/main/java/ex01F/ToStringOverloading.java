package ex01F;

import org.apache.log4j.*;
public class ToStringOverloading {
	protected static Logger log = Logger.getLogger(ToStringOverloading.class);

	public static void main(String[] args) {
		Circle c1 = new Circle(0, 0, 5);
		Circle c2 = new Circle(0, 0, 3);
		System.out.println("C1 => " + c1);
	}

}
