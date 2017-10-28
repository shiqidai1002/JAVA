package edu.neu.csye6200.aircraft;

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
		AircraftFleet fleet = AircraftFleet.instance();
		FleetIO io = new FleetIO("FleetIO.log");
		System.out.println("Our Aircraft test program is beginning");
		System.out.println("\n");
		fleet.add(new CargoAircraft("1769", "Boeing", "777-300", 145538, 160520, 299370, 892, 7500, 2, 396, 50.3, 5.4,
				4.5));
		fleet.add(new Aircraft("1763", "Airbus", "A333-300", 109185, 121870, 242000, 871, 6000, 2, 440));
		fleet.add(new Aircraft("1764", "Boeing", "777-300", 145538, 160520, 299370, 892, 7500, 2, 396));
		fleet.add(new Aircraft("1765", "Airbus", "A333-300", 109185, 121870, 242000, 871, 6000, 2, 440));
		fleet.add(new Aircraft("1766", "Boeing", "777-300", 145538, 160520, 299370, 892, 7500, 2, 396));
		fleet.add(new CargoAircraft("1767", "Airbus", "A333-300", 109185, 121870, 242000, 871, 6000, 2, 440, 50.5,
				5.5, 4.2));
		fleet.add(new Aircraft("1764", "Boeing", "777-300", 145538, 160520, 299370, 892, 7500, 2, 396));
		fleet.add(new Aircraft("1765", "Airbus", "A333-300", 109185, 121870, 242000, 871, 6000, 2, 440));
		fleet.add(new Aircraft("1766", "Boeing", "777-300", 145538, 160520, 299370, 892, 7500, 2, 396));
		fleet.add(new CargoAircraft("1767", "Airbus", "A333-300", 109185, 121870, 242000, 871, 6000, 2, 440, 50.5,
				5.5, 4.2));
		fleet.sort();
		System.out.println(fleet.displayAllAircrafts());
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("Our Aircraft test program is ending");

	}

}
