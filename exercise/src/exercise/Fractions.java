package exercise;


	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class Fractions {
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int arr[] = new int[n];
	        for(int arr_i=0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }
	        DecimalFormat df = new DecimalFormat("0.000000");
	        for (int i = 0; i < 3; i++){
	            System.out.println("" + df.format(solve(n, arr)[i]));
	        }
	    }
	    
	    public static double[] solve(int n, int[] arr){
	        double pf = 0;
	        double p = 0;
	        double nf = 0;
	        double ne = 0;
	        double zf = 0;
	        double z = 0;
	        for (int i = 0; i < n; i++){
	            if (arr[i] > 0){
	                p = p + 1;
	            }
	            if (arr[i] < 0){
	                ne = ne + 1;
	            }
	            z = z + 1;
	        }
	        pf = p / n;
	        nf = ne / n;
	        zf = z / n;
	        double[] result = {pf, nf, zf};
	        return result;
	    }
	}

