package test.jiadongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.jiadong.US16;

/**
* @author Jiadong chen 
*         E-mail:jchen69@stevens.edu
* @date Oct 25 2017 
* 
* @version 
*/

public class testUS16 extends TestCase {
	
	public void testMaleLastName(){
		ArrayList<Family> families = new ArrayList<Family>();
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			Individual individual3 = new Individual();
			Individual individual4 = new Individual();
			Family family = new Family();
			
			individual1.setIndividualId("I1");
			individual2.setIndividualId("I2");
			individual3.setIndividualId("I3");
			individual4.setIndividualId("I4");
			
			individual1.setName("Michale /Jefferson/");
			individual2.setName("Howard /Jefferson/");
			individual3.setName("Robert /Jefferson/");
			individual4.setName("Abigale /Jefferson/");
			
			individual1.setGender("M");
			individual2.setGender("M");
			individual3.setGender("M");
			individual4.setGender("M");
			
			family.setHusbandName("Thomas /Jefferson/");
			ArrayList<String> child = new ArrayList<String>();
			child.add("I1");
			child.add("I2");
			child.add("I3");
			child.add("I4");
			family.setChilden(child);
			
			families.add(family);
			individuals.add(individual1);
			individuals.add(individual2);
			individuals.add(individual3);
			individuals.add(individual4);
			
			assertTrue(US16.maleLastName(individuals, families, outFile));
			
			Individual individual5 = new Individual();
			individual5.setName("George /Jefferso/");
			individual5.setIndividualId("I5");
			individual5.setGender("M");
			
			individuals.add(individual5);
			child.add("I5");
			family.setChilden(child);
			families.add(family);
			assertFalse(US16.maleLastName(individuals, families, outFile));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
