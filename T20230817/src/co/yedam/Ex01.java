package co.yedam;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		
		if(num1>num2) {
			System.out.println("큰 수: "+num1);
		} else {
			System.out.println("큰 수: "+num2);
		}
	}
}
