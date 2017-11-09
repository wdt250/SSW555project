package main.java.userstories.daotong;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

import main.java.beans.Family;
import main.java.beans.Individual;

public class US14 {

	public static Boolean MultipleBirthsNoMoreThan5(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile){
		
		ArrayList<String> child = new ArrayList<String>();
		ArrayList<String> birthDate = new ArrayList<String>();
		ArrayList<String> DuplicateDate = new ArrayList<String>();
		Boolean flag = true;
		
		for (Iterator<Family> iteratorofFamily = families.iterator(); iteratorofFamily.hasNext();){
			Family fami = iteratorofFamily.next();
			child.clear();
			birthDate.clear();
			DuplicateDate.clear();
			if(fami.getChildren()!= null){
				child= (ArrayList<String>) fami.getChildren().clone();
				
				for (Iterator<String> iteratorofchild = child.iterator(); iteratorofchild.hasNext();	){
					String childIDstr = iteratorofchild.next();
					
					for (Iterator<Individual> iteratorofIndividual = individuals.iterator(); iteratorofIndividual.hasNext();){
						Individual indi = iteratorofIndividual.next();
						if(childIDstr.equals(indi.getIndividualId())){
							birthDate.add(indi.getBirthDate());
							break;
						}
					}
					
				}
				
				DuplicateDate = (ArrayList<String>) birthDate.stream().collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) //get the map of elements with frequency, key is the element, value is the frequency
	            													  .entrySet().stream()                   //Stream all the Stream are correspond to the entry
	            													  .filter(entry -> entry.getValue() > 5) 
	            													  .map(entry -> entry.getKey())          //get the Stream
	            													  .collect(Collectors.toList());         //转化为 List get the List
				if(!DuplicateDate.isEmpty()){
					System.out.println("Error: US14: "+"the family of " + fami.getFamilyId() + " has more than 5 siblings born simutaneously");
					outFile.println("Error: US14: "+"the family of " + fami.getFamilyId() + " has more than 5 siblings born simutaneously");
					flag = false;
				}else if(DuplicateDate.isEmpty()){
//					System.out.println("the family of " + fami.getFamilyId() + " has no more than 5 siblings born simutaneously");
				}
			}
		}
		outFile.flush();
		return flag;
	}
}
