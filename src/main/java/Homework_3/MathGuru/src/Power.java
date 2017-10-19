package main.java.Homework_3.MathGuru.src;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Sep 21, 2017 
*
*/
public class Power {
	
	public static int powerIt(int times) {
		int result = 1;

		for(int i = 0;i < times;i++){
			result *= 2;
		}
		return result;
	}
}
