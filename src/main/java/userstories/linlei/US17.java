package main.java.userstories.linlei;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.FamilyUtil;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Nov 6, 2017 
* 
* @version 
*/
public class US17 {
	public static boolean NoMarryDescendant(ArrayList<Individual> individuals, 
			ArrayList<Family> families, PrintWriter outFile){
		boolean flag1 = true;
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = (Individual) iterator.next();
			Family ownFamily = FamilyUtil.findFamilyByIndividual(families, individual);
			String spouseId = FamilyUtil.findSpouseId(families, individual);
			HashSet<String> mark = new HashSet<String>();
			if (spouseId !=null && spouseId.length() != 0) {
				flag1 = MarryDescendant(individuals, families, outFile, spouseId, ownFamily, mark);
				if (flag1 == false) {
					break;
				}
			}
		}
		
		outFile.flush();
		return flag1;
	}
	
	private static boolean MarryDescendant(ArrayList<Individual> individuals, ArrayList<Family> families,
			PrintWriter outFile, String targetId, Family compareFamily, HashSet<String> mark) {
		boolean flag2 = true;
		ArrayList<String>  children = compareFamily.getChildren();
		if (children != null && !children.isEmpty()) {
			for (String childId : children) {
				if (!mark.contains(childId)) {
					mark.add(childId);
					if (targetId.equals(childId)) {
						System.out.println("Error: FAMILY: US17: " + FamilyUtil.findFamilyByIndividualId(families, targetId).getFamilyId() + ": Parent married descendant");
						outFile.println("Error: FAMILY: US17: " + FamilyUtil.findFamilyByIndividualId(families, targetId).getFamilyId() + ": Parent married descendant");
						flag2 = false;
						break;
					} else {
						if (!targetId.equals(FamilyUtil.findSpouseIdByIndividualId(families, childId))) {
							Family sonFamily = FamilyUtil.findFamilyByIndividualId(families, childId);
							if (sonFamily != null) {
								flag2 = MarryDescendant(individuals, families, outFile, targetId, sonFamily, mark);
								if (flag2 == false) {
									break;
								}
							}
						}
					}
				}
			}
		}
		return flag2;
	}
}


