import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Shiqi
 *
 */
public class FleetIO {
	private static BufferedWriter bw;
	private static BufferedReader br;

	/**
	 * passing in a AircraftFleet and a filename as parameters
	 * 
	 * @param a
	 * @param fileName
	 * @author Shiqi
	 * 
	 */
	public static AircraftFleet load(String fileName) {
		AircraftFleet a = new AircraftFleet();
		Aircraft ac;
		try {
			br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			String s = br.readLine();
			while (s != null) {
				String id = br.readLine().split("=")[1];
				String make = br.readLine().split("=")[1];
				String model = br.readLine().split("=")[1];
				double fuelCap = Double.parseDouble(br.readLine().split("=")[1]);
				double weight = Double.parseDouble(br.readLine().split("=")[1]);
				double cargoWeight = Double.parseDouble(br.readLine().split("=")[1]);
				double maxTakeoffWeight = Double.parseDouble(br.readLine().split("=")[1]);
				double cruiseSpeed = Double.parseDouble(br.readLine().split("=")[1]);
				double fuelFlowRate = Double.parseDouble(br.readLine().split("=")[1]);
				double range = Double.parseDouble(br.readLine().split("=")[1]);
				int crewNum = Integer.parseInt(br.readLine().split("=")[1]);
				int payload = Integer.parseInt(br.readLine().split("=")[1]);
				if (s.equals("[CargoAircraft]")) {
					double cargoAreaLength = Double.parseDouble(br.readLine().split("=")[1]);
					double cargoAreaHeight = Double.parseDouble(br.readLine().split("=")[1]);
					double cargoAreaWidth = Double.parseDouble(br.readLine().split("=")[1]);
					double cargoArea = Double.parseDouble(br.readLine().split("=")[1]);
					ac = new CargoAircraft(id, make, model, fuelCap, weight, maxTakeoffWeight, cruiseSpeed,
							fuelFlowRate, crewNum, payload, cargoAreaLength, cargoAreaHeight, cargoAreaWidth,
							cargoArea);
				} else {
					ac = new Aircraft(id, make, model, fuelCap, weight, cargoWeight, maxTakeoffWeight, cruiseSpeed,
							fuelFlowRate, range, crewNum, payload);
				}
				a.add(ac);
				br.readLine();// skip the blank that divided different Aircraft
								// in the file
				s = br.readLine();// update s
			}
		} catch (IOException e) {
			System.err.println("IO ERROR received: " + e.getMessage());
			e.printStackTrace();
		}
		return a;

	}

	/**
	 * 
	 * writing an AircraftFleet to a file
	 * 
	 * @param a
	 * @param fileName
	 * @author Shiqi
	 * 
	 */
	public static void save(AircraftFleet a, String fileName) {
		for (Aircraft ac : a.fleet) {
			save(ac, fileName);
		}
	}

	/**
	 * writing a single aircraft to an open file
	 * 
	 * @param ac
	 * @author Shiqi
	 */
	private static void save(Aircraft ac, String fileName) {
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
}
