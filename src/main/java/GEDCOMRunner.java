package main.java;

import java.util.Scanner;

import main.java.common.GEDCOMReader;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 6, 2017 
*
*/
public class GEDCOMRunner {
	
	public static void main(String args[]){
		GEDCOMReader gedcomReader = new GEDCOMReader();
		Scanner scanner=new Scanner(System.in);
		System.out.println("==========GEDCOM Reader==========");
		do{
			System.out.println("\nPlease input the input path(such as \"d:\\GEDCOM.txt\"):");
			String inputPath = scanner.nextLine();
			if (inputPath == null || inputPath.isEmpty()) {
				inputPath = "src\\doc\\My-Family-18-Sep-2017-172.ged";
			}
			
			System.out.println("Please input the output path(such as \"d:\\\"):");
			String outputPath = scanner.nextLine();
			if (outputPath == null || outputPath.isEmpty()) {
//				outputPath = "d:\\Result.txt";
				outputPath = "src\\doc\\Result.txt";
			}else {
				outputPath = outputPath + "Result.txt";
			}
			
			gedcomReader.FileConvertor(inputPath, outputPath);
			
			System.out.println("Would you like to make another calculation(yes/no)?");
		}while(!"no".equals(scanner.nextLine()));
		scanner.close();
	}
}
