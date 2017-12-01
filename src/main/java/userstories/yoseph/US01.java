package main.java.userstories.yoseph;

import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.StringUtil;

public class US01 {
	public static Boolean DatesBeforeNow(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outfile){
		Date now = new Date();
		boolean flag = true;

		for(Individual individual: individuals){
			if(individual.getBirthDate() != null && individual.getBirthDate().length() != 0
					&& !"NA".equals(individual.getBirthDate())){
			    if(now.before(StringUtil.Str2DateFormat(individual.getBirthDate()))){
			    	System.out.println("Error: Individual:(" + individual.getIndividualId() + "): Birth date(" + individual.getBirthDate() + ") cannot be after today!");
			    	outfile.println("Error: Individual:(" + individual.getIndividualId() + "): Birth date(" + individual.getBirthDate() + ") cannot be after today!");
				    flag = false;
			    }
			}
			if(individual.getDeathDate() != null && individual.getDeathDate().length() != 0
					&& !"NA".equals(individual.getDeathDate())){
			    if(now.before(StringUtil.Str2DateFormat(individual.getDeathDate()))){
			    	System.out.println("Error: Individual:(" + individual.getIndividualId() + "): Death date(" + individual.getDeathDate() + ") cannot be after today!");
			    	outfile.println("Error: Individual:(" + individual.getIndividualId() + "): Death date(" + individual.getDeathDate() + ") cannot be after today!");
				    flag = false;
			    }
			}
		}
		
		for(Family family: families){
			if(family.getMarriedDate() != null && family.getMarriedDate().length() !=0
					&& !"NA".equals(family.getMarriedDate())){
			    if(now.before(StringUtil.Str2DateFormat(family.getMarriedDate()))){
			    	System.out.println("Error: Family:(" + family.getFamilyId() + "): Marriage date(" + family.getMarriedDate() + ") cannot be after today!");
			    	outfile.println("Error: Family:(" + family.getFamilyId() + "): Marriage date(" + family.getMarriedDate() + ") cannot be after today!");
				    flag = false;
			    }
			}
			if(family.getDivorceDate() != null && family.getDivorceDate().length() !=0
					&& !"NA".equals(family.getDivorceDate())){
			    if(now.before(StringUtil.Str2DateFormat(family.getDivorceDate()))){
			    	System.out.println("Error: Family:(" + family.getFamilyId() + "): Divorce date(" + family.getDivorceDate() + ") cannot be after today!");
			    	outfile.println("Error: Family:(" + family.getFamilyId() + "): Divorce date(" + family.getDivorceDate() + ") cannot be after today!");
				    flag = false;
			    }
			}
		}
		outfile.flush();
		return flag;
	}
}
