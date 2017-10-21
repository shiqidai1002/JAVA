package exercise;

public class Pair {
	private int a;
	private double b;
	
	Pair(int a, double b){
		this.a = a;
		this.b = b;
	}
  
  public int getInt(){
  	return a;
  }
  
  public double getDouble(){
  	return b;
  }
	
	public boolean equals(Object p){ //equal(Object other)
	/**
	 * This method is basically using hashCode() to compare different objects.
	 * When it catches the ClassCastException, it will try to cast the object to Pair, then compares.
	 */
		if (hashCode() != p.hashCode()) {
			return false;
		}
		try {
			return (a == ((Pair) p).getInt()) && (b == ((Pair) p).getDouble());
		} 
		catch (ClassCastException cce) {
			return false;
	    }
	}
	
	public int hashCode() {
	/**
	 * Both 17 and 27 are magic numbers. They don't have certain meanings.
	 * There is a possibility that two different objects has the same hash code.
	 * ¡ü This is because of our hashCode() only return integer type and integer type cannot cover all possibilities of Pair object.
	 */
		return (int) (a * 17 + b * 27); 
	}
	
	public String toString(){
		String str = " Integer: " + a + ", " 
					+ "Double: " + b + ". ";
		return str;
	}
	
}