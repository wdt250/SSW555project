package main.java.userstories.linlei;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

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
		boolean flag = true;
//		for (Iterator<Family> iterator1 = families.iterator(); iterator1.hasNext();) {
//			Family family1 = (Family) iterator1.next();
//			if (!family1.getChildren().isEmpty()) {
//				for(Iterator<String> iterator2 = family1.getChildren().iterator(); iterator2.hasNext();){
//					String childId = iterator2.next();
//					if (family1.getHusbandId().equals(childId) || family1.getWifeId().equals(childId)) {
//						System.out.println("Error: FAMILY: US17: " + family1.getFamilyId() + ": Parent married his descendant");
//						outFile.println("Error: FAMILY: US17: " + family1.getFamilyId() + ": Parent married his descendant");
//						flag = false;
//					}else {
//						for(Iterator<Family> iterator3 = families.iterator(); iterator3.hasNext();){
//							Family family2 = (Family) iterator3.next();
//							if (childId.equals(family2.getHusbandId()) || childId.equals(family2.getWifeId())) {
//								if (!family2.getChildren().isEmpty()) {
//									for(Iterator<String> iterator4 = family2.getChildren().iterator(); iterator4.hasNext();){
//										String grandChildId = iterator4.next();
//										if (family1.getHusbandId().equals(grandChildId) || family1.getWifeId().equals(grandChildId)) {
//											System.out.println("Error: FAMILY: US17: " + family1.getFamilyId() + ": Parent married his descendant");
//											outFile.println("Error: FAMILY: US17: " + family1.getFamilyId() + ": Parent married his descendant");
//											flag = false;
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
		
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = (Individual) iterator.next();
			Family ownFamily = FamilyUtil.findFamilyByIndividual(families, individual);
			String spouseId = FamilyUtil.findSpouseId(families, individual);
			if (spouseId !=null && spouseId.length() != 0) {
				flag = MarryDescendant(individuals, families, outFile, spouseId, ownFamily);
			}
		}
		
		outFile.flush();
		return flag;
	}
	
	private static boolean MarryDescendant(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile, 
			String targetId, Family compareFamily) {
		boolean flag = true;
		ArrayList<String>  children = compareFamily.getChildren();
		if (children != null && !children.isEmpty()) {
			for (String childId : children) {
				if (targetId.equals(childId)) {
					System.out.println("Error: FAMILY: US17: " + FamilyUtil.findFamilyByIndividualId(families, targetId).getFamilyId() + ": Parent married descendant");
					outFile.println("Error: FAMILY: US17: " + FamilyUtil.findFamilyByIndividualId(families, targetId).getFamilyId() + ": Parent married descendant");
					flag = false;
				} else {
					Family sonFamily = FamilyUtil.findFamilyByIndividualId(families, childId);
					if (sonFamily != null) {
						MarryDescendant(individuals, families, outFile, targetId, sonFamily);
					}
				}
			}
		}
		return flag;
	}
}


