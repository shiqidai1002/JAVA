package exercise;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxMin {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        for(int i = 0; i < 2; i++){
        System.out.print(solve(arr)[i] + " ");
        }
    }
    
    public static long[] solve(int[] list){
        long total = 0;
        for (int i = 0; i < 5; i++){
            total = total + list[i];
        }
        long[] sum = new long[5];
        for (int i = 0; i < 5; i++){
            sum[i] = total - list[i];
        }
        long max = 0;
        long min = (long) (Math.pow(2, 63) - 1);
        for (int i = 0; i < 5; i++){
            if (sum[i] > max){
                max = sum[i];
            }
            if (sum[i] < min){
                min = sum[i];
            }
        }
        long[] result = {min , max};
        return result;
    }
}


//501893267 649027153 379408215 452968170 487530619