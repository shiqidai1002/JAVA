import java.util.Arrays;

public class SortName {
	public static void main(String[] args){
		String[] names = {"ShiqiDai", "QingDai", "LiLin"};
		Arrays.sort(names);
		for(int i = 0; i < 3; i++){
			System.out.println(names[i]);
		}
	}
}
