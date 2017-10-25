package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Individual;

public class US07 {

	public static boolean LessThan150YearsOld(ArrayList<Individual> individuals, PrintWriter outFile){
		for(Individual in: individuals){
			if(in.getAge()<150){
//				System.out.println("Error: INDIVIDUAL: US07: "+in.getIndividualId()+" "+ in.getName()+ "'s age is "+ in.getAge()+ " which is okay");
				
			}else if(in.getAge()>=150){
				System.out.println("Error: INDIVIDUAL: US07: "+in.getIndividualId()+" "+in.getName()+"'s age is "+in.getAge()+" more than 150 years old");
				outFile.println("Error: INDIVIDUAL: US07: "+in.getIndividualId()+" "+in.getName()+"'s age is "+in.getAge()+" more than 150 years old");
				return false;
			}else{
				System.out.println("Error: INDIVIDUAL: US07: "+in.getIndividualId()+" "+in.getName()+" something problem with his/her age");
				outFile.println("Error: INDIVIDUAL: US07: "+in.getIndividualId()+" "+in.getName()+" something problem with his/her age");
				return false;
			}
		}
		outFile.flush();
		return true;
	}
}
