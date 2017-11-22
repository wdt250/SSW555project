package main.java.userstories.yoseph;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintWriter;

import main.java.beans.*;
import main.java.util.StringUtil;

public class US25 {
	public static boolean UniqueFirstNamesInFamilies(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outfile) {
		boolean flag = true;
		HashMap<String, String> names = new HashMap<String, String>(individuals.size() + 1);
		ArrayList<String> children;
		ArrayList<String> checker = new ArrayList<String>();
		
		for(Individual individual: individuals) {
			names.put(individual.getIndividualId(), individual.getName());
		}

		for(Family family: families) {
			children = family.getChildren();
			for(String child: children) {
				if(StringUtil.ifStrInArr(names.get(child), checker)) {
					flag = false;
					System.out.println("Error:US25:Family:(" + family.getFamilyId() + "): Cannot have two children with the same name!");
					outfile.println("Error:US25:Family:(" + family.getFamilyId() + "): Cannot have two children with the same name!");
				}
				
				checker.add(names.get(child));
			}
			
			checker.clear();
		}
		
		return flag;
	}
}
