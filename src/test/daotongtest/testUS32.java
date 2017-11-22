package test.daotongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.daotong.US32;

public class testUS32 extends TestCase{

	public void testListMultipleBirths() {
		try {
			ArrayList<Individual> individuals = new ArrayList();
			ArrayList<Family> families = new ArrayList();
			ArrayList<String> children = new ArrayList();
			PrintWriter outFile = null;
			
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual in1 = new Individual();
			Individual in2 = new Individual();
			Individual in3 = new Individual();
			Individual in4 = new Individual();
			Individual in5 = new Individual();
			Individual in6 = new Individual();
			Family fa = new Family();
			
			in1.setIndividualId("I1");
			in2.setIndividualId("I2");
			in3.setIndividualId("I3");
			in4.setIndividualId("I4");
			in5.setIndividualId("I5");
			in6.setIndividualId("I6");
			
			children.add("I3");
			children.add("I4");
			children.add("I5");
			children.add("I6");
			fa.setChildren(children);
			fa.setHusbandId("I1");
			fa.setWifeId("I2");
			fa.setFamilyId("F1");
			
			in3.setBirthDate("1993-08-03");
			in4.setBirthDate("1992-08-03");
			in5.setBirthDate("1991-08-03");
			in6.setBirthDate("1999-08-03");
			
			individuals.add(in1);
			individuals.add(in2);
			individuals.add(in3);
			individuals.add(in4);
			individuals.add(in5);
			individuals.add(in6);
			families.add(fa);
			
			assertFalse(US32.ListMultipleBirths(families, individuals, outFile));
			
			in4.setBirthDate("1993-08-03");
			assertTrue(US32.ListMultipleBirths(families, individuals, outFile));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
