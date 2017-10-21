package exercise;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StairCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] output = new String[n];
        for (int i = 0; i < n; i ++){
            int a = 0;
            for (;a < n - i - 1; a++ ){
                output[a] = " ";
                System.out.println("a: " + a);
                System.out.println("output["+ a +"]: " + output[a]);
            }
            for (; a < n; a++ ){
                output[a] = "*";
                System.out.println("a: " + a);
                System.out.println("output["+ a +"]: " + output[a]);
            }
        System.out.println(toString(n, output));
        output = new String[n];
        }
    }
    
    public static String toString(int n, String[] arr){
    	String result = "";
    	for (int i = 0; i < n; i++){
    		result = result + arr[i];
    	}
    	return result;
    }
}
