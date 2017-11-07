package main.java.userstories.linlei;

import java.io.PrintWriter;
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
	
	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		US05.DeathBeforeMarriage(individuals, families, outFile);
		US06.DeathBeforeDivorce(individuals, families, outFile);
		US10.MarriageAfter14(individuals, families, outFile);
		US13.SiblingSpace(individuals, families, outFile);
		US17.NoMarryDescendant(individuals, families, outFile);
		US20.AuntsAndUncles(individuals, families, outFile);
	}
	
}
