package co.yedam.array;

import java.util.Scanner;
class Member{
	String name;
	int score;
	
}
public class ScoreApp {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		Member students[] = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1. 학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo==1) {
				System.out.print("학생수> "); 
				int num=Integer.parseInt(scanner.nextLine());
				students=new Member[num];
			} else if(selectNo == 2) {
				for(int i=0; i<students.length;i++) {
					System.out.print("이름과 성적을 입력하세요> ");
					String[] data=scanner.nextLine().split(" ");
					Member m =new Member();
					m.name=data[0];
					m.score=Integer.parseInt(data[1]);
					students[i]=m;
				}
			} else if(selectNo == 3) {
				for(int i=0; i<students.length;i++) {
					System.out.println("이름: "+students[i].name+" 점수: "+students[i].score);
				}
			}else if(selectNo ==4) {
				int max=0;
				double sum=0;
				for(int i=0; i<students.length;i++) {
					if(max<students[i].score) {
						max=students[i].score;
					}
					sum+=students[i].score;
				}
				System.out.println("최고 점수: "+max);
				System.out.println("평균 점수: "+sum/students.length);
			} else if(selectNo==5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료"); 
	}
	
}
