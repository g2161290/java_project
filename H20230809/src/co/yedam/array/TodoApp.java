package co.yedam.array;

import java.util.Scanner;

public class TodoApp {
	public static void main(String[] args) {
		// 등록/완료/조회(날짜)/미완료/
		// 등록: 2 할일 0812 (false(done))
		// 완료: 1 2 4 -> (true(done))
		// 조회(날짜): 0812 ->목록(순번 기준으로 정렬)
		// 미완료: 목록 출력
		Scanner sc = new Scanner(System.in);
		Todo todo[]=null;
		boolean run=true;
		while(run) {
			System.out.println("1.등록 | 2.완료 | 3.조회 | 4.미완료 | 5.종료");
			System.out.print("선택> ");
			int menu=Integer.parseInt(sc.nextLine());
			switch(menu) {
				case 1: 
					System.out.print("목록수> ");
					todo=new Todo[Integer.parseInt(sc.nextLine())];
					for(int i=0;i<todo.length;i++) {
						System.out.println("순번과 할일 날짜를 입력하세요.");
						String [] data =sc.nextLine().split(" ");	
						Todo t=new Todo();
						t.no=Integer.parseInt(data[0]);
						t.todo=data[1];
						t.dueDate=data[2];
						t.done=false;
						todo[i]=t;
					}
					break;
				case 2:
					System.out.print("완료한 일> ");
					String [] data =sc.nextLine().split(" ");
					for(int i=0;i<data.length;i++) {
						for(int j=0; j<todo.length;j++) {
							if(Integer.parseInt(data[i])==todo[j].no) {
								todo[j].done=true;
							}
						}
						
					}
					break;
				case 3:
					for(int i=0;i<todo.length-1;i++) {
						for(int j=i+1;j<todo.length;j++) {
							if(todo[i].no>todo[j].no) {
								Todo k=todo[i];
								todo[i]=todo[j];
								todo[j]=k;
							}
						}
					}
					for(int i=0; i<todo.length;i++) {
						System.out.println("할일 : "+todo[i].todo+" 마감일 : "+todo[i].dueDate);
					}
					break;
				case 4:
					for(int i=0;i<todo.length;i++) {
						if(!todo[i].done) {
							System.out.println("할일 : "+todo[i].todo+" 마감일 : "+todo[i].dueDate);
						}
					}
					break;
				case 5:
					System.out.println("종료합니다.");
					break;
			}
		}
	}
	
	public static void sortSample() {
		int[] intAry= {45,23,90,77,12};
		for(int i=0; i<intAry.length-1;i++) {
			for(int j=i+1;j<intAry.length;j++) {
				if(intAry[i]>intAry[j]) {
				int k=intAry[i];
				intAry[i]=intAry[j];
				intAry[j]=k;
			}
			}
			
		}
		for(int i=0; i<intAry.length;i++) {
			System.out.println(intAry[i]);
		}
		
	}
}
