package test.linleitest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Test;
import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.linlei.US17;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Nov 6, 2017 
* 
* @version 
*/
public class testUS17 extends TestCase{

	public void testNoMarryDescendant() {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Family family1 = new Family();	//ordinary family
			Family family2 = new Family();	//Husband married child
			Family family3 = new Family();	//Wife married child
			
			family1.setFamilyId("F1");
			family2.setFamilyId("F2");
			family3.setFamilyId("F3");
			
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			Individual individual3 = new Individual();
			Individual individual4 = new Individual();
			Individual individual5 = new Individual();
			Individual individual6 = new Individual();
			Individual individual7 = new Individual();
			Individual individual8 = new Individual();
						
			individual1.setIndividualId("I1");
			individual2.setIndividualId("I2");
			individual3.setIndividualId("I3");
			individual4.setIndividualId("I4");
			individual5.setIndividualId("I5");
			individual6.setIndividualId("I6");
			individual7.setIndividualId("I7");
			individual8.setIndividualId("I8");
			
			ArrayList<String> children1 = new ArrayList<String>();
			ArrayList<String> children2 = new ArrayList<String>();
			
			children1.add(individual3.getIndividualId());
			children1.add(individual5.getIndividualId());
			children2.add(individual7.getIndividualId());
			children2.add(individual8.getIndividualId());
			
			family1.setHusbandId(individual1.getIndividualId());
			family2.setHusbandId(individual3.getIndividualId());
			family3.setHusbandId(individual5.getIndividualId());
			
			family1.setWifeId(individual2.getIndividualId());
			family2.setWifeId(individual4.getIndividualId());
			family3.setWifeId(individual6.getIndividualId());
			
			family1.setChildren(children1);
			family2.setChildren(children2);
			
			individuals.add(individual1);
			individuals.add(individual2);
			individuals.add(individual3);
			individuals.add(individual4);
			individuals.add(individual5);
			individuals.add(individual6);
			individuals.add(individual7);
			individuals.add(individual8);
			families.add(family1);
			families.add(family2);
			families.add(family3);
			
			assertTrue(US17.NoMarryDescendant(individuals, families, outFile));
			
			family1.setWifeId(individual5.getIndividualId());
			assertFalse(US17.NoMarryDescendant(individuals, families, outFile));
			
			family1.setWifeId(individual8.getIndividualId());
			assertFalse(US17.NoMarryDescendant(individuals, families, outFile));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}

}
