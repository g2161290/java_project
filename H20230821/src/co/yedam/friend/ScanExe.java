package co.yedam.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ScanExe {
	public static void main(String[] args) {
		File file=new File("src/co/yedam/friend/friends.txt");
		Scanner scn=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		while(scn.hasNext()) {
//			String line = scn.next();
//			System.out.println(line);
//		}
		List<Friend> friends = new ArrayList<>();
		while(true) {
			String line = scn.nextLine();
			if(line.equals("")) {
				break;
			} else {
				String[] data =line.split(" ");
				Date birth=null;
				try {
					birth = sdf.parse(data[2]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Friend friend=new Friend(data[0],data[1],birth);
				friends.add(friend);
				
			}
		}
		for(Friend fnd:friends) {
			System.out.println(fnd.toString());
		}
		System.out.println("end of line");
	}
}
