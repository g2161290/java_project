package co.yedam.friend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FriendApp {
//crud(create, read, update, delete)
	//배열 > 컬랙션 > 파일 > DB
	Friend[] friends = new Friend[10];
	Scanner sc=new Scanner(System.in);
	//컨트롤
	public void start() {
		boolean run=true;
		int menu = -1;
		while(run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("선택>> ");
			
			try {
			menu=sc.nextInt();	
			} catch (InputMismatchException e) {
//				System.out.println("메뉴를 다시 선택하세요");
//				continue;
			} finally {
				sc.nextLine();
			}
			
			switch(menu) {
			case 1:
				addFriend();
				break;
			case 2:
				search();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.println("종료합니다.");
				run=false;
				break;
				default:System.out.println("잘못된 메뉴입니다.");
			}
		}
	}
	//
	private String printString(String msg) {
		System.out.println(msg + ">> ");
		return sc.nextLine();
	}
	//등록
	private void addFriend() {
		int subMenu=-1;
		while(true){
			System.out.println("1.학교 2.회사 3.기타");
			System.out.println("선택>> ");
			try {
				subMenu = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("메뉴를 다시 선택하세요.");
				continue;
			} finally {
				sc.nextLine();
			}
			if(subMenu!=1&&subMenu!=2&&subMenu!=3) {
				System.out.println("메뉴를 다시 선택하세요.");
				continue;
			}
			break;
		}
		Friend friend=null;
			String name=printString("이름입력");
			String phone=printString("연락처입력");
			if(subMenu==1) {
				String univ=printString("학교입력");
				String major=printString("전공입력");
				friend=new UnivFriend(name, phone, univ, major);
			} else if(subMenu==2) {
				String comp=printString("회사입력");
				String dept=printString("부서입력");
				friend=new CompFriend(name, phone, comp, dept);
			} else{
				friend=new Friend(name, phone);
			}
		
		//
		for(int i=0;i<friends.length;i++) {
			if(friends[i]==null) {
				friends[i]=friend;
				break;
			}
		}
	}
	//조회: 이름 -> 조회
	private void search() {
		String name=printString("이름입력");
		if(name!="") {
			for(int i=0;i<friends.length;i++) {
				if(friends[i]!=null&&friends[i].getName().equals(name)) {
					System.out.println(friends[i].showInfo());
					break;
				}
				if(i==friends.length-1) {
					System.out.println("찾는 이름이 없습니다.");
				}
			}
		} else {
			for(int i=0;i<friends.length;i++) {
				if(friends[i]!=null) {
					System.out.println(friends[i].showInfo());
				}
			}
		}
	}
		
	//수정: 연락처수정.
	private void modify() {
		String name=printString("이름입력");
		for(int i=0;i<friends.length;i++) {
			if(friends[i]!=null&&friends[i].getName().equals(name)) {
				String phone=printString("연락처수정");
				friends[i].setPhone(phone);
				break;
			}
			if(i==friends.length-1) {
				System.out.println("찾는 이름이 없습니다.");
			}
		}
	}
	//삭제: 이름
	private void remove() {
		String name=printString("이름입력");
		for(int i=0;i<friends.length;i++) {
			if(friends[i]!=null&&friends[i].getName().equals(name)) {
				friends[i]=null;
				break;
			}
			if(i==friends.length-1) {
				System.out.println("찾는 이름이 없습니다.");
			}
		}

	}
}
