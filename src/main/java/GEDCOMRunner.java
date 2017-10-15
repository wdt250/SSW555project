import java.util.Scanner;

import linlei.GEDCOMReader;

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
		
		System.out.println("Please input the le path(such as \"d:\\GEDCOM.txt\"):");
		Scanner scanner=new Scanner(System.in);
		String inputPath = scanner.next();
		
		System.out.println("Please input the output path(such as \"d:\\\"):");
		String outputPath = scanner.next() + "Result.txt";
		
		gedcomReader.FileConvertor(inputPath, outputPath);
		
	}
}
