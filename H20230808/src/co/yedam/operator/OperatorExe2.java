package co.yedam.operator;

import java.util.Scanner;

//은행 app
public class OperatorExe2 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int balance =0; //10만원 이상 불가, -금액 불가.
		boolean run=true;
		while(run) {
			System.out.println("1.예금 2.출금 3.잔고 4. 종료");
			System.out.println("선택>>");
			
			int menu = Integer.parseInt(scn.nextLine());
			if(menu ==1) {
				System.out.println("입금액 입력 >>");
				int money=Integer.parseInt(scn.nextLine());
				balance+=money;
				if(balance>=100000||money<0) {
					balance-=money;
					System.out.println("입금 불가");
				}
				
			} else if(menu == 2) {
				System.out.println("출금액 입력 >>");
				int money=Integer.parseInt(scn.nextLine());
				balance-=money;
				if(balance<0 || money<0) {
					balance+=money;
					System.out.println("출금 불가");
				}
			} else if(menu==3) {
				System.out.println("잔고는 "+balance+"입니다.");
				
			} else if(menu == 4) {
				break;
			}
		}
		System.out.println("end of prog.");
		
	}
	
}
