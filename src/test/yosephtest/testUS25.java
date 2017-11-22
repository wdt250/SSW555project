package test.yosephtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.US25;

public class testUS25 extends TestCase{
	public void testUniqueFirstNamesInFamilies(){
		try {
		  PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
		  Individual individual1 = new Individual();
		  Individual individual2 = new Individual();
		  Individual individual3 = new Individual();
		  Family family1 = new Family();
		  ArrayList<String> childrenIDs = new ArrayList<String>();
		  ArrayList<Individual> individuals = new ArrayList<Individual>();
		  ArrayList<Family> families = new ArrayList<Family>();
		  childrenIDs.add("@I01@");
		  childrenIDs.add("@I02@");
		  childrenIDs.add("@I03@");
		  individuals.add(individual1);
		  individuals.add(individual2);
		  individuals.add(individual3);
		  individual1.setName("Hairy");
		  individual2.setName("Fairy");
		  individual2.setName("Mary");
		  individual1.setIndividualId("@I01@");
		  individual2.setIndividualId("@I02@");
		  individual3.setIndividualId("@I03@");
		  families.add(family1);
		  family1.setChildren(childrenIDs);
		  assertTrue(US25.UniqueFirstNamesInFamilies(individuals, families, outfile));
		  individual2.setName("Hairy");
		  assertFalse(US25.UniqueFirstNamesInFamilies(individuals, families, outfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}