import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		experiments(5000);

	}

	public static void experiments(int n) {
		double[] avg = { 0, 0, 0, 0, 0 };
		int[] arr = { 10, 100, 1000, 10000, 100000 };
		RandomWalk rw = new RandomWalk();
		for (int x = 0; x < n; x++) {
			// System.out.println("");
			// System.out.println("This is experiment " + (x+1));
			for (int i = 0; i < arr.length; i++) {
				rw.randomWalk(arr[i]);
				double dis = rw.distance();
				avg[i] = avg[i] + dis * dis / n;
				// System.out.println("The distance of " + arr[i] + "
				// randomWalks: " + rw.distance());
				rw = new RandomWalk();
			}
		}
		System.out.println("");
		System.out.println("");
		for (int a = 0; a < avg.length; a++) {
			System.out.printf(
					"This is the average of distance^2 after %d times %d-walks:  avg: %.2f%n ",n, arr[a], avg[a]);
			double assumption = arr[a];
			double approximateRate = avg[a] / arr[a];
			System.out.printf("Assumption : %d " + "(the average of distance^2 is equal to N)%n", arr[a]);
			System.out.printf("Approximate rate: %.2f%n%n", approximateRate);
		}
	}
}
