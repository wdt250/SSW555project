package main.java.userstories.yoseph;

import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.*;

/**
* @author 
*         E-mail:l
* @date Oct 19, 2017 
*
* @version 
*/
public class YosephStories {

	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families) {
		US01.DatesBeforeNow(individuals, families);
		US02.BirthBeforeMarriage(individuals, families);
		US11.NoBigamy(individuals, families);
		US12.ParentsNotTooOld(individuals, families);
	}
	
}
