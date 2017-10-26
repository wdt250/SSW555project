package main.java.userstories.linlei;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.DateUtil;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 18, 2017 
*
*/
public class US06 {
	public static Boolean DeathBeforeDivorce(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile){
		for(Family family: families){
			if(family.getDivorceDate() == "NA"){
				continue;
			}

			for(Individual individual: individuals){
				if(individual.getDeathDate() == "NA"){
					continue;
				}
				
				if(family.getHusbandId() == individual.getIndividualId())
					if(DateUtil.findDate(individual.getDeathDate()).before(DateUtil.findDate(family.getDivorceDate()))){
						System.out.println("Error: INDIVIDUAL: US06: " + individual.getIndividualId() + ": Husband dead before get divorce");
						outFile.println("Error: INDIVIDUAL: US06: " + individual.getIndividualId() + ": Husband dead before get divorce");
						return false;
					}

				if(family.getWifeId() == individual.getIndividualId())
					if(DateUtil.findDate(individual.getDeathDate()).before(DateUtil.findDate(family.getDivorceDate()))){
						System.out.println("Error: INDIVIDUAL: US06: " + individual.getIndividualId() + ": Husband dead before get divorce");
						outFile.println("Error: INDIVIDUAL: US06: " + individual.getIndividualId() + ": Husband dead before get divorce");
						return false;
					}
			}
		}
		outFile.flush();
		return true;
	}
	
	
}
