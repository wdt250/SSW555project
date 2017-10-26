package test.yosephtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import main.java.Methods;
import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.US01;

public class testUS01 extends TestCase {
	
	public void testDatesBeforeNow(){
		try {
		  PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("src\\doc\\Result.txt")));
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
	
		  Date check = new Date();
		  String valid = Integer.toString(check.getYear() + 1900) + "-" + Integer.toString(check.getMonth() + 1) + "-" + Integer.toString(check.getDate() - 1);
		  String invalid = Integer.toString(check.getYear() + 1900) + "-" + Integer.toString(check.getMonth() + 1) + "-" + Integer.toString(check.getDate() + 1);
		  individual1.setBirthDate("1970-01-01");
		  individual1.setDeathDate("NA");
		  individual2.setBirthDate(valid);
		  individual2.setDeathDate(valid);
		  family1.setMarriedDate("1997-05-10");
		  family1.setDivorceDate(valid);
		  family2.setMarriedDate(valid);
		  family2.setDivorceDate("NA");
		  assertTrue(US01.DatesBeforeNow(individuals, families, outfile));
		  individual1.setDeathDate(invalid);
		  assertFalse(US01.DatesBeforeNow(individuals, families, outfile));
		  individual1.setDeathDate("NA");
		  family2.setDivorceDate(invalid);
		  assertFalse(US01.DatesBeforeNow(individuals, families, outfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}