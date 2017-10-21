package main.java.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.userstories.daotong.DaotongStories;
import main.java.userstories.jiadong.JiadongStories;
import main.java.userstories.linlei.LinleiStories;
import main.java.userstories.yoseph.YosephStories;
import main.java.util.DateUtil;
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
		File outputFile = new File(outputPath);
        BufferedReader reader = null;  
        PrintWriter outFile = null;
        
		
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			outFile = new PrintWriter(new BufferedWriter(new FileWriter(outputPath)));
			
			String line = new String();
			
			ArrayList<Individual> individuals = new ArrayList<Individual>();
			ArrayList<Family> families = new ArrayList<Family>();
			Individual individual = new Individual();
			
			Family family = new Family();
			IndividualProcess individualProcess = new IndividualProcess();
			FamilyProcess familyProcess = new FamilyProcess();
			
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
            			
            			individuals.set(individuals.size()-1, individualProcess.individualCombiner(individuals.get(individuals.size()-1), splitResults));
            			
            		}else if(StringUtil.ifStrInArr(splitResults[1], familyTags))	{
            			if("FAM".equals(splitResults[1])){
            				family = new Family();
            				families.add(family);
            			}
            			families.set(families.size()-1, familyProcess.familyCombiner(family, individuals, splitResults));
            		}
            		
            	}
            }
            
            //output file to console
            System.out.println("Individuals");
    		System.out.format("%-6s%-32s%-10s%-16s%-4s%-7s%-16s%-32s%-10s", "ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse","\r\n");
    		for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
    			Individual indi = iterator.next();
    			System.out.format("%-6s%-32s%-10s%-16s%-4d%-7b%-16s%-32s%-10s", 	indi.getIndividualId(),
																					indi.getName(),
																					indi.getGender(),
																					indi.getBirthDate(),
																					indi.getAge(),indi.getAlive(),
																					indi.getDeathDate(),
																					indi.getChild(),
																					indi.getSpouse());
    			System.out.print("\r\n");
    		}
    		
    		System.out.println("Families");
    		System.out.format("%-6s%-16s%-16s%-12s%-32s%-12s%-32s%-32s", "ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children");
    		
    		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
    			Family fa = iterator.next();
    			System.out.format("%-6s%-16s%-16s%-12s%-32s%-12s%-32s%-32s", 	fa.getFamilyId(), 
    																		fa.getMarriedDate(), 
    																		fa.getDivorceDate(), 
    																		fa.getHusbandId(), 
    																		fa.getHusbandName(), 
    																		fa.getWifeId(), 
    																		fa.getWifeName(), 
    																		fa.getChildren());
    			System.out.print("\r\n");
    		}	
    		
    		LinleiStories.check(individuals, families);
    		DaotongStories.check(individuals, families);
    		YosephStories.check(individuals, families);
    		JiadongStories.check(individuals, families);
    		
            //output file into a Result.txt
			outFile.println("Individuals");
			outFile.format("%-6s%-32s%-10s%-16s%-4s%-7s%-16s%-32s%-10s", "ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse");
			outFile.print("\r\n");
			
			for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
    			Individual indi = iterator.next();
    			outFile.format("%-6s%-32s%-10s%-16s%-4d%-7b%-16s%-32s%-10s", 	indi.getIndividualId(),
    																			indi.getName(),
    																			indi.getGender(),
    																			indi.getBirthDate(),
    																			indi.getAge(),indi.getAlive(),
    																			indi.getDeathDate(),
    																			indi.getChild(),
    																			indi.getSpouse());
    			outFile.print("\r\n");
    		}
			
			outFile.println("Families");
			outFile.format("%-6s%-16s%-16s%-12s%-32s%-12s%-32s%-32s", "ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children");
			outFile.print("\r\n");
			
    		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
    			Family fa = iterator.next();
    			outFile.format("%-6s%-16s%-16s%-12s%-32s%-12s%-32s%-32s", 	fa.getFamilyId(), 
    																		fa.getMarriedDate(), 
    																		fa.getDivorceDate(), 
    																		fa.getHusbandId(), 
    																		fa.getHusbandName(), 
    																		fa.getWifeId(), 
    																		fa.getWifeName(), 
    																		fa.getChildren());
    			outFile.print("\r\n");
    		}	
			
    		outFile.flush();
    		
            System.out.println("Finish parse GEDCOM file.");
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
				{"1","SEX"},{"1","BIRT"},{"1","DEAT"},{"1","FAMC"},{"1","FAMS"},{"1","MARR"},{"1","HUSB"},{"1","WIFE"},
				{"1","CHIL"},{"1","DIV"},{"2","DATE"}};
		
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
			level = sliptStrs[0];
			tag = sliptStrs[1];
			value = sliptStrs[2];
			if ("INDI".equals(value) || "FAM".equals(value )) {
				String temp = tag;
				tag = value;
				value = temp;
			}
		} else {
			sliptStrs = line.split(" ",2);
			level = sliptStrs[0];
			tag = sliptStrs[1];
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
	
}
