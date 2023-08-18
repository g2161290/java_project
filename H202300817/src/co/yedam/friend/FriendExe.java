package co.yedam.friend;

public class FriendExe {
	public static void main(String[] args) {
		Friend friends[]=new Friend[5];
		friends[0]=new Friend("홍길동","010-1111");
		friends[1]=new Friend("김길동","010-2222");
		friends[2]=new Friend("최길동","010-3333");
		String name="홍길동";
		String phone="010-9999";
		for(int i=0;i<friends.length;i++) {
			if(friends[i]!=null) {
				friends[i]=new Friend("홍길동","010-1111");
				break;
			}
		}
		for(int i=0;i<friends.length;i++) {
			if(friends[i]!=null&&friends[i].getName().equals(name)) {
				System.out.println(friends[i].showInfo());
				friends[i].setPhone(phone);
			}
		}
	}
}
