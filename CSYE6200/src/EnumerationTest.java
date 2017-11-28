/**
 * 
 */

/**
 * @author Shiqi
 *
 */
public class EnumerationTest {

	enum WeekDay {SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);
		private int value;
		WeekDay(int n) {value = n;}
		public int getValue(){return value;}
	}
	
	private WeekDay myDay = WeekDay.WEDNESDAY;
	
	
	/**
	 * @return the myDay
	 */
	public WeekDay getMyDay() {
		return myDay;
	}

	/**
	 * @param myDay the myDay to set
	 */
	public void setMyDay(WeekDay myDay) {
		this.myDay = myDay;
	}

	public EnumerationTest(){
		System.out.println("Current Day is: " + myDay);
		setMyDay(WeekDay.TUESDAY);
		System.out.println("Current Day is: " + myDay);
		
		for(WeekDay d : WeekDay.values()){
			System.out.println("Day: " + d.name() + "\nOrdinal: " + d.ordinal() + "\nValue: " + d.value);
		}
	}
	
	public static void main(String[] args){
		EnumerationTest et = new EnumerationTest();
	}
}
