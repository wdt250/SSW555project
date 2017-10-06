import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.*;
import java.util.Date;
import java.util.Locale;

public class OutputfileFilter {

	static String inputfile = "output.txt";
	static String outputfile;
	
	
	
	
	public static void main(String args[]){
		
		String sCurrent;
		String[] s;
		int iCurrent = -1; //which individual
		int fCurrent = -1; //which family
		boolean bdate = false;
		boolean ddate = false;//these two indicate whether it is birtdate or dead
		boolean madate = false;
		boolean didate = false;//these two indicate whether it is marrieddate or divorce
		String [] date ;//split the birthdate into 3	parts
		String [] date2;//date2 is the 3 parts of deaddate
		
		
		Individual []in = new Individual[12];
		for(int i=0; i<12; i++){
			in[i] = new Individual();
		}//initialize the individual
		
		Family []fa = new Family[5];
		for(int i=0; i<5; i++){
			fa[i] = new Family();
		}//initialize the family
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputfile));
			
			while((sCurrent = br.readLine())!=null){
				s = sCurrent.split("\\|");
				
				if(s[2].equals("Y")){
					switch(s[1]){
					case "INDI":
						iCurrent++;
						in[iCurrent].setId(s[3].replace("@", ""));
						break;
						//rank 0
					case "NAME":
						in[iCurrent].setName(s[3]);
						break;
						//rank 1
					case "SEX":
						in[iCurrent].setGend(s[3]);
						break;
						//rank 1
						//FAMS rank 1
					case "BIRT":
						//rank 1 but the DATE rank 2
						bdate = true;
						break;
						
					case "DEAT":
						//rank 1 but the DATE rank 2
						ddate = true;
						break;
						
					case "FAMS":
						in[iCurrent].setSpouse("{'"+s[3].replace("@", "")+"'}");
						
						break;
						
					case "FAMC":
						in[iCurrent].setChild("{'"+s[3].replace("@", "")+"'}");
						
						break;
					//above is the information collected about individuals
						
					case "FAM":
						fCurrent++;
						fa[fCurrent].setId(s[3].replace("@", ""));
						break;
						
					case "HUSB":
						fa[fCurrent].setHusbandid(s[3].substring(0, s[3].length()-1).replace("@", ""));//I don't know why the original output contains a space at last, resulting to never equals
						for(int i=0; i<in.length; i++){
							if(fa[fCurrent].getHusbandid().equals(in[i].getId())){
								fa[fCurrent].setHusbandname(in[i].getName());
								break;
							}
						}
						break;
						
					case "WIFE":
						fa[fCurrent].setWifeid(s[3].substring(0, s[3].length()-1).replace("@", ""));//same as above reason
						for(int i=0; i<in.length; i++){
							if(fa[fCurrent].getWifeid().equals(in[i].getId())){
								fa[fCurrent].setWifename(in[i].getName());
								break;
							}
						}
						break;
						
					case "MARR":
						madate = true;
						break;
						
					case "DIV":
						didate =true;
						break;
						
					case "CHIL":
						if(fa[fCurrent].getChild()== null){
							
							fa[fCurrent].setChild(s[3].substring(0, s[3].length()-1).replace("@", ""));
						}
						else if(fa[fCurrent].getChild()!= null){
							fa[fCurrent].setChild(fa[fCurrent].getChild()+","+s[3].substring(0, s[3].length()-1).replace("@", ""));
							
						}
						break;
					//above is the information collected about families	
					case "DATE":
						if(bdate){
							in[iCurrent].setBirt(s[3]);
							bdate = false;
						}
						else if(ddate){
							in[iCurrent].setDeat(s[3]);
							ddate = false;
						}//set the rank 2 date 
						else if(madate){
							fa[fCurrent].setMarrieddate(s[3]);
							madate = false;
						}
						else if(didate){
							fa[fCurrent].setDivorcedate(s[3]);
							didate = false;
						}//set the rank 2 date for family
						 
						
						break;
						
					default: 
						break;
						
					}
				}
				
			}
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0; i<in.length;i++){
			if(in[i].getDeat()== null && in[i].getBirt()!= null){
				date = in[i].getBirt().split(" ");
				in[i].setDeat("NA");
				in[i].setAlive(true);
				in[i].setAge(2017-Integer.parseInt(date[2]));// only when the birthday and deadday avaliable count the age
				
				SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy",Locale.US);
				SimpleDateFormat fn = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
				try {
					Date d = f.parse(in[i].getBirt());
					in[i].setBirt(fn.format(d));
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//transfer date
				
			}else if(in[i].getDeat()!= null && in[i].getBirt()!= null) {
				in[i].setAlive(false);
				date = in[i].getBirt().split(" ");
				date2 = in[i].getDeat().split(" ");
				in[i].setAge(Integer.parseInt(date2[2])-Integer.parseInt(date[2]));
				
				SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy",Locale.US);
				SimpleDateFormat fn = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
				try {
					Date d = f.parse(in[i].getBirt());
					in[i].setBirt(fn.format(d));
					Date dd = f.parse(in[i].getDeat());
					in[i].setDeat(fn.format(dd));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}//fixing the individuals' age
		
		for(int i=0; i<in.length; i++){
			if(in[i].getChild()== null){
				in[i].setChild("NA");
			}
			else if(in[i].getSpouse()== null){
				in[i].setSpouse("NA");
			}
		}//fixing individuals' child and spouse'
		
		for(int i=0; i<fa.length; i++){
			if(fa[i].getMarrieddate()==null && fa[i].getDivorcedate()== null){
				fa[i].setMarrieddate("NA");
				fa[i].setDivorcedate("NA");
			}
			else if(fa[i].getMarrieddate()!=null && fa[i].getDivorcedate()== null){
				SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy",Locale.US);
				SimpleDateFormat fn = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
				try {
					Date d = f.parse(fa[i].getMarrieddate());
					fa[i].setMarrieddate(fn.format(d));
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fa[i].setDivorcedate("NA");
			}
			else if(fa[i].getMarrieddate()==null && fa[i].getDivorcedate()!= null){
				SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy",Locale.US);
				SimpleDateFormat fn = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
				try {
					Date d = f.parse(fa[i].getDivorcedate());
					fa[i].setDivorcedate(fn.format(d));
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fa[i].setMarrieddate("NA");
			}
			else if(fa[i].getMarrieddate()!=null && fa[i].getDivorcedate()!= null){
				SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy",Locale.US);
				SimpleDateFormat fn = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
				try {
					Date d = f.parse(fa[i].getMarrieddate());
					fa[i].setMarrieddate(fn.format(d));
					Date dd = f.parse(fa[i].getDivorcedate());
					fa[i].setDivorcedate(fn.format(dd));
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}//fixing families date
		
		/*for(int i=0; i<in.length; i++){
			System.out.println(in[i].toString());
		}
		
		for(int i=0; i<fa.length; i++){
			System.out.println(fa[i].toString());
		}//check*/
		
		System.out.println("Individuals");
		System.out.format("%-6s%-32s%-10s%-16s%-4s%-7s%-16s%-32s%-10s", "ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse");
		for(int i=0; i<in.length; i++){
			System.out.print("\r\n");
			System.out.format("%-6s%-32s%-10s%-16s%-4d%-7b%-16s%-32s%-10s", in[i].getId(), in[i].getName(), in[i].getGend(), in[i].getBirt(), in[i].getAge(), in[i].getAlive(), in[i].getDeat(), in[i].getChild(),in[i].getSpouse());
		}
		//output of Individuals
		
		System.out.print("\r\n");
		System.out.println("Families");
		System.out.format("%-6s%-16s%-16s%-12s%-32s%-12s%-32s%-32s", "ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children");
		for(int i=0; i<fa.length; i++){
			System.out.print("\r\n");
			System.out.format("%-6s%-16s%-16s%-12s%-32s%-12s%-32s%-32s", fa[i].getId(),fa[i].getMarrieddate(),fa[i].getDivorcedate(),fa[i].getHusbandid(),fa[i].getHusbandname(),fa[i].getWifeid(),fa[i].getWifename(),"{'"+fa[i].getChild()+"'}");
			
		}//output of Families
		
	}
}
