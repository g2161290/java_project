package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import co.yedam.friend.Friend;

public class FriendApp {
	Scanner sc = new Scanner(System.in);
	List<Friend> friends = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

	public FriendApp() {
		loadFile();
	}

	public void start() {
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.종료");
			System.out.print("선택>> ");
			int menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				add();
			} else if (menu == 2) {
				list();
			} else if (menu == 3) {
				saveFile();
				System.out.println("종료합니다.");
				run = false;
			}
		}
	}

	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return sc.nextLine();
	}

	private void add() {
		Friend friend = null;
		String name = printString("이름입력");
		String phone = printString("연락처입력");
		Date birthday = null;

		while (true) {
			String birth = printString("생일(yy-MM-dd)입력");
			try {
				birthday = sdf.parse(birth);
				break;
			} catch (ParseException e) {

			}
		}
		friend = new Friend(name, phone, birthday);
		friends.add(friend);
	}

	private void list() {
		for (Friend f : friends) {
			System.out.println(f);
		}
	}

	private void saveFile() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			FileWriter fw = new FileWriter("C:/temp/friendList.txt");
			for (Friend f : friends) {
				String line = f.getName() + " " + f.getPhone() + " " + sdf.format(f.getBirth());
				fw.write(line + "\n");
			}
			fw.write("\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadFile() {
		File file = new File("C:/temp/friendList.txt");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scn = null;
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (true) {
			String line = null;
			try {
				line = scn.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}
			String[] data = line.split(" ");
			Friend newFriend = null;
			try {
				newFriend = new Friend(data[0], data[1], sdf.parse(data[2]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			friends.add(newFriend);
		}

	}

}
