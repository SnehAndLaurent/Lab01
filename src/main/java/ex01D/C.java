package ex01D; 
public class C 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		StringBuffer s = new StringBuffer("abc");
		i = method1(i, s);
		System.out.println("i=" + i + ", s=" + s);
	}

	private static int method1(int i, StringBuffer s) {
		// TODO Auto-generated method stub
		i++;
		s.append("d");
		return i;
	}
 }