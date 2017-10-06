import java.util.Date;

/*
*Yoseph Borai
*10/6/17
*/

public class Methods {

    public static Date findDate(String date){
    	String[] temp = date.split("-");
    	int year = Integer.parseInt(temp[0]) - 1900;
    	int month = Integer.parseInt(temp[1]) - 1;
    	int day = Integer.parseInt(temp[2]);
    	Date response = new Date(year, month, day);
    	
    	return(response);
    }
    
	public static Boolean DatesBeforeNow(Individual[] in, Family[] fa){
		Date now = new Date();
		
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

}