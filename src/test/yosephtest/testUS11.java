package test.yosephtest;

import java.util.ArrayList;
import junit.framework.TestCase;

import main.java.beans.Family;
import main.java.userstories.yoseph.US11;

public class testUS11 extends TestCase{
	public void testNoBigamy(){
      Family family1 = new Family();
	  Family family2 = new Family();
	  ArrayList<Family> families = new ArrayList<Family>();
	  families.add(family1);
	  families.add(family2);
	  family1.setFamilyId("@F01@");
	  family1.setWifeId("@I02@");
	  family1.setHusbandId("@I01@");
	  family2.setFamilyId("@F02@");
	  family2.setWifeId("@I03");
	  family2.setHusbandId("@I01@");

	  family1.setMarriedDate("1997-05-10");
	  family1.setDivorceDate("2010-10-11");
	  family2.setMarriedDate("2011-10-11");
	  family2.setDivorceDate("NA");
	  assertTrue(US11.NoBigamy(families));
	  family2.setMarriedDate("2000-01-12");
	  assertFalse(US11.NoBigamy(families));
	  family1.setDivorceDate("NA");
	  assertFalse(US11.NoBigamy(families));
	}
}
