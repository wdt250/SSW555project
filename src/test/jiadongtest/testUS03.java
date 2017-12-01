package test.jiadongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Individual;
import main.java.userstories.jiadong.US03;
/**
* @author Jiadong chen 
*         E-mail:jchen69@stevens.edu
* @date Oct 25 2017 
* 
* @version 
*/

public class testUS03 extends TestCase {
	
	public void testBirthBeforeDeath(){
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Individual individual1 = new Individual();
			individual1.setBirthDate("1990-05-02");
			individual1.setDeathDate("2000-06-04");
			individuals.add(individual1);
			assertTrue(US03.birthBeforeDeath(individuals, outFile));
			Individual individual2 = new Individual();
			individual2.setBirthDate("1990-05-02");
			individual2.setDeathDate("1980-06-04");
			individuals.add(individual2);
			assertFalse(US03.birthBeforeDeath(individuals, outFile));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
