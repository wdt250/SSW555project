package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US18 {
	
	public static boolean SiblingsShouldNotMarry(ArrayList<Family> families, PrintWriter outFile){
		boolean flag = true;
		
		for(Family fa: families){
			for (Family fa2: families){
				if (fa2.getChildren()!=null && fa2.getChildren().contains(fa.getHusbandId()) && fa2.getChildren().contains(fa.getWifeId())){
					flag = false;
					System.out.println("Error: Family: US18: " + "the family of " + fa.getFamilyId() + "'s parents are siblings");
					outFile.println("Error: Family: US18: " + "the family of " + fa.getFamilyId() + "'s parents are siblings");
					break;
				}else{
					continue;
				}
			}	
		}
		outFile.flush();
		return flag;
	}
}
