package edu.neu.csye6200.aircraft;

public class CargoAircraft extends Aircraft {

	private double cargoAreaLength;// meter
	private double cargoAreaHeight;// meter
	private double cargoAreaWidth;// meter
	private double cargoArea;// cubic meter

	/*
	 * passed-in values: normal aircraft + 3 cargoAircraft variables
	 */
	public CargoAircraft(String id, String make, String model, double fuelCap, double weight, double maxTakeoffWeight,
			double cruiseSpeed, double fuelFlowRate, int crewNum, int payload, double length, double height,
			double width) {
		super(id, make, model, fuelCap, weight, maxTakeoffWeight, cruiseSpeed, fuelFlowRate, crewNum, payload);
		this.cargoAreaLength = length;
		this.cargoAreaHeight = height;
		this.cargoAreaWidth = width;
		calculateCargoArea();
	}

	/*
	 * Passed-in values: normal aircraft + 3 cargoAircraft variables + cargoArea
	 * This is only used for reading profiles from disk.
	 */
	public CargoAircraft(String id, String make, String model, double fuelCap, double weight, double maxTakeoffWeight,
			double cruiseSpeed, double fuelFlowRate, int crewNum, int payload, double length, double height,
			double width, double cargoArea) throws Exception {
		super(id, make, model, fuelCap, weight, maxTakeoffWeight, cruiseSpeed, fuelFlowRate, crewNum, payload);
		this.cargoAreaLength = length;
		this.cargoAreaHeight = height;
		this.cargoAreaWidth = width;
		if(length * height * width != cargoArea)
			throw new Exception("Please rechck your entering!");
		this.cargoArea = cargoArea;
	}

	public void calculateCargoArea() {
		cargoArea = cargoAreaHeight * cargoAreaHeight * cargoAreaHeight;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return cargoAreaHeight;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(double length) {
		this.cargoAreaHeight = length;
		calculateCargoArea();
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return cargoAreaHeight;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.cargoAreaHeight = height;
		calculateCargoArea();
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return cargoAreaHeight;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(double width) {
		this.cargoAreaHeight = width;
		calculateCargoArea();
	}
	@Override
	public String toString() {
		String s = super.toString().replace("\n[Aircraft]", "\n[CargoAircraft]") + "\ncargoAreaLength=" + cargoAreaLength
				+ "\ncargoAreaHeight=" + cargoAreaHeight + "\ncargoAreaWidth=" + cargoAreaWidth + "\ncargoArea="
				+ cargoArea;
		return s;
	}

}
