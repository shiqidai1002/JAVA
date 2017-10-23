
/**
 * Aircraft Test Program Class
 * 
 * @author SHIQI DAI NUID: 001819581
 *
 */
public class AircraftTest {
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		AircraftFleet fleet = new AircraftFleet();
		String fileNameToSave = "test17.txt";
		String fileNameToLoad = "test17.txt";
		System.out.println("Our Aircraft test program is beginning");
		System.out.println("\n");
		fleet.add(new Aircraft("N1762J", "Boeing", "777-300", 145538, 160520, 299370, 892, 7500, 2, 396));
		fleet.add(new Aircraft("N1763J", "Airbus", "A333-300", 109185, 121870, 242000, 871, 6000, 2, 440));
		fleet.add(new Aircraft("N1764J", "Boeing", "777-300", 145538, 160520, 299370, 892, 7500, 2, 396));
		fleet.add(new Aircraft("N1765J", "Airbus", "A333-300", 109185, 121870, 242000, 871, 6000, 2, 440));
		fleet.add(new Aircraft("N1766J", "Boeing", "777-300", 145538, 160520, 299370, 892, 7500, 2, 396));
		fleet.add(new CargoAircraft("N1767J", "Airbus", "A333-300", 109185, 121870, 242000, 871, 6000, 2, 440, 50.5,
				5.5, 4.2));
		FleetIO.save(fleet, fileNameToSave);
		System.out.println("Save succeed!");
		System.out.println("\n");
		System.out.println(FleetIO.load(fileNameToLoad).displayAllAircrafts());
		System.out.println("Load succeed!");
		System.out.println("\n");
		System.out.println("Our Aircraft test program is ending");

	}

}
