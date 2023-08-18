package co.yedam.api;

import java.util.Scanner;

public class StringExe2 {
	public static void main(String[] args) {
		String file = "C:Dev/temp/flower.jpg";
		StringUtils.getFileName(file);
		System.out.println(StringUtils.getFileName(file));
		String scn="350514 7234567";
		StringUtils.checkGender(scn);
		System.out.println(StringUtils.checkGender(scn));
	}
}
