package main.java.userstories.jiadong;

import java.util.Date;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.ArrayList; 

import main.java.beans.Individual;


public class US03 {
	
	public static Date dateParse(String date){
		 	String[] temp = date.split("-");
		 	int year = Integer.parseInt(temp[0]);
		 	int month = Integer.parseInt(temp[1]);
		 	int day = Integer.parseInt(temp[2]);
		 	Date response = new Date(year, month, day);
		 
		 	return(response);
	}
	
	public static Boolean birthBeforeDeath(ArrayList<Individual> in, PrintWriter outFile) {
		
		for (Iterator<Individual> iterator = in.iterator(); iterator.hasNext();) {
			Individual indi = iterator.next();
			
			if(indi.getDeathDate() != "NA") {
				if(dateParse(indi.getBirthDate()).after(dateParse(indi.getDeathDate()))) {
					System.out.println("ERROR: INDIVIDUAL: US03: " + indi.getIndividualId() + ": has death date before birth date");
					outFile.println("ERROR: INDIVIDUAL: US03: " + indi.getIndividualId() + ": has death date before birth date");
					return false;
				}			
			}
		}
		
		outFile.flush();
		return true;
	}
}
