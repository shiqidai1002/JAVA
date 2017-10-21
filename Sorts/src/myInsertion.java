
public class myInsertion {

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap;
		swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
			}
		}
	}
	public static void sort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i < hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
					exch(a, j, j - 1);
			}
		}
	}
}
