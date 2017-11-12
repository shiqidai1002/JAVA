/**
 * 
 */
package edu.neu.coe.info6205;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author Shiqi
 *
 */
public class ParSort {
	public static int cutoff = 50001;

	public static void sort(int[] array, int from, int to) {
		int size = to - from;
		if (size < cutoff)
			Arrays.sort(array, from, to);
		else {
			int mid = from + (to - from) / 2;
			CompletableFuture<int[]> cf1 = parsort(array, from, mid);
			CompletableFuture<int[]> cf2 = parsort(array, mid, to);
			CompletableFuture<int[]> cf = cf1.thenCombine(cf2, (xs1, xs2) -> {
				int[] result = new int[xs1.length + xs2.length];
				int i = 0, j = 0;
				for (int k = 0; k < result.length; k++) {
					if (i >= xs1.length)
						result[k] = xs2[j++];
					else if(j >= xs2.length)
						result[k] = xs1[i++];
					else if (less(xs1[i], xs2[j]))
						result[k] = xs1[i++];
					else
						result[k] = xs2[j++];
				}

				return result;
			});
			cf.whenComplete((result, throwable) -> {
				for(int i = 0; i < result.length; i++){
					array[i] = result[i];
				}
			});
			cf.join();
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
		return CompletableFuture.supplyAsync(() -> {
			int[] result = new int[to - from];
			for(int i = 0; i < result.length; i++){
				result[i] = array[from + i];
			}
			sort(result, 0, result.length);
			return result;
		});
	}

}