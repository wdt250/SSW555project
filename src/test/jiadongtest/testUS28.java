package test.jiadongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.jiadong.US28;

public class testUS28 extends TestCase{
	public void testOutputSiblings() {
		ArrayList<Family> families = new ArrayList<Family>();
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			Individual individual3 = new Individual();
			Individual individual4 = new Individual();
			Family family1 = new Family();
			family1.setFamilyId("F1");
			Family family2 = new Family();
			family2.setFamilyId("F2");
			
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
			
			individual1.setAge(5);
			individual2.setAge(9);
			individual3.setAge(4);
			individual4.setAge(7);
			
			ArrayList<String> child1 = new ArrayList<String>();
			child1.add("I1");
			family1.setChildren(child1);
			
			ArrayList<String> child2 = new ArrayList<String>();
			child2.add("I2");
			child2.add("I3");
			child2.add("I4");
			family2.setChildren(child2);
			
			families.add(family1);
			families.add(family2);
			individuals.add(individual1);
			individuals.add(individual2);
			individuals.add(individual3);
			individuals.add(individual4);
			
	/*		Individual individual5 = new Individual();
			individual5.setName("George /Jefferso/");
			individual5.setIndividualId("I5");
			individual5.setGender("M");
			
			individuals.add(individual5);
			child.add("I5");
			family.setChildren(child);
			families.add(family);*/
			
			try {
				US28.orderSiblingByAge(individuals, families, outFile);
			} catch (Exception e) {
	            e.printStackTrace();
	            fail("Error: US30: print problem");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
