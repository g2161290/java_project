package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FriendApp {
	Map<String,String> userList = new HashMap<>();
	List<Friend> friends = new ArrayList<Friend>();
	Scanner sc=new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	//생성자,
	public FriendApp() {
		userList.put("user1", "1234");
		userList.put("user2", "5678");
		userList.put("user3", "9087");
	}
	private boolean userCheck() {
		int i=0;
		while(true) {
			System.out.println("id>> ");
			String id=sc.nextLine();
			System.out.println("pw>> ");
			String pw=sc.nextLine();
			
			if(userList.containsKey(id)&&userList.get(id).equals(pw)) {
				return true;
			} else {
				System.out.println("틀렸습니다.");
				i+=1;
			}
			if(i==5) {
				System.out.println("5번 틀렸습니다."); 
				return false;
			}
		}
		
		
	}
	public void start() {
		boolean run=userCheck();
		int menu = -1;
		while(run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택>> ");
			
			try {
			menu=sc.nextInt();	
			} catch (InputMismatchException e) {
			} finally {
				sc.nextLine();
			}
			
			switch(menu) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				del();
				break;
			case 4:
				list();
				break;
			case 5:
				System.out.println("종료합니다.");
				run=false;
				break;
				default:System.out.println("잘못된 메뉴입니다.");
			}
		}
	}
	private String printString(String msg) {
		System.out.println(msg + ">> ");
		return sc.nextLine();
	}
	private void add() {
		Friend friend=null;
		String name=printString("이름입력");
		String phone=printString("연락처입력");
		Date birthday=null;
		
		while(true) {
			String birth=printString("생일(yyyy-MM-dd)입력");
			try {
				birthday =sdf.parse(birth);
				break;
			} catch (ParseException e) {
				
			}
		}
		friend=new Friend(name, phone, birthday);
		friends.add(friend);
	}
	private void edit() {
		String name=printString("이름입력");
		for(int i=0; i<friends.size();i++) {
			if(friends.get(i).getName().equals(name)) {
				String phone=printString("연락처수정");
				friends.get(i).setPhone(phone);
				break;
			}
			if(i==friends.size()-1) {
				System.out.println("없는 이름입니다.");
			}
		}
	}
	private void del() {
		String name=printString("이름입력");
		for(int i=0; i<friends.size();i++) {
			if(friends.get(i).getName().equals(name)) {
				friends.remove(i);
				break;
			}
			if(i==friends.size()-1) {
				System.out.println("없는 이름입니다.");
			}
		}
	}
	private void list() {
		for(int i=0; i<friends.size();i++) {
			Friend f= friends.get(i);
			System.out.println("이름: "+f.getName()+" 연락처: "+f.getPhone()+" 생일: "+sdf.format(f.getBirth()));
		}
	}
}
