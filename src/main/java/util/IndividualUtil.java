package main.java.util;

import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Individual;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Nov 7, 2017 
* 
* @version 
*/
public class IndividualUtil {
	
	public static Individual findFamilyById(ArrayList<Individual> individuals, String individualId) {
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual individual = (Individual) iterator.next();
			if (individualId.equals(individual.getIndividualId())) {
				return individual;
			}
		}
		return null;
	}
}
