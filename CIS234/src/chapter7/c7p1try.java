package chapter7;
import java.util.*;
public class c7p1try {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double subtotal = 0.0;
		for(int i = 0; i < 5; i++){
		try{
			System.out.println("Enter subtotal:  ");
			subtotal = sc.nextDouble();
		}
		catch (InputMismatchException e){
			sc.next();  //discard the invalid value
			System.out.println("Error! Invalid number. Try again.\n");
			continue;  //jump to the top of the loop
		}
		}
	}
}
