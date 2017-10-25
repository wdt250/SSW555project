package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
<<<<<<< HEAD
import main.java.userstories.daotong.Us07;
import main.java.userstories.daotong.Us08;
=======
>>>>>>> branch 'master' of https://github.com/wdt250/SSW555project

/**
* @author Daotong Wang
*         E-mail: dwang37@stevens.edu
* @date 10/21/2017
*
* @version
*/
public class DaotongStories {

<<<<<<< HEAD
	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families) {
		Us07.LessThan150YearsOld(individuals);
		Us08.BirthBeforeMarriageofParents(individuals, families);
		Us14.MultipleBirthsNoMoreThan5(individuals, families);
=======
	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		Us07.DeathBeforeMarriage(individuals, families);
		Us08.DeathBeforeDivorce(individuals, families);
		System.out.println("abc");
		System.out.println("Just a test");;
>>>>>>> branch 'master' of https://github.com/wdt250/SSW555project
	}

}
