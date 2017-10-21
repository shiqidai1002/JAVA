package chapter6;

import java.util.Scanner;

public class c6p2switch {
	public static void main(String[] args){
		String productDescription = null;
		Scanner putIn = new Scanner(System.in);
		String productCode = putIn.nextLine();
		switch (productCode)
		{
		    case "hm01":
		        productDescription = "Hammer";
		        System.out.println(productDescription);
		        break;
		    case "bn03":
		        productDescription = "Box of Nails";
		        System.out.println(productDescription);
		        break;
		    default:
		        productDescription = "Product not found";
		        System.out.println(productDescription);
		        break;
		}

	}
}
