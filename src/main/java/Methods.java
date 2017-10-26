package main.java;

import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.ParseException;

public class Methods {
	//Makes a date value based off of date format YYYY-MM-DD
    public static Date findDate(String date){
    	String[] temp = date.split("-");
    	int year = Integer.parseInt(temp[0]) - 1900;
    	int month = Integer.parseInt(temp[1]) - 1;
    	int day = Integer.parseInt(temp[2]);
    	Date response = new Date(year, month, day);
    	
    	return(response);
    }
	
    //flags to test of testFor150 and BirthBeforeMarriageofParents
    public static boolean testFor150 = false;
    public static boolean testForBirthDateBetween = true;

    //Verifies whether all dates are before the given date when passed an array of individuals and families
	public static Boolean DatesBeforeNow(Individual[] in, Family[] fa){
		Date now = new Date();

		//Checks all valid individual dates for a logical date
		for(int i = 0;i < in.length;i++){
			if(!(in[i].getBirt().equals("NA"))){
			    if(findDate(in[i].getBirt()).after(now)){
				    return false;
			    }
			}
			if(!(in[i].getDeat().equals("NA"))){
			    if(findDate(in[i].getDeat()).after(now)){
				    return false;
			    }
			}
		}
		
		//Checks all valid family dates for l
		for(int i = 0;i < fa.length;i++){
			if(!(fa[i].getMarrieddate().equals("NA"))){
			    if(findDate(fa[i].getMarrieddate()).after(now)){
				    return false;
			    }
			}
			if(!(fa[i].getDivorcedate().equals("NA"))){
			    if(findDate(fa[i].getDivorcedate()).after(now)){
				    return false;
			    }
			}
		}
		
		return true;
	}
	
	public static Boolean birthBeforeMarriage(Individual[] in, Family[] fa){
		for(Family fam: fa){
			for(Individual indi: in){
				if(fam.getMarrieddate() == "NA")
					continue;

				if(fam.getHusbandid() == indi.getId())
					if(Methods.findDate(indi.getBirt()).after(Methods.findDate(fam.getMarrieddate())))
						return false;

				if(fam.getWifeid() == indi.getId())
					if(Methods.findDate(indi.getBirt()).after(Methods.findDate(fam.getMarrieddate())))
						return false;
			}
		}
		
		return true;
	}
	
	public static Boolean DeathBeforeMarriage(Individual[] in, Family[] fa){
		for(Family fam: fa){
			if(fam.getMarrieddate() == "NA"){
				continue;
			}

			for(Individual indi: in){
				if(indi.getDeat() == "NA"){
					continue;
				}
				
				if(fam.getHusbandid() == indi.getId())
					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getMarrieddate())))
						return false;

				if(fam.getWifeid() == indi.getId())
					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getMarrieddate())))
						return false;
			}
		}
		return true;
	}
	
//	public static Boolean DeathBeforeDivorce(Individual[] in, Family[] fa){
//		for(Family fam: fa){
//			if(fam.getDivorcedate() == "NA"){
//				continue;
//			}
//
//			for(Individual indi: in){
//				if(indi.getDeat() == "NA"){
//					continue;
//				}
//				
//				if(fam.getHusbandid() == indi.getId())
//					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getDivorcedate())))
//						return false;
//
//				if(fam.getWifeid() == indi.getId())
//					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getDivorcedate())))
//						return false;
//			}
//		}
//		return true;
//	}

	//Verify the birth of an individual is before death
	public static Boolean birthBeforeDeath(Individual[] in) {
		for(int i = 0; i < in.length; i++) {
			if(in[i].getDeat() != "NA") {
				if(Methods.findDate(in[i].getBirt()).after(Methods.findDate(in[i].getDeat()))) {
					return false;
				}			
			}
		}
		
		return true;
	}
	
	//Verify the marriage of an family is before divorce
//	public static Boolean marriageBeforeDivorce(Family[] fa) {
//		for(int i = 0; i < fa.length; i++) {
//			if(fa[i].getDivorcedate() != "NA") {
//				if(Methods.findDate(fa[i].getMarrieddate()).after(Methods.findDate(fa[i].getDivorcedate()))) {
//					return false;
//				}			
//			}
//		}
//		
//		return true;
//	}
	
	

}
