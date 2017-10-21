import java.util.Random;

public class Test {
	public static void main(String args[]) {
		int n = 1000;
		double runTimes = 100000;
		double avg = 0;
		double result;
		for (int i = 0; i < runTimes; i++) {
			result = count(n);
			System.out.println("connections: " + result);
			avg = avg + result / runTimes;
		}
		System.out.println("N is " + n);
		System.out.println("average of " + runTimes + " times : " + avg);
		System.out.println("assumption: " + 0.5 * n * Math.log(n));
	}

	public static int count(int n) {
		int count = 0;
		Random rd = new Random();
		WQUPC test = new WQUPC(n);
		while (test.count != 1) {
			int p = rd.nextInt(n);
			int q;
			do {
				q = rd.nextInt(n);
			} while (p == q);
			if (!test.connected(p, q)) {
				test.union(p, q);
			}
			count++;
		}
		return count;
	}
}
