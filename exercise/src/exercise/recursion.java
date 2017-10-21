package exercise;

public class recursion {
 public static void main(String[] args){ 
	 System.out.println(fibIterative(18));
	 System.out.println(fib(18));
}
public static int fib(int n) {
			if (n == 1) {
				return 1;
		  }
		  if (n == 2) {
		  	return 1;
		  }
		  return fib(n-1) + fib(n-2);
		}

public static long fibIterative(int n) {
	  if (n == 1) {
			return 1;
	  }
	  if (n == 2) {
	  	return 1;
	  }

	  int a = 1;
	  int b = 1;
	  int value = 0;
	  for ( int i = 3; i <= n; i++ ) {
	    value = a + b;
	    b = a;
	    a = value;
	    
	  }
	  return value;
	}
 }