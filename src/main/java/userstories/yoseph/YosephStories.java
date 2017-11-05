package main.java.userstories.yoseph;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.PrintWriter;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.*;

public class YosephStories {

	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outfile) {
		US01.DatesBeforeNow(individuals, families, outfile);
		US02.BirthBeforeMarriage(individuals, families, outfile);
		US11.NoBigamy(families, outfile);
		US12.ParentsNotTooOld(individuals, families, outfile);
		US21.CorrectGenderForRole(individuals, families, outfile);
		US23.UniqueNameAndBirthDate(individuals, outfile);
	}
	
}
