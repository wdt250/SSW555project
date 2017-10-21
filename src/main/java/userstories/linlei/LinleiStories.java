package main.java.userstories.linlei;

import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 19, 2017 
*
*/
public class LinleiStories {
	
	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families) {
		Us05.DeathBeforeMarriage(individuals, families);
		Us06.DeathBeforeDivorce(individuals, families);
	}
	
}
