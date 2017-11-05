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
				if(individual.getIndividualId().equals(family.getHusbandId()) && !individual.getGender().equals("M")) {
					flag = false;
					System.out.println("Error:Individual:(" + family.getHusbandId() + "): Father cannot be a female!");
					outfile.println("Error:Individual:(" + family.getHusbandId() + "): Father cannot be a female!");
				}
				
				if(individual.getIndividualId().equals(family.getWifeId()) && !individual.getGender().equals("F")) {
					flag = false;
					System.out.println("Error:Individual:(" + family.getWifeId() + "): Mother cannot be a male!");
					outfile.println("Error:Individual:(" + family.getWifeId() + "): Mother cannot be a male!");
				}
			}
		}
		return flag;
	}
}
