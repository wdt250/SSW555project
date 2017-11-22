package test.jiadongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.jiadong.US33;

public class testUS33 extends TestCase{
	public void testlistOrphans() {
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
			family.setFamilyId("F1");
			
			individual1.setIndividualId("H1");
			individual2.setIndividualId("W1");
			individual3.setIndividualId("I3");
			individual4.setIndividualId("I4");
			
			individual1.setName("Michale /Jefferson/");
			individual2.setName("Lily /Jefferson/");
			individual3.setName("Robert /Jefferson/");
			individual4.setName("Abigale /Jefferson/");
			
			individual1.setGender("M");
			individual2.setGender("F");
			individual3.setGender("M");
			individual4.setGender("M");
			
			individual1.setAlive(false);
			individual2.setAlive(false);
			individual3.setAge(4);
			individual4.setAge(20);
			
			ArrayList<String> child1 = new ArrayList<String>();
			child1.add("I1");
			child1.add("I2");
			child1.add("I3");
			child1.add("I4");
			family.setChildren(child1);
			
			family.setHusbandId("H1");
			family.setWifeId("W1");
			
			families.add(family);
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
				US33.listOrphans(individuals, families, outFile);
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
