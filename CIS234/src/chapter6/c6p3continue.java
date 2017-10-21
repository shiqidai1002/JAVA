package chapter6;

public class c6p3continue {
	public static void main(String[] args){
		for (int j = 1; j < 10; j++)
		{
		System.out.println("j is " + j);
		int number = (int) (Math.random() * 10);
		System.out.println("random number is " + number);
		if (number <= 7)
		     continue;
		System.out.println("This number is greater than 7");
		}

	}
}
