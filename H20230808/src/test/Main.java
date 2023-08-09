package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int N[]=new int [n];
		for(int i=0; i<n;i++) {
			N[i]=i+1;
		}
		for(int a=0; a<m;a++) {
			int i=sc.nextInt();
			int j=sc.nextInt();
			int b=i;
			int c=j;
			for(b=i;b<=j;b++) {
				int I=N[b-1];
				N[c-1]=I;	
				c--;
				}
				
			}
		String result="";
		for(int i=0; i<n; i++) {
			result+=N[i]+" ";
		}
		System.out.println(result);
	}
		
}
	



