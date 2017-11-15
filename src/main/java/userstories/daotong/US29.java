package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.beans.Individual;

public class US29 {

	public static boolean ListDeceased(ArrayList<Individual> individuals, PrintWriter outFile){
		boolean flag = true;
		for(Individual in: individuals){
			if(!in.getAlive()){
				System.out.println("US29: Individual: whose id is " + in.getIndividualId() + " passed away");
				outFile.println("US29: Individual: whose id is " + in.getIndividualId() + " passed away");
			}
		}
		outFile.flush();
		return flag;
	}
}
