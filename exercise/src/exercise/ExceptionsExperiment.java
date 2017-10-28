/**
 * 
 */
package exercise;

/**
 * @author Shiqi
 *
 */
public class ExceptionsExperiment {
	
	public static void main(String[] args){
		try{
			throw new Exception();
		}
		catch(Exception e){
			System.out.println("We got an exception!");
		}
		finally{
			System.out.println("Do you hear that?");
		}
	}

}
