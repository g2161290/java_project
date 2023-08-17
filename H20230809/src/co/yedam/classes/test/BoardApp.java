package co.yedam.classes.test;

import java.util.Scanner;

public class BoardApp {
	static void start() {
		Scanner sc= new Scanner(System.in);
		Board[] boards = new Board[10];
		boolean run = true;
		while(run) {
			System.out.println("1.등록 2.목록 3.상세보기 4.수정 5.삭제 6.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				System.out.println("글번호>> ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("제목>> ");
				String title=sc.nextLine();
				System.out.println("내용>> ");
				String content=sc.nextLine();
				System.out.println("작성자>> ");
				String writer=sc.nextLine();
				for(int i=0; i<boards.length;i++) {
					if(boards[i]==null) {
						Board board=new Board(num,title,writer,content);
						boards[i]=board;
						System.out.println("등록되었습니다.");
						break;
					}
				}
				break;
			case 2:
				System.out.println("글번호 제목 작성자");
				for(int i=0; i<boards.length-1;i++) {
					for(int j=i; j<boards.length;j++) {
						if(boards[i]!=null&&boards[j]!=null) {
							if(boards[i].no>boards[j].no) {
								Board k=boards[i];
								boards[i]=boards[j];
								boards[j]=k;
							}
						}
					}
				}
				int idx=0;
				for(int i=0; i<boards.length;i++) {
					if(boards[i]!=null) {
						idx+=1;
						if(idx==6) {
							System.out.println("       다음>> 1");
							int page = Integer.parseInt(sc.nextLine());
							if(page!=1) {
								break;
							}
						}
						System.out.println(boards[i].no+" "+boards[i].title+" "+boards[i].writer);
					}
					if(i==boards.length-1) {
						System.out.println("1 <<이전");
						int page = Integer.parseInt(sc.nextLine());
						if(page==1) {
							i=0;
							idx=0;
						}
					}
				}
				break;
			case 3:
				System.out.println("글번호>> ");
				num = Integer.parseInt(sc.nextLine());
				for(int i=0; i<boards.length;i++) {
					if(boards[i].no==num) {
						System.out.println("글번호: "+boards[i].no+" 작성자: "+boards[i].writer);
						System.out.println("글제목: "+boards[i].title);
						System.out.println("글내용: "+boards[i].content);
						break;
					}
				}
				break;
			case 4:
				System.out.println("글번호>> ");
				num = Integer.parseInt(sc.nextLine());
				for(int i=0; i<boards.length;i++) {
					if(boards[i].no==num) {
						System.out.println("제목>> ");
						boards[i].title=sc.nextLine();
						System.out.println("글내용>> ");
						boards[i].content=sc.nextLine();
						break;
					}
				}
				break;
			case 5:
				System.out.println("글번호>> ");
				num = Integer.parseInt(sc.nextLine());
				for(int i=0; i<boards.length;i++) {
					if(boards[i].no==num) {
						boards[i]=null;
						System.out.println("글이 삭제되었습니다!!");
						break;
					}
				}
				break;
			case 6:
				System.out.println("종료합니다.");
				run=false;
			}
		}
	}
}
