package helloWorld;

public class pratice1 {
	public static void main ( String [] args ){
		double pizzaPrice = 5.00;
		double sodaPrice = 2.50;
		double tipRate = 0.18;
		double taxRate = 0.09;
		double totalCost = ( 6 * pizzaPrice + 4 * sodaPrice ) * ( 1 + taxRate ) * ( 1 + tipRate);
		System.out.println(totalCost);
	}
}
