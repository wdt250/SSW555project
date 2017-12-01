package test.jiadongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.userstories.jiadong.US24;

public class testUS24 extends TestCase {
	public void testUniqueFamiliesBySpouses() {
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			
			Family family1 = new Family();
			family1.setFamilyId("F1");
			family1.setHusbandName("James");
			family1.setWifeName("Lily");
			family1.setMarriedDate("2000-01-01");
			families.add(family1);
			
			Family family2 = new Family();
			family2.setFamilyId("F2");
			family2.setHusbandName("Jameswen");
			family2.setWifeName("Lilycat");
			family2.setMarriedDate("2000-01-01");
			families.add(family2);
			
			assertTrue(US24.uniqueFamiliesBySpouses(families, outFile));
			
			Family family3 = new Family();
			family3.setFamilyId("F3");
			family3.setHusbandName("James");			
			family3.setWifeName("Lily");		
			family3.setMarriedDate("2000-01-01");
			families.add(family3);
			
			assertFalse(US24.uniqueFamiliesBySpouses(families, outFile));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
