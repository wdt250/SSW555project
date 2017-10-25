package test.daotongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.daotong.US08;

public class testUS08 extends TestCase {

	public void testBirthBeforeMarriageofParents() {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual indi1 = new Individual();
			Individual indi2 = new Individual();
			Family fami1 = new Family();
			
			indi1.setBirthDate("1970-02-01");
			indi2.setBirthDate("1972-03-01");
			indi1.setName("Mary");
			indi2.setName("John");
			indi1.setAsChildOfFamily("F1");
			indi2.setAsChildOfFamily("F1");
			fami1.setFamilyId("F1");
			fami1.setMarriedDate("1970-01-01");
			
			individuals.add(indi1);
			individuals.add(indi2);
			families.add(fami1);
			
			assertTrue(US08.BirthBeforeMarriageofParents(individuals, families, outFile));
			
			fami1.setMarriedDate("1971-01-01");
			assertFalse(US08.BirthBeforeMarriageofParents(individuals, families, outFile));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
