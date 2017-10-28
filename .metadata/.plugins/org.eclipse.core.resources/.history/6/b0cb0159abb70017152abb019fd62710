
public class CargoAircraft extends Aircraft {

	private double length;//meter
	private double height;//meter
	private double width;//meter
	private double cargoArea;//cubic meter

	public CargoAircraft(double length, double height, double width) {
		super();
		this.length = length;
		this.height = height;
		this.width = width;
		calculateCargoArea();
	}
	
	public CargoAircraft(String id, String make, String model, double fuelCap, double weight, double cargoWeight,
			double maxTakeoffWeight, double cruiseSpeed, double fuelFlowRate, double range, int crewNum, int payload, double cargoArea) {
		super(id, make, model, fuelCap, weight, cargoWeight, maxTakeoffWeight, cruiseSpeed,
				fuelFlowRate, range, crewNum, payload);
		this.cargoArea = cargoArea;
		// TODO SHIKI we're not setting the length width height in this constructor?
	}

	public void calculateCargoArea() {
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
	public void setLength(double length) { // TODO SHIKI IMPORTANT!!! YOU ARE NOT UDPATING THE TOTAL AREA WHEN THE LENGTH/HEIGHT/WIDTH CHANGES!
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

	 
	public String toString() {
		String s = super.toString().replaceFirst("Aircraft", "CargoAircraft") + "\ncargoArea=" + cargoArea + "\n";
		return s;
	}

}
