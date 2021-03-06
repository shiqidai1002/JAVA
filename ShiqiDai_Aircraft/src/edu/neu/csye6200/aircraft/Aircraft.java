package edu.neu.csye6200.aircraft;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Aircraft class
 * 
 * @author SHIQI DAI NUID: 0018109581
 *
 */
public class Aircraft implements Comparable<Aircraft>{
	// fields
	String id;
	String make;
	String model;
	double fuelCap; // Kilograms
	double weight;// Kilograms
	double cargoWeight;// Kilograms : how much cargo is on board
	double maxTakeoffWeight;// Kilograms
	double cruiseSpeed; // Kilometers/hr
	double fuelFlowRate;// Kilograms/hr
	double range;// Kilometers
	int crewNum;
	int payload;

	/*
	 * constructor 1: full 12 variables
	 */
	public Aircraft(String id, String make, String model, double fuelCap, double weight, double cargoWeight,
			double maxTakeoffWeight, double cruiseSpeed, double fuelFlowRate, double range, int crewNum, int payload) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.fuelCap = fuelCap;
		this.weight = weight;
		this.cargoWeight = cargoWeight;
		this.maxTakeoffWeight = maxTakeoffWeight;
		this.cruiseSpeed = cruiseSpeed;
		this.fuelFlowRate = fuelFlowRate;
		this.range = range;
		this.crewNum = crewNum;
		this.payload = payload;
	}

	/*
	 * constructor 2:  10 variables
	 */
	public Aircraft(String id, String make, String model, double fuelCap, double weight, double maxTakeoffWeight,
			double cruiseSpeed, double fuelFlowRate, int crewNum, int payload) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.fuelCap = fuelCap;
		this.weight = weight;
		this.maxTakeoffWeight = maxTakeoffWeight;
		this.cruiseSpeed = cruiseSpeed;
		this.fuelFlowRate = fuelFlowRate;
		this.crewNum = crewNum;
		this.payload = payload;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the maxTakeoffWeight
	 */
	public double getMaxTakeoffWeight() {
		return maxTakeoffWeight;
	}

	/**
	 * @param maxTakeoffWeight
	 *            the maxTakeoffWeight to set
	 */
	public void setMaxTakeoffWeight(double maxTakeoffWeight) {
		this.maxTakeoffWeight = maxTakeoffWeight;
	}

	/**
	 * @return the cargoWeight
	 */
	public double getCargoWeight() {
		return cargoWeight;
	}

	/**
	 * @param cargoWeight
	 *            the cargoWeight to set
	 */
	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	/**
	 * @return the id
	 */
	public String getID() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * @param range
	 *            the range to set
	 */
	public void setRange(double range) {
		this.range = range;
	}

	/**
	 * @return the crewNum
	 */
	public int getCrewNum() {
		return crewNum;
	}

	/**
	 * @param crewNum
	 *            the crewNum to set
	 */
	public void setCrewNum(int crewNum) {
		this.crewNum = crewNum;
	}

	/**
	 * @return the fuelCap
	 */
	public double getFuelCap() {
		return fuelCap;
	}

	/**
	 * @param fuelCap
	 *            the fuelCap to set
	 */
	public void setFuelCap(double fuelCap) {
		this.fuelCap = fuelCap;
	}

	/**
	 * @return the cruiseSpeed
	 */
	public double getCruiseSpeed() {
		return cruiseSpeed;
	}

	/**
	 * @param cruiseSpeed
	 *            the cruiseSpeed to set
	 */
	public void setCruiseSpeed(double cruiseSpeed) {
		this.cruiseSpeed = cruiseSpeed;
	}

	/**
	 * @return the fuelFlowRate
	 */
	public double getFuelFlowRate() {
		return fuelFlowRate;
	}

	/**
	 * @param fuelFlowRate
	 *            the fuelFlowRate to set
	 */
	public void setFuelFlowRate(double fuelFlowRate) {
		this.fuelFlowRate = fuelFlowRate;
	}

	/**
	 * @return the range
	 */
	public double getRange() {
		return range;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make
	 *            the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the payload
	 */
	public int getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(int payload) {
		this.payload = payload;
	}

	/**
	 * @author Shiqi Dai
	 */
	public void calculateRange() {
		double maxFlightTime = fuelCap / fuelFlowRate;
		range = maxFlightTime * cruiseSpeed;
	}

	public double availableCargoCap() {
		return maxTakeoffWeight - weight - cargoWeight - fuelCap;
	}

	public void save(Aircraft ac, String fileName) {
		BufferedWriter bw;
		try {
			final String newline = System.getProperty("line.separator");
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.append(ac.toString().replace("\n", newline));
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.err.println("IO ERROR received: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "\n[Aircraft]" + "\nID=" + id + "\nmake=" + make + "\nmodel=" + model + "\nfuelCap=" + fuelCap
				+ "\nweight=" + weight + "\ncargoWeight=" + cargoWeight + "\nmaxTakeoffWeight=" + maxTakeoffWeight
				+ "\ncruiseSpeed=" + cruiseSpeed + "\nfuelFlowRate=" + fuelFlowRate + "\nrange=" + range + "\ncrewNum="
				+ crewNum + "\npayload=" + payload;
	}

	@Override
	public int compareTo(Aircraft a) {
		int thisId = Integer.parseInt(id);
		int aId = Integer.parseInt(a.id);
		if(thisId > aId)
			return 1;
		if(thisId < aId)
			return -1;
		else
			return 0;
	}


}
