
public class myMerge {
	private static Comparable[] aux;

	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				// left half exhausted ( take from the right )
				aux[k] = a[j++];
			else if (j > hi)
				// right half exhausted ( take from the left )
				aux[k] = a[i++];
			else if (less(a[j], a[i]))
				// current key on right less than current key on left
				aux[k] = a[j++];
			else
				// current key on right greater than current key on left
				aux[k] = a[i++];
		}
	}

	public static void sort(Comparable a[]) {
		aux = new Comparable[a.length];
		for (int i = 0; i < a.length; i++) {
			aux[i] = a[i];
		}
		sort(aux, a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		int cutoff = 1;
		if (hi <= lo + cutoff - 1) {
			myInsertion.sort(a, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid + 1, hi);
		if (!less(a[mid + 1], a[mid])) {
			System.out.println("ccc");
			for(int i = lo; i<= hi; i++)
				aux[i] = a[i];
			return;
		}
		merge(a, aux, lo, mid, hi);
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
