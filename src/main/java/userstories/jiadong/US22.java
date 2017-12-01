package main.java.userstories.jiadong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US22 {
	public static boolean uniqueIds(ArrayList<Individual> individuals, ArrayList<Family> fa, PrintWriter outFile) {
		ArrayList<String> fId = new ArrayList<String>();
		ArrayList<String> iId = new ArrayList<String>();
		Boolean flag = true;
		
		for(int i = 0; i < fa.size(); i++) {		
			if(fId.contains(fa.get(i).getFamilyId())) {
				System.out.println("Anomaly: FAMILY: US22 " + fa.get(i).getFamilyId() + ": have a same ID with another family");
				outFile.println("Anomaly: FAMILY: US22 " + fa.get(i).getFamilyId() + ": have a same ID with another family");
				flag = false;
			}else {
				fId.add(fa.get(i).getFamilyId());
			}
		}
		
		for(int i = 0; i < individuals.size(); i++) {
			if(iId.contains(individuals.get(i).getIndividualId())) {
				System.out.println("Anomaly: INDIVIDUAL: US22 " + individuals.get(i).getIndividualId() + ": have a same ID with another individual");
				outFile.println("Anomaly: INDIVIDUAL: US22 " + individuals.get(i).getIndividualId() + ": have a same ID with another individual");
				flag = false;
			}else {
				iId.add(individuals.get(i).getIndividualId());
			}
		}
		
		outFile.flush();
		return flag;	
	}
}
