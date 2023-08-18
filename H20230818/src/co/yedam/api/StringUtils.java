package co.yedam.api;

import java.util.Scanner;

public class StringUtils {
	static String checkGender(String ssn) {
		int year=Integer.parseInt(ssn.substring(0,2));
		int gender;
		if(ssn.length()==13) {
			gender=ssn.charAt(6)-48;
		} else {
			gender=ssn.charAt(7)-48;
		}
		if(year>23) {
			if(gender==1) {
				return "남자";
			} else if(gender==2) {
				return "여자";
			} else {
				return"오류";
			}
		} else {
			if(gender==3) {
				return "남자";
			} else if(gender==4) {
				return "여자";
			} else {
				return"오류";
			}
		}
	}
	
	static String getFileName(String filePath){
		String strs[]=filePath.split("/");
		return strs[strs.length-1];
	}

}
