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
		ArrayList<Individual> indis = new ArrayList<Individual>();
		for (Iterator iterator = families.iterator(); iterator.hasNext();) {
			Family family = (Family) iterator.next();
			if (family.getChildren().size() > 1) {
				for (Iterator iterator2 = family.getChildren().iterator(); iterator2.hasNext();) {
					String id = (String)iterator2.next();
					for (Iterator iterator3 = individuals.iterator(); iterator3.hasNext();) {
						Individual individual = (Individual) iterator3.next();
						if (id.equals(individual.getIndividualId())) {
							indis.add(individual);
							break;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < indis.size()-1; i++){  
			if (DateUtil.compareMonth(indis.get(i).getBirthDate(), indis.get(i+1).getBirthDate()) < 8) {
				if (DateUtil.compareDay(indis.get(i).getBirthDate(), indis.get(i+1).getBirthDate()) > 2) {
					System.out.println("Error: FAMILY: US13: " + indis.get(i+1).getIndividualId()
							+ ": birthed less than 8 months or more than 2 days after siblings");
					outFile.println("Error: FAMILY: US13: " + indis.get(i+1).getIndividualId()
							+ ": birthed less than 8 months or more than 2 days after siblings");
					flag = false;
				}
			}
		}
		outFile.flush();
		return flag;
	}
}
