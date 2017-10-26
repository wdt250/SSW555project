package test.jiadongtest;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Test;


import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.userstories.jiadong.US04;

/**
* @author Jiadong chen 
*         E-mail:jchen69@stevens.edu
* @date Oct 25 2017 
* 
* @version 
*/

public class testUS04 extends TestCase {
	
	public void testmarriageBeforeDivorce(){
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Family family1 = new Family();
			Family family2 = new Family();
			family1.setDivorceDate("1990-03-04");
			family1.setMarriedDate("1980-05-06");
			families.add(family1);
			assertTrue(US04.marriageBeforeDivorce(families, outFile));

			family2.setDivorceDate("1990-03-04");
			family2.setMarriedDate("2000-05-06");
			families.add(family2);
			assertFalse(US04.marriageBeforeDivorce(families, outFile));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
