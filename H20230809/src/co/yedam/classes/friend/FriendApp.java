package co.yedam.classes.friend;

import java.sql.Date;
import java.util.Scanner;


public class FriendApp {
	
	Friend[] friends = new Friend[10];
	Scanner sc = new Scanner(System.in);
	
	FriendApp(){
		
	}
	
	void addFriend() {
		System.out.println("이름 연락처 생년월일");
		String[] data = sc.nextLine().split(" ");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date birth=null;
//		try {
//			birth=(Date) sdf.parse(data[2]);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		Friend friend = new Friend(data[0], data[1], data[2]);
		
		for(int i=0; i<friends.length;i++) {
			if(friends[i]==null) {
				friends[i]=friend;
				break;
			}
		}
	}// addFriend
	
	void list () {
		for(int i=0; i<friends.length;i++) {
			if(friends[i]!=null) {
				System.out.println(friends[i].toString());
			}
		}
	}
	void findFriend() {
		System.out.println("이름>> ");
		String name=sc.nextLine();
		for(int i=0; i<friends.length;i++) {
			if(friends[i]!= null) {
				if(friends[i].getName().equals(name)) {
					System.out.println(friends[i].getPhone());
					break;
				}
			}
		}
	}
	void editFriend() {
		System.out.println("이름>> ");
		String name=sc.nextLine();
		System.out.println("연락처>> ");
		String phone=sc.nextLine();
		for(int i=0; i<friends.length;i++) {
			if(friends[i] != null) {
				if(friends[i].getName().equals(name)) {
					friends[i].setPhone(phone);
					break;
				}
			}
		}
	}
	void delFriend() {
		System.out.println("이름>> ");
		String name=sc.nextLine();
		for(int i=0; i<friends.length;i++) {
			if(friends[i]!= null) {
				if(friends[i].getName().equals(name)) {
					friends[i]=null;
					break;
				}
			}
		}
	}
	
	static void start() {
		
		FriendApp app= new FriendApp();
		Scanner sc = app.sc;
		boolean run = true;
		while(run) {
			
			System.out.println("1.등록 2.목록 3.조회(이름) 4.수정 5.삭제 9.종료");
			System.out.println("선택>> ");
			
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case Menu.ADD:
				app.addFriend();
				break;
			case Menu.LIST:
				app.list();
				break;
			case Menu.SEARCH:
				app.findFriend();
				break;
			case Menu.EDIT:
				app.editFriend();
				break;
			case Menu.DEL:
				app.delFriend();
				break;
			case Menu.EXIT:
				System.out.println("종료합니다.");
				run=false;
			} // end of switch 
		} // end of while
	} // end of start
} // end of class
