/*
Homework #3
Group Members:
-Yoseph Borai
-Daotong Wang
-Linlei Liu
-Oscar Chen
*/
import java.util.*;

//Main class from which all other methods will be run
class MathGuru{
    public static void main(String[] arg){
        char choice = '';
        char continue = 'y'
        int n = 0;
        Scanner in = new Scanner(System.in);

        do{
            do{
                System.out.println("Enter the letter corresponding to your desired function
                    ('p'=2^n|'f'=n!|'o'=Fibonacci)");
                choice = in.nextChar();
            }while(!(choice == 'q' || choice == 'f' || choice = 'o'));

            do{
                System.out.println("Enter a value for n(0 <= n <= 20:")
                n = in.nextInt();
            }while(n >= 0 && n <= 20);

            if(choice == 'p'){

            }
            else if(choice == 'f'){

            }
            else{

            }

            System.out.println("Would you like to make another calculation(y/n)?")
            continue = in.nextChar();
        }while
    }
}