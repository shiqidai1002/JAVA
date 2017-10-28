package edu.neu.csye6200.aircraft;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class AircraftFleet {
	private static AircraftFleet instance = null;
	protected ArrayList<Aircraft> fleet;
	private HashMap<String, Aircraft> fleetHm;
	private static Logger log;
	Handler handler;

	private AircraftFleet() {
		fleet = new ArrayList<Aircraft>();
		fleetHm = new HashMap<String, Aircraft>();
		try {
			handler = new FileHandler("AircraftFleet.log");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		log = Logger.getLogger("AircraftFleet");
		log.addHandler(handler);
	}

	public static AircraftFleet instance(){
		if (instance == null)
			instance = new AircraftFleet();
		log.info("The instace of AircraftFleet has been called.");
		return instance;
	}
	
	public void add(Aircraft a) {
		fleet.add(a);
		fleetHm.put(a.id, a);
		log.info("one aircraft has been added into fleet.");
	}

	public void remove(Aircraft a) {
		fleet.remove(a);
		fleetHm.remove(a.id);
		log.info("one aircraft has been removed into fleet.");
	}

	public String displayAllAircrafts() {
		String s = "";
		for (Aircraft i : fleet) {
			s = s + i.toString() + "\n";
		}
		return s;
	}
	
	/*sorts your aircraft by tail number ID
	 * Ensure that you have at least 10 Aircraft defined
	 * Print the results
	 */
	public void sort(){
		int n = fleet.size();
		for (int i = 1; i<n; i++){
			for(int j = i; j>0;j--){
				if(fleet.get(j).compareTo(fleet.get(j - 1)) < 0){
					Aircraft swap = fleet.get(j);
					fleet.set(j, fleet.get(j - 1));
					fleet.set(j - 1, swap);
				}
			}
		}
 	}
	
	public Aircraft getByID(String ID) {
		return fleetHm.get(ID);
	}

}
