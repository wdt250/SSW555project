package cs_projection_3;

import java.util.Scanner;

public class FibonacciNum {

	public static int FebNum(int n){
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
	
	public static void main(String args[]){
		
		int input;
		int output;
		int flag = 1;//determine if the input will continue, but will always be 1
		
		Scanner s = new Scanner(System.in);
		
		while (flag == 1){
			
			System.out.println("please input the number of which Febonacci number you want to know:");
			input = s.nextInt();
			output=FebNum(input);
			
			System.out.println("It is "+ output);
			
			System.out.println("Do you want to continue or not? Y/N (Y is yes, N is no)");
			
			int flag2 = 1;//examine if the user wants to continue
			
			while(flag2 == 1){
				String sCurrent = s.next();
				if (sCurrent.equals("Y") || sCurrent.equals("N")){
					
					switch (sCurrent){
					case "Y":
						System.out.println("----------------okay, let's get back---------------");
						flag2--;
						break;
					case "N":
						System.out.println("--------------------good bye----------------------");
						System.exit(1);
					}
					
				}
				
				else {
					System.out.println("-------invalid input, please input again-------------");
					s.nextLine();
				}
			}//determine the input
		}
	}
}
