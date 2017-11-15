package test.linleitest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.linlei.US31;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Nov 14, 2017 
* 
* @version 
*/
public class testUS31 extends TestCase{
	public void testLivingSingle() {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			
			Individual individual1 = new Individual(); //alive & married
			Individual individual2 = new Individual(); //alive & single
			Individual individual3 = new Individual(); //dead & married
			Individual individual4 = new Individual(); //dead & single
			
			individual1.setIndividualId("I1");
			individual1.setName("Michale /Jefferson/");
			individual1.setGender("M");
			individual1.setBirthDate("1913-02-04");
			individual1.setAge(52);
			individual1.setAlive(true);
			individual1.setDeathDate("NA");
			individual1.setAsChildOfFamily("None");
			individual1.setAsSpouseOfFamily("F1");
			
			individual2.setIndividualId("I2");
			individual2.setName("Nami /Rodham/");
			individual2.setGender("F");
			individual2.setBirthDate("2010-05-12");
			individual2.setAge(7);
			individual2.setAlive(true);
			individual2.setDeathDate("NA");
			individual2.setAsChildOfFamily("F5");
			individual2.setAsSpouseOfFamily("NA");

			individual3.setIndividualId("I3");
			individual3.setName("Howard /Jefferson/");
			individual3.setGender("M");
			individual3.setBirthDate("1913-05-31");
			individual3.setAge(52);
			individual3.setAlive(false);
			individual3.setDeathDate("1965-12-05");
			individual3.setAsChildOfFamily("F3");
			individual3.setAsSpouseOfFamily("F6");

			individual4.setIndividualId("I4");
			individual4.setName("Joe /Rodham");
			individual4.setGender("F");
			individual4.setBirthDate("1993-09-04");
			individual4.setAge(14);
			individual4.setAlive(false);
			individual4.setDeathDate("2017-02-20");
			individual4.setAsChildOfFamily("f6");
			individual4.setAsSpouseOfFamily("NA");
			
			individuals.add(individual1);
			individuals.add(individual2);
			individuals.add(individual3);
			individuals.add(individual4);
			
			try {
				US31.LivingSingle(individuals, families, outFile);
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
