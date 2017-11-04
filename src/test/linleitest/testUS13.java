package test.linleitest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.linlei.US13;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 15, 2017 
*
*/
public class testUS13
//{
extends TestCase{
	public void testSiblingSpace() {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		PrintWriter outFile = null;
		
		try {
			outFile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
			Family family1 = new Family();	//single child family
			Family family2 = new Family();	//3 children, birth more than 8 months
			Family family3 = new Family();	//3 children, birth less than 8 months 
			Family family4 = new Family();	//3 children, 1 twins, another more than 8 months, twins less than 2 days
			Family family5 = new Family();	//3 children, 1 twins, another less than 8 months, twins less than 2 days
			Family family6 = new Family();	//3 children, 1 twins, another more than 8 months, twins more than 2 days
			Family family7 = new Family();	//3 children, 1 twins, another less than 8 months, twins more than 2 days
			
			Individual individual1 = new Individual();
			Individual individual2 = new Individual();
			Individual individual3 = new Individual();
			Individual individual4 = new Individual();
			Individual individual5 = new Individual();
			Individual individual6 = new Individual();
			Individual individual7 = new Individual();
			Individual individual8 = new Individual();
			Individual individual9 = new Individual();
			Individual individual10 = new Individual();
			Individual individual11 = new Individual();
			Individual individual12 = new Individual();
			Individual individual13 = new Individual();
			Individual individual14 = new Individual();
			Individual individual15 = new Individual();
			Individual individual16 = new Individual();
			Individual individual17 = new Individual();
			Individual individual18 = new Individual();
			Individual individual19 = new Individual();
	
			ArrayList<String> children1 = new ArrayList<String>();
			ArrayList<String> children2 = new ArrayList<String>();
			ArrayList<String> children3 = new ArrayList<String>();
			ArrayList<String> children4 = new ArrayList<String>();
			ArrayList<String> children5 = new ArrayList<String>();
			ArrayList<String> children6 = new ArrayList<String>();
			ArrayList<String> children7 = new ArrayList<String>();
			
			individual1.setIndividualId("I1");
			individual2.setIndividualId("I2");
			individual3.setIndividualId("I3");
			individual4.setIndividualId("I4");
			individual5.setIndividualId("I5");
			individual6.setIndividualId("I6");
			individual7.setIndividualId("I7");
			individual8.setIndividualId("I8");
			individual9.setIndividualId("I9");
			individual10.setIndividualId("I10");
			individual11.setIndividualId("I11");
			individual12.setIndividualId("I12");
			individual13.setIndividualId("I13");
			individual14.setIndividualId("I14");
			individual15.setIndividualId("I15");
			individual16.setIndividualId("I16");
			individual17.setIndividualId("I17");
			individual18.setIndividualId("I18");
			individual19.setIndividualId("I19");
			
			individual1.setBirthDate("1950-04-04");
			
			individual2.setBirthDate("1950-04-04");
			individual3.setBirthDate("1951-04-04");
			individual4.setBirthDate("1952-04-04");
			
			individual5.setBirthDate("1950-04-04");
			individual6.setBirthDate("1950-05-04");
			individual7.setBirthDate("1950-06-04");
			
			individual8.setBirthDate("1950-04-04");
			individual9.setBirthDate("1950-04-05");
			individual10.setBirthDate("1952-04-04");
			
			individual11.setBirthDate("1950-04-04");
			individual12.setBirthDate("1950-04-05");
			individual13.setBirthDate("1950-09-04");
			
			individual14.setBirthDate("1950-04-04");
			individual15.setBirthDate("1950-04-12");
			individual16.setBirthDate("1952-04-04");
			
			individual17.setBirthDate("1950-04-04");
			individual18.setBirthDate("1950-04-12");
			individual19.setBirthDate("1950-09-04");
			
			children1.add("I1");
			children2.add("I2");
			children2.add("I3");
			children2.add("I4");
			children3.add("I5");
			children3.add("I6");
			children3.add("I7");
			children4.add("I8");
			children4.add("I9");
			children4.add("I10");
			children5.add("I11");
			children5.add("I12");
			children5.add("I13");
			children6.add("I14");
			children6.add("I15");
			children6.add("I16");
			children7.add("I17");
			children7.add("I18");
			children7.add("I19");
			
			family1.setFamilyId("F1");
			family2.setFamilyId("F2");
			family3.setFamilyId("F3");
			family4.setFamilyId("F4");
			family5.setFamilyId("F5");
			family6.setFamilyId("F6");
			family7.setFamilyId("F7");
			
			family1.setChildren(children1);
			family2.setChildren(children2);
			family3.setChildren(children3);
			family4.setChildren(children4);
			family5.setChildren(children5);
			family6.setChildren(children6);
			family7.setChildren(children7);
	
			individuals.add(individual1);
			families.add(family1);
			assertTrue(US13.SiblingSpace(individuals, families, outFile));
			
			individuals.removeAll(individuals);
			families.removeAll(families);
			individuals.add(individual2);
			individuals.add(individual3);
			individuals.add(individual4);
			families.add(family2);
			assertTrue(US13.SiblingSpace(individuals, families, outFile));

			individuals.removeAll(individuals);
			families.removeAll(families);
			individuals.add(individual5);
			individuals.add(individual6);
			individuals.add(individual7);
			families.add(family3);
			assertFalse(US13.SiblingSpace(individuals, families, outFile));
//			System.out.println(US13.SiblingSpace(individuals, families, outFile));
			
			individuals.removeAll(individuals);
			families.removeAll(families);
			individuals.add(individual8);
			individuals.add(individual9);
			individuals.add(individual10);
			families.add(family4);
			assertTrue(US13.SiblingSpace(individuals, families, outFile));
			
			individuals.removeAll(individuals);
			families.removeAll(families);
			individuals.add(individual11);
			individuals.add(individual12);
			individuals.add(individual13);
			families.add(family5);
			assertFalse(US13.SiblingSpace(individuals, families, outFile));
			
			individuals.removeAll(individuals);
			families.removeAll(families);
			individuals.add(individual14);
			individuals.add(individual15);
			individuals.add(individual16);
			families.add(family6);
			assertFalse(US13.SiblingSpace(individuals, families, outFile));
			
			individuals.removeAll(individuals);
			families.removeAll(families);
			individuals.add(individual17);
			individuals.add(individual18);
			individuals.add(individual19);
			families.add(family7);
			assertFalse(US13.SiblingSpace(individuals, families, outFile));
//			System.out.println(US13.SiblingSpace(individuals, families, outFile));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
