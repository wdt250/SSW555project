package main.java.userstories.jiadong;

import java.util.Date;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.ArrayList; 

import main.java.beans.Individual;
import main.java.util.DateUtil;
import main.java.util.StringUtil;


public class US03 {
	
	public static Boolean birthBeforeDeath(ArrayList<Individual> in, PrintWriter outFile) {
		
		for (Iterator<Individual> iterator = in.iterator(); iterator.hasNext();) {
			Individual indi = iterator.next();
			
			if(indi.getBirthDate() != null && indi.getBirthDate().length() != 0 
					&& indi.getDeathDate() != null && indi.getDeathDate().length() != 0 
					&& !"NA".equals(indi.getBirthDate()) && !"NA".equals(indi.getDeathDate())) {
				if(StringUtil.Str2DateFormat(indi.getBirthDate()).after(StringUtil.Str2DateFormat(indi.getDeathDate()))){
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
