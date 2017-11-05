package test.yosephtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.US23;

public class testUS23 extends TestCase {
	
	public void testCorrectGenderForRole(){
		try {
		  PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
		  Individual individual1 = new Individual();
		  Individual individual2 = new Individual();
		  ArrayList<Individual> individuals = new ArrayList<Individual>();
		  individuals.add(individual1);
		  individuals.add(individual2);
		  individual1.setName("Hairy");
		  individual2.setName("Fairy");
		  individual1.setBirthDate("5/10/1997");
		  individual2.setBirthDate("5/11/1997");
		  individual1.setIndividualId("@I01@");
		  individual2.setIndividualId("@I02@");
		  assertTrue(US23.UniqueNameAndBirthDate(individuals, outfile));
		  individual2.setName("Hairy");
		  individual2.setBirthDate("5/10/1997");
		  assertFalse(US23.UniqueNameAndBirthDate(individuals, outfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}