package helloWorld;

public class practice3d {
	public static void main ( String[] args){
		char i = '!';
		int x = 1;
		while ( x < 126 - 33 + 2){
			int y = 32 + x;
			if ( x%5 == 0 ){
				if (y > 99){
				System.out.println("Index " + y + ": " + i + "   ");
				i++;	
				}
				else{
					System.out.println("Index " + y + ":  " + i + "   ");
					i++;
				}
			}
			else{
				if (y > 99){
				System.out.print("Index " + y + ": " + i + "   ");
				i++;	
				}
				else{
					System.out.print("Index " + y + ":  " + i + "   ");
					i++;
				}
			}
			x++;
		}
	}
}
