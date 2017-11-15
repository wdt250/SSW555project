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
public class US30 {
	public static void LivingMarried(ArrayList<Individual> individuals, 
			ArrayList<Family> families, PrintWriter outFile){
		
		System.out.println("\nUS30: List all living married people:");
		System.out.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s", "ID","Name","Gender","Birthday",
				"Age","Child","Spouse");
		System.out.println();
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = (Individual) iterator.next();
			if (individual.getAlive() && !"NA".equals(individual.getAsSpouseOfFamily())) {
				System.out.format("%-6s%-20s%-10s%-16s%-7d%-16s%-10s", 	individual.getIndividualId(),
																		individual.getName(),
																		individual.getGender(),
																		individual.getBirthDate(),
																		individual.getAge(),
																		individual.getAsChildOfFamily(),
																		individual.getAsSpouseOfFamily());
				System.out.print("\r\n");
			}
		}
		System.out.println();
		
		outFile.println("\nUS30: List all living married people:");
		outFile.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s", "ID","Name","Gender","Birthday",
				"Age","Child","Spouse");
		outFile.print("\r\n");
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = iterator.next();
			if (individual.getAlive() && !"NA".equals(individual.getAsSpouseOfFamily())) {
				outFile.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s", individual.getIndividualId(),
																	individual.getName(),
																	individual.getGender(),
																	individual.getBirthDate(),
																	individual.getAge(),
																	individual.getAsChildOfFamily(),
																	individual.getAsSpouseOfFamily());
				outFile.print("\r\n");
			}
		}
		outFile.println();
		
		outFile.flush();
	}
}
