package main.java.common;

import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Individual;
import main.java.util.DateUtil;
import main.java.util.StringUtil;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 13, 2017 
*
*/
public class IndividualProcess {

	static String dateSwitch = "";
	
	public static Individual individualCombiner(Individual individual, String[] strArr) 
			throws Exception {
		
		switch(strArr[1]){
		
			case "INDI":
				individual.setIndividualId(strArr[2]);
				break;
				
			case "NAME":
				individual.setName(strArr[2]);
				break;
				
			case "SEX":
				individual.setGender(strArr[2]);
				break;
				
			case "BIRT":
				dateSwitch = "birth";
				break;
				
			case "DEAT":
				dateSwitch = "death";
				break;
				
			case "DATE":
				switch (dateSwitch) {
					case "birth":
						individual.setBirthDate(StringUtil.DateFormat(strArr[2]));
						individual.setAge(DateUtil.getAge(StringUtil.Str2DateFormat(individual.getBirthDate())));
						individual.setAlive(true);
						individual.setDeathDate("NA");
						break;
					case "death":
						if (strArr[2] != null || !strArr[2].isEmpty()) {
							individual.setAlive(false);
							individual.setDeathDate(StringUtil.DateFormat(strArr[2]));
							int age = 0;
							try {
								age = DateUtil.getAge(StringUtil.Str2DateFormat(individual.getBirthDate()),StringUtil.Str2DateFormat(individual.getDeathDate()));
							} catch (Exception e) {
								e.printStackTrace();
							}
							individual.setAge(age);
						}
						break;
					default:
						break;
				}
				break;
				
			case "FAMS":
				if (strArr[2] == null || strArr[2].isEmpty()) {
					individual.setAsSpouseOfFamily("NA");
				} else {
					individual.setAsSpouseOfFamily(strArr[2].replaceAll("@", ""));
				}
				break;
				
			case "FAMC":
				if (strArr[2] == null || strArr[2].isEmpty()) {
					individual.setAsChildOfFamily("NA");
				} else {
					individual.setAsChildOfFamily(strArr[2].replaceAll("@", ""));
				}
				break;
				
			default: 
				break;
			
		}
		return individual;
	}
	
	public static ArrayList<Individual> dataIntegrality(ArrayList<Individual> individuals) {
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = (Individual) iterator.next();
			if (individual.getAsChildOfFamily() == null || individual.getAsChildOfFamily().isEmpty()) {
				individual.setAsChildOfFamily("None");
			}
			if (individual.getAsSpouseOfFamily() == null || individual.getAsSpouseOfFamily().isEmpty()){
				individual.setAsSpouseOfFamily("NA");
			}
		}
		return individuals;
	}
}
