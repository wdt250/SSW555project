package main.java.userstories.yoseph;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Family;
import main.java.util.StringUtil;

public class US11 {
    public static boolean NoBigamy(ArrayList<Family> families, PrintWriter outfile) { 
    	boolean afterMarriageCheck;
    	boolean beforeDivorceCheck;
    	boolean flag = true;
    	for(Family family: families)
    		for(Family bigamyCheck: families) {
    			if(bigamyCheck == family || bigamyCheck.getMarriedDate().equals("NA") || family.getMarriedDate().equals("NA"))
    				continue;
    			
    			if(family.getHusbandId().equals(bigamyCheck.getHusbandId()) || family.getWifeId().equals(bigamyCheck.getWifeId())) {
    				afterMarriageCheck = StringUtil.Str2DateFormat(bigamyCheck.getMarriedDate()).after(StringUtil.Str2DateFormat(family.getMarriedDate()));
    				if(family.getDivorceDate().equals("NA")) {
    					if(afterMarriageCheck) {
    						System.out.println("Anomaly:Family:(" + family.getFamilyId() + "): cannot have more than one marriage at a time!");
    						outfile.println("Anomaly:Family:(" + family.getFamilyId() + "): cannot have more than one marriage at a time!");
    						flag = false;
    					}
    					continue;
    				}
    				
    				beforeDivorceCheck = StringUtil.Str2DateFormat(bigamyCheck.getMarriedDate()).before(StringUtil.Str2DateFormat(family.getDivorceDate()));
    				
    				if(beforeDivorceCheck && afterMarriageCheck) {
    					flag = false;
    					System.out.println("Anomaly:Family:(" + family.getFamilyId() + "): Cannot have more than one marriage at a time!");
    					outfile.println("Anomaly:Family:(" + family.getFamilyId() + "): Cannot have more than one marriage at a time!");
    				}
    			}
    		}
    	outfile.flush();
    	return flag;	
    }
}
