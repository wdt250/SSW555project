package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US19 {

	public static boolean FirstCousinsShouldNotMarry(ArrayList<Family> families, PrintWriter outFile){
		boolean flag = true;
		String mother1 = null;
		String father1 = null;
		String mother2 = null;
		String father2 = null;
		
		for (Family fa: families){
			for(Family familyofparent: families){
				
					if(familyofparent.getChildren()!= null && familyofparent.getChildren().contains(fa.getHusbandId()) && !familyofparent.getChildren().contains(fa.getWifeId())){
						if(familyofparent.getWifeId()!= null && familyofparent.getHusbandId()!= null){
							mother1=familyofparent.getWifeId();
							father1=familyofparent.getHusbandId();		
						}
							else if(familyofparent.getWifeId()!= null && familyofparent.getHusbandId()== null){
							mother1=familyofparent.getWifeId();
						}else if(familyofparent.getWifeId()== null && familyofparent.getHusbandId()!= null){
							father1 = familyofparent.getHusbandId();
						}
												
					}else if(familyofparent.getChildren()!= null && !familyofparent.getChildren().contains(fa.getHusbandId()) && familyofparent.getChildren().contains(fa.getWifeId())){
						if(familyofparent.getWifeId()!= null && familyofparent.getHusbandId()!= null){
							mother2=familyofparent.getWifeId();
							father2=familyofparent.getHusbandId();
						}
						else if(familyofparent.getWifeId()!= null && familyofparent.getHusbandId()== null){
							mother2=familyofparent.getWifeId();
						}else if(familyofparent.getWifeId()== null && familyofparent.getHusbandId()!= null){
							father2 = familyofparent.getHusbandId();
						}
						
					}
								
					for(Family parentsasChildtoTest: families){
						if (mother1 != null && mother2 != null && parentsasChildtoTest.getChildren()!= null && parentsasChildtoTest.getChildren().contains(mother1) && parentsasChildtoTest.getChildren().contains(mother2)){
							flag = false;
							System.out.println("Error: Family: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins"+ " ,parents ids are: " + mother1 + " and "+ mother2);
							outFile.println("Error: Family: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins" );
							mother1 = null;
							father1 = null;
							mother2 = null;
							father2 = null;
							break;
						}else if (mother1 != null && father2 != null && parentsasChildtoTest.getChildren()!= null && parentsasChildtoTest.getChildren().contains(mother1) && parentsasChildtoTest.getChildren().contains(father2) ){
							flag = false;
							System.out.println("Error: Family: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins"+ " ,parents ids are: " + mother1 + " and "+ father2);
							outFile.println("Error: Family: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
							mother1 = null;
							father1 = null;
							mother2 = null;
							father2 = null;
							break;
						}else if (father1 != null && mother2 != null && parentsasChildtoTest.getChildren()!= null && parentsasChildtoTest.getChildren().contains(father1) && parentsasChildtoTest.getChildren().contains(mother2) ){
							flag = false;
							System.out.println("Error: Family: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins"+ " ,parents ids are: " + father1 + " and "+ mother2);
							outFile.println("Error: Family: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
							mother1 = null;
							father1 = null;
							mother2 = null;
							father2 = null;
							break;
						}else if (father1 != null && father2 != null && parentsasChildtoTest.getChildren()!= null && parentsasChildtoTest.getChildren().contains(father1) && parentsasChildtoTest.getChildren().contains(father2) ){
							flag = false;
							System.out.println("Error: Family: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins"+ " ,parents ids are: " + father1 + " and "+ father2);
							outFile.println("Error: Family: US19: the family of " + fa.getFamilyId() + " has trouble marrying: the couples are First Cousins");
							mother1 = null;
							father1 = null;
							mother2 = null;
							father2 = null;
							break;
						}
					}
				
				
			}
		}
		outFile.flush();
		return flag;
	}
}
