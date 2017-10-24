package main.java.userstories.linlei;

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
	public static void SiblingSpace(ArrayList<Individual> individuals, ArrayList<Family> families) {
		for (Iterator iterator = families.iterator(); iterator.hasNext();) {
			Family family = (Family) iterator.next();
			if (family.getChildren().size() > 1) {
				ArrayList<String> birthdays = new ArrayList<String>();
				for (Iterator iterator2 = family.getChildren().iterator(); iterator2.hasNext();) {
					String id = (String)iterator2.next();
					for (Iterator iterator3 = individuals.iterator(); iterator3.hasNext();) {
						Individual individual = (Individual) iterator3.next();
						if (individual.getIndividualId().equals(id)) {
							birthdays.add(individual.getBirthDate());
							break;
						}
					}
				}
				Collections.sort(birthdays);
				for (int i = 0; i < birthdays.size()-1; i++){  
					if (DateUtil.compareMonth(birthdays.get(i), birthdays.get(i+1)) < 8 
							&& DateUtil.compareDay(birthdays.get(i), birthdays.get(i+1)) > 2 ) {
						System.out.println(family.getFamilyId() + " Error: Siblings spacing");
					}
				}
			}
		}
		
	}
}
