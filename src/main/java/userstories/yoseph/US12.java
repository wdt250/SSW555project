package main.java.userstories.yoseph;

import java.util.ArrayList;

import main.java.beans.*;
import main.java.util.StringUtil;

public class US12 {
	public static boolean ParentsNotTooOld(ArrayList<Individual> individuals, ArrayList<Family> families) {
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
					System.out.println("Error(" + family.getHusbandId() + "): Father cannot be more than 80 years older than child!");
				}
				
				if((motherAge - childAge) > 60) {
					System.out.println(motherAge.toString() + childAge.toString());
					flag = false;
					System.out.println("Error(" + family.getWifeId() + "): Mother cannot be more than 60 years older than child!");
				}
			}
			childrenAge.clear();
		}
		
		return flag;
	}
}
