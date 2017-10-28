import java.util.ArrayList;
import java.util.HashMap;

public class AircraftFleet {
	protected ArrayList<Aircraft> fleet = new ArrayList<Aircraft>(); // Todo Shiki Why protected?
	private HashMap<String, Aircraft> hm = new HashMap<String, Aircraft>(); // Todo Shiki name could be more descriptive. aircraftHashMap maybe?

	public AircraftFleet() {
		 // Todo Shiki this is the constructor. It would make more sense to initialize the arraylist and map in here rather than up above.
	}

	public void add(Aircraft a) {
		fleet.add(a);
		hm.put(a.ID, a);
	}

	public void remove(Aircraft a) {
		fleet.remove(a);
		hm.remove(a.ID);
	}
	
	 // Todo Shiki why do you have both a hashmap and an arraylist? Isn't just one hashmap good enough?
	public String displayAllAircrafts(){
		String s = "";
		for (Aircraft i : fleet){
			s = s + i.toString() + "\n";
		}
		return s;
	}

	public Aircraft getByID(String ID) {
		return hm.get(ID);
	}
	
}
