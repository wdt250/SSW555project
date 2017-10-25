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
import main.java.userstories.daotong.US14;

public class testUS14 extends TestCase{

	public void testMultipleBirthsNoMoreThan5() {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual indi1 = new Individual();
			Individual indi2 = new Individual();
			Individual indi3 = new Individual();
			Individual indi4 = new Individual();
			Individual indi5 = new Individual();
			Family fami1 = new Family();
			ArrayList<String> Children = new ArrayList();
			
			indi1.setIndividualId("I1");
			indi2.setIndividualId("I2");
			indi3.setIndividualId("I3");
			indi4.setIndividualId("I4");
			indi5.setIndividualId("I5");
			indi1.setBirthDate("1970-01-01");
			indi2.setBirthDate("1970-01-01");
			indi3.setBirthDate("1970-01-01");
			indi4.setBirthDate("1970-01-01");
			indi5.setBirthDate("1971-01-01");
			Children.add("I1");
			Children.add("I2");
			Children.add("I3");
			Children.add("I4");
			Children.add("I5");
			
			fami1.setChilden(Children);
			individuals.add(indi1);
			individuals.add(indi2);
			individuals.add(indi3);
			individuals.add(indi4);
			individuals.add(indi5);
			families.add(fami1);
			
			assertTrue(US14.MultipleBirthsNoMoreThan5(individuals, families, outFile));
			
			indi5.setBirthDate("1970-01-01");
			assertFalse(US14.MultipleBirthsNoMoreThan5(individuals, families, outFile));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
