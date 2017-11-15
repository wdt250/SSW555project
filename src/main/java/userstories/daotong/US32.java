package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US32 {

	public static boolean ListMultipleBirths(ArrayList<Family> families, ArrayList<Individual> individuals, PrintWriter outFile){
		boolean flag = false;
		
		ArrayList<Individual> indiCache = new ArrayList();
		HashMap<String , String> childCache = new HashMap();
		HashMap<String , Integer> finalCache = new HashMap();
		String dupBirthDate = null;
		
		for(Family fa: families){
			for(String childId: fa.getChildren()){
				for(Individual indi: individuals){
					if(indi.getIndividualId() == childId){
						indiCache.add(indi);						
						break;
					}
				}
			}
			
			for(Individual in: indiCache){
				childCache.put(in.getIndividualId(), in.getBirthDate());
			}
			
			for(Map.Entry<String, String> entry: childCache.entrySet()){
				if(finalCache.containsKey(entry.getValue())){
					finalCache.put(entry.getValue(), finalCache.get(entry.getValue())+1);
				}else{
					finalCache.put(entry.getValue(), 1);
				}
			}
			
			for(Map.Entry<String, Integer> entry: finalCache.entrySet()){
				if(entry.getValue()>1){
					dupBirthDate = entry.getKey();
					for(Individual in: indiCache){
						if(in.getBirthDate()==dupBirthDate){
							System.out.println("US32: Individual: " + "the person whose id is " + in.getIndividualId() + "from the family of " + fa.getFamilyId() + " has a multiple birth of" + in.getBirthDate());
						}
					}
				}
			}
			
		}
		
		
		
		outFile.flush();
		return flag;
	}
}
