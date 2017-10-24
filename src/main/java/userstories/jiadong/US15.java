package main.java.userstories.jiadong;

import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;

public class US15 {
	public static boolean fewerThan15Sib(ArrayList<Family> fa) {
		for (Iterator<Family> iterator = fa.iterator(); iterator.hasNext();) {
			Family fam = iterator.next();
			
			if(fam.getChildren().size() > 15) {
				return false;
			}
		}
		
		return true;
	};
}
