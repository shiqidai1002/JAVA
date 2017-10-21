package exercise;

import java.util.Scanner;

public class BirthdayCakeCandles {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
    
    public static int birthdayCakeCandles(int a, int[] arr){
        int max = 0;
        for (int i = 0; i < a; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int count = 0;
        for (int i = 0; i < a; i++){
            if (arr[i] == max){
                ++count;
            }
        }
        return count;
        
    }
}
