package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US19 {
	//need to validate
	public static boolean FirstCousinsShouldNotMarry(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile){
		boolean flag = true;
		String mother1 = null;
		String father1 = null;
		String mother2 = null;
		String father2 = null;
		
		for (Family fa: families){
			for(Family fa2: families){
				if(fa2.getChildren().contains(fa.getHusbandId()) && !fa2.getChildren().contains(fa.getWifeId())){
					mother1.equals(fa2.getWifeId());
					father1.equals(fa2.getHusbandId());
				}else if(!fa2.getChildren().contains(fa.getHusbandId()) && fa2.getChildren().contains(fa.getWifeId())){
					mother2.equals(fa2.getWifeId());
					father2.equals(fa2.getHusbandId());
				}
				
				for(Family fa3: families){
					if (fa3.getChildren().contains(mother1) && fa3.getChildren().contains(mother2)){
						flag = false;
						System.out.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
						outFile.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
						break;
					}else if (fa3.getChildren().contains(mother1) && fa3.getChildren().contains(father2)){
						flag = false;
						System.out.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
						outFile.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
						break;
					}else if (fa3.getChildren().contains(father1) && fa3.getChildren().contains(mother2)){
						flag = false;
						System.out.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
						outFile.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
						break;
					}else if (fa3.getChildren().contains(father1) && fa3.getChildren().contains(father2)){
						flag = false;
						System.out.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
						outFile.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
						break;
					}
				}
			}
		}
		return flag;
	}
}
