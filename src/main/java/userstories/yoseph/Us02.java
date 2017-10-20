package main.java.userstories.yoseph;

import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.StringUtil;

public class Us02 {
	public static Boolean BirthBeforeMarriage(ArrayList<Individual> individuals, ArrayList<Family> families){
		boolean flag = true;
		for(Family family: families){
			for(Individual individual: individuals){
				if(family.getMarriedDate().equals("NA"))
					continue;

				if(family.getHusbandId().equals(individual.getIndividualId()))
					if(StringUtil.Str2DateFormat(individual.getBirthDate()).after(StringUtil.Str2DateFormat(family.getMarriedDate()))) {
				    	flag = false;
				    	System.out.println("Error(" + individual.getIndividualId() + "): Marriage date(" +family.getMarriedDate() + ") cannot be before birth date(" + individual.getBirthDate() + ")");
					}

				if(family.getWifeId().equals(individual.getIndividualId()))
					if(StringUtil.Str2DateFormat(individual.getBirthDate()).after(StringUtil.Str2DateFormat(family.getMarriedDate()))) {
				    	flag = false;
				    	System.out.println("Error(" + individual.getIndividualId() + "): Marriage date(" +family.getMarriedDate() + ") cannot be before birth date(" + individual.getBirthDate() + ")");
					}
			}
		}
		
		System.out.println("No Marriage before birth!");
		
		return flag;
	}
}
