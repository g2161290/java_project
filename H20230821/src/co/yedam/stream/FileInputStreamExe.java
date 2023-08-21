package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExe {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:/Temp/out.data");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			int val = 0;
			try {
				val = fis.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(val==-1) {
				break;
			}
			System.out.println(val);
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
