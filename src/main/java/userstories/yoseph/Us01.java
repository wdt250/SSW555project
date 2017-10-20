package main.java.userstories.yoseph;

import java.util.Date;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.StringUtil;

public class Us01{
	public static Boolean DatesBeforeNow(ArrayList<Individual> individuals, ArrayList<Family> families){
		Date now = new Date();
		boolean flag = true;

		//Checks all valid individual dates for a logical date
		for(Individual individual: individuals){
			if(!(individual.getBirthDate().equals("NA"))){
			    if(StringUtil.Str2DateFormat(individual.getBirthDate()).after(now)){
			    	flag = false;
			    	System.out.println("Error(" + individual.getIndividualId() + "): Birth date(" +individual.getBirthDate() + ") cannot be before today");
			    }
			}
			if(!(individual.getDeathDate().equals("NA"))){
			    if(StringUtil.Str2DateFormat(individual.getDeathDate()).after(now)){
			    	flag = false;
			    	System.out.println("Error(" + individual.getIndividualId() + "): Death date(" +individual.getDeathDate() + ") cannot be before today");
			    }
			}
		}
		
		//Checks all valid family dates for l
		for(Family family: families){
			if(!(family.getMarriedDate().equals("NA"))){
			    if(StringUtil.Str2DateFormat(family.getMarriedDate()).after(now)){
			    	flag = false;
			    	System.out.println("Error(" + family.getFamilyId() + "): Marriage date(" +family.getMarriedDate() + ") cannot be before today");
			    }
			}
			if(!(family.getDivorceDate().equals("NA"))){
			    if(StringUtil.Str2DateFormat(family.getDivorceDate()).after(now)){
			    	flag = false;
			    	System.out.println("Error(" + family.getFamilyId() + "): Divorce date(" +family.getDivorceDate() + ") cannot be before today");
			    }
			}
		}
		
		System.out.println("No dates after today!");
		
		return flag;
	}
}