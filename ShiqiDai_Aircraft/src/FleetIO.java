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
			while(br.readLine() != null) { // Todo Shiki similar to my comment in cargoplane, do we want to account for the fact that the toString of cargoplanes have a few extra lines?
				String ID = br.readLine().split("=")[1]; // Todo Shiki lowercase id
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
				ac = new Aircraft(ID, make, model, fuelCap, weight, cargoWeight, maxTakeoffWeight, cruiseSpeed,
						fuelFlowRate, range, crewNum, payload);
				a.add(ac);
				br.readLine();//skip the blank that divided different Aircraft in the file
			} 
		} catch (IOException e) {
			System.err.println("IO ERROR received: " + e.getMessage());
			e.printStackTrace(); // Todo Shiki I'm pretty sure you're printing the stack trace twice like this, but I could be wrong
		}
		return a;

	}

	 // Todo Shiki you have two methods called save, which is weird. You should be more specific with the naming of at least the second one.
	
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
			bw.append(ac.toString().replace("\n", "\r\n")); // Todo Shiki This certainly works but only for Windows. If possible, try usith System.getProperty("newline") or something instead of "\r\n"
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.err.println("IO ERROR received: " + e.getMessage());
			e.printStackTrace(); // Todo Shiki I'm pretty sure you're printing the stack trace twice like this, but I could be wrong.
		}
	}
}
