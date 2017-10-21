package chapter5;

import java.text.NumberFormat;

public class c5p1 {
	public static void main(String[] args){
		double b = 0.785;
		NumberFormat nf = NumberFormat.getPercentInstance();
		System.out.println(nf.format(b));
		nf.setMaximumFractionDigits(2);
		System.out.println(nf.format(b));
		
		double price = 11.575;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String priceString = currency.format(price);
		System.out.println(priceString);

	}
}
