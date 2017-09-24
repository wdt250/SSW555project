public class FibonacciNum {

	public static int fibNum(int n){
		int c = 0;
		
		if (n==1 || n==2){
			c = 1;
			return c;
		}//this is the first 2 numbers of the Fibonacci
		else {
			int a=1,b=1;
			for (int i=0; i<n-2; i++){
				c = a+b;
				a = b;
				b = c;
			}
			return c;
		}//add the previous 2 numbers equals the next number
		
	}
}

