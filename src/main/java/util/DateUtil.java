package util;

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
}
