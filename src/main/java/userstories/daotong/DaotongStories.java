package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;


/**
* @author Daotong Wang
*         E-mail: dwang37@stevens.edu
* @date 10/21/2017
*
* @version
*/
public class DaotongStories {

	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		US07.LessThan150YearsOld(individuals, outFile);
		US08.BirthBeforeMarriageofParents(individuals, families, outFile);
//		US14.MultipleBirthsNoMoreThan5(individuals, families, outFile);
		US18.SiblingsShouldNotMarry(families, outFile);
		US19.FirstCousinsShouldNotMarry(families, outFile);
	}

}