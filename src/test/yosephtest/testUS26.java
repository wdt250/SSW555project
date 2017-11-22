package test.yosephtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.US26;

public class testUS26 extends TestCase{
	public void testCorrespondingEntries(){
		try {
		  PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
		  Individual individual1 = new Individual();
		  Individual individual2 = new Individual();
		  Individual individual3 = new Individual();
		  Family family1 = new Family();
		  ArrayList<Individual> individuals = new ArrayList<Individual>();
		  ArrayList<Family> families = new ArrayList<Family>();
		  ArrayList<String> children = new ArrayList<String>();
		  children.add("@I01@");
		  individuals.add(individual1);
		  individuals.add(individual2);
		  individuals.add(individual3);
		  individual1.setIndividualId("@I01@");
		  individual1.setAsChildOfFamily("@F01@");
		  individual1.setAsSpouseOfFamily("NA");
		  individual2.setIndividualId("@I02@");
		  individual2.setAsChildOfFamily("None");
		  individual2.setAsSpouseOfFamily("@F01@");
		  individual3.setIndividualId("@I03@");
		  individual3.setAsChildOfFamily("None");
		  individual3.setAsSpouseOfFamily("@F01@");
		  families.add(family1);
		  family1.setFamilyId("@F01@");
		  family1.setChildren(children);
		  family1.setHusbandId("@I02@");
		  family1.setWifeId("@I03@");
		  family1.setDivorceDate("NA");
		  assertTrue(US26.CorrespondingEntries(individuals, families, outfile));
		  individual1.setAsChildOfFamily("@F02@");
		  assertFalse(US26.CorrespondingEntries(individuals, families, outfile));
		  individual2.setAsSpouseOfFamily("@F02@");
		  individual1.setAsChildOfFamily("@F01@");
		  assertFalse(US26.CorrespondingEntries(individuals, families, outfile));
		  individual3.setAsSpouseOfFamily("@F02@");
		  individual2.setAsSpouseOfFamily("@F01@");
		  assertFalse(US26.CorrespondingEntries(individuals, families, outfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}
