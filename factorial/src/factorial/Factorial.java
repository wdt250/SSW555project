package factorial;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args){
		System.out.println("Input the number that you want to compute:");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 1;
		
		for(int i = n; i > 0; i--) {
			result = result * i;
		}
		
		System.out.println(result);
	}
}
