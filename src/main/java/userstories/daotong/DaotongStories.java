package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;

/**
* @author
*         E-mail:
* @date Oct 19, 2017
*
* @version
*/
public class DaotongStories {

	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		Us07.DeathBeforeMarriage(individuals, families);
		Us08.DeathBeforeDivorce(individuals, families);
		System.out.println("abc");
		System.out.println("Just a test");;
	}

}
