package main.java.userstrories.jiadong;

import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstrories.linlei.Us05;
import main.java.userstrories.linlei.Us06;

/**
* @author 
*         E-mail:
* @date Oct 19, 2017 
* 
* @version 
*/
public class JiadongStories {

	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families) {
		Us03.DeathBeforeMarriage(individuals, families);
		Us04.DeathBeforeDivorce(individuals, families);
	}
	
}
