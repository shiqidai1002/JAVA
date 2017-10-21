package exercise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class bigSort {

	public static void exch(String[] unsorted, int min, int i) {
		String s;
		s = unsorted[min];
		unsorted[min] = unsorted[i];
		unsorted[i] = s;
	}

	public static boolean less(String a, String b) {
		// System.out.println("a" + " " + a);
		// System.out.println("b" + " " + b);
		if (a.length() != b.length()) {
			if (a.length() > b.length())
				return false;
			else
				return true;
		} else {
			for (int i = 0; i < a.length(); i++) {
				int A = Integer.valueOf(a.substring(i, i + 1)).intValue();
				int B = Integer.valueOf(b.substring(i, i + 1)).intValue();
				// System.out.println(A);
				// System.out.println(B);
				if (A > B)
					return false;
				else if (A < B)
					return true;
				else
					continue;
			}
		}
		return false;
	}

	public static void sort(String[] a) {
		String[] aux = new String[a.length];
		for (int i = 0; i < a.length; i++)
			aux[i] = a[i];
		sort(aux, a, 0, a.length - 1);
		a = aux;
	}

	public static void sort(String[] a, String[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid + 1, hi);
		// if (less(a[mid], a[mid + 1]))
		// System.out.println("improvement2");
		// return;
		merge(a, aux, lo, mid, hi);
	}

	public static void merge(String[] a, String[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				aux[k] = a[j++];
			else if (j > hi)
				aux[k] = a[i++];
			else if (less(a[i], a[j]))
				aux[k] = a[i++];
			else
				aux[k] = a[j++];
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] unsorted = new String[n];
		for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
			unsorted[unsorted_i] = in.next();
		}
		// your code goes here
		sort(unsorted);
		for (int i = 0; i < n; i++)
			System.out.println(unsorted[i]);
	}
}
