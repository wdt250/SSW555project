package main.java.userstories.yoseph;

import java.util.ArrayList;
import java.io.PrintWriter;

import main.java.beans.*;
import main.java.util.StringUtil;

public class US21 {
	public static boolean CorrectGenderForRole(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outfile) {
		boolean flag = true;
		for(Family family: families) {
			for(Individual individual: individuals) {
				if(individual.getIndividualId().equals(family.getHusbandId()) && individual.getGender() != null 
						&& individual.getGender().length() != 0 && !"M".equals(individual.getGender())) {
					flag = false;
					System.out.println("Error:US21:Individual:(" + family.getHusbandId() + "): Father cannot be a female!");
					outfile.println("Error:US21:Individual:(" + family.getHusbandId() + "): Father cannot be a female!");
				}
				
				if(individual.getIndividualId().equals(family.getWifeId()) && individual.getGender() != null 
						&& individual.getGender().length() != 0 && !"F".equals(individual.getGender())) {
					flag = false;
					System.out.println("Error:US21:Individual:(" + family.getWifeId() + "): Mother cannot be a male!");
					outfile.println("Error:US21:Individual:(" + family.getWifeId() + "): Mother cannot be a male!");
				}
			}
		}
		return flag;
	}
}
