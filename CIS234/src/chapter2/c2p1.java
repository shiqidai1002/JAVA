package chapter2;

public class c2p1 {
	public static void main( String[] args ){
		int numb; //declare numb as an integer variable
		numb = 5;
		numb = 8;
		numb = 1;
		numb = numb +4; // 5
		numb = 20; // 20	
		numb = -10; // -10
		
	/* in class exercise */
		int a, b, c;
		a = 2;
		b = 3;
		c = 4;
		b = a;
		a = c;
		a = b;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		
	/* notes */
		double x = 8.5;
		int y = 8;
		double z = x / y;
		System.out.println("z : " + z); //y will be changed into double automatically
		
	/* String */
		//java has a class called "string", so the data type should be "String"
		String s = "CIS234";// String is a java API class, s is a object
		String message1 = "";//the value is a empty string, like a empty box. It has a value.
		String message2 = null;//the value is undefined, like a box with "null" in it. The value has not been assigned.
		
		String firstName = "Bob";
		String lastName = "Smith";
		String fullName = firstName + " " + lastName;//"+" means concatenation;
		System.out.println("the full name is " + fullName);
		
	/* escape sequence */
		
		
	/* shortcut operators */
		int i = 0;
		i = i + 7;
		i += 7;
		i = i - 5;
		i -= 5;
		i = i * 3;
		i *= 3;
		i = i / 2;
		i /= i;
		
		
		
	}
}
