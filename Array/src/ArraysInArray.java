

public class ArraysInArray {
	public static void main(String[] args){
		int[][] shenmegui = new int[5][5];
		for(int x = 0; x < 5; x++){
			for(int i = 0; i < 5; i++){
				shenmegui[x][i] = i + 1;
				System.out.print(shenmegui[x][i]);
			}
			System.out.println("");
		}
	}
}
