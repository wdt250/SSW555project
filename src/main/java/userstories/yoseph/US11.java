package main.java.userstories.yoseph;

import java.util.ArrayList;
import java.util.HashMap;

import main.java.beans.Individual;
import main.java.util.StringUtil;
import main.java.beans.Family;

public class US11 {
    public static boolean NoBigamy(ArrayList<Individual> individuals, ArrayList<Family> families) { 
    	boolean afterMarriageCheck;
    	boolean beforeDivorceCheck;
    	boolean flag = true;
    	for(Family family: families)
    		for(Family bigamyCheck: families) {
    			if(bigamyCheck == family)
    				continue;
    			
    			if(family.getHusbandId().equals(bigamyCheck.getHusbandId()) || family.getWifeId().equals(bigamyCheck.getWifeId())) {
    				afterMarriageCheck = StringUtil.Str2DateFormat(bigamyCheck.getMarriedDate()).after(StringUtil.Str2DateFormat(family.getMarriedDate()));
    				if(family.getDivorceDate().equals("NA") && afterMarriageCheck) {
    					System.out.println("Error(" + family.getFamilyId() + "): cannot have more than one marriage at a time!");
    					flag = false;
    					continue;
    				}
    				
    				beforeDivorceCheck = StringUtil.Str2DateFormat(bigamyCheck.getMarriedDate()).before(StringUtil.Str2DateFormat(family.getDivorceDate()));
    				
    				if(beforeDivorceCheck && afterMarriageCheck) {
    					flag = false;
    					System.out.println("Error(" + family.getFamilyId() + "): cannot have more than one marriage at a time!");
    				}
    			}
    		}
    	
    	return flag;
    	
    }
}
