package main.java.userstories.linlei;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.FamilyUtil;
import main.java.util.StringUtil;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Nov 6, 2017 
* 
* @version 
*/
public class US20 {
	public static boolean AuntsAndUncles(ArrayList<Individual> individuals, 
			ArrayList<Family> families, PrintWriter outFile){
		boolean flag = true;
		
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = (Individual) iterator.next();
			String parentFamilyId = individual.getAsChildOfFamily();
			String ownFamilyId = individual.getAsSpouseOfFamily();
			if (parentFamilyId != null && parentFamilyId.length() != 0 
					&& ownFamilyId != null && ownFamilyId.length() != 0
					&& !parentFamilyId.equals("None")) {
				Family parentFamily = FamilyUtil.findFamilyByFamilyId(families, parentFamilyId);
				Family ownFamily = FamilyUtil.findFamilyByFamilyId(families, ownFamilyId);
				Individual spouse = FamilyUtil.findSpouse(families, individuals, individual);
				ArrayList<String>  sibling = parentFamily.getChildren();
				for (String string : sibling) {
					Family fam = FamilyUtil.findFamilyByIndividualId(families, string);
					if (fam != null) {
						if (fam.getChildren() != null && !fam.getChildren().isEmpty()) {
							if (StringUtil.ifStrInArr(spouse.getIndividualId(), fam.getChildren())) {
								System.out.println("Error: FAMILY: US20: " + ownFamily.getFamilyId() + ": " + individual.getIndividualId() + ": Aunt or Uncle married niece or nephew");
								outFile.println("Error: FAMILY: US20: " + ownFamily.getFamilyId() + ": " + individual.getIndividualId() + ": Aunt or Uncle married niece or nephew");
								flag = false;
							}
						}
					}
				}
			}
		}

		outFile.flush();
		return flag;
	}
}
