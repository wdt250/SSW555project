package test.yosephtest;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import main.java.Methods;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.US02;
/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 18, 2017 
*
*/
public class testUS02 extends TestCase {
	
	public void testDatesBeforeNow(){
		  Individual individual1 = new Individual();
		  Individual individual2 = new Individual();
		  Family family1 = new Family();
		  Family family2 = new Family();
		  ArrayList<Individual> individuals = new ArrayList<Individual>();
		  ArrayList<Family> families = new ArrayList<Family>();
		  individuals.add(individual1);
		  individuals.add(individual2);
		  families.add(family1);
		  families.add(family2);

		  individual1.setBirthDate("1970-08-09");
		  individual2.setBirthDate("1900-10-10");
		  individual1.setIndividualId("I1");
		  individual2.setIndividualId("I2");
		  family1.setHusbandId("I1");
		  family2.setWifeId("I2");
		  family2.setHusbandId("I1");
		  family1.setWifeId("I2");
		  family1.setMarriedDate("NA");
		  family2.setMarriedDate("1970-08-10");
		  assertTrue(US02.BirthBeforeMarriage(individuals, families));
		  family1.setMarriedDate("1970-08-08");
		  assertFalse(US02.BirthBeforeMarriage(individuals, families));
		  family1.setMarriedDate("NA");
		  individual2.setBirthDate("1970-09-10");
		  assertFalse(US02.BirthBeforeMarriage(individuals, families));
   }
}