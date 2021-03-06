package test.linleitest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.linlei.US05;
/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 18, 2017 
*
*/
public class testUS05 extends TestCase {
	
	public void testDeathBeforeMarriage(){
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			Family family1 = new Family();
			Family family2 = new Family();

			individual1.setDeathDate("1970-08-10");
			individual2.setDeathDate("2000-10-10");
			individual1.setIndividualId("I1");
			individual2.setIndividualId("I2");
			family1.setHusbandId("I1");
			family2.setWifeId("I2");
			family2.setHusbandId("I1");
			family1.setWifeId("I2");
			family1.setMarriedDate("NA");
			family2.setMarriedDate("1970-08-09");

			individuals.add(individual1);
			individuals.add(individual2);
			families.add(family1);
			families.add(family2);
			assertTrue(US05.DeathBeforeMarriage(individuals, families, outFile));

			family1.setMarriedDate("1970-08-11");
			assertFalse(US05.DeathBeforeMarriage(individuals, families, outFile));

			family1.setMarriedDate("NA");
			individual2.setDeathDate("1970-08-08");
			assertFalse(US05.DeathBeforeMarriage(individuals, families, outFile));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
