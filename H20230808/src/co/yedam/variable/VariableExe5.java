package co.yedam.variable;

import java.util.Scanner;

//Scanner 클래스 활용
public class VariableExe5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);// 스캐너(키보드 입력)
		String numStr="123";
		int num=Integer.parseInt(numStr); // "123" ->123 변환
		System.out.println(num);
		int sum=0;
		while(true) {
			System.out.println("정수값을 입력: 종료하려면 quit >>>");
			String result= scan.nextLine();
			System.out.printf("입력값은 %s입니다. \n",result);
			
		if(result.equals("quit")) {
			break;
		}
		int number=Integer.parseInt(result);
		if(number<=100&&number>0) {
			sum+=number;
		}
		
	}
		System.out.println("입력값의 합계는 "+sum);
		System.out.println(" end of prog.");
}
}
