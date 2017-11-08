package test.daotongtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.userstories.daotong.US18;

public class testUS18 extends TestCase{

	public void testSiblingsShouldNotMarry() {
		ArrayList<Family> families = new ArrayList();
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Family fa1 = new Family();
			Family fa2 = new Family();
//			Family fa3 = new Family();
//			ArrayList<String> childrenof1 = new ArrayList<String>();
			ArrayList<String> childrenof2 = new ArrayList<String>();
//			ArrayList<String> childrenof3 = new ArrayList<String>();
			
			childrenof2.add("I1");
			childrenof2.add("I2");
			fa1.setFamilyId("F1");
			fa2.setFamilyId("F2");
			fa1.setHusbandId("I1");
			fa1.setWifeId("I2");
			fa2.setChildren(childrenof2);
			
			families.add(fa1);
			families.add(fa2);
			
			assertFalse(US18.SiblingsShouldNotMarry(families, outFile));
			
			childrenof2.remove("I2");
			assertTrue(US18.SiblingsShouldNotMarry(families, outFile));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
