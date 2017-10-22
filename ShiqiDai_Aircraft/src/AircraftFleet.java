import java.util.ArrayList;
import java.util.HashMap;

public class AircraftFleet {
	protected ArrayList<Aircraft> fleet; 
	private HashMap<String, Aircraft> fleetHm; 

	public AircraftFleet() {
		fleet = new ArrayList<Aircraft>();
		fleetHm = new HashMap<String, Aircraft>();
	}
	

	public void add(Aircraft a) {
		fleet.add(a);
		fleetHm.put(a.id, a);
	}

	public void remove(Aircraft a) {
		fleet.remove(a);
		fleetHm.remove(a.id);
	}
	
	 
	public String displayAllAircrafts(){
		String s = "";
		for (Aircraft i : fleet){
			s = s + i.toString() + "\n";
		}
		return s;
	}

	public Aircraft getByID(String ID) {
		return fleetHm.get(ID);
	}
	
}
