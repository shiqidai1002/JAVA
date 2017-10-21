
public class HelloArray {
	public static void main(String[] args){
		char[] word = {'H', 'e', 'l', 'l', 'o'};
		String result = "";
		for(int i = 0; i < 5; i++){
			result = result + word[i];
		}
		System.out.println(result);
	}

}
