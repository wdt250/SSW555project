package main.java.userstories.jiadong;

import main.java.util.Date;
import main.java.util.Iterator;
import main.java.util.ArrayList; 

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
	
	public static Boolean birthBeforeDeath(ArrayList<Individual> in) {
		
		for (Iterator<Individual> iterator = in.iterator(); iterator.hasNext();) {
			Individual indi = iterator.next();
			
			if(indi.getDeathDate() != "NA") {
				if(dateParse(indi.getBirthDate()).after(dateParse(indi.getDeathDate()))) {
					return false;
				}			
			}
		}
		
		return true;
	}
}
