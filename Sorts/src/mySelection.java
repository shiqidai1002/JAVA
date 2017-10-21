
public class mySelection {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[i]))
					min = j;
			}
			exch(a, i, min);
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap;
		swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
