package edu.neu.coe.info6205;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		for (int m = 11000; m <= 2351000; m += 10000) {
			ParSort.cutoff = m;
			// if (args.length>0) ParSort.cutoff = Integer.parseInt(args[0]);
			Random random = new Random(0L);
			int[] array = new int[2000000];
			for (int i = 0; i < array.length; i++)
				array[i] = random.nextInt(10000);
			// for (int i = 0; i < array.length; i++) array[i] =(int)
			// (Math.random()*10000);
			long start = System.currentTimeMillis();
			ParSort.sort(array, 0, array.length);
			long end = System.currentTimeMillis();
			// for (int i : array) System.out.println(i);
			// if (array[0]==11) System.out.println("Success!");
			// for (String i :args){ System.out.print(i);}
			System.out.print(ParSort.cutoff + "\t\t");
			System.out.println(end - start);
		}
	}
}
