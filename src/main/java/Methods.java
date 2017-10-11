import java.util.Date;

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
	
	//verify all the individuals lives not more than 150 years old, input is the original .ged 
	//and if there's anyone longer than 150, output a string"someone's age is not correct"
	public static void LessThan150YearsOld(){
		
		
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
