
public class test {
	public static void main(String[] args) {
		Integer[] a = { 8, 7, 6, 5, 6, 4, 2, 8, 90, 7, 64, 7, 43, 6, 3, 56, 4, 3, 2, 1, 66, 4, 2, 6 };
		myMerge.sort(a);
		int N = a.length;
		for (int i = 0; i < N; i++)
			System.out.print(a[i] + " ");
	}
}
