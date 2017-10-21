import java.util.*;
import java.text.NumberFormat;
public class IncomeApp {
	public static void main(String[] args){
		double income = 0;
		double min = 2000000;
		double max = -1;
		int count = 0;
		double sum = 0;
		while(income >= 0){
			System.out.println("Enter an income (any negative number to quit): ");
			Scanner sc = new Scanner(System.in);
			income = sc.nextDouble();
			if (income >= 0){
				max = Math.max(max, income);
				min = Math.min(min, income);
				sum = sum + income;
				count ++;
			}
			else continue;
		}
		double avg = sum / count;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("The minimum number is " + currency.format(min) + ",");
		System.out.println("the average is " + currency.format(avg) + ", and");
		System.out.println("the maximun is " + currency.format(max) + ".");
	}
}
