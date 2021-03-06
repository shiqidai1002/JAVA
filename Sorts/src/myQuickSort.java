import java.util.Random;

/**
 * @author Shiqi
 *
 */
public class myQuickSort {
	
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);
		sort(a, 0 , a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while(true){
			while(less(a[++i],v)){//find a larger one from the left
				if (i == hi)
					break;
			}
			while(less(v,a[--j])){//find a larger one from the right
				if(j == lo)
					break;
			}
			if(i > j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);//lo is the index of our current v
		return j;//return the position of our completed v.
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
