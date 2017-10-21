package chapter3;

public class c3p2 {
	public static void main( String[] args ){
		int n = 10;
		int m = 15;
		int sum = n + m;
		System.out.println("The sum of " + n + " and " + m + " is " + sum); 
		// number will be convert into string   10 ¡ú "10"
		System.out.println("10" + "15"); //1015
		System.out.println(10 + 15); //25
		System.out.println("" + 10 + 15); //1015
	}
}
