package main.java.userstories.yoseph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.io.PrintWriter;

import main.java.beans.*;
import main.java.util.StringUtil;

public class US23 {
		public static boolean UniqueNameAndBirthDate(ArrayList<Individual> individuals, PrintWriter outfile) {
			boolean flag = true;
			HashMap<String, String> names = new HashMap<String, String>(individuals.size() + 1);
			
			for(Individual individual: individuals) {
				if(names.containsKey(individual.getName()) && names.get(individual.getName()).equals(individual.getBirthDate())){
					flag = false;
					System.out.println("Error:US23:Individual:(" + individual.getIndividualId() + "): Cannot have duplicate name and birthdate!");
					outfile.println("Error:US23:Individual:(" + individual.getIndividualId() + "): Cannot have duplicate name and birthdate!");
				}
				
				names.put(individual.getName(), individual.getBirthDate());
			}
			
			return flag;
		}
}
