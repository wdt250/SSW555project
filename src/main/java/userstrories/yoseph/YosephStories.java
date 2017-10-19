package main.java.userstrories.yoseph;

import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstrories.linlei.Us05;
import main.java.userstrories.linlei.Us06;

/**
* @author 
*         E-mail:l
* @date Oct 19, 2017 
*
* @version 
*/
public class YosephStories {

	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families) {
		Us01.DeathBeforeMarriage(individuals, families);
		Us02.DeathBeforeDivorce(individuals, families);
	}
	
}
