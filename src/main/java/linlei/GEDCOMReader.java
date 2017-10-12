package linlei;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import beans.Family;
import beans.Individual;
import util.DateUtil;
import util.StringUtil;
/**
 * 
 * @author Linlei Liu 
 *         E-mail:lliu33@stevens.edu
 * @date 2017-10-06
 * modify Daotong's code
 */
public class GEDCOMReader {
	
	static String dateSwitch = "";
	
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
			Individual individual = new Individual();
			Family family = new Family();
			
			String[] individualTags = {"INDI","NAME","SEX","BIRT","DEAT","DATE","FAMS","FAMC"};
    		String[] famalyTags = {"FAM","HUSB","WIFE","MARR","DIV","DATE","CHIL"};
    		
            while ((line = reader.readLine()) != null) {
            	String[] splitResults = sentenceIllegalChecker(line);
            	if (usefulChecker(splitResults)) {
            		if (StringUtil.ifStrInArr(splitResults[1], individualTags)) {
            			individual = individualCombiner(individual, splitResults);
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
            			family = familyCombiner(family, individuals, splitResults);
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
		
		combStrs = new String[]{level,tag};
		
		if (StringUtil.ifStrArrInArr(combStrs, strArray)) {
			returnStrs[0] = level;
			returnStrs[1] = tag;
			returnStrs[2] = value;
		} else {
			System.out.println("Illegal file. Error in levels and tags");
			throw new NoSuchFieldException();
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
	
	public static Individual individualCombiner(Individual individual, String[] strArr) 
			throws Exception {
		
		switch(strArr[1]){
		
			case "INDI":
				individual.setIndividualId(strArr[2]);
				break;
				
			case "NAME":
				individual.setName(strArr[2]);;
				break;
				
			case "SEX":
				individual.setGender(strArr[2]);
				break;
				
			case "BIRT":
				dateSwitch = "birth";
				break;
				
			case "DEAT":
				dateSwitch = "death";
				break;
				
			case "DATE":
				switch (dateSwitch) {
					case "birth":
						individual.setBirthDate(StringUtil.DateFormat(strArr[2]));
						break;
					case "death":
						if ("".equals(strArr[2])) {
							individual.setAlive(true);
							individual.setDeathDate("NA");
							int age = 0;
							try {
								age = DateUtil.getAge(StringUtil.Str2DateFormat(individual.getBirthDate()));
							} catch (Exception e) {
								e.printStackTrace();
							}
							individual.setAge(age);
						}else {
							individual.setAlive(false);
							individual.setDeathDate(StringUtil.DateFormat(strArr[2]));
							int age = 0;
							try {
								age = DateUtil.getAge(StringUtil.Str2DateFormat(individual.getBirthDate()),StringUtil.Str2DateFormat(individual.getDeathDate()));
							} catch (Exception e) {
								e.printStackTrace();
							}
							individual.setAge(age);
						}
						break;
					default:
						break;
				}
				break;
				
			case "FAMS":
				if ("".equals(strArr[2])) {
					individual.setSpouse("NA");
				} else {
					individual.setSpouse(strArr[2]);
				}
				break;
				
			case "FAMC":
				if ("".equals(strArr[2])) {
					individual.setChild("NA");
				} else {
					individual.setChild(strArr[2]);
				}
				break;
				
			default: 
				break;
			
		}
		return individual;
	}
		
	public static Family familyCombiner(Family family, ArrayList<Individual> individuals, String[] strArr) 
			throws NoSuchFieldException {
		
		switch(strArr[1]){
		
			case "FAM":
				family.setFamiliesId(strArr[2]);
				break;
				
			case "HUSB":
				family.setHusbandId(strArr[2]);
				for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
					Individual i = (Individual) iterator.next();
					if (i.getIndividualId() == family.getHusbandId()) {
						family.setHusbandName(i.getName());
					}
				}
				break;
				
			case "WIFE":
				family.setWifeId(strArr[2]);
				for (Iterator<Individual> iterator = individuals.iterator(); iterator.hasNext();) {
					Individual i = (Individual) iterator.next();
					if (i.getIndividualId() == family.getWifeId()) {
						family.setWifeName(i.getName());
					}
				}
				break;
				
			case "MARR":
				dateSwitch = "married";
				break;
				
			case "DIV":
				dateSwitch = "divorce";
				break;
				
			case "CHIL":
				family.getChildren().add(strArr[2]);
				break;
				
			case "DATE":
				switch (dateSwitch) {
					case "married":
						family.setMarriedDate(StringUtil.DateFormat(strArr[2]));
						break;
					case "divorce":
						if ("".equals(strArr[2])) {
							family.setDivorceDate("NA");
						} else {
							family.setDivorceDate(StringUtil.DateFormat(strArr[2]));
						}
						
						break;
					default:
						break;
				}
				break;
				
			default: 
				break;
		}
		return family;
	}
}
