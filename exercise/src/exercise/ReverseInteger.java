package exercise;

import java.util.Stack;

public class ReverseInteger {

	
	public static int reverse(int n)
	{
		//输出结果定义为long
		long sum=0;
		while (n!=0)
		{
			int s=n%10;
			sum=sum*10+s;
			n=n/10;
		}
		
		//防止溢出操作
		if (sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
		{
			return 0;
		}
		return (int)sum;
	}
	
	public static int reverseByStack(int num){
		Stack<Integer> temp = new Stack<Integer>();
		int s = String.valueOf(num).length();//get digits of the integer
		int result = 0;
		
		//Breakdown session
		for (int n = s; n > 0; n--){
			int x =(int) Math.pow(10, n - 1 );
			int psh = num / x;
			System.out.println("psh:" + psh + "n:" + n );
			temp.push(psh);
			num = num - psh * x;
			System.out.println("num:" + num + "n:" + n );
		}
		System.out.println("Breakdown complete" );
		
		
		//Rebuild session
		for (int n = s; n > 0; n--){
			int pop = temp.pop();
			System.out.println("pop:" + pop + "n:" + n );
			int x = (int) Math.pow(10, n - 1 );
			result = result + pop * x;
		}
		return result;
	}
}
