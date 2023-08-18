package co.yedam;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		
		int bnum, snum;
		
		if(num1>num2) {
			bnum=num1;
			snum=num2;
		} else {
			bnum=num2;
			snum=num1;
		}
		
		int sum2=0;
		int sum3=0;
		
		for(int i=snum; i<=bnum;i++) {
			if(i%2==0) {
				sum2+=i;
			}
			if(i%3==0) {
				sum3+=i;
			}
		}
		
		System.out.println("sum2: "+sum2+" sum3: "+sum3);
	}
	
}
