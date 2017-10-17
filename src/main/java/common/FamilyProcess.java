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
*
*/
public class FamilyProcess {
	
	static String dateSwitch = "";

	public static Family familyCombiner(Family family, ArrayList<Individual> individuals, String[] strArr) 
			throws NoSuchFieldException {
		
		switch(strArr[1]){
		
			case "FAM":
				family.setFamiliesId(strArr[2]);
				break;
				
			case "HUSB":
				family.setHusbandId(strArr[2]);
				for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
					Individual i = (Individual) iterator.next();
					if (i.getIndividualId() == family.getHusbandId()) {
						family.setHusbandName(i.getName());
					}
				}
				break;
				
			case "WIFE":
				family.setWifeId(strArr[2]);
				for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
					Individual i = (Individual) iterator.next();
					if (i.getIndividualId() == family.getWifeId()) {
						family.setWifeName(i.getName());
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
				family.getChildren().add(strArr[2]);
				break;
				
			case "DATE":
				switch (dateSwitch) {
					case "married":
						family.setMarriedDate(StringUtil.DateFormat(strArr[2]));
						break;
					case "divorce":
						if ("".equals(strArr[2])) {
							family.setDivorceDate("NA");
						} else {
							family.setDivorceDate(StringUtil.DateFormat(strArr[2]));
						}
						
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
}
