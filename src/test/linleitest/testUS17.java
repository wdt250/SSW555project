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
public class testUS17
	extends TestCase{

	public void testNoMarryDescendant() {
//	public static void main(String[] args) {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Family family1 = new Family();	//ordinary family
			Family family2 = new Family();	//Husband married child
			Family family3 = new Family();	//Wife married child
			Family family4 = new Family();	
			Family family5 = new Family();
			
			family1.setFamilyId("F1");
			family2.setFamilyId("F2");
			family3.setFamilyId("F3");
			family4.setFamilyId("F4");
			family5.setFamilyId("F5");
			
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			Individual individual3 = new Individual();
			Individual individual4 = new Individual();
			Individual individual5 = new Individual();
			Individual individual6 = new Individual();
			Individual individual7 = new Individual();
			Individual individual8 = new Individual();
			Individual individual9 = new Individual();
			Individual individual10 = new Individual();
			Individual individual11 = new Individual();
			Individual individual12 = new Individual();
			
			individual1.setIndividualId("I1");
			individual2.setIndividualId("I2");
			individual3.setIndividualId("I3");
			individual4.setIndividualId("I4");
			individual5.setIndividualId("I5");
			individual6.setIndividualId("I6");
			individual7.setIndividualId("I7");
			individual8.setIndividualId("I8");
			individual9.setIndividualId("I9");
			individual10.setIndividualId("I10");
			individual11.setIndividualId("I11");
			individual12.setIndividualId("I12");
			
			ArrayList<String> children1 = new ArrayList<String>();
			ArrayList<String> children2 = new ArrayList<String>();
			ArrayList<String> children3 = new ArrayList<String>();
			
			family1.setHusbandId(individual1.getIndividualId());
			family1.setWifeId(individual2.getIndividualId());
			children1.add(individual3.getIndividualId());
			children1.add(individual5.getIndividualId());
			family1.setChildren(children1);
			
			
			family2.setHusbandId(individual3.getIndividualId());
			family2.setWifeId(individual4.getIndividualId());
			children2.add(individual7.getIndividualId());
			children2.add(individual9.getIndividualId());
			family2.setChildren(children2);

			
			family3.setHusbandId(individual5.getIndividualId());
			family3.setWifeId(individual6.getIndividualId());
			
			family4.setHusbandId(individual7.getIndividualId());
			family4.setWifeId(individual8.getIndividualId());
			children3.add(individual11.getIndividualId());
			family4.setChildren(children3);
			
			family5.setHusbandId(individual9.getIndividualId());
			family5.setWifeId(individual10.getIndividualId());
			
//			family4.setWifeId(individual12.getIndividualId());
//			children3.add(individual12.getIndividualId());
			
			individuals.add(individual1);
			individuals.add(individual2);
			individuals.add(individual3);
			individuals.add(individual4);
			individuals.add(individual5);
			individuals.add(individual6);
			individuals.add(individual7);
			individuals.add(individual8);
			individuals.add(individual9);
			individuals.add(individual10);
			individuals.add(individual11);
			individuals.add(individual12);
			families.add(family1);
			families.add(family2);
			families.add(family3);
			families.add(family4);
			families.add(family5);
			
			assertTrue(US17.NoMarryDescendant(individuals, families, outFile));
			
			family1.setWifeId(individual12.getIndividualId());
			children1.add(individual12.getIndividualId());
			assertFalse(US17.NoMarryDescendant(individuals, families, outFile));
			
			children1.remove(individual12.getIndividualId());
			children2.add(individual12.getIndividualId());
			assertFalse(US17.NoMarryDescendant(individuals, families, outFile));
			
			children2.remove(individual12.getIndividualId());
			children3.add(individual12.getIndividualId());
			assertFalse(US17.NoMarryDescendant(individuals, families, outFile));
			
			family1.setWifeId(individual2.getIndividualId());
			family2.setWifeId(individual12.getIndividualId());
			children3.remove(individual12.getIndividualId());
			children2.add(individual12.getIndividualId());
			assertFalse(US17.NoMarryDescendant(individuals, families, outFile));
			
			children2.remove(individual12.getIndividualId());
			children3.add(individual12.getIndividualId());
			assertFalse(US17.NoMarryDescendant(individuals, families, outFile));
			
			family2.setWifeId(individual4.getIndividualId());
			family4.setWifeId(individual12.getIndividualId());
			children3.add(individual12.getIndividualId());
			assertFalse(US17.NoMarryDescendant(individuals, families, outFile));
//			US17.NoMarryDescendant(individuals, families, outFile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}

}
