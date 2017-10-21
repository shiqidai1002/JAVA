package helloWorld;

public class practice3c {
	public static void main ( String[] args){
		char i = '!';
		int x = 1;
		while ( x < 126 - 33 + 2){
			if ( x%10 == 0 ){
				System.out.println(i);
				i++;
			}
			else{
				System.out.print(i);
				i++;
			}
			x++;
		}
	}
}
