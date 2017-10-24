package main.java.userstories.yoseph;

import java.util.Date;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.StringUtil;

public class US01 {
	public static Boolean DatesBeforeNow(ArrayList<Individual> individuals, ArrayList<Family> families){
		Date now = new Date();
		boolean flag = true;

		for(Individual individual: individuals){
			if(!(individual.getBirthDate().equals("NA"))){
			    if(StringUtil.Str2DateFormat(individual.getBirthDate()).after(now)){
			    	System.out.println("Error: Individual:(" + individual.getIndividualId() + ": Birth date(" + individual.getBirthDate() + "cannot be after today!");
				    flag = false;
			    }
			}
			if(!(individual.getDeathDate().equals("NA"))){
			    if(StringUtil.Str2DateFormat(individual.getDeathDate()).after(now)){
			    	System.out.println("Error: Individual:(" + individual.getIndividualId() + ": Death date(" + individual.getDeathDate() + "cannot be after today!");
				    flag = false;
			    }
			}
		}
		
		for(Family family: families){
			if(!(family.getMarriedDate().equals("NA"))){
			    if(StringUtil.Str2DateFormat(family.getMarriedDate()).after(now)){
			    	System.out.println("Error: Family:(" + family.getFamilyId() + ": Marriage date(" + family.getMarriedDate() + "cannot be after today!");
				    flag = false;
			    }
			}
			if(!(family.getDivorceDate().equals("NA"))){
			    if(StringUtil.Str2DateFormat(family.getDivorceDate()).after(now)){
			    	System.out.println("Error: Family:(" + family.getFamilyId() + ": Divorce date(" + family.getDivorceDate() + "cannot be after today!");
				    flag = false;
			    }
			}
		}
		
		return flag;
	}
}
