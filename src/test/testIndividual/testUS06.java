package test.testIndividual;

import java.util.Date;

import junit.framework.TestCase;
import main.java.Family;
import main.java.Individual;
import main.java.userstrories.linlei.Us06;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 18, 2017 
*
*/
public class testUS06 extends TestCase {
	
	protected Individual[] individuals;
	protected Family[] families;
	protected Date check;

	public testUS06(String s){
		   super(s);   
	   }

	@Override
	protected void setUp() {
		individuals = new Individual[2];
		families = new Family[2];
		check = new Date(0, 0, 1);
	}
	
	public void testDeathBeforeDivorce(){
		   individuals[0] = new Individual();
		   individuals[1] = new Individual();
		   families[0] = new Family();
		   families[1] = new Family();
		   individuals[0].setDeat("1970-08-10");
		   individuals[1].setDeat("2000-10-10");
		   individuals[0].setId("I1");
		   individuals[1].setId("I2");
		   families[0].setHusbandid("I1");
		   families[1].setWifeid("I2");
		   families[1].setHusbandid("I1");
		   families[0].setWifeid("I2");
		   families[0].setDivorcedate("NA");
		   families[1].setDivorcedate("1970-08-09");
		   assertTrue(Us06.DeathBeforeDivorce(individuals, families));
		   families[0].setDivorcedate("1970-08-11");
		   assertFalse(Us06.DeathBeforeDivorce(individuals, families));
		   families[0].setDivorcedate("NA");
	       individuals[1].setDeat("1970-08-08");
	       assertFalse(Us06.DeathBeforeDivorce(individuals, families));
	   }
}
