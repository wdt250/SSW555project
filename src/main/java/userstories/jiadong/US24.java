package main.java.userstories.jiadong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;

public class US24 {
	public static boolean uniqueFamiliesBySpouses(ArrayList<Family> families, PrintWriter outFile) {
		Boolean flag = true;
		for(Family fa: families) {
			for(Family fa2: families) {
				if(fa.getFamilyId() != fa2.getFamilyId() && fa.getHusbandName().equals(fa2.getHusbandName()) && fa.getWifeName().equals(fa2.getWifeName()) && fa.getMarriedDate().equals(fa2.getMarriedDate())) {
					System.out.println("Anomaly: FAMILY: US24 " + fa.getFamilyId() +  ": has a same family spouse and marriaed date with another family");
					outFile.println("Anomaly: FAMILY: US24 " + fa.getFamilyId() +  ": has a same family spouse and marriaed date with another family");
					
					flag = false;
				}
				
			}
		}
		outFile.flush();
		return flag;	
	}
}
