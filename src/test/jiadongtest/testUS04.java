package test.jiadongtest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.beans.Individual;

import main.java.userstories.jiadong.US04;

/**
* @author Jiadong chen 
*         E-mail:jchen69@stevens.edu
* @date Oct 25 2017 
* 
* @version 
*/

public class marriageBeforeDivorce {

	@Test
	public void test() {
		ArrayList<Family> families = new ArrayList<Family>();
		Family family1 = new Family();
		Family family2 = new Family();
		family1.setDivorceDate("1990-03-04");
		family1.setMarriedDate("1980-05-06");
		families.add(family1);
		assertTrue(US04.marriageBeforeDivorce(families));

		family2.setDivorceDate("1990-03-04");
		family2.setMarriedDate("2000-05-06");
		families.add(family2);
		assertFalse(US04.marriageBeforeDivorce(families));
	}

}
