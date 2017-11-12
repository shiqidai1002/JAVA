package edu.neu.coe.info6205;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

class ParSort {

	public static int cutoff = 1000;

	public static void sort(int[] array, int from, int to) {
		int size = to - from;
		if (size < cutoff)
			Arrays.sort(array, from, to);
		else {
			CompletableFuture<int[]> parsort1 = parsort(array, from, from + (to - from) / 2 + 1);
			CompletableFuture<int[]> parsort2 = parsort(array, from + (to - from) / 2 + 1, to);
			CompletableFuture<int[]> parsort = parsort1.thenCombine(parsort2, (xs1, xs2) -> {
				int[] result = new int[xs1.length + xs2.length];
				int ll = 0;
				int rr = 0;
				for (int i = 0; i < result.length; i++) {
					if (ll >= xs1.length)
						result[i] = xs2[rr++];
					else if (rr >= xs2.length)
						result[i] = xs1[ll++];
					else if ((xs1[ll] < xs2[rr]))
						result[i] = xs1[ll++];
					else
						result[i] = xs2[rr++];
				}
				return result;
			});

			parsort.whenComplete((result, throwable) -> {
				for (int i = 0; i < result.length; i++) {
					array[from + i] = result[i];
				}
			});
			parsort.join();
		}
	}

	private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
		return CompletableFuture.supplyAsync(() -> {
			int[] result = new int[to - from];
			for (int i = 0; i < result.length; i++) {
				result[i] = array[from + i];
			}
			sort(result, 0, result.length);
			return result;
		});
	}
}
