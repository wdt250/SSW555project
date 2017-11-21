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
		
		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family fam = (Family)iterator.next();
			
			arr = null;
			Integer fSize = fam.getChildren().size();
			arr = new String[fSize];
			Integer count = 0;
			
			for(String fId: fam.getChildren()) {
				arr[count] = fId;
				count++;
			};//what's your mean of ";"? what's your mean of this for loop? I think it ends too early
			
			if(fSize == 1) {
				System.out.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s%-7s", "ID","Name","Gender","Birthday",
						"Age","Child","Spouse","family");
				
				for (Iterator<Individual> iterator2 = individuals.iterator(); iterator.hasNext();) {
					Individual indi = (Individual) iterator2.next();
					
					if(arr[0].equals(indi.getIndividualId())) {
						
						System.out.format("%-6s%-20s%-10s%-16s%-7d%-16s%-10s%-7s", 	indi.getIndividualId(),
																				indi.getName(),
																				indi.getGender(),
																				indi.getBirthDate(),
																				indi.getAge(),
																				indi.getAsChildOfFamily(),
																				indi.getAsSpouseOfFamily(),
																				fam.getFamilyId());
					}
				}
			}else {
				System.out.println(2);
				System.out.format("%-6s%-20s%-10s%-16s%-7s%-16s%-10s", "ID","Name","Gender","Birthday",
						"Age","Child","Spouse");
				for(int i = 0; i < arr.length; i++) {
					for(int j = 0; j < arr.length - i - 1; j++) {
						int indi1Age = 0;
						int indi2Age = 0;
						
						for (Iterator<Individual> iterator2 = individuals.iterator(); iterator.hasNext();) {
							Individual indi = (Individual) iterator2.next();
							//what the meaning of the following two if? why use arr[j] twice?
							if(arr[j].equals(indi.getIndividualId())) {
								indi1Age = indi.getAge();
							}
							
							if(arr[j].equals(indi.getIndividualId())) {
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
					for (Iterator<Individual> iterator2 = individuals.iterator(); iterator.hasNext();) {
						Individual indi = (Individual) iterator2.next();
						
						if(arr[i].equals(indi.getIndividualId())) {
							System.out.format("%-6s%-20s%-10s%-16s%-7d%-16s%-10s", 	indi.getIndividualId(), 
																					indi.getName(),
																					indi.getGender(),
																					indi.getBirthDate(),
																					indi.getAge(),
																					indi.getAsChildOfFamily(),
																					indi.getAsSpouseOfFamily());
						}
					}
				}
			}
		}
		outFile.flush();
	}
};



