package test.daotongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Individual;
import main.java.userstories.daotong.US29;

public class testUS29 extends TestCase {

	public void testListDeceased(){
		
		try {
			ArrayList<Individual> individuals = new ArrayList<Individual>();
			PrintWriter outFile = null;
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual in1 = new Individual();
			Individual in2 = new Individual();
			Individual in3 = new Individual();
			in1.setIndividualId("I1");
			in2.setIndividualId("I2");
			in3.setIndividualId("I3");
			in1.setAlive(true);
			;
			in2.setAlive(false);
			in3.setAlive(true);
			individuals.add(in1);
			individuals.add(in2);
			individuals.add(in3);
			
			try {
				US29.ListDeceased(individuals, outFile);
			} catch (Exception e) {
	            e.printStackTrace();
	            fail("Error: US29: print problem");
			}
			
			in2.setAlive(true);
			try {
				US29.ListDeceased(individuals, outFile);
			} catch (Exception e) {
	            e.printStackTrace();
	            fail("Error: US29: print problem");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
