package main.java.userstories.jiadong;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US28 {
	public static void orderSiblingByAge(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		String arr[];
		
		System.out.println("US28: Below is the list of siblings in families by decreasing age: ");
		outFile.println("\nUS28: Below is the list of siblings in families by decreasing age: ");
		
		System.out.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s%-7s", "ID","Name","Gender","Birthday",
				"Age","Child","Spouse","Family");
		System.out.println();
		
		outFile.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s%-7s", "ID","Name","Gender","Birthday",
				"Age","Child","Spouse","Family");
		outFile.print("\r\n");
		
		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family fam = (Family)iterator.next();
			
			arr = null;
			Integer fSize = fam.getChildren().size();
			arr = new String[fSize];
			Integer count = 0;
			
			for(String fId: fam.getChildren()) {
				arr[count] = fId;
				count++;
			};
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr.length - i - 1; j++) {
					int indi1Age = 0;
					int indi2Age = 0;
					
					for (Iterator<Individual> iterator3 = individuals.iterator(); iterator3.hasNext();) {
						Individual indi = (Individual) iterator3.next();
						
						if(arr[j].equals(indi.getIndividualId())) {
							indi1Age = indi.getAge();
						}
						
						if(arr[j+1].equals(indi.getIndividualId())) {
							indi2Age = indi.getAge();
						}
					}
					
					if(indi1Age < indi2Age) {
						String temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					};
				}
			}
			
			for(int i = 0; i < arr.length; i++) {
				for (Iterator<Individual> iterator4 = individuals.iterator(); iterator4.hasNext();) {
					Individual indi = (Individual) iterator4.next();
					
					if(arr[i].equals(indi.getIndividualId())) {
						System.out.format("%-6s%-20s%-10s%-16s%-7d%-16s%-10s%-7s", 	indi.getIndividualId(), 
																					indi.getName(),
																					indi.getGender(),
																					indi.getBirthDate(),
																					indi.getAge(),
																					indi.getAsChildOfFamily(),
																					indi.getAsSpouseOfFamily(),
																					fam.getFamilyId());
						System.out.println();
						
						outFile.format("%-6s%-20s%-10s%-16s%-7d%-16s%-10s%-7s", 	indi.getIndividualId(), 
																					indi.getName(),
																					indi.getGender(),
																					indi.getBirthDate(),
																					indi.getAge(),
																					indi.getAsChildOfFamily(),
																					indi.getAsSpouseOfFamily(),
																					fam.getFamilyId());
						outFile.print("\r\n");
					}
				}
			}

		}
		outFile.flush();
	}
};



