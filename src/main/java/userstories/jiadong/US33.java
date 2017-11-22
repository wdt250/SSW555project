package main.java.userstories.jiadong;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US33 {
	public static void listOrphans(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		System.out.println("\nUS33: List all orphaned child:");
		outFile.println("\nUS33: List all orphaned child:");
		System.out.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s", "ID","Name","Gender","Birthday",
				"Age","Child","Spouse");
		System.out.println();
		outFile.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s", "ID","Name","Gender","Birthday",
				"Age","Child","Spouse");
		outFile.print("\r\n");
		
		String husId;
		String wifeId;
		String husStatus = "null";
		String wifeStatus = "null";
		ArrayList<String> thisChild;
		
		for(Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family fam = (Family)iterator.next();
			
			husId = fam.getHusbandId();
			wifeId = fam.getWifeId();
			
			for (Iterator<Individual> iterator2 = individuals.iterator(); iterator2.hasNext();) {
				Individual indi = (Individual) iterator2.next();
				
				if(husId.equals(indi.getIndividualId())) {
					if((indi.getAlive()).equals(false)) {
						husStatus = "died";
					}
				}
				
				if(wifeId.equals(indi.getIndividualId())) {
					if((indi.getAlive()).equals(false)) {
						wifeStatus = "died";
					}
				}
			}
			
			if(husStatus.equals("died") && wifeStatus.equals("died")) {
				thisChild = null;
				thisChild = fam.getChildren();
				
				for(String childId: thisChild) {
					for (Iterator<Individual> iterator3 = individuals.iterator(); iterator3.hasNext();) {
						Individual individual = (Individual) iterator3.next();
						
						if(childId.equals(individual.getIndividualId())) {
							if(individual.getAge() < 18) {								
								System.out.format("%-6s%-20s%-10s%-16s%-7d%-16s%-10s", 	individual.getIndividualId(),
																						individual.getName(),
																						individual.getGender(),
																						individual.getBirthDate(),
																						individual.getAge(),
																						individual.getAsChildOfFamily(),
																						individual.getAsSpouseOfFamily());
								System.out.print("\r\n");
								
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
					}
				}
			}
		}
		
		outFile.println();
		
		outFile.flush();
	}
}
