package main.java.userstories.yoseph;

import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.StringUtil;

public class US02 {
	public static Boolean BirthBeforeMarriage(ArrayList<Individual> individuals, ArrayList<Family> families){
		boolean flag = true;
		
		for(Family family: families){
			for(Individual individual: individuals){
				if(family.getMarriedDate() == "NA") 
					continue;

				if(family.getHusbandId() == individual.getIndividualId())
					if(StringUtil.Str2DateFormat(individual.getBirthDate()).after(StringUtil.Str2DateFormat(family.getMarriedDate()))) {
				    	System.out.println("Error: Individual(" + individual.getIndividualId() + ": Birth date(" + individual.getBirthDate() + "cannot be before marriage date(" + family.getMarriedDate() + ")!");
						flag = false;
					}

				if(family.getWifeId() == individual.getIndividualId())
					if(StringUtil.Str2DateFormat(individual.getBirthDate()).after(StringUtil.Str2DateFormat(family.getMarriedDate()))) {
				    	System.out.println("Error: Individual(" + individual.getIndividualId() + ": Birth date(" + individual.getBirthDate() + "cannot be before marriage date(" + family.getMarriedDate() + ")!");
						flag = false;
					}
			}
		}
		
		return flag;
	}
}
