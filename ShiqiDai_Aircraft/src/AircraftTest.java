import java.util.List;
import java.util.ArrayList; // Todo Shiki unused import statements? 

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
	
	private static void run(){
		AircraftFleet fleet = new AircraftFleet();
		String fileNameToSave = "test9.txt";
		String fileNameToLoad = "test9.txt";
		System.out.println("Our Aircraft test program is beginning");
		System.out.println("\n"); 
		fleet.add(new Aircraft("N1762J", "Boeing", "777-300", 145538,  160520, 299370,892, 7500, 2, 396));
		fleet.add(new Aircraft("N1763J", "Airbus", "A333-300", 109185, 121870, 242000,871, 6000, 2, 440));
		fleet.add(new Aircraft("N1764J", "Boeing", "777-300", 145538,  160520, 299370,892, 7500, 2, 396));
		fleet.add(new Aircraft("N1765J", "Airbus", "A333-300", 109185, 121870, 242000,871, 6000, 2, 440));
		fleet.add(new Aircraft("N1766J", "Boeing", "777-300", 145538,  160520, 299370,892, 7500, 2, 396));
		fleet.add(new Aircraft("N1767J", "Airbus", "A333-300", 109185, 121870, 242000,871, 6000, 2, 440));
		FleetIO.save(fleet, fileNameToSave);  // TODO SHIKI have you considered making save a method in the Aircraft class that calls the save method in the IO class?
		System.out.println("Save succeed!");
		System.out.println("\n");
				System.out.println(FleetIO.load(fileNameToLoad).displayAllAircrafts());
		System.out.println("Load succeed!");
		System.out.println("\n");
		System.out.println("Our Aircraft test program is ending");
		
	}

}
