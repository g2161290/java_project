package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int n[]= new int [N];
		for(int i=0;i<N;i++) {
			n[i]=0;
		}
		for(int a=0;a<M;a++) {
			int i=sc.nextInt();
			int j=sc.nextInt();
			int k=sc.nextInt();
			for(int b=i-1; b<j;b++) {
				n[b]=k;
			}
		}
		String r="";
		for(int i=0; i<N;i++) {
			r+=n[i]+" ";
		}
		System.out.println(r);
	}
	
}


