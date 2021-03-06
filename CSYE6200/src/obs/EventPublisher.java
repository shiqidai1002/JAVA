/**
 * 
 */
package obs;

import java.util.Observable;

/**
 * @author Shiqi
 *
 */
public class EventPublisher extends Observable{
	private boolean done = false; //set true to stop the run method
	private int ctr = 0;
	
	//Constructor
	public EventPublisher(){
		System.out.println("EventPublisher - we are here");
	}
	
	public void doAction(){
		setChanged();//Something happened
		notifyObservers("counter: " + ctr++);
	}
	
	public void run(){
		while(!done){
			doAction();
			if(ctr > 10)
				done = true;
		}
	}
	
	public static void main(String[] args){
		EventPublisher ep = new EventPublisher();
		EventSubscriber es = new EventSubscriber();
		ep.addObserver(es);//make the subscription
		ep.run();
		
	}
}
