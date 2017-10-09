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

}