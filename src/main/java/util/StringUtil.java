package main.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
* @author Linlei Liu 
*         E-mail:lliu33@stevens.edu
* @version 
* @date Oct 6, 2017 
*
*/
public class StringUtil {
	public static String DateFormat(String string) {
		if (string == null || string.length() == 0) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy",Locale.US);
		Date date = new Date();
		try {
			date = simpleDateFormat.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
		return simpleDateFormat.format(date);
	}
	
	public static Date Str2DateFormat(String string) {
		if (string == null || string.length() == 0) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
		Date date = new Date();
		try {
			date = simpleDateFormat.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static boolean ifStrInArr(String target, String[] arr) {
		if (arr.length == 0 || arr == null) {
			return false;
		}
		for(String s:arr){
			if (s.equals(target)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean ifStrInArr(String target, ArrayList<String> arr) {
		if (arr == null || arr.isEmpty()) {
			return false;
		}
		for(String s:arr){
			if(s == null || s.length() == 0){
				return false;
			}
			if (s.equals(target)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean ifStrArrInArr(String[] target, String[][] arr) {
		if (arr.length == 0 || arr == null) {
			return false;
		}
		for(String[] s:arr){
			if (Arrays.equals(s, target)) {
				return true;
			}
		}
		return false;
	}
	

}
