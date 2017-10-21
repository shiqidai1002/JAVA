import java.util.Random;

public class RandomWalk {
	private int x = 0;
	private int y = 0;
	private static int length = 1;

	public void move(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}

	public void randomWalk(int n) {
		for (int i = 0; i < n; i++) {
			Random r = new Random();
			int direction = r.nextInt(4);
			switch (direction) {
			case 0:
				//direction: north
				move(0, length); 
				break;
			case 1:
				//direction: east
				move(length, 0);
				break;
			case 2:
				//direction: south
				move(0, -length);
				break;
			case 3:
				//direction: west
				move(-length, 0);
				break;
			}
		}
	}

	public double distance() {	
		return Math.sqrt(x * x + y * y); 
	}
}
