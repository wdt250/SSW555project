package test.yosephtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.US21;

public class testUS21 extends TestCase {
	
	public void testCorrectGenderForRole(){
		try {
		  PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
		  Individual individual1 = new Individual();
		  Individual individual2 = new Individual();
		  Family family1 = new Family();
		  ArrayList<Individual> individuals = new ArrayList<Individual>();
		  ArrayList<Family> families = new ArrayList<Family>();
		  individuals.add(individual1);
		  individuals.add(individual2);
		  families.add(family1);
		  family1.setHusbandId("@I01@");
		  family1.setWifeId("@I02@");
		  individual1.setGender("M");
		  individual2.setGender("F");
		  individual1.setIndividualId("@I01@");
		  individual2.setIndividualId("@I02@");
		  assertTrue(US21.CorrectGenderForRole(individuals, families, outfile));
		  individual1.setGender("F");
		  assertFalse(US21.CorrectGenderForRole(individuals, families, outfile));
		  individual1.setGender("M");
		  individual2.setGender("M");
		  assertFalse(US21.CorrectGenderForRole(individuals, families, outfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}
