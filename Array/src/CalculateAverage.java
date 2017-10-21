
public class CalculateAverage {
	public static void main(String[] args){
		int[] array = new int[10];
		for (int x = 0; x < 10; x++){
			array[x] = x + 1;
		}
		double sum = 0;
		for (int i = 0; i < 10; i++){
			sum = sum + array[i];
		}
		System.out.println("the Average of the Array is:" + sum/array.length);
	}
}
