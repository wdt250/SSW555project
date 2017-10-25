package main.java.userstories.daotong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

import main.java.beans.Individual;
import main.java.beans.Family;

public class Us08 {

	public static void BirthBeforeMarriageofParents(ArrayList<Individual> individuals, ArrayList<Family> families){

		Calendar DateofBirth = Calendar.getInstance();
		Calendar DateofMarried = Calendar.getInstance();
		Calendar DateofDivorce = Calendar.getInstance();
		SimpleDateFormat origindate = new SimpleDateFormat("yyyy-mm-dd",Locale.US);
		
		for(Iterator<Individual> iteratorofIndividual = individuals.iterator(); iteratorofIndividual.hasNext();){
			Individual indi = iteratorofIndividual.next();

			if(indi.getChild()!=null){
				try {
					DateofBirth.setTime(origindate.parse(indi.getBirthDate()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Iterator<Family> iteratorofFamily = families.iterator(); iteratorofFamily.hasNext();){
					Family fami = iteratorofFamily.next();

					if(fami.getFamilyId().equals(indi.getChild()) && fami.getMarriedDate()!= null && fami.getDivorceDate()!= null){//there is divorce and test
						try {
							DateofMarried.setTime(origindate.parse(fami.getMarriedDate()));
							DateofDivorce.setTime(origindate.parse(fami.getDivorceDate()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						DateofDivorce.add(Calendar.MONTH, 9);
						if(DateofBirth.after(DateofMarried)&&DateofBirth.before(DateofDivorce)){
							System.out.println(indi.getName() + " of " + fami.getFamilyId() +" is good baby! ");
						}else{
							System.out.println(indi.getName() + " of " + fami.getFamilyId() + " hold on, maybe not your baby...");
						}
						
						break;
					}else if(fami.getFamilyId().equals(indi.getChild()) && fami.getMarriedDate()!= null && fami.getDivorceDate()== null){//no divorce
						try {
							DateofMarried.setTime(origindate.parse(fami.getMarriedDate()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(DateofBirth.after(DateofMarried)){
							System.out.println(indi.getName() + " of " + fami.getFamilyId() +" is good baby! ");
						}else{
							System.out.println(indi.getName() + " of " + fami.getFamilyId() + " hold on, maybe not your baby...");
						}
						break;
					}
					else if(fami.getFamilyId().equals(indi.getChild())){//this is essential cause maybe result in check error
						System.out.println(indi.getName() + " of " + fami.getFamilyId() +" can not decide may due to some missing date");
						break;
					}
				}
			}
		}
		
	}
}
