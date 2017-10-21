package chapter4;

import java.util.Scanner;

public class c4p1 {
	public static void main( String[] args){
		//control of the flow/logic
		/* two methods to compare strings*/
		// equals();
		// equalsIgnoreCase();
		String choice = "y";
		while(choice.equalsIgnoreCase("y")){
		Scanner sc = new Scanner (System.in);
		System.out.println("What is the customer type?");
		String customerType = sc.next(); //dataType dataName = objectName.methodName(arguments)
		System.out.println("What is the subtotal of this customer?");
		double subtotal = sc.nextDouble();
		double discountPrecent;
		if(customerType.equals("R")){
			if(subtotal >= 100)
				discountPrecent = .2;
			else
				discountPrecent = .1;
		}
		else
			discountPrecent = .4;
		System.out.println("the discountPrecent is " + discountPrecent);
		System.out.println();
		System.out.println("Would you like to continue?(y/n)");
		choice = sc.next();
		}
	}
}
