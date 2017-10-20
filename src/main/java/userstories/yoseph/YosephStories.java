package main.java.userstories.yoseph;

import java.util.ArrayList;
import java.util.Date;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.yoseph.Us01;
import main.java.userstories.yoseph.Us02;
import main.java.util.StringUtil;

public class YosephStories {
	public static void check(ArrayList<Individual> individuals, ArrayList<Family> families) {
		Us01.DatesBeforeNow(individuals, families);
		Us02.BirthBeforeMarriage(individuals, families);
	}
}
