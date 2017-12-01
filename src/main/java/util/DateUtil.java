package main.java.util;

import java.util.Calendar;
import java.util.Date;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 11, 2017 
*
*/
public class DateUtil {
	
	public static int getAge(Date birthDay) throws Exception  
    {  
		if (birthDay == null) {
			return 0;
		}
        Calendar cal = Calendar.getInstance();  
  
        int currentYear = cal.get(Calendar.YEAR);  
        int currentMonth = cal.get(Calendar.MONTH);  
        int currentDate = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int birthYear = cal.get(Calendar.YEAR);  
        int birthMonth = cal.get(Calendar.MONTH);  
        int birthDate = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = currentYear - birthYear;  
  
        if (currentMonth <= birthMonth)  
        {  
            if (currentMonth == birthMonth)  
            {  
                if (currentDate < birthDate)  
                    age--;  
            }  
            else  
            {  
                age--;  
            }  
        }  
        return age;  
    }  
	
	public static int getAge(Date birthDay, Date deathDay) throws Exception  
    {  
		if (birthDay == null || deathDay == null) {
			return 0;
		}
        Calendar birthCal = Calendar.getInstance();
        Calendar deathCal = Calendar.getInstance();
  
        birthCal.setTime(birthDay);  
        deathCal.setTime(deathDay);
  
        int birthYear = birthCal.get(Calendar.YEAR);  
        int birthMonth = birthCal.get(Calendar.MONTH);  
        int birthDate = birthCal.get(Calendar.DAY_OF_MONTH);
        
        int deathYear = deathCal.get(Calendar.YEAR);
        int deathMonth = deathCal.get(Calendar.MONTH);
        int deathDate = deathCal.get(Calendar.DAY_OF_MONTH);
  
        int age = deathYear - birthYear;  
  
        if (deathMonth <= birthMonth)  
        {  
            if (deathMonth == birthMonth)  
            {  
                if (deathDate < birthDate)  
                    age--;  
            }  
            else  
            {  
                age--;  
            }  
        }  
        return age;  
    }

	public static long compareDate(String previousDate, String lateDate) {
		return StringUtil.Str2DateFormat(lateDate).getTime() - StringUtil.Str2DateFormat(previousDate).getTime();
	}  
	
	public static long compareYear(String previousDate, String lateDate) {
		return compareDay(previousDate, lateDate)/365;
	}
	
	public static long compareMonth(String previousDate, String lateDate) {
		return compareDay(previousDate, lateDate)/30;
	}
	
	public static long compareDay(String previousDate, String lateDate) {
		return compareHour(previousDate, lateDate)/24;
	}
	
	public static long compareHour(String previousDate, String lateDate) {
		return compareMinute(previousDate, lateDate)/60;
	}
	
	public static long compareMinute(String previousDate, String lateDate) {
		return compareSecond(previousDate, lateDate)/60;
	}
	
	public static long compareSecond(String previousDate, String lateDate) {
		return compareDate(previousDate, lateDate)/1000;
	}
	
	public static Date findDate(String date){
		
    	String[] temp = date.split("-");
    	int year = Integer.parseInt(temp[0]) - 1900;
    	int month = Integer.parseInt(temp[1]) - 1;
    	int day = Integer.parseInt(temp[2]);
    	Date response = new Date(year, month, day);
    	
    	return(response);
    }
}
