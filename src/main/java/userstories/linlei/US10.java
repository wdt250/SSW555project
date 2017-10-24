package main.java.userstories.linlei;

import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.DateUtil;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Oct 23, 2017 
* 
* @version 
*/
public class US10 {
	public static void MarriageAfter14(ArrayList<Individual> individuals, ArrayList<Family> families) {
		String HusbandBirthday = "";
		String WifeBirthday = "";
		for (Iterator iterator = families.iterator(); iterator.hasNext();) {
			Family family = (Family) iterator.next();
			for (Iterator iterator2 = individuals.iterator(); iterator2.hasNext();) {
				Individual individual = (Individual) iterator2.next();
				if (family.getHusbandId().equals(individual.getIndividualId())) {
					HusbandBirthday = individual.getBirthDate();
				}
				if (family.getWifeId().equals(individual.getIndividualId())) {
					WifeBirthday = individual.getBirthDate();
				}
			}
			if (DateUtil.compareYear(HusbandBirthday, family.getMarriedDate()) < 14 
					|| DateUtil.compareYear(WifeBirthday, family.getMarriedDate()) < 14) {
				System.out.println("Error: Marriage after 14");
			}
		}
	}
}