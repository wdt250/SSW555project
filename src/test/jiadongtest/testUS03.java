package test.jiadongtest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.beans.Individual;

import main.java.userstories.jiadong.US03
/**
* @author Jiadong chen 
*         E-mail:jchen69@stevens.edu
* @date Oct 25 2017 
* 
* @version 
*/
public class birthBeforeDeath {

	@Test
	public void test() {
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		Individual individual1 = new Individual();
		individual1.setBirthDate("1990-05-02");
		individual1.setDeathDate("2000-06-04");
		individuals.add(individual1);
		assertTrue(US03.birthBeforeDeath(individuals));
		Individual individual2 = new Individual();
		individual2.setBirthDate("1990-05-02");
		individual2.setDeathDate("1980-06-04");
		individuals.add(individual2);
		assertFalse(US03.birthBeforeDeath(individuals));
	}

}
