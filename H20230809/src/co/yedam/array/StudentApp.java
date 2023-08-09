package co.yedam.array;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		// 1.등록 2.조회 3.목록
		Student[] students = new Student[10];
		Scanner sc= new Scanner(System.in);
		boolean run=true;
		while(run) {
			System.out.println("1.등록 2.조회 3.목록 4.종료");
			System.out.println("선택>>");
			
			int menu = sc.nextInt();
			int idx=0;
			
			switch(menu) {
			case 1:
				Student s1 =new Student();
				System.out.println("이름을 입력하세요");
				s1.name=sc.nextLine();
				System.out.println("점수를 입력하세요");
				s1.score=sc.nextInt();
				students[idx]=s1;
				idx++;
				break;
			case 2:
				System.out.println("이름을 입력하세요");
				String name2=sc.nextLine();
				for(int i=0; i<10; i++) {
					if(students[i].name.equals(name2)) {
						System.out.println("점수는 "+students[i].score+"입니다.");
					}
				}
				break;
			case 3:
				for(int i=0; i<10; i++) {
					System.out.printf("이름: %s, 점수: %d\n",students[i].name,students[i].score);
				}
				break;
			case 4:
				System.out.println("종료합니다.");
				run=false;
				break;
			}
		}
	}
}
