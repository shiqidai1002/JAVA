/**
 * 
 */
package obs;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Shiqi
 *
 */
public class EventSubscriber implements Observer{

	@Override
	public void update(Observable arg0, Object arg1){
		//react to update
		System.out.println("ES receive update from: " + arg0);
		System.out.println("               message: " + arg1);
	}
	
}
