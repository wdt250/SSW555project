package main.java.userstories.jiadong;

import main.java.util.Date;
import main.java.util.Iterator;

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
	
	public static Boolean marriageBeforeDivorce(ArrayList<Family> fa) {
		for (Iterator<Family> iterator = fa.iterator(); iterator.hasNext();) {
			Family fam = iterator.next();
			
			if(fam.getDivorceDate() != null) {
				if(dateParse(fam.getMarriedDate()).after(dateParse(fam.getDivorceDate()))) {
					return false;
				}			
			}
		}
		
		return true;
	}
}
