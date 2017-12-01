package test.jiadongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.userstories.jiadong.US15;

/**
* @author Jiadong chen 
*         E-mail:jchen69@stevens.edu
* @date Oct 25 2017 
* 
* @version 
*/

public class testUS15 extends TestCase {
	
	public void testFewerThan15Sib(){
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			
			Family family = new Family();
			ArrayList<String> child = new ArrayList<String>();
			child.add("I1");
			child.add("I2");
			child.add("I3");
			child.add("I4");
			child.add("I5");
			child.add("I6");
			child.add("I7");
			child.add("I8");
			child.add("I9");
			child.add("I10");
			child.add("I11");
			child.add("I12");
			child.add("I13");
			child.add("I14");
			child.add("I15");
			family.setChildren(child);
			
			families.add(family);
			assertTrue(US15.fewerThan15Sib(families, outFile));
			
			child.add("I16");
			family.setChildren(child);
			assertFalse(US15.fewerThan15Sib(families, outFile));
			
			families.add(family);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
