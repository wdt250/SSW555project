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
public class Us05 {
	public static Boolean DeathBeforeMarriage(Individual[] in, Family[] fa){
		for(Family fam: fa){
			if(fam.getMarrieddate() == "NA"){
				continue;
			}

			for(Individual indi: in){
				if(indi.getDeat() == "NA"){
					continue;
				}
				
				if(fam.getHusbandid() == indi.getId())
					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getMarrieddate())))
						return false;

				if(fam.getWifeid() == indi.getId())
					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getMarrieddate())))
						return false;
			}
		}
		return true;
	}
}
