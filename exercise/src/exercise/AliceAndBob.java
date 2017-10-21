package exercise;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AliceAndBob {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                c[a_i][a_j] = in.nextInt();
            }
        }
        System.out.println(solve(n,c));
    }
    public static int solve(int n, int c[][]){
        int sum_1 = 0;
        int sum_2 = 0;
        for (int a = 0; a < n; a++){
           sum_1 = sum_1 + c[a][a];
           System.out.println("sum1: "+ sum_1);
           sum_2 = sum_2 + c[a][n - 1 - a]; 
           System.out.println("sum2: "+ sum_2);
        }
        return Math.abs(sum_1 - sum_2);       
    }
}
