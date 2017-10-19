package main.java.Homework_3.MathGuru.src;
/*

Homework #3
Group Members:
-Yoseph Borai
-Daotong Wang
-Linlei Liu
-Oscar Chen
*/
import java.util.Scanner;

//Main class from which all other methods will be run
public class MathGuru{
    public static void main(String[] arg){
        char choice = 'a';
        char cont = 'y';
        int n = -1;
        Scanner in = new Scanner(System.in);

        do{
            do{
                System.out.println("Enter the letter corresponding to your desired function('p'=2^n|'f'=n!|'o'=Fibonacci)");
                choice = in.next().charAt(0);
            }while(!(choice == 'p' || choice == 'f' || choice == 'o'));

            do{
                System.out.println("Enter a value for n(0 <= n <= 20):");
                n = in.nextInt();
            }while(n < 0 && n > 20);

            if(choice == 'p'){
                System.out.println("2^" + n + " = " + Power.powerIt(n));
            }
            else if(choice == 'f'){
                System.out.println("Factorial of " + n + " is " + Factorial.factorial(n));
            }
            else{
                System.out.println(n + "th term of fibonacci is " + FibonacciNum.fibNum(n));
            }

            System.out.println("Would you like to make another calculation(y/n)?");
            cont = in.next().charAt(0);
        }while(cont == 'y');
        
        in.close();
    }
}
