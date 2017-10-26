package main.java.userstories.jiadong;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;

public class US15 {
	public static boolean fewerThan15Sib(ArrayList<Family> fa, PrintWriter outFile) {
		for (Iterator<Family> iterator = fa.iterator(); iterator.hasNext();) {
			Family fam = iterator.next();
			
			if(fam.getChildren().size() > 15) {
				System.out.println("Anomaly: FAMILY: US15: " + fam.getFamilyId() + ": the family has more than 15 siblings");
				outFile.println("Anomaly: FAMILY: US04: " + fam.getFamilyId() + ": the family has more than 15 siblings.");
				return false;
			}
		}
		
		return true;
	};
}
