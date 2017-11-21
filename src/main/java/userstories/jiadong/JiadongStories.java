package main.java.userstories.jiadong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.jiadong.US03;
import main.java.userstories.jiadong.US04;
import main.java.userstories.jiadong.US15;
import main.java.userstories.jiadong.US16;
import main.java.userstories.jiadong.US22;
import main.java.userstories.jiadong.US24;

/**
* @author jiadong chen
*         E-mail:jchen69@stevens.edu
* @date Oct 25, 2017 
* 
* @version 
*/
public class JiadongStories {

	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		US03.birthBeforeDeath(individuals, outFile);
		US04.marriageBeforeDivorce(families, outFile);
		US15.fewerThan15Sib(families, outFile);
		US16.maleLastName(individuals, families, outFile);
		US22.uniqueIds(individuals, families, outFile);
		US24.uniqueFamiliesBySpouses(families, outFile);
		US28.orderSiblingByAge(individuals, families, outFile);
	}
	
}
