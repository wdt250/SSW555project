package test.yosephtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.US12;

public class testUS12 extends TestCase {
	
	public void testParentsNotTooOld(){
		try {
		  PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
		  Individual individual1 = new Individual();
		  Individual individual2 = new Individual();
		  Individual individual3 = new Individual();
		  Individual individual4 = new Individual();
		  Family family1 = new Family();
		  ArrayList<Individual> individuals = new ArrayList<Individual>();
		  ArrayList<Family> families = new ArrayList<Family>();
		  ArrayList<String> children = new ArrayList<String>();
		  individuals.add(individual1);
		  individuals.add(individual2);
		  individuals.add(individual3);
		  individuals.add(individual4);
		  families.add(family1);
		  family1.setHusbandId("@I01@");
		  family1.setWifeId("@I02@");
		  individual1.setAge(80);
		  individual2.setAge(60);
		  individual3.setAge(20);
		  individual4.setAge(10);
		  individual1.setIndividualId("@I01@");
		  individual2.setIndividualId("@I02@");
		  individual3.setIndividualId("@I03@");
		  individual4.setIndividualId("@I04@");
		  children.add(individual3.getIndividualId());
		  children.add(individual4.getIndividualId());
		  family1.setChildren(children);
		  assertTrue(US12.ParentsNotTooOld(individuals, families, outfile));
		  individual1.setAge(95);
		  assertFalse(US12.ParentsNotTooOld(individuals, families, outfile));
		  individual1.setAge(80);
		  individual2.setAge(75);
		  assertFalse(US12.ParentsNotTooOld(individuals, families, outfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}