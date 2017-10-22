
public class CargoAircraft extends Aircraft {

	 // Todo Shiki NONONO these are not supposed to be static! You will get 30% off on your assignment and then be mad if you don't change this.
	private static double length;//meter
	private static double height;//meter
	private static double width;//meter
	private static double cargoArea;//cubic meter

	public CargoAircraft(double length, double height, double width) {
		super();
		this.length = length;
		this.height = height;
		this.width = width;
		calculateCargoArea();
	}

	 // Todo Shiki either make this nonstatic or pass in the l, w, h, as parameters. 
	public static void calculateCargoArea() {
		cargoArea = length * height * width;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	 // Todo Shiki Will this interfere with your AircraftIO java file? Since we're adding extra lines for cargo planes but not accounting for it in the while loop.
	public String toString() {
		String s = super.toString() + "\ncargoArea=" + cargoArea + "\n";
		return s;
	}

}
