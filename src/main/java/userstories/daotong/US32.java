package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US32 {

	public static boolean ListMultipleBirths(ArrayList<Family> families, ArrayList<Individual> individuals, PrintWriter outFile){
		boolean flag = false;
		
		ArrayList<Individual> indiCache = new ArrayList();
		
		for(Family fa: families){
			for(String childId: fa.getChildren()){
				for(Individual indi: individuals){
					if(indi.getIndividualId() == childId){
						indiCache.add(indi);
						break;
					}
				}
			}
			
			
		}
		return flag;
	}
}
