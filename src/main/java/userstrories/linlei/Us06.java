package main.java.userstrories.linlei;

import main.java.Family;
import main.java.Individual;
import main.java.Methods;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 18, 2017 
*
*/
public class Us06 {
	public static Boolean DeathBeforeDivorce(Individual[] individuals, Family[] families){
		for(Family family: families){
			if(family.getDivorcedate() == "NA"){
				continue;
			}

			for(Individual individual: individuals){
				if(individual.getDeat() == "NA"){
					continue;
				}
				
				if(family.getHusbandid() == individual.getId())
					if(Methods.findDate(individual.getDeat()).before(Methods.findDate(family.getDivorcedate())))
						return false;

				if(family.getWifeid() == individual.getId())
					if(Methods.findDate(individual.getDeat()).before(Methods.findDate(family.getDivorcedate())))
						return false;
			}
		}
		return true;
	}
}
