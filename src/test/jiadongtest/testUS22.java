package test.jiadongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.jiadong.US22;

public class testUS22 extends TestCase {
	public void testUniqueIds() {
		ArrayList<Family> families = new ArrayList<Family>();
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		PrintWriter outFile = null;
		
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			Individual individual3 = new Individual();
			Individual individual4 = new Individual();
			
			individual1.setIndividualId("I1");
			individual2.setIndividualId("I2");
			individual3.setIndividualId("I3");
			individual4.setIndividualId("I4");
			
			individuals.add(individual1);
			individuals.add(individual2);
			individuals.add(individual3);
			individuals.add(individual4);
			
			Family family1 = new Family();
			Family family2 = new Family();
			Family family3 = new Family();
			Family family4 = new Family();
			
			family1.setFamilyId("F1");
			family2.setFamilyId("F2");
			family3.setFamilyId("F3");
			family4.setFamilyId("F4");

			families.add(family1);
			families.add(family2);
			families.add(family3);
			families.add(family4);

			assertTrue(US22.uniqueIds(individuals, families, outFile));
			
			Individual individual5 = new Individual();
			individual5.setIndividualId("I3");
			individuals.add(individual5);
			
			assertFalse(US22.uniqueIds(individuals, families, outFile));
			
			individuals.remove(4);
			
			Family family5 = new Family();
			family5.setFamilyId("F2");
			families.add(family5);
			
			assertFalse(US22.uniqueIds(individuals, families, outFile)); 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
		
	}
}
