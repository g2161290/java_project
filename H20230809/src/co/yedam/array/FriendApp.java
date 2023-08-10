package co.yedam.array;

import java.util.Scanner;

public class FriendApp {
	static Friend[] friends = new  Friend[10];
	static Scanner sc= new Scanner(System.in);
	static String name;
	static Gender gender;
	public static boolean checkFriend(String name){
		for(int i=0;i<friends.length; i++) {
			if(friends[i]!=null&&friends[i].name.equals(name)) {
				return true;
			}
		}
		return false;
	}
	public static void init() {
		for(int i = 0; i < 5;i++) {
			Friend f = new Friend();
			f.name = "test"+i;
			f.phone = "010-1234-567"+i;
			f.gender = i%2 == 0 ? Gender.MEN:Gender.WOMEN;
			friends[i] = f;
		}
	}
	public static void printMenu() {
		System.out.println("1.추가 2.수정 3.삭제 4.조회 5.목록 6. 종료");
		System.out.println("선택 >> ");
	}
	public static void add() {
		Friend f1 =new Friend();
		System.out.println("이름>> ");
		f1.name=sc.nextLine();
		System.out.println("연락처>> ");
		f1.phone=sc.nextLine();
		System.out.println("성별(1:남자, 2:여자)>> ");
		int choice= Integer.parseInt(sc.nextLine());
		if(choice==1) {
			f1.gender = Gender.MEN;
		} else {
			f1.gender = Gender.WOMEN;
		}
		for(int i=0; i<friends.length;i++) {
			if(friends[i]==null) {
				friends[i]=f1;
				System.out.println("정상적으로 등록되었습니다.");
				break;
			}
			if(i==friends.length-1) {
				System.out.println("목록이 다 등록되어 있습니다.");
			}
		}
	}
	public static void edit() {
		Friend f2 =new Friend();
		System.out.println("이름>> ");
		f2.name=sc.nextLine();
		if(!checkFriend(f2.name)) {
			System.out.println("찾는 이름이 없습니다");
			return; //메소드의 실행 중지
		}
		System.out.println("연락처>> ");
		f2.phone=sc.nextLine();
		for(int i=0; i<friends.length;i++) {
			if(friends[i] != null) {
				if(friends[i].name.equals(f2.name)) {
					friends[i].phone = f2.phone;
					break;
				}
			}
		}
	}
	public static void del() {
		System.out.println("이름>> ");
		String name=sc.nextLine();
		if(!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다");
			return;
		}
		for(int i=0; i<friends.length;i++) {
			if(friends[i]!= null) {
				if(friends[i].name.equals(name)) {
					friends[i]=null;
					break;
				}
			}
			if(i==friends.length-1) {
				System.out.println("찾는 이름이 없습니다");
			}
		}
	}
	public static void search() {
		System.out.println("이름>> ");
		name=sc.nextLine();
		if(!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다");
			return;
		}
		for(int i=0; i<friends.length;i++) {
			if(friends[i] != null) {
				if(friends[i].name.equals(name)) {
					friends[i].showInfo();
					break;
				}
			}
			if(i==friends.length-1) {
				System.out.println("찾는 이름이 없습니다");
			}
		}
	}
	public static void list() {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] !=null) {
				friends[i].briefInfo();
			}
		}
	}
	public static void main(String[] args) {
		// 추가, 수정, 삭제, 조회, 목록
		boolean run=true;
		init();
		while(run) {
			printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				add();
				break;
			case 2 :
				edit();
				break;
			case 3 :
				del();
				break;
			case 4 :
				search();
				break;
			case 5 :
				list();
				break;
			case 6 :
				System.out.println("종료합니다.");
				run=false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
}
