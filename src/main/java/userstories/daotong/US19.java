package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US19 {
	//need to validate
	public static boolean FirstCousinsShouldNotMarry(ArrayList<Family> families, PrintWriter outFile){
		boolean flag = true;
		String mother1 = null;
		String father1 = null;
		String mother2 = null;
		String father2 = null;
		
		for (Family fa: families){
			for(Family fa2: families){
				
					if(fa2.getChildren()!= null && fa2.getChildren().contains(fa.getHusbandId()) && !fa2.getChildren().contains(fa.getWifeId())){
						if(fa2.getWifeId()!= null && fa2.getHusbandId()!= null){
							mother1=fa2.getWifeId();
							father1=fa2.getHusbandId();		
						}
							else if(fa2.getWifeId()!= null && fa2.getHusbandId()== null){
							mother1=fa2.getWifeId();
						}else if(fa2.getWifeId()== null && fa2.getHusbandId()!= null){
							father1 = fa2.getHusbandId();
						}
												
					}else if(fa2.getChildren()!= null && !fa2.getChildren().contains(fa.getHusbandId()) && fa2.getChildren().contains(fa.getWifeId())){
						if(fa2.getWifeId()!= null && fa2.getHusbandId()!= null){
							mother2=fa2.getWifeId();
							father2=fa2.getHusbandId();
						}
						else if(fa2.getWifeId()!= null && fa2.getHusbandId()== null){
							mother2=fa2.getWifeId();
						}else if(fa2.getWifeId()== null && fa2.getHusbandId()!= null){
							father2 = fa2.getHusbandId();
						}
						
					}
								
					for(Family fa3: families){
						if (mother1 != null && mother2 != null && fa3.getChildren()!= null && fa3.getChildren().contains(mother1) && fa3.getChildren().contains(mother2)){
							flag = false;
							System.out.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins"+ " ,parents ids are: " + mother1 + " and "+ mother2);
							outFile.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins" );
							mother1 = null;
							father1 = null;
							mother2 = null;
							father2 = null;
							break;
						}else if (mother1 != null && father2 != null && fa3.getChildren()!= null && fa3.getChildren().contains(mother1) && fa3.getChildren().contains(father2) ){
							flag = false;
							System.out.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins"+ " ,parents ids are: " + mother1 + " and "+ father2);
							outFile.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
							mother1 = null;
							father1 = null;
							mother2 = null;
							father2 = null;
							break;
						}else if (father1 != null && mother2 != null && fa3.getChildren()!= null && fa3.getChildren().contains(father1) && fa3.getChildren().contains(mother2) ){
							flag = false;
							System.out.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins"+ " ,parents ids are: " + father1 + " and "+ mother2);
							outFile.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
							mother1 = null;
							father1 = null;
							mother2 = null;
							father2 = null;
							break;
						}else if (father1 != null && father2 != null && fa3.getChildren()!= null && fa3.getChildren().contains(father1) && fa3.getChildren().contains(father2) ){
							flag = false;
							System.out.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins"+ " ,parents ids are: " + father1 + " and "+ father2);
							outFile.println("Error: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
							mother1 = null;
							father1 = null;
							mother2 = null;
							father2 = null;
							break;
						}
					}
				
				
			}
		}
		return flag;
	}
}
