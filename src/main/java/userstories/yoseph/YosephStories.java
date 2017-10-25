package main.java.userstories.yoseph;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.*;

public class YosephStories {

	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		US01.DatesBeforeNow(individuals, families);
		US02.BirthBeforeMarriage(individuals, families);
		US11.NoBigamy(families);
		US12.ParentsNotTooOld(individuals, families);
	}
	
}
