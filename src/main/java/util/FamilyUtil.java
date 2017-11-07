package main.java.util;

import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Nov 7, 2017 
* 
* @version 
*/
public class FamilyUtil {
	
	public static Family findFamilyByFamilyId(ArrayList<Family> families, String familyId) {
		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family family = (Family) iterator.next();
			if (familyId.equals(family.getFamilyId())) {
				return family;
			}
		}
		return null;
	}
	
	public static Family findFamilyByIndividual(ArrayList<Family> families, Individual individual) {
		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family family = (Family) iterator.next();
			if (individual.getIndividualId().equals(family.getHusbandId()) || individual.getIndividualId().equals(family.getWifeId())) {
				return family;
			}
		}
		return null;
	}
	
	public static Family findFamilyByIndividualId(ArrayList<Family> families, String individualId) {
		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family family = (Family) iterator.next();
			if (individualId.equals(family.getHusbandId()) || individualId.equals(family.getWifeId())) {
				return family;
			}
		}
		return null;
	}
	
	public static Individual findSpouse(ArrayList<Family> families, ArrayList<Individual> individuals, Individual individual) {
		Individual indi = new Individual();
		for (Iterator<Family> iterator1 = families.iterator(); iterator1.hasNext();) {
			Family family = (Family) iterator1.next();
			if (individual.getIndividualId().equals(family.getHusbandId())) {
				String wifeId = family.getWifeId();
				for (Iterator<Individual> iterator2 = individuals.iterator(); iterator2.hasNext();) {
					indi = (Individual) iterator2.next();
					if (wifeId.equals(indi.getIndividualId())) {
						return indi;
					}
				}
			}
			if (individual.getIndividualId().equals(family.getWifeId())) {
				String husbandId = family.getHusbandId();
				for (Iterator<Individual> iterator3 = individuals.iterator(); iterator3.hasNext();) {
					indi = (Individual) iterator3.next();
					if (husbandId.equals(indi.getIndividualId())) {
						return indi;
					}
				}
			}
		}
		
		return indi;
	}
	
	public static String findSpouseId(ArrayList<Family> families, Individual individual) {
		for (Iterator<Family> iterator1 = families.iterator(); iterator1.hasNext();) {
			Family family = (Family) iterator1.next();
			if (individual.getIndividualId().equals(family.getHusbandId())) {
				return family.getWifeId();
			}
			if (individual.getIndividualId().equals(family.getWifeId())) {
				return family.getHusbandId();
			}
		}
		return "";
	}
}
