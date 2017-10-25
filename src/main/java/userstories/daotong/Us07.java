package main.java.userstories.daotong;

import java.util.ArrayList;

import main.java.beans.Individual;

public class Us07 {

	public static void LessThan150YearsOld(ArrayList<Individual> individuals){
		for(Individual in: individuals){
			if(in.getAge()<150){
				System.out.println(in.getIndividualId()+" "+ in.getName()+ "'s age is "+ in.getAge()+ " which is okay");
			}else if(in.getAge()>=150){
				System.out.println(in.getIndividualId()+" "+in.getName()+"'s age is "+in.getAge()+" more than 150 years old");
			}else{
				System.out.println(in.getIndividualId()+" "+in.getName()+" something problem with his/her age");
			}
		}
	}
}
