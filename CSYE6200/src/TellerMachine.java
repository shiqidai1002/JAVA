import java.text.NumberFormat;
import java.util.Scanner;

public class TellerMachine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to use this machine!");
		System.out.println("To begin, please enter your 4-digit PIN and press ENTER to complete.");
		System.out.print("PIN: ");
		pinModule(sc);
		menu(sc);
	}
	
	/*
	 * Module: Logon
	 * Author: Shiqi Dai
	 * This part includes two methods.	They are pinModule() and checkPIN().
	 * pinModule() will call checkPIN() to decide if the customer entered PIN can meet our requirements.
	*/
	
	private static void pinModule(Scanner sc)	{
		String pin = sc.nextLine();
		while(checkPIN(pin) == false) {
			System.out.println("Sorry, your entered PIN is incorrect! Please enter again!");
			System.out.println("TIP: The correct PIN should be a 4-digit number.");
			System.out.print("PIN: ");
			pin = sc.nextLine();
		}
    System.out.println("Your PIN is correct!");
	}

	private static boolean checkPIN(String pin) {
		if (pin.length() == 4){
			try{
				Integer.parseInt(pin);
				return true;
			}
			catch (NumberFormatException e){
				return false;
			}
		}
		return false;
	}

	
	
	/*
	 * Author: Shiqi Dai
	 * This method will show users the main menu after they enter correct PINs.
	 */
	private static void menu(Scanner sc){
		System.out.println("");
		System.out.println("");
		
		do{
			int userInput = 0;
			System.out.println("");
			System.out.println("---Main Menu---");
			System.out.println("1. Balance");
			System.out.println("2. Quick Cash");
			System.out.println("3. Withdraw");
			System.out.println("4. Quit");
			
			System.out.println("Please select and press \"enter \" to confirm. ");
			boolean invalidInput = true;
			do{
				try {
					System.out.print("Your selection: ");
					userInput = Integer.parseInt(sc.nextLine());
					invalidInput = false;
				}
				catch (Exception e) {
					System.out.println("------------------------");
					System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
					System.out.println("TIP: Please type 1/2/3/4 only.");
					System.out.println("");
				}
			}
			while(invalidInput);
			switch (userInput){
			case 1:
				System.out.println("------------------------");
				System.out.println("You have selected: 1. Balance");
				System.out.println("");
				System.out.println("");
				System.out.println("------------------------");
				balance(sc);
				break;
			case 2:
				System.out.println("------------------------");
				System.out.println("You have selected: 2. Quick Cash");
				System.out.println("");
				System.out.println("");
				System.out.println("------------------------");
				quickCash(sc);
				break;
			case 3:
				System.out.println("------------------------");
				System.out.println("You have selected: 3. Withdraw");
				System.out.println("");
				System.out.println("");
				System.out.println("------------------------");
				withdraw(sc);
				break;
			case 4:
				quit();
				break;
			default:
				System.out.println("------------------------");
				System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
				System.out.println("TIP: Please type 1/2/3/4 only.");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				continue;
			}
		}
		while (true);
	}

	/*
	 * Author: Shiqi Dai
	 * This method will allow the user to enter a valid amount to withdraw.
 	 * It can be dispensed using $20, $10, or $5 notes.
	 */
	private static void withdraw(Scanner sc) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		int userInput = 0;
		
		String amount;
		do{
			System.out.println("");
			System.out.println("---Withdraw---");
			System.out.println("Please enter an amount of money to withdraw.");
			
			boolean invalidInput = true;
			do{
				try {
					System.out.print("Amount: ");
					userInput = Integer.parseInt(sc.nextLine());
					invalidInput = false;
				}
				catch (Exception e) {
					System.out.println("------------------------");
					System.out.println("Sorry, your entered amount is incorrect! Please enter again!");
					System.out.println("");
				}
			}
			while(invalidInput);
			amount = nf.format(userInput);
			System.out.println("Your entered amount is "+ amount + " .");
			System.out.println("Please select how you want to dispense.");
			System.out.println("1. $20");
			System.out.println("2. $10");
			System.out.println("3. $5");
			boolean invalidInput2 = true;
			do{
				try {
					System.out.print("Your selection: ");
					userInput = Integer.parseInt(sc.nextLine());
					invalidInput2 = false;
				}
				catch (Exception e) {
					System.out.println("------------------------");
					System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
					System.out.println("TIP: Please type 1/2/3 only.");
					System.out.println("");
				}
			}
			while(invalidInput2);
			
			switch(userInput) {
				case 1:
					System.out.println("------------------------");
					System.out.println("You will recieve" + amount + "dispensed with $20.");
					receipt(sc);
					break;
				case 2:
					System.out.println("------------------------");
					System.out.println("You will recieve" + amount + "dispensed with $10.");
					receipt(sc);
					break;
				case 3:
					System.out.println("------------------------");
					System.out.println("You will recieve" + amount + "dispensed with $5.");
					receipt(sc);
					break;
				default:
					System.out.println("------------------------");
					System.out.println("Sorry, your selection is incorrect! Please enter again!");
					System.out.println("TIP: Please type 1/2/3 only.");
					System.out.print("Your selection: ");
					continue;
			}
		}
		while(true);
	}
	
	/*
	 * Author: Shiqi Dai
	 * This method allows users to withdraw certain amounts of money they usually want.
	 * Besides, if they don't find any amount they desire, they can go with "Other amount".
	 */
	private static void quickCash(Scanner sc) {
		int userInput = 0;
		
		do{
			System.out.println("");
			System.out.println("---Quick Cash---");
			System.out.println("1. $100");
			System.out.println("2. $50");
			System.out.println("3. $20");
			System.out.println("4. Other amount");
			System.out.println("5. Back to main menu");
			
			
			System.out.println("Please select and press \"enter \" to confirm. ");
			boolean invalidInput = true;
			do{
				try {
					System.out.print("Your selection: ");
					userInput = Integer.parseInt(sc.nextLine());
					invalidInput = false;
				}
				catch (Exception e) {
					System.out.println("------------------------");
					System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
					System.out.println("TIP: Please type 1/2/3/4/5 only.");
					System.out.println("");
				}
			}
			while(invalidInput);
			switch (userInput) {
				case 1:
					System.out.println("------------------------");
					System.out.println("You have selected: 1. $100");
					System.out.println("");
					System.out.println("");
					receipt(sc);
					break;
				case 2:
					System.out.println("------------------------");
					System.out.println("You have selected: 2. $50");
					System.out.println("");
					System.out.println("");
					receipt(sc);
					break;
				case 3:
					System.out.println("------------------------");
					System.out.println("You have selected: 3. $20");
					System.out.println("");
					System.out.println("");
					receipt(sc);
					break;
				case 4:
					System.out.println("------------------------");
					System.out.println("You have selected: 4. Other amount");
					System.out.println("Now jumpping...");
					System.out.println("");
					System.out.println("");
					withdraw(sc);
					break;
				case 5:
					System.out.println("------------------------");
					System.out.println("Now jumpping...");
					System.out.println("");
					System.out.println("");
					menu(sc);
					break;
				default: 
					System.out.println("------------------------");
					System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
					System.out.println("TIP: Please type 1/2/3/4/5 only.");
					continue;
				}
		}
		while ( true );
	}

	/*
	 * Author: Shiqi Dai
	 * This method will be called after users withdraw money.
	 * including withdraw() and quickCash()
	 */
	private static void receipt(Scanner sc){
		int userInput = 0;
		
		System.out.println("------------------------");
		System.out.println("Please take your cash.");

		
		do{
			System.out.println("------------------------");
		System.out.println("Do you need a transaction receipt?");
		System.out.println("1. YES");
		System.out.println("2. NO");
		System.out.println("Please select and press \"enter \" to confirm. ");
		boolean invalidInput = true;
		do{
			try {
				System.out.print("Your selection: ");
				userInput = Integer.parseInt(sc.nextLine());
				invalidInput = false;
			}
			catch (Exception e) {
				System.out.println("------------------------");
				System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
				System.out.println("TIP: Please type 1/2 only.");
				System.out.println("");
			}
		}
		while(invalidInput);
		switch (userInput) {
		case 1: 
			System.out.println("------------------------");
			System.out.println("Please take your receipt");
			System.out.println("Thank you for using!");
			whatIsNext(sc);
			break;
		case 2: 
			System.out.println("------------------------");
			System.out.println("Thank you for using!");
			whatIsNext(sc);
			break;
		default:
			System.out.println("------------------------");
			System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
			continue;
		}
		}
		while(true);
		
	}
	
	/*
	 * Author: Shiqi Dai
	 * This method will show the balance of the user.
	 * For now, we don't have a database storing user's account information.
	 * Thus, userInput just made a sample of this method.
	 */
	private static void balance(Scanner sc) {
		System.out.println("");
		System.out.println("---Balance---");
		System.out.println("The balance of your account is : " + "XXXX");
		whatIsNext(sc);
	}
	
	
	/*
	 * Author: Shiqi Dai
	 * This method is called when users finish their transactions.
	 * It will allow users start a new transaction or exit.
	 */
	private static void whatIsNext(Scanner sc) {
		int userInput = 0;
		do {
			System.out.println("------------------------");
			System.out.println("What is next?");
			System.out.println("1. Back to menu");
			System.out.println("2. Quit");
			System.out.println("Please select and press \"enter \" to confirm. ");
			
			boolean invalidInput = true;
			do{
				try {
					System.out.print("Your selection: ");
					userInput = Integer.parseInt(sc.nextLine());
					invalidInput = false;
				}
				catch (Exception e) {
					System.out.println("------------------------");
					System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
					System.out.println("TIP: Please type 1/2 only.");
					System.out.println("");
				}
			}
			while(invalidInput);
			
			switch (userInput) {
				case 1:
					System.out.println("------------------------");
					System.out.println("Now jumpping...");
					System.out.println("");
					System.out.println("");
					System.out.println("------------------------");
					menu(sc);
					break;
				case 2:
					quit();
					break;
				default: 
					System.out.println("------------------------");
					System.out.println("Sorry, your entered selection is incorrect! Please enter again!");
					continue;
			}
		}
		while (true);
	}

	/*
	 * Author: Shiqi Dai
	 * This method helps users exit from the program.
	 */
	private static void quit() {
		System.out.println("------------------------");
		System.out.println("Thank you for using!");
		main(new String[0]);
	}
		
}
