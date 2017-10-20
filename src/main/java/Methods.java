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
	public static Boolean DatesBeforeNow(Individual[] individuals, Family[] families){
		Date now = new Date();
		boolean flag = true;

		//Checks all valid individual dates for a logical date
		for(Individual individual: individuals){
			if(!(individual.getBirt().equals("NA"))){
			    if(findDate(individual.getBirt()).after(now)){
			    	flag = false;
			    	System.out.println("Error(" + individual.getId() + "): Birth date(" +individual.getBirt() + ") cannot be before today");
			    }
			}
			if(!(individual.getDeat().equals("NA"))){
			    if(findDate(individual.getDeat()).after(now)){
			    	flag = false;
			    	System.out.println("Error(" + individual.getId() + "): Death date(" +individual.getBirt() + ") cannot be before today");
			    }
			}
		}
		
		//Checks all valid family dates for l
		for(Family family: families){
			if(!(family.getMarrieddate().equals("NA"))){
			    if(findDate(family.getMarrieddate()).after(now)){
			    	flag = false;
			    	System.out.println("Error(" + family.getId() + "): Marriage date(" +family.getBirt() + ") cannot be before today");
			    }
			}
			if(!(family.getDivorcedate().equals("NA"))){
			    if(findDate(family.getDivorcedate()).after(now)){
			    	flag = false;
			    	System.out.println("Error(" + family.getId() + "): Divorce date(" +family.getBirt() + ") cannot be before today");
			    }
			}
		}
		
		System.out.println("No dates after today!");
		
		return flag;
	}
	
	public static Boolean birthBeforeMarriage(Individual[] individuals, Family[] families){
		boolean flag = true;
		for(Family family: families){
			for(Individual individual: individuals){
				if(family.getMarrieddate().equals("NA"))
					continue;

				if(family.getHusbandid().equals(individual.getId()))
					if(Methods.findDate(individual.getBirt()).after(Methods.findDate(family.getMarrieddate()))) {
				    	flag = false;
				    	System.out.println("Error(" + individual.getId() + "): Marriage date(" +family.getMarrieddate() + ") cannot be before birth date(" + individual.getBirt() + ")");
					}

				if(family.getWifeid().equals(individual.getId()))
					if(Methods.findDate(individual.getBirt()).after(Methods.findDate(family.getMarrieddate()))) {
				    	flag = false;
				    	System.out.println("Error(" + individual.getId() + "): Marriage date(" +family.getMarrieddate() + ") cannot be before birth date(" + individual.getBirt() + ")");
					}
			}
		}
		
		System.out.println("No Marriage before birth!");
		
		return flag;
	}
	
	public static Boolean DeathBeforeMarriage(Individual[] in, Family[] fa){
		for(Family fam: fa){
			if(fam.getMarrieddate().equals("NA")){
				continue;
			}

			for(Individual indi: in){
				if(indi.getDeat() == "NA"){
					continue;
				}
				
				if(fam.getHusbandid().equals(indi.getId()))
					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getMarrieddate())))
						return false;

				if(fam.getWifeid().equals(indi.getId()))
					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getMarrieddate())))
						return false;
			}
		}
		return true;
	}
	
	public static Boolean DeathBeforeDivorce(Individual[] in, Family[] fa){
		for(Family fam: fa){
			if(fam.getDivorcedate().equals("NA")){
				continue;
			}

			for(Individual indi: in){
				if(indi.getDeat().equals("NA")){
					continue;
				}
				
				if(fam.getHusbandid().equals(indi.getId()))
					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getDivorcedate())))
						return false;

				if(fam.getWifeid().equals(indi.getId()))
					if(Methods.findDate(indi.getDeat()).before(Methods.findDate(fam.getDivorcedate())))
						return false;
			}
		}
		return true;
	}

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
	
	//verify all the individuals lives not more than 150 years old, input is the original .ged 
	//and if there's anyone longer than 150, output a string"someone's age is not correct"
	public static void LessThan150YearsOld(String inputfile){
		
		
		try {
			String sCurrent;
			String[] s;
			boolean birtdate = false;
			boolean deatdate = false;
			
			int birtyear = 0;
			int deatyear ;
			
			
			
					
					BufferedReader br = new BufferedReader(new FileReader(inputfile));
					while((sCurrent = br.readLine())!= null){
						s = sCurrent.split(" ");
						/*for(int i =0; i<s.length;i++){
							System.out.println(s[i]);
						}*/
						switch(s[1]){
						case "BIRT":
							birtdate = true;
							break;
						case "DEAT":
							deatdate = true;
							break;
							
						case "DATE":
							
							if(birtdate==true&&deatdate==false){
								if(birtyear!=0&&(2017-birtyear)>150){//this is the situation of someone still alive and there's no deatdate
									System.out.println("someone's age is not correct");
									testFor150 = true;
									birtyear = 0;
								}
								birtyear = Integer.parseInt(s[4]);

								
								
							}else if(deatdate==true&&birtdate==true){//this is when someone has a birthday and dead 
								deatyear = Integer.parseInt(s[4]);
								deatdate = false;
								if((deatyear-birtyear)>150){
									System.out.println("someone's age is not correct");
									testFor150 = true;
								}
								deatyear = 0;
								birtyear = 0;
								birtdate = false;
								deatdate = false;
							}
							break;
						}
					}
					
					br.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	//verify the birth of child is in the time perioud between the marrige
	// input is the arraylist of individuals and families, and output are some strings:"good baby" or "not your baby"
	public static void BirthBeforeMarriageofParents(Individual[] in, Family[] fa){
		//attention to the input: this method has to wait for the classification of individuals and families
		String family;
		
		
		Calendar DateofBirth = Calendar.getInstance();
		Calendar DateofMarried = Calendar.getInstance();
		Calendar DateofDivorce = Calendar.getInstance();
		
		SimpleDateFormat origindate = new SimpleDateFormat("dd MMM yyyy",Locale.US);
		
		for(int i = 0; i< in.length; i++){
			if(in[i].getChild()!=null){
				family = in[i].getChild();
				try {
					DateofBirth.setTime(origindate.parse(in[i].getBirt()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				for(int j = 0; j< fa.length; j++){
					if(fa[j].getId()== family && fa[j].getDivorcedate()!= null){
						
						try {
							DateofMarried.setTime(origindate.parse(fa[j].getMarrieddate()));
							DateofDivorce.setTime(origindate.parse(fa[j].getDivorcedate()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						DateofDivorce.add(Calendar.MONTH, 9);
						if(DateofBirth.after(DateofMarried)&&DateofBirth.before(DateofDivorce)){
							System.out.println("good baby!");
						}else{
							System.out.println("not your baby...");
							testForBirthDateBetween = false;
						}
						
						break;
					}else if(fa[j].getId()== family && fa[j].getDivorcedate()== null){
						try {
							DateofMarried.setTime(origindate.parse(fa[j].getMarrieddate()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(DateofBirth.after(DateofMarried)){
							System.out.println("good baby!");
						}else{
							System.out.println("not your baby");
							testForBirthDateBetween = false;
						}
						
						break;
					}
				}
			}
		}
			
		
		
		
	}

}

