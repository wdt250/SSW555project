import junit.framework.*;
import junit.framework.Test;
import java.util.Date;



public class GedTest extends TestCase{
   protected Individual[] in;
   protected Family[] fa;
   protected Date check;
   
   public GedTest(String s){
	   super(s);   
   }

   @Override
   protected void setUp(){
   	  in = new Individual[2];
   	  fa = new Family[2];
   	  check = new Date(0, 0, 1);
   }
   
   public void testFindDate(){
	   Date begin = Methods.findDate("1900-01-01");
      assertEquals(check.getYear(), begin.getYear());
      assertEquals(check.getMonth(), begin.getMonth());
      assertEquals(check.getDate(), begin.getDate());
   }

   public void testDatesBeforeNow(){
	  check = new Date();
	  String valid = Integer.toString(check.getYear() + 1900) + "-" + Integer.toString(check.getMonth() + 1) + "-" + Integer.toString(check.getDate() - 1);
	  String invalid = Integer.toString(check.getYear() + 1900) + "-" + Integer.toString(check.getMonth() + 1) + "-" + Integer.toString(check.getDate() + 1);
	  in[0] = new Individual();
      in[1] = new Individual();
      fa[0] = new Family();
      fa[1] = new Family();
      in[0].setBirt("1970-01-01");
      in[0].setDeat("NA");
      in[1].setBirt(valid);
      in[1].setDeat(valid);
      fa[0].setMarrieddate("1997-05-10");
      fa[0].setDivorcedate(valid);
      fa[1].setMarrieddate(valid);
      fa[1].setDivorcedate("NA");
      assertTrue(Methods.DatesBeforeNow(in, fa));
      in[0].setDeat(invalid);
      assertFalse(Methods.DatesBeforeNow(in, fa));
      in[0].setDeat("NA");
      fa[1].setDivorcedate(invalid);
      assertFalse(Methods.DatesBeforeNow(in, fa));
   }
   
   public void testBirthBeforeMarriage(){
	   in[0] = new Individual();
	   in[1] = new Individual();
	   fa[0] = new Family();
	   fa[1] = new Family();
	   in[0].setBirt("1970-08-09");
	   in[1].setBirt("1900-10-10");
	   in[0].setId("I1");
	   in[1].setId("I2");
	   fa[0].setHusbandid("I1");
	   fa[1].setWifeid("I2");
	   fa[1].setHusbandid("I1");
	   fa[0].setWifeid("I2");
	   fa[0].setMarrieddate("NA");
	   fa[1].setMarrieddate("1970-08-10");
	   assertTrue(Methods.birthBeforeMarriage(in, fa));
	   fa[0].setMarrieddate("1970-08-08");
	   assertFalse(Methods.birthBeforeMarriage(in, fa));
	   fa[0].setMarrieddate("NA");
      in[1].setBirt("1970-09-10");
      assertFalse(Methods.birthBeforeMarriage(in, fa));
   }

   public void testLessthan150years(){
	   Methods.LessThan150YearsOld("My-Family-13-Sep-2017-897.ged");
	   assertEquals(true, Methods.testFor150);
   }
	
   public void testBirthBeforeMarriageofParents(){
	in[1] = new Individual();
	fa[1] = new Family();
   	in[0] = new Individual();
	in[0].setBirt("10 MAY 1900");
	in[0].setChild("@F1@");
	fa[0] = new Family();
	fa[0].setMarrieddate("1 APR 1900");
	fa[0].setId("@F1@");
	Methods.BirthBeforeMarriageofParents(in, fa);
	assertEquals(true, Methods.testForBirthDateBetween);
	fa[0].setMarrieddate("1 APR 1901");
	Methods.BirthBeforeMarriageofParents(in, fa);
	assertEquals(false, Methods.testForBirthDateBetween);
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
	   assertTrue(Methods.DeathBeforeMarriage(in, fa));
	   fa[0].setMarrieddate("1970-08-11");
	   assertFalse(Methods.DeathBeforeMarriage(in, fa));
	   fa[0].setMarrieddate("NA");
       in[1].setDeat("1970-08-08");
       assertFalse(Methods.DeathBeforeMarriage(in, fa));
   }
   
   public void testDeathBeforeDivorce(){
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
	   fa[0].setDivorcedate("NA");
	   fa[1].setDivorcedate("1970-08-09");
	   assertTrue(Methods.DeathBeforeDivorce(in, fa));
	   fa[0].setDivorcedate("1970-08-11");
	   assertFalse(Methods.DeathBeforeDivorce(in, fa));
	   fa[0].setDivorcedate("NA");
       in[1].setDeat("1970-08-08");
       assertFalse(Methods.DeathBeforeDivorce(in, fa));
   }
	   
   public void testBirthBeforeDeath() {
	   in[0] = new Individual();
	   in[0].setBirt("1970-08-09");
	   in[0].setDeat("1960-06-07");
	   assertFalse(Methods.birthBeforeDeath(in));
	   
   }
   
   public void testMarriageBeforeDivorce() {
	   fa[0] = new Family();
	   fa[0].setDivorcedate("1970-08-09");
	   fa[0].setMarrieddate("1960-06-07");
	   assertTrue(Methods.marriageBeforeDivorce(fa));
	   
   }
	
	   
   public static Test Suite(){
   	   TestSuite suite = new TestSuite();
   	   suite.addTest(new GedTest("testFindDate"));
   	   suite.addTest(new GedTest("testDatesBeforeNow"));
   	   suite.addTest(new GedTest("testBirthBeforeMarriage"));
	   suite.addTest(new GedTest("testLessthan150years"));
	   suite.addTest(new GedTest("testBirthBeforeMarriageofParents"));
	   suite.addTest(new GedTest("testDeathBeforeDivorce"));
	   suite.addTest(new GedTest("testDeathBeforeMarriage"));
	   suite.addTest(new GedTest("testBirthBeforeDeath"));
	   suite.addTest(new GedTest("testMarriageBeforeDivorce"));
   	   return suite;
   }
}
