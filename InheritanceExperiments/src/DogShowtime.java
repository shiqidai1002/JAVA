/**
 * 
 */

/**
 * @author Shiqi
 *
 */
public class DogShowtime {

	public static void main(String[] args){
		Husky h1 = new Husky();
		h1.bark();//call the overridden one
		((Dog)h1).bark();//still call the overridden one
	}
}
