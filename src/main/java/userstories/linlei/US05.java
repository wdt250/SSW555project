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
		for(Family fam: families){
			if(fam.getMarriedDate() == "NA"){
				continue;
			}

			for(Individual indi: individuals){
				if(indi.getDeathDate() == "NA"){
					continue;
				}
				
				if(fam.getHusbandId() == indi.getIndividualId())
					if(Methods.findDate(indi.getDeathDate()).before(Methods.findDate(fam.getMarriedDate())))
						return false;

				if(fam.getWifeId() == indi.getIndividualId())
					if(Methods.findDate(indi.getDeathDate()).before(Methods.findDate(fam.getMarriedDate())))
						return false;
			}
		}
		return true;
	}
}
