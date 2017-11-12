/**
 * 
 */
package edu.neu.coe.info6205;

import java.util.Random;

/**
 * @author Shiqi
 *
 */
public class Main {
	public static void main(String[] args) {
		for (int k = 11000; k < 2051000; k += 10000) {
			ParSort.cutoff = k;
			Random random = new Random(0L);
			int[] array = new int[2000000];
			for (int i = 0; i < array.length; i++) {
				array[i] = random.nextInt(10000);
			}
			long start = System.currentTimeMillis();
			ParSort.sort(array, 0, array.length);
			long end = System.currentTimeMillis();
			// for (int i = 0; i < 2000; i++) {
			// System.out.println(array[i]);
			// }
			System.out.println("cutoff: " + ParSort.cutoff + "\t\tTime: " + (end - start));
		}
		// if (array[0] == 11)
		// System.out.println("Success!" + "\nTime: " + (end - start));
	}
}
