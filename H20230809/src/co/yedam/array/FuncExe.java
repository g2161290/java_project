package co.yedam.array;

public class FuncExe {
	public static void main(String[] args) {
		printStar(5);
		printString(3, "#");
		int n3= sum(5,7);
		System.out.println(n3);
		int[] intAry = {5,7,9,2,6};
		int n4= sum(intAry);
		System.out.println(n4);
		
		getFriend("홍길동","010-4567-2345",Gender.MEN).showInfo();;
	}
	public static void printStar() {
		System.out.println("*");
	}
	public static void printStar(int times) {
		for(int i=0; i<times; i++) {
			System.out.println("*");	
		}
	}
	public static void printString(int times, String str) {
		for(int i=0; i<times; i++) {
			System.out.println(str);	
		}
	}
	public static int sum(int n1, int n2) {
		int result = n1+n2;
		return result;
	}
	public static int sum(int [] arry) {
		int sum=0;
		for(int i=0; i<arry.length; i++) {
			sum+=arry[i];
		}
		return sum;
	}
	
	public static Friend getFriend(String name, String phone, Gender gender) {
		Friend f = new Friend();
		f.name=name;
		f.phone=phone;
		f.gender=gender;
		return f;
		
	}
}
