package test.linleitest;

import java.util.ArrayList;

import junit.framework.TestCase;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.linlei.US10;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @date Oct 23, 2017 
* 
* @version 
*/
public class testUS10 {
//	extends TestCase {

	public static void main(String[] args) {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		ArrayList<Family> families = new ArrayList<Family>();
		Individual individual1 = new Individual();
		Individual individual2 = new Individual();
		Individual individual3 = new Individual();
		Individual individual4 = new Individual();
		Family family1 = new Family();
		Family family2 = new Family();
		
		individual1.setIndividualId("I1");
		individual2.setIndividualId("I2");
		individual3.setIndividualId("I3");
		individual4.setIndividualId("I4");
		
		family1.setHusbandId("I1");
		family1.setWifeId("I2");
		family2.setHusbandId("I3");
		family2.setWifeId("I4");
		
		individual1.setBirthDate("1925-06-14");
		individual2.setBirthDate("1928-08-06");
		individual3.setBirthDate("1950-04-04");
		individual4.setBirthDate("1951-03-14");
		
		family1.setMarriedDate("1947-05-09");
		family2.setMarriedDate("1960-10-05");
		
		individuals.add(individual1);
		individuals.add(individual2);
		individuals.add(individual3);
		individuals.add(individual4);
		families.add(family1);
		families.add(family2);
		
		US10.MarriageAfter14(individuals, families);
		
	}

}
