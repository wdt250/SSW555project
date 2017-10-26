package main.java.userstories.jiadong;

import java.util.Date;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.ArrayList; 


import main.java.beans.Family;
import main.java.beans.Individual;

public class US04 {

	public static Date dateParse(String date){
	 	String[] temp = date.split("-");
	 	int year = Integer.parseInt(temp[0]);
	 	int month = Integer.parseInt(temp[1]);
	 	int day = Integer.parseInt(temp[2]);
	 	Date response = new Date(year, month, day);
	 
	 	return(response);
}
	
	public static Boolean marriageBeforeDivorce(ArrayList<Family> fa,  PrintWriter outFile) {
		for (Iterator<Family> iterator = fa.iterator(); iterator.hasNext();) {
			Family fam = iterator.next();
			
			if(!"NA".equals(fam.getDivorceDate())) {
				if(dateParse(fam.getMarriedDate()).after(dateParse(fam.getDivorceDate()))) {
					System.out.println("ERROR: FAMILY: US04: " + fam.getFamilyId() + ": the family's divorce date is before marriage date.");
					outFile.println("ERROR: FAMILY: US04: " + fam.getFamilyId() + ": the family's divorce date is before marriage date.");
					return false;
				}			
			}
		}
		
		outFile.flush();
		return true;
	}
}
