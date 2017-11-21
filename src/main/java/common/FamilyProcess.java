package main.java.common;

import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.StringUtil;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 13, 2017 
* @editor Daotong Wang
*/
public class FamilyProcess {
	
	static String dateSwitch = "";

	public static Family familyCombiner(Family family, ArrayList<Individual> individuals, String[] strArr) 
			throws NoSuchFieldException {
		
		switch(strArr[1]){
		
			case "FAM":
				family.setFamilyId(strArr[2]);
				break;
				
			case "HUSB":
				family.setHusbandId(strArr[2].replaceAll("@", ""));
				for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
					Individual i = iterator.next();
					if (family.getHusbandId().equals(i.getIndividualId()) ) {
						family.setHusbandName(i.getName());
						break;
					}
				}
				break;
				
			case "WIFE":
				family.setWifeId(strArr[2].replaceAll("@", ""));
				for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
					Individual i = (Individual) iterator.next();
					if (family.getWifeId().equals(i.getIndividualId())) {
						family.setWifeName(i.getName());
						break;
					}
				}
				break;
				
			case "MARR":
				dateSwitch = "married";
				break;
				
			case "DIV":
				dateSwitch = "divorce";
				break;
				
			case "CHIL":
				ArrayList<String> child = new ArrayList<String>();
				if(family.getChildren()!= null){
					child = family.getChildren();
				}
				child.add(strArr[2].replaceAll("@", ""));
				family.setChildren(child);
				break;
				
			case "DATE":
				switch (dateSwitch) {
					case "married":
						family.setMarriedDate(StringUtil.DateFormat(strArr[2]));
						family.setDivorceDate("NA");
						dateSwitch="";
						break;
					case "divorce":
						if (!"".equals(strArr[2])) {
							family.setDivorceDate(StringUtil.DateFormat(strArr[2]));
						}
						dateSwitch="";
						break;
						
					default:
						break;
				}
				break;
				
			default: 
				break;
		}
		return family;
	}
	
	public static ArrayList<Family> dataIntegrality(ArrayList<Family> families) {
		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family family = (Family) iterator.next();
			if (family.getMarriedDate() == null || family.getMarriedDate().isEmpty()) {
				family.setMarriedDate("NA");
			}
			if (family.getDivorceDate() == null || family.getDivorceDate().isEmpty()) {
				family.setDivorceDate("NA");
			}
			if (family.getWifeId() == null || family.getWifeId().isEmpty()) {
				family.setWifeId("NA");
			}
			if (family.getWifeName() == null || family.getWifeName().isEmpty()) {
				family.setWifeName("NA");
			}
		}
		return families;
	}
}
