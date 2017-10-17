package main.java.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.beans.Family;
import main.java.beans.Individual;
import main.java.util.DateUtil;
import main.java.util.StringUtil;
/**
 * 
 * @author Linlei Liu 
 *         E-mail:lliu33@stevens.edu
 * @date 2017-10-06
 * modify Daotong's code
 */
public class GEDCOMReader {
	
	public void FileConvertor(String inputPath, String outputPath) {
		
		File inputFile = new File(inputPath);
		File outputFile = new File(outputPath);
        BufferedReader reader = null;  
        BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			writer = new BufferedWriter(new FileWriter(outputFile));
			String line = new String();
			
			ArrayList<Individual> individuals = new ArrayList<Individual>();
			ArrayList<Family> families = new ArrayList<Family>();
			Individual individual = null;
			Family family = new Family();
			IndividualProcess individualProcess = new IndividualProcess();
			FamilyProcess familyProcess = new FamilyProcess();
			
			String[] individualTags = {"INDI","NAME","SEX","BIRT","DEAT","DATE","FAMS","FAMC"};
    		String[] famalyTags = {"FAM","HUSB","WIFE","MARR","DIV","DATE","CHIL"};
    		
            while ((line = reader.readLine()) != null) {
            	String[] splitResults = sentenceIllegalChecker(line);
            	if (usefulChecker(splitResults)) {
            		if (StringUtil.ifStrInArr(splitResults[1], individualTags)) {
            			if ("INDI".equals(splitResults[1])) {
							individual = new Individual();
						}
            			individual = individualProcess.individualCombiner(individual, splitResults);
            			continue;
					}
				}else {
					continue;
				}
            }
            individuals.add(individual);
            
            while ((line = reader.readLine()) != null) {
            	String[] splitResults = sentenceIllegalChecker(line);
            	if (usefulChecker(splitResults)) {
            		if (StringUtil.ifStrInArr(splitResults[1], famalyTags)) {
            			family = familyProcess.familyCombiner(family, individuals, splitResults);
            			continue;
					}
				}else {
					continue;
				}
            }
            families.add(family);
            
    		writer.write("Individuals");
			writer.newLine();
			writer.write("ID Name Gender Birthday Age Alive Death Child Spouse");
			writer.newLine();
			for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
    			Individual indi = iterator.next();
    			writer.write(indi.getIndividualId() + " " + indi.getName() + " " + indi.getGender()
    				+ " " + indi.getBirthDate() + " " + indi.getAge() + " " + indi.getAlive()
    				+ " " + indi.getDeathDate() + " " + indi.getChild() + " " + indi.getSpouse());
    			writer.newLine();
    		}
			writer.newLine();
			writer.write("Families");
			writer.write("ID Married Divorced Husband ID Husband Name Wife ID Wife Name Children");
    		for (Iterator<Family> iterator = families.iterator(); iterator.hasNext();) {
    			Family fa = iterator.next();
    			writer.write(fa.getFamiliesId() + " " + fa.getMarriedDate() + " " + fa.getDivorceDate()
    				+ " " + fa.getHusbandId() + " " + fa.getHusbandName() + " " + fa.getWifeId()
    				+ " " + fa.getWifeName() + " {'" + fa.getChildren() + "'}");
    		}	
			
    		writer.flush();
    		
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
                if (writer != null) {
                	writer.close();
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
		
//		combStrs = new String[]{level,tag};
//		
//		if (StringUtil.ifStrArrInArr(combStrs, strArray)) {
//			returnStrs[0] = level;
//			returnStrs[1] = tag;
//			returnStrs[2] = value;
//		} else {
//			System.out.println("Illegal file. Error in levels and tags");
//			throw new NoSuchFieldException();
//		}
		
		returnStrs[0] = level;
		returnStrs[1] = tag;
		returnStrs[2] = value;
		
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
