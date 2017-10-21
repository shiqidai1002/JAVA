
public class FibonacciSequence {
	public static void main(String[] args){
		int[] sequence = new int[40];
		sequence[0] = 1;
		sequence[1] = 1;
		for(int i = 2; i < 40; i++){
			sequence[i] = sequence[i - 1] + sequence[i - 2];
		}
		System.out.println("the value of the last index is: " + sequence[39]);
	}
}
