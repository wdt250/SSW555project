package project;
/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Sep 21, 2017 
*
*/
public class Power {
	
	public double powerIt(double times) {
		return Math.pow(2, times);
	}
	
	public static void main(String[] args) {
		Power power = new Power();
		System.out.println(power.powerIt(5));
	}
}
