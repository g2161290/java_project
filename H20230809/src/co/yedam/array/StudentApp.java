package co.yedam.array;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		// 1.등록 2.조회 3.목록
		Student[] students = new Student[10];
		Scanner sc= new Scanner(System.in);
		boolean run=true;
		int idx=0;
		while(run) {
			System.out.println("1.등록 2.조회 3.목록 4.키큰학생 5.종료");
			System.out.println("선택>>");
			
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				Student s1 =new Student();
				System.out.println("이름을 입력하세요");
				s1.name=sc.nextLine();
				System.out.println("점수를 입력하세요");
				s1.score=Integer.parseInt(sc.nextLine());
				System.out.println("키를 입력하세요");
				s1.height=Double.parseDouble(sc.nextLine());
				students[idx]=s1;
				idx++;
				break;
			case 2:
				System.out.println("이름을 입력하세요");
				String name2=sc.nextLine();
				for(int i=0; i<students.length; i++) {
					if(students[i]!= null) {
						if(students[i].name.equals(name2)) {
						System.out.println("점수는 "+students[i].score+", 키는 "+students[i].height+"입니다.");
						} else {
						System.out.println("찾는 이름이 없습니다.");
						}
					}
				}
				break;
			case 3:
				for(int i=0; i<students.length; i++) {
					if(students[i] !=null) {
						System.out.printf("이름: %s, 점수: %d, 키: %f\n",students[i].name,students[i].score, students[i].height);
					}
				}
				break;
			case 4:
				double max=0;
				String maxName="";
				for(int i=0; i<students.length; i++ ) {
					if(students[i] != null && max<students[i].height) {
						max=students[i].height;
						maxName=students[i].name;
					}
				}
				System.out.println("가장 키가 큰 학생은 "+maxName+"입니다.");
				break;
			case 5:
				System.out.println("종료합니다.");
				run=false;
				break;
			}
		}
	}
}
