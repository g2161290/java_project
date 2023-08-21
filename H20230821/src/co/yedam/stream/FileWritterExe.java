package co.yedam.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritterExe {
	public static void main(String[] args) {
		try {
		FileWriter fw = new FileWriter("C:/temp/names.txt");
		Scanner scn = new Scanner(System.in);
		System.out.println("start");
		while(true) {
			String line = scn.nextLine();
			if(line.equals("quit")) {
				break;
			}
			fw.write(line+"\n");
		}
		fw.flush();
		fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
