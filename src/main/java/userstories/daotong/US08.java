package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

import main.java.beans.Individual;
import main.java.beans.Family;

public class US08 {

	public static Boolean BirthBeforeMarriageofParents(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile){

		Calendar DateofBirth = Calendar.getInstance();
		Calendar DateofMarried = Calendar.getInstance();
		Calendar DateofDivorce = Calendar.getInstance();
		SimpleDateFormat origindate = new SimpleDateFormat("yyyy-mm-dd",Locale.US);
		Boolean flag = true;
		
		for(Iterator<Individual> iteratorofIndividual = individuals.iterator(); iteratorofIndividual.hasNext();){
			Individual indi = iteratorofIndividual.next();

			if(indi.getAsChildOfFamily()!="None"){
				try {
					DateofBirth.setTime(origindate.parse(indi.getBirthDate()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Iterator<Family> iteratorofFamily = families.iterator(); iteratorofFamily.hasNext();){
					Family fami = iteratorofFamily.next();

					if(fami.getFamilyId().equals(indi.getAsChildOfFamily()) && !fami.getMarriedDate().equals("NA") && !fami.getDivorceDate().equals("NA")){//there is divorce and test
						try {
							DateofMarried.setTime(origindate.parse(fami.getMarriedDate()));
							DateofDivorce.setTime(origindate.parse(fami.getDivorceDate()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						DateofDivorce.add(Calendar.MONTH, 9);
						if(DateofBirth.after(DateofMarried)&&DateofBirth.before(DateofDivorce)){
//							System.out.println(indi.getName() + " of " + fami.getFamilyId() +" is good baby! ");
						}else{
							System.out.println("Error: US08: the Birth of "+indi.getName() + " of " + fami.getFamilyId() + " happened not in the period of parents' marriage");
							outFile.println("Error: US08: the Birth of "+indi.getName() + " of " + fami.getFamilyId() + " happened not in the period of parents' marriage");
							flag = false;
						}
						
						break;
					}else if(fami.getFamilyId().equals(indi.getAsChildOfFamily()) && !fami.getMarriedDate().equals("NA") && fami.getDivorceDate().equals("NA")){//no divorce
						try {
							DateofMarried.setTime(origindate.parse(fami.getMarriedDate()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(DateofBirth.after(DateofMarried)){
//							System.out.println(indi.getName() + " of " + fami.getFamilyId() +" is good baby! ");
						}else{
							System.out.println("Error: US08: the Birth of "+indi.getName() + " of " + fami.getFamilyId() + " happened not in the period of parents' marriage");
							outFile.println("Error: US08: the Birth of "+indi.getName() + " of " + fami.getFamilyId() + " happened not in the period of parents' marriage");
							flag = false;
						}
						break;
					}
					else if(fami.getFamilyId().equals(indi.getAsChildOfFamily())){//this is essential cause maybe result in check error
						System.out.println("Error: US08: the Birth of "+indi.getName() + " of " + fami.getFamilyId() +" can not decide may due to some missing date");
						outFile.println("Error: US08: the Birth of "+indi.getName() + " of " + fami.getFamilyId() +" can not decide may due to some missing date");
						flag = false;
						break;
					}
				}
			}
		}
		outFile.flush();
		return flag;
	}
}
