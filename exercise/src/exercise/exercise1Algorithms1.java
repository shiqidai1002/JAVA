package exercise;
import java.util.ArrayList;
public class exercise1Algorithms1 {

	public static int findIndex1(int value, int[] array) {
		int size = array.length;
	  for (int i = 0; i < size; i++){
	  	if ( array[i] == value )
	    	return i;
	  }
	  return -1;
	}
	
	public static int findIndex2(int value, int[] array) {
		int size = array.length;
	  int middle = array[size/2];
	  if (value < middle) {
	  	for (int i = 0; i < size/2; i++) {
	  		if ( array[i] == value ) {
	    		return i;
	      }
	  	}
	  }
	  else if (value > middle) {
	  	for (int i = size/2; i < size; i++) {
	  		if ( array[i] == value ) {
	    		return i;
	  		}
	  	}
	  }
		else {
	   return size/2 - 1;
	  }
	  return -1;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		for (int x = 3; x < 100; x++) {
			System.out.println("For array size " + x + ", we went into the while loop "
					+ findIndex3(-1, list.toArray(new Integer[0])) + " times");
			list.add(x);
		}
	}

  
	public static int findIndex3(int value, Integer[] array) { // O(n)
		int counter = 0;
		int lowest = 0;
		int highest = array.length - 1;
		while (highest > lowest) {
			counter++;
			int middle = (highest + lowest) / 2; // The average of the two
			if (array[middle] == value) {
				// We found the answer
				return middle;
			} else if (array[middle] < value) {
				// The answer is above the middle
				lowest = middle + 1;
			} else {
				// The answer is below the middle
				highest = middle - 1;
			}
		}
		// We couldn't find the answer
		return counter;
	}

	//lowest = 50
	//highest = 51
	//array[50] = 10
	//value = 51
	//middle = 50


	}

	//Assume n is very big
	//1. go through length n and search up to n times. 
	//2. go through length n / 2 and search up to n/2 times.
	//3. go through length log(n) and search up to log(n) times.

