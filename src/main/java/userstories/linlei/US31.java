package main.java.userstories.linlei;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Nov 14, 2017 
* 
* @version 
*/
public class US31 {
	public static void LivingSingle(ArrayList<Individual> individuals, 
				ArrayList<Family> families, PrintWriter outFile){
		System.out.println("\nUS31: List all living single people:");
		System.out.format("%-6s%-20s%-10s%-16s%-7s%-16s", "ID","Name","Gender","Birthday",
				"Age","Child");
		System.out.println();
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = (Individual) iterator.next();
			if (individual.getAlive() && "NA".equals(individual.getAsSpouseOfFamily())) {
				System.out.format("%-6s%-20s%-10s%-16s%-7d%-16s", 	individual.getIndividualId(),
																		individual.getName(),
																		individual.getGender(),
																		individual.getBirthDate(),
																		individual.getAge(),
																		individual.getAsChildOfFamily());
				System.out.print("\r\n");
			}
		}
		System.out.println();
		
		outFile.println("\nUS31: List all living single people:");
		outFile.format("%-6s%-20s%-10s%-16s%-7s%-16s", "ID","Name","Gender","Birthday",
				"Age","Child");
		outFile.print("\r\n");
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = iterator.next();
			if (individual.getAlive() && "NA".equals(individual.getAsSpouseOfFamily())) {
				outFile.format("%-6s%-20s%-10s%-16s%-7s%-16s", individual.getIndividualId(),
																	individual.getName(),
																	individual.getGender(),
																	individual.getBirthDate(),
																	individual.getAge(),
																	individual.getAsChildOfFamily());
				outFile.print("\r\n");
			}
		}
		outFile.println();
		
		outFile.flush();
	}
}
