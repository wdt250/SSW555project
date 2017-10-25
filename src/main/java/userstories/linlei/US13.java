package main.java.userstories.linlei;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.DateUtil;
import main.java.util.StringUtil;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Oct 24, 2017 
* 
* @version 
*/
public class US13 {
	public static boolean SiblingSpace(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		boolean flag = true;
		
		for (Iterator iterator = families.iterator(); iterator.hasNext();) {
			Family family = (Family) iterator.next();
			if (family.getChildren().size() > 1) {
				ArrayList<String> birthdays = new ArrayList<String>();
				Individual individual = new Individual();
				for (Iterator iterator2 = individuals.iterator(); iterator2.hasNext();) {
					individual = (Individual) iterator2.next();
					for (Iterator iterator3 = family.getChildren().iterator(); iterator3.hasNext();) {
						String id = (String)iterator3.next();
						if (individual.getIndividualId().equals(id)) {
							birthdays.add(individual.getBirthDate());
							break;
						}
					}
				}
				Collections.sort(birthdays);
				for (int i = 0; i < birthdays.size()-1; i++){  
					if (DateUtil.compareMonth(birthdays.get(i), birthdays.get(i+1)) < 8) {
						System.out.println("Error: FAMILY: US13: " + individual.getIndividualId() + ": birthed less than 8 months after siblings");
						outFile.println("Error: FAMILY: US13: " + individual.getIndividualId() + ": birthed less than 8 months after siblings");
						flag = false;
					}
					if (DateUtil.compareDay(birthdays.get(i), birthdays.get(i+1)) > 2) {
						System.out.println("Error: FAMILY: US13: " + individual.getIndividualId() + ": birthed more than 2 days after siblings");
						outFile.println("Error: FAMILY: US13: " + individual.getIndividualId() + ": birthed more than 2 days after siblings");
						flag = false;
					}
				}
			}
		}
		outFile.flush();
		return flag;
	}
}
