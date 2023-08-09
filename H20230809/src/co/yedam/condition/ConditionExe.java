package co.yedam.condition;

public class ConditionExe {
	public static void main(String[] args) {
		int rcp=(int)(Math.random()*3)+1;
		switch(rcp) {
		case 1:
			System.out.println("가위입니다.");
			break;
		case 2:
			System.out.println("바위입니다.");
			break;
		case 3:
			System.out.println("보입니다.");
			break;
		}
		System.out.println("어떤 혜택을 원하세요?");
		char grade= (char) ((Math.random()*5)+65);
		System.out.println(grade);
		switch(grade) {
		case 65: System.out.println("VVIP 혜택을 받으실 수 있습니다.");
		break;
		case 66: System.out.println("VIP 혜택을 받으실 수 있습니다.");
		break;
		case 67: System.out.println("우수 회원 혜택을 받으실 수 있습니다.");
		break;
		case 68: System.out.println("일반 회원 혜택을 받으실 수 있습니다.");
		break;
		default: System.out.println("혜택이 없습니다.");
		}
		System.out.println("감사합니다.");
	}
}
