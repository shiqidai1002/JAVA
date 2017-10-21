package helloWorld;

public class practice3b {
	public static void main( String[] args){
		char i = '!';
		for (int x = 1; x < 126 - 33 + 2; x++){
			if ( x%10 == 0 ){
				System.out.println(i);
				i++;
			}
			else{
				System.out.print(i);
				i++;
			}
		}
	}
}
