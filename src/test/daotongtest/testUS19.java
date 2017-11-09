package test.daotongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.userstories.daotong.US19;

public class testUS19 extends TestCase{

	public void testFirstCousinsShouldNotMarry() {
		ArrayList<Family> families = new ArrayList();
		PrintWriter outFile = null;
		
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			
			Family fa1 = new Family();
			Family fa2 = new Family();
			Family fa3 = new Family();
			Family fa4 = new Family();			
			ArrayList<String> childrenof1 = new ArrayList<String>();
			ArrayList<String> childrenof2 = new ArrayList<String>();
			ArrayList<String> childrenof3 = new ArrayList<String>();
			ArrayList<String> childrenof4 = new ArrayList<String>();
			
			fa1.setFamilyId("F1");
			fa2.setFamilyId("F2");
			fa3.setFamilyId("F3");
			fa4.setFamilyId("F4");
			fa1.setHusbandId("I1");
			fa1.setWifeId("I2");
			fa2.setHusbandId("I3");
			fa2.setWifeId("I4");
			fa3.setHusbandId("I5");
			fa3.setWifeId("I6");
			fa4.setWifeId("I7");
			fa4.setHusbandId("I8");
			childrenof2.add("I1");
			childrenof3.add("I2");
			childrenof4.add("I3");
			childrenof4.add("I5");
			
			fa1.setChildren(childrenof1);
			fa2.setChildren(childrenof2);
			fa3.setChildren(childrenof3);
			fa4.setChildren(childrenof4);
			families.add(fa1);
			families.add(fa2);
			families.add(fa3);
			families.add(fa4);
			
			assertFalse(US19.FirstCousinsShouldNotMarry(families, outFile));
			
			childrenof4.remove("I5");
			assertTrue(US19.FirstCousinsShouldNotMarry(families, outFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
