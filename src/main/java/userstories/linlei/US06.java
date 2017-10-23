package main.java.userstories.linlei;

import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.Methods;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 18, 2017 
*
*/
public class Us06 {
	public static Boolean DeathBeforeDivorce(ArrayList<Individual> individuals, ArrayList<Family> families){
		for(Family family: families){
			if(family.getDivorceDate() == "NA"){
				continue;
			}

			for(Individual individual: individuals){
				if(individual.getDeathDate() == "NA"){
					continue;
				}
				
				if(family.getHusbandId() == individual.getIndividualId())
					if(Methods.findDate(individual.getDeathDate()).before(Methods.findDate(family.getDivorceDate())))
						return false;

				if(family.getWifeId() == individual.getIndividualId())
					if(Methods.findDate(individual.getDeathDate()).before(Methods.findDate(family.getDivorceDate())))
						return false;
			}
		}
		return true;
	}
}
