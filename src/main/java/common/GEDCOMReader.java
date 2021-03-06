package main.java.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.daotong.DaotongStories;
import main.java.userstories.jiadong.JiadongStories;
import main.java.userstories.linlei.LinleiStories;
import main.java.userstories.yoseph.YosephStories;
import main.java.util.StringUtil;
/**
 * 
 * @author Linlei Liu 
 *         E-mail:lliu33@stevens.edu
 * @date 2017-10-06
 * modify Daotong's code
 * @version 1.3
 */
public class GEDCOMReader {
	
	public void FileConvertor(String inputPath, String outputPath) {
		
		File inputFile = new File(inputPath);
        BufferedReader reader = null;  
        PrintWriter outFile = null;
        
		
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			outFile = new PrintWriter(new BufferedWriter(new FileWriter(outputPath)));
			
			String line = new String();
			
			ArrayList<Individual> individuals = new ArrayList<Individual>();
			ArrayList<Family> families = new ArrayList<Family>();
			Individual individual = null;
			Family family = null;
			
			String[] individualTags = {"INDI","NAME","SEX","BIRT","DEAT","DATE","FAMS","FAMC"};
    		String[] familyTags = {"FAM","HUSB","WIFE","MARR","DIV","DATE","CHIL"};
    		
            while ((line = reader.readLine()) != null) {
            	String[] splitResults = sentenceIllegalChecker(line);
            	if(usefulChecker(splitResults)) {
            		if(StringUtil.ifStrInArr(splitResults[1], individualTags) && families.isEmpty()) {
            			if("INDI".equals(splitResults[1])){
            				individual = new Individual();
            				individuals.add(individual);	
            			}
            			individuals.set(individuals.size()-1, IndividualProcess.individualCombiner(individuals.get(individuals.size()-1), splitResults));
            		}else if(StringUtil.ifStrInArr(splitResults[1], familyTags))	{
            			if("FAM".equals(splitResults[1])){
            				family = new Family();
            				families.add(family);
            			}
            			families.set(families.size()-1, FamilyProcess.familyCombiner(family, individuals, splitResults));
            		}
            	}
            }
            
            IndividualProcess.dataIntegrality(individuals);
            FamilyProcess.dataIntegrality(families);
            
            printToConsole(individuals, families);
            printToFile(individuals, families, outFile);
            
            if (!individuals.isEmpty()) {
				if (!families.isEmpty()) {
					LinleiStories.check(individuals, families, outFile);
		    		DaotongStories.check(individuals, families, outFile);
		    		YosephStories.check(individuals, families, outFile);
		    		JiadongStories.check(individuals, families, outFile);
				}else {
					System.out.println("No Family in the file");
					outFile.println("No Family in the file");
					outFile.flush();
				}
			}else {
				System.out.println("No Individual in the file");
				outFile.println("No Individual in the file");
				outFile.flush();
			}
            System.out.println("\r\nFinish parse GEDCOM file.\n");
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (outFile != null) {
                	outFile.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	
	public static String[] sentenceIllegalChecker(String line) throws NoSuchFieldException {
		
		String[] returnStrs = new String[3];
		
		if ("".equals(line)) {
			return returnStrs;
		}
		
		String[][] strArray = {{"0","INDI"},{"0","FAM"},{"0","HEAD"},{"0","TRLR"},{"0","NOTE"},{"1","NAME"},
				{"1","SEX"},{"1","BIRT"},{"1","DEAT"},{"1","FAMC"},{"1","FAMS"},{"1","MARR"},{"1","HUSB"},
				{"1","WIFE"},{"1","CHIL"},{"1","DIV"},{"2","DATE"}};
		
		String[] sliptStrs;
		String[] combStrs;
		String level;
		String tag;
		String value = "";
		
		/**
		 * Line cannot just simplely be splited using split(" ") method instead of split(" ", limit), because
		 * each record line has two type, one is level and tag, the other is level, tag and value.
		 * For the first one, the length is less than 6 and it should be splited into 2 parts.
		 * For the second one, the length is always not less than 6 and it should be splited into 3 parts.
		 * If using split(" "), the value part will be split into pieces, which is not what we want
		 */
		if (line.length() > 6) {
			sliptStrs = line.split(" ",3);
			level = sliptStrs[0].trim();
			tag = sliptStrs[1].trim();
			value = sliptStrs[2].trim();
			if ("INDI".equals(value) || "FAM".equals(value )) {
				String temp = tag;
				tag = value;
				value = temp.replaceAll("@", "");
			}
		} else {
			sliptStrs = line.split(" ",2);
			level = sliptStrs[0].trim();
			tag = sliptStrs[1].trim();
		}
		
		combStrs = new String[]{level,tag};
		
		if(StringUtil.ifStrArrInArr(combStrs, strArray)){
			returnStrs[0] = level;
			returnStrs[1] = tag;
			returnStrs[2] = value;
		}
		return returnStrs;
	}
	
	public static boolean usefulChecker(String[] strArr){
		String[] usefulTags = {"INDI","NAME","SEX","BIRT","DEAT","DATE","FAMS","FAMC","FAM","HUSB","WIFE","MARR","DIV","CHIL"};
		if (StringUtil.ifStrInArr(strArr[1], usefulTags)) {
			return true;
		} else {
			return false;
		}
	} 
	
	public static void printToConsole(ArrayList<Individual> individuals, ArrayList<Family> families) {
		//output file to console
        System.out.println("Individuals");
		System.out.format("%-6s%-20s%-10s%-16s%-7s%-10s%-16s%-16s%-10s", "ID","Name","Gender","Birthday",
				"Age","Alive","Death","Child","Spouse");
		System.out.println();
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual indi = iterator.next();
			System.out.format("%-6s%-20s%-10s%-16s%-7d%-10b%-16s%-16s%-10s", 	indi.getIndividualId(),
																				indi.getName(),
																				indi.getGender(),
																				indi.getBirthDate(),
																				indi.getAge(),indi.getAlive(),
																				indi.getDeathDate(),
																				indi.getAsChildOfFamily(),
																				indi.getAsSpouseOfFamily());
			System.out.print("\r\n");
		}
		
		System.out.println("\r\nFamilies");
		System.out.format("%-6s%-16s%-16s%-12s%-20s%-12s%-20s%-20s", "ID","Married","Divorced","Husband ID",
				"Husband Name","Wife ID","Wife Name","Children");
		System.out.println();
		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family fa = iterator.next();
			System.out.format("%-6s%-16s%-16s%-12s%-20s%-12s%-20s%-20s", 	fa.getFamilyId(), 
    																		fa.getMarriedDate(), 
    																		fa.getDivorceDate(), 
    																		fa.getHusbandId(), 
    																		fa.getHusbandName(), 
    																		fa.getWifeId(), 
    																		fa.getWifeName(), 
    																		fa.getChildren());
			System.out.print("\r\n");
		}	
		System.out.print("\r\n");
	}
	
	public static void printToFile(ArrayList<Individual> individuals, ArrayList<Family> families, PrintWriter outFile) {
		//output file into a Result.txt
		outFile.println("Individuals");
		outFile.format("%-6s%-20s%-10s%-16s%-7s%-10s%-16s%-16s%-10s", "ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse");
		outFile.print("\r\n");
		
		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
			Individual indi = iterator.next();
			outFile.format("%-6s%-20s%-10s%-16s%-7s%-10s%-16s%-16s%-10s", 	indi.getIndividualId(),
																			indi.getName(),
																			indi.getGender(),
																			indi.getBirthDate(),
																			indi.getAge(),indi.getAlive(),
																			indi.getDeathDate(),
																			indi.getAsChildOfFamily(),
																			indi.getAsSpouseOfFamily());
			outFile.print("\r\n");
		}
		outFile.println("\r\nFamilies");
		outFile.format("%-6s%-16s%-16s%-12s%-20s%-12s%-20s%-20s", "ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children");
		outFile.print("\r\n");
		
		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
			Family fa = iterator.next();
			outFile.format("%-6s%-16s%-16s%-12s%-20s%-12s%-20s%-20s", 	fa.getFamilyId(), 
																		fa.getMarriedDate(), 
																		fa.getDivorceDate(), 
																		fa.getHusbandId(), 
																		fa.getHusbandName(), 
																		fa.getWifeId(), 
																		fa.getWifeName(), 
																		fa.getChildren());
			outFile.print("\r\n");
		}	
		outFile.print("\r\n");
		outFile.flush();
	}
	
}
