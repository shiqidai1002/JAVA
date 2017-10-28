/**
 * 
 */

/**
 * @author Shiqi
 *
 */
public class MeterManager {

	//private but static single instance
	private static MeterManager instance = null;
	
	
	//private constructor
	private MeterManager(){
		
	}
	
	//single pattern creation
	public static MeterManager instance(){
		if(instance == null)
			instance = new MeterManager();
		return instance;
	}
}
