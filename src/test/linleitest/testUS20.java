package test.linleitest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.linlei.US20;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Nov 6, 2017 
* 
* @version 
*/
public class testUS20 extends TestCase{
		
	public void testAuntsAndUncles() {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Family family1 = new Family();	//grand family
			Family family2 = new Family();	//parents family
			Family family3 = new Family();	//Uncle1 family, normal 
			Family family4 = new Family();	//Uncle2 family, abnormal
			
			family1.setFamilyId("F1");
			family2.setFamilyId("F2");
			family3.setFamilyId("F3");
			family4.setFamilyId("F4");
			
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			Individual individual3 = new Individual();
			Individual individual4 = new Individual();
			Individual individual5 = new Individual();
			Individual individual6 = new Individual();
			Individual individual7 = new Individual();
			Individual individual8 = new Individual();
			Individual individual9 = new Individual();
			
			individual1.setIndividualId("I1");
			individual2.setIndividualId("I2");
			individual3.setIndividualId("I3");
			individual4.setIndividualId("I4");
			individual5.setIndividualId("I5");
			individual6.setIndividualId("I6");
			individual7.setIndividualId("I7");
			individual8.setIndividualId("I8");
			individual9.setIndividualId("I9");

			individual3.setAsChildOfFamily("F1");
			individual5.setAsChildOfFamily("F1");
			individual8.setAsChildOfFamily("F2");
			individual9.setAsChildOfFamily("F2");
			
			individual1.setAsSpouseOfFamily("F1");
			individual2.setAsSpouseOfFamily("F1");
			individual3.setAsSpouseOfFamily("F2");
			individual4.setAsSpouseOfFamily("F2");
			individual5.setAsSpouseOfFamily("F3");
			individual6.setAsSpouseOfFamily("F3");
			
			ArrayList<String> children1 = new ArrayList<String>();
			ArrayList<String> children2 = new ArrayList<String>();
						
			family1.setHusbandId(individual1.getIndividualId());
			family1.setWifeId(individual2.getIndividualId());
			children1.add(individual3.getIndividualId());
			children1.add(individual5.getIndividualId());
			family1.setChildren(children1);
			
			family2.setHusbandId(individual3.getIndividualId());
			family2.setWifeId(individual4.getIndividualId());
			children2.add(individual8.getIndividualId());
			children2.add(individual9.getIndividualId());
			family2.setChildren(children2);
			
			family3.setHusbandId(individual5.getIndividualId());
			family3.setWifeId(individual6.getIndividualId());
			
			individuals.add(individual1);
			individuals.add(individual2);
			individuals.add(individual3);
			individuals.add(individual4);
			individuals.add(individual5);
			individuals.add(individual6);
			individuals.add(individual8);
			individuals.add(individual9);
			families.add(family1);
			families.add(family2);
			families.add(family3);
			
			assertTrue(US20.AuntsAndUncles(individuals, families, outFile));
			
			individual7.setAsSpouseOfFamily("F4");
			individual8.setAsSpouseOfFamily("F4");
			individual7.setAsChildOfFamily("F1");
			family4.setHusbandId(individual7.getIndividualId());
			family4.setWifeId(individual8.getIndividualId());
			children1.add(individual7.getIndividualId());
			individuals.add(individual7);
			families.add(family4);
			assertFalse(US20.AuntsAndUncles(individuals, families, outFile));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
	
}
