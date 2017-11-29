package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Individual;

public class US29 {

	public static boolean ListDeceased(ArrayList<Individual> individuals, PrintWriter outFile){
		boolean flag = true;
		System.out.println("\nUS29: List all deceased people: ");
		System.out.format("%-6s%-20s%-10s%-16s%-7s%-16s", "ID","Name","Gender","Birthday",
				"Age","ChildofFamily");
		System.out.print("\r\n");
		outFile.println("\nUS29: List all deceased people: ");
		outFile.format("%-6s%-20s%-10s%-16s%-7s%-16s", "ID","Name","Gender","Birthday",
				"Age","ChildofFamily");
		outFile.print("\r\n");
		for(Individual in: individuals){

			if(!in.getAlive()){
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
		System.out.println();
		outFile.println();
		
		outFile.flush();
		return flag;
	}
}
