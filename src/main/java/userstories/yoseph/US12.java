package main.java.userstories.yoseph;

import java.util.ArrayList;
import java.io.PrintWriter;

import main.java.beans.*;
import main.java.util.StringUtil;

public class US12 {
	public static boolean ParentsNotTooOld(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outfile) {
		boolean flag = true;
		Integer fatherAge = 0;
		Integer motherAge = 0;
		ArrayList<Integer> childrenAge = new ArrayList<Integer>();
		
		for(Family family: families) {
			for(Individual individual: individuals) {
				if(StringUtil.ifStrInArr(individual.getIndividualId(), family.getChildren()))
					childrenAge.add(individual.getAge());

				if(individual.getIndividualId().equals(family.getHusbandId()))
					fatherAge = individual.getAge();
				
				if(individual.getIndividualId().equals(family.getWifeId()))
					motherAge = individual.getAge();
			}

			for(Integer childAge: childrenAge) {
				if((fatherAge - childAge) > 80) {
					flag = false;
					System.out.println("Error:Individual:(" + family.getHusbandId() + "): Father cannot be more than 80 years older than child!");
					outfile.println("Error:Individual:(" + family.getHusbandId() + "): Father cannot be more than 80 years older than child!");
				}
				
				if((motherAge - childAge) > 60) {
					flag = false;
					System.out.println("Error:Indiviudal:(" + family.getWifeId() + "): Mother cannot be more than 60 years older than child!");
					outfile.println("Error:Indiviudal:(" + family.getWifeId() + "): Mother cannot be more than 60 years older than child!");
				}
			}
			childrenAge.clear();
		}
		outfile.flush();
		return flag;
	}
}
