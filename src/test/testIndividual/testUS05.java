package test.testIndividual;

import junit.framework.TestCase;
import main.java.Family;
import main.java.Individual;
import main.java.userstrories.linlei.Us05;

import java.util.Date;
/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 18, 2017 
*
*/
public class testUS05 extends TestCase {
	
	protected Individual[] in;
	protected Family[] fa;
	protected Date check;

	public testUS05(String s){
		   super(s);   
	   }

	@Override
	protected void setUp() {
		in = new Individual[2];
		fa = new Family[2];
		check = new Date(0, 0, 1);
	}
	   
	public void testDeathBeforeMarriage(){
		   in[0] = new Individual();
		   in[1] = new Individual();
		   fa[0] = new Family();
		   fa[1] = new Family();
		   in[0].setDeat("1970-08-10");
		   in[1].setDeat("2000-10-10");
		   in[0].setId("I1");
		   in[1].setId("I2");
		   fa[0].setHusbandid("I1");
		   fa[1].setWifeid("I2");
		   fa[1].setHusbandid("I1");
		   fa[0].setWifeid("I2");
		   fa[0].setMarrieddate("NA");
		   fa[1].setMarrieddate("1970-08-09");
		   assertTrue(Us05.DeathBeforeMarriage(in, fa));
		   fa[0].setMarrieddate("1970-08-11");
		   assertFalse(Us05.DeathBeforeMarriage(in, fa));
		   fa[0].setMarrieddate("NA");
	       in[1].setDeat("1970-08-08");
	       assertFalse(Us05.DeathBeforeMarriage(in, fa));
	   }
}
