package main.java.userstories.yoseph;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintWriter;

import main.java.beans.*;

public class US26 {
	public static boolean CorrespondingEntries(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outfile) {
		boolean flag = true;
		HashMap<String, String> ChildFamilies = new HashMap<String, String>(individuals.size() + 1);
		HashMap<String, String> SpouseFamilies = new HashMap<String, String>(individuals.size() + 1);
		
		for(Individual individual: individuals) {
			if(!"None".equals(individual.getAsChildOfFamily()))
				ChildFamilies.put(individual.getIndividualId(), individual.getAsChildOfFamily());
			if(!"NA".equals(individual.getAsSpouseOfFamily()))
				SpouseFamilies.put(individual.getIndividualId(), individual.getAsSpouseOfFamily());
		}
		
		if (ChildFamilies != null && !ChildFamilies.isEmpty() && SpouseFamilies != null && !SpouseFamilies.isEmpty()) {
			for(Family family: families) {
				for(String child: family.getChildren()) {
					if(!ChildFamilies.get(child).equals(family.getFamilyId())) {
						flag = false;
						System.out.println("Error:US26:Individual:(" + child + "): Family role records not consistent!");
						outfile.println("Error:US26:Individual:(" + child + "): Family role records not consistent!");
					}
				}
				
				if((SpouseFamilies.get(family.getWifeId()) != null) && (!SpouseFamilies.get(family.getHusbandId()).equals(family.getFamilyId()) && family.getDivorceDate().equals("NA"))) {
					flag = false;
					System.out.println("Error:US26:Individual:(" + family.getHusbandId() + "): Family role records not consistent!");
					outfile.println("Error:US26:Individual:(" + family.getHusbandId() + "): Family role records not consistent!");
				}
				
				if((SpouseFamilies.get(family.getWifeId()) != null) && (!SpouseFamilies.get(family.getWifeId()).equals(family.getFamilyId()) && family.getDivorceDate().equals("NA"))) {
					flag = false;
					System.out.println("Error:US26:Individual:(" + family.getWifeId() + "): Family role records not consistent!");
					outfile.println("Error:US26:Individual:(" + family.getWifeId() + "): Family role records not consistent!");
				}
			}
		}
		
		return flag;
	}
}
