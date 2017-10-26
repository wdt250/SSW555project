package main.java.userstories.jiadong;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US16 {
	public static boolean maleLastName(ArrayList<Individual> individuals, ArrayList<Family> fa, PrintWriter outFile) {
		for (Iterator<Family> iterator = fa.iterator(); iterator.hasNext();) {
			Family fam = (Family)iterator.next();
			
			String[] temp = fam.getHusbandName().split("/");
			String lastName = temp[1];
			
			if(fam.getChildren() != null) {
				for(int i = 0; i < fam.getChildren().size(); i++) {
					String thisId = fam.getChildren().get(i);
					
					for (Iterator<Individual> iterator2 = individuals.iterator(); iterator2.hasNext();) {
						Individual individual = (Individual) iterator2.next();
						
						if(individual.getIndividualId().equals(thisId) && "M".equals(individual.getGender())) {
							String[] temp2 = individual.getName().split("/");
							String childLastName = temp2[1];
							
							if(!lastName.equals(childLastName)) {
								System.out.println("Anomaly: INDIVIDUAL: US16 " + individual.getIndividualId() + ": have a last name different from his family member");
								outFile.println("Anomaly: INDIVIDUAL: US16 " + individual.getIndividualId() + ": have a last name different from his family member");
								return false;
							}
						}
					}
				}
			}
		}
		
		outFile.flush();
		return true;
	}
}
