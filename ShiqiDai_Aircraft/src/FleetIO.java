import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader; // Todo Shiki unused import statements?
import java.io.Writer;

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
			String s = br.readLine();
			while(s != null) { 
				String id = br.readLine().split("=")[1]; // 
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
				if(s == "CargoAircraft"){
					double cargoArea = Double.parseDouble(br.readLine().split("=")[1]);
					ac = new CargoAircraft(id, make, model, fuelCap, weight, cargoWeight, maxTakeoffWeight, cruiseSpeed,
							fuelFlowRate, range, crewNum, payload, cargoArea);
				}
				ac = new Aircraft(id, make, model, fuelCap, weight, cargoWeight, maxTakeoffWeight, cruiseSpeed,
						fuelFlowRate, range, crewNum, payload);
				a.add(ac);
				br.readLine();//skip the blank that divided different Aircraft in the file
			} 
		} catch (IOException e) {
			System.err.println("IO ERROR received: " + e.getMessage());
			e.printStackTrace(); //TODO George our professor gave us this template. I am not sure if it's true as well.
		}
		return a;

	}

	 // TODO George This is what our professor asked.  I will post his instructions towards this assignment.
	
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
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.append(ac.toString().replace("\n", "\r\n")); // TODO George I remember my professor uses mac. However I don't know how to use System.getProperty("newline") or something instead of "\r\n".
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.err.println("IO ERROR received: " + e.getMessage());
			e.printStackTrace(); 
		}
	}
}
