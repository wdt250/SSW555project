package test.daotongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Individual;
import main.java.userstories.daotong.US07;;


public class testUS07 extends TestCase {

	public void testLessThan150YearsOld() {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			
			individual1.setAge(120);
			individual2.setAge(10);
			
			individuals.add(individual1);
			individuals.add(individual2);
			
			assertTrue(US07.LessThan150YearsOld(individuals, outFile));
			
			individual1.setAge(150);
			assertFalse(US07.LessThan150YearsOld(individuals, outFile));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}

}
