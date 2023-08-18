package co.yedam;

import java.util.Scanner;

public class Ex05 {
	
	static Scanner sc=new Scanner(System.in); 
	static Friend friends[]=new Friend[10];
	
	public static void main(String[] args) {
		boolean run=true;
		while(run) {
			System.out.println("1.등록 2.목록 3.전화번호수정 4.삭제 5.종료");
			System.out.println("선택>> ");
			int menu=sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				register();
				break;
			case 2:
				list();
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
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}
		
	}
	
	private static void register() {
		System.out.println("친구이름>> ");
		String name=sc.nextLine();
		System.out.println("전화번호>> ");
		String phone=sc.nextLine();
		System.out.println("생년월일>> ");
		int birth=sc.nextInt();
		System.out.println("키>> ");
		double height=sc.nextDouble();
		Friend friend=new Friend(name, phone, birth, height);
		for(int i=0; i<friends.length; i++) {
			if(friends[i]==null) {
				friends[i]=friend;
				System.out.println("등록되었습니다.");
				break;
			}
			if(i==friends.length-1) {
				System.out.println("목록이 다 찼습니다.");
			}
		}
	}
	
	private static void list() {
		for(int i=0; i<friends.length;i++) {
			if(friends[i]!=null) {
				System.out.println("친구이름: "+friends[i].getName()+" 전화번호: "+friends[i].getPhone()+" 생년월일: "+friends[i].getBirth()+" 키: "+friends[i].getHeight());
			}
		}
	}
	
	private static void modify() {
		System.out.println("친구이름>> ");
		String name=sc.nextLine();
		for(int i=0; i<friends.length;i++) {
			if(friends[i]!=null&&friends[i].getName().equals(name)) {
				System.out.println("전화번호>> ");
				String phone=sc.nextLine();
				friends[i].setPhone(phone);
				System.out.println("수정되었습니다.");
				break;
			}
			if(i==friends.length-1) {
				System.out.println("없는 이름입니다.");
			}
		}
	}
	
	private static void remove() {
		System.out.println("친구이름>> ");
		String name=sc.nextLine();
		for(int i=0; i<friends.length;i++) {
			if(friends[i]!=null&&friends[i].getName().equals(name)) {
				friends[i]=null;
				System.out.println("삭제되었습니다.");
				break;
			}
			if(i==friends.length-1) {
				System.out.println("없는 이름입니다.");
			}
		}
	}
	
}
