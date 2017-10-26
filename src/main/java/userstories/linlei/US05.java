package main.java.userstories.linlei;

import java.io.PrintWriter;
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
public class US05 {
	public static Boolean DeathBeforeMarriage(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile){
		for(Family family: families){
			if(family.getMarriedDate() == "NA"){
				continue;
			}

			for(Individual individual: individuals){
				if(individual.getDeathDate() == "NA"){
					continue;
				}
				
				if(family.getHusbandId() == individual.getIndividualId())
					if(Methods.findDate(individual.getDeathDate()).before(Methods.findDate(family.getMarriedDate()))){
						System.out.println("Error: INDIVIDUAL: US05: " + individual.getIndividualId() + ": Husband dead before get marriage");
						outFile.println("Error: INDIVIDUAL: US05: " + individual.getIndividualId() + ": Husband dead before get marriage");
						return false;
					}
						
				if(family.getWifeId() == individual.getIndividualId())
					if(Methods.findDate(individual.getDeathDate()).before(Methods.findDate(family.getMarriedDate()))){
						System.out.println("Error: INDIVIDUAL: US05: " + individual.getIndividualId() + ": Wife dead before get marriage");
						outFile.println("Error: INDIVIDUAL: US05: " + individual.getIndividualId() + ": Wife dead before get marriage");
						return false;
					}
			}
		}
		outFile.flush();
		return true;
	}
}
