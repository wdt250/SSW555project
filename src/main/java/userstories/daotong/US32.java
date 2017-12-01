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
		boolean flag = true;
		
		ArrayList<Individual> indiCache = new ArrayList();
		HashMap<String , String> childCache = new HashMap();
		HashMap<String , Integer> finalCache = new HashMap();
		String dupBirthDate = null;
		
		System.out.println("\nUS32: List all siblings born at the same times:");
		System.out.format("%-6s%-20s%-10s%-16s%-7s%-16s", "ID","Name","Gender","Birthday",
				"Age","ChildofFamily");
		System.out.print("\r\n");
		outFile.println("\nUS32: List all siblings born at the same times: ");
		outFile.format("%-6s%-20s%-10s%-16s%-7s%-16s", "ID","Name","Gender","Birthday",
				"Age","ChildofFamily");
		outFile.print("\r\n");
		
		for(Family fa: families){
			indiCache.clear();
			childCache.clear();
			finalCache.clear();
			
			if(fa.getChildren()!= null){
				for(String childId: fa.getChildren()){
					for(Individual indi: individuals){
						if(indi.getIndividualId().equals(childId)){
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
							if(in.getBirthDate().equals(dupBirthDate)){
								flag = false;
								System.out.format("%-6s%-20s%-10s%-16s%-7d%-16s", 	in.getIndividualId(),
																					in.getName(),
																					in.getGender(),
																					in.getBirthDate(),
																					in.getAge(),
																					in.getAsChildOfFamily());
								System.out.print("\r\n");

								outFile.format("%-6s%-20s%-10s%-16s%-7d%-16s", 	in.getIndividualId(),
																				in.getName(),
																				in.getGender(),
																				in.getBirthDate(),
																				in.getAge(),
																				in.getAsChildOfFamily());
								outFile.print("\r\n");
							}
						}
					}
				}
			}
		}
		System.out.println();
		outFile.println();

		outFile.flush();
		return flag;
	}
}

