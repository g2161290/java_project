package co.yedam.board;

import java.util.List;
import java.util.Scanner;

public class BoardApp {

	Scanner sc = new Scanner(System.in);
	BoardService service = new BoardServiceJdbc();
	UserService uservice = new UserServiceJdbc();
	ReplyService rservice = new ReplyServiceImpl();
	String id;

	public void start() {
		boolean run = true;
		User user=null;
		while (true) {
			id = printString("id입력");
			String pw = printString("pw입력");
			user = new User(id, pw, null);
			user=uservice.checkLogin(user);
			if (user!=null) {
				System.out.println(user.getName()+", 환영합니다.");
				break;
			}
			System.out.println("로그인 실패");
		}

		while (run) {
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.print("선택>> ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				register();
				break;
			case 2:
				boardList();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				search();
				break;
			case 9:
				System.out.println("종료합니다.");
				service.save();
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		System.out.println("end of prog");
	}

	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return sc.nextLine();
	}

	void register() {
		String title = printString("제목입력");
		String content = printString("내용입력");
		Board board = new Board(title, content, id);

		if (service.add(board)) {
			System.out.println("등록성공");
		} else {
			System.out.println("등록실패");
		}
	}

	void boardList() {
		int page = 1;

		while (true) {
			List<Board> list = service.list(page);
			for (Board b : list) {
				System.out.println(b.listInfo());
			}
			int totalCnt = (int) Math.ceil(service.getTotal() / 5.0);
			for (int i = 1; i <= totalCnt; i++) {
				if (i == page) {
					System.out.printf(" [" + i + "]");
				} else {
					System.out.printf("  " + i + " ");

				}
			}
			System.out.println();
			System.out.print("조회페이지 입력(exit: -1)>> ");
			page = sc.nextInt();
			if (page == -1) {
				break;
			}

		}
	}

	void modify() {
		while(true) {
			Board brd = new Board();
			int brdNo = Integer.parseInt(printString("번호입력"));
			
			if(!service.getResponseUser(brdNo).equals(id)) {
				System.out.println("권한 없음");
				break;
			}
			String content = printString("내용입력");
			brd.setBrdNo(brdNo);
			brd.setBrdContent(content);
			if (service.modify(brd)) {
				System.out.println("수정성공");
				break;
			} else {
				System.out.println("수정실패");
				break;
			}
			
		}
	}

	void remove() {
		while(true) {
			int brdNo = Integer.parseInt(printString("번호입력"));
			if(!service.getResponseUser(brdNo).equals(id)) {
				System.out.println("권한 없음");
				break;
			}
			if (service.remove(brdNo)) {
				System.out.println("삭제성공");
				break;
			} else {
				System.out.println("삭제실패");
				break;
			}
		}
	}

	void search() {
		int brdNo =Integer.parseInt(printString("번호입력"));
		Board result = service.search(brdNo);
		if(result==null) {
			System.out.println("해당글번호가 없습니다.");
			return;
		}else {
			System.out.println(result.showInfo());
			ReplyApp rapp = new ReplyApp(brdNo);
			rapp.start();
		}
		
		
	}
	class ReplyApp{
		private ReplyService rservice = new ReplyServiceImpl();
		private int brdNo;
		Board result = service.search(brdNo);
		ReplyApp(int brdNo){
			this.brdNo=brdNo;
		}
		void start() {
			List<Reply> rlist= rservice.list(brdNo);
			if(rlist!=null) {
				for(Reply r: rlist) {
					System.out.println(r.listInfo()); 
				}
			}
			boolean run=true;
			while(run) {
				System.out.println("1.댓글등록 2.댓글삭제 3.댓글목록 9.이전메뉴");
				int No =Integer.parseInt(printString("선택")) ;
				switch(No) {
				case 1:
					add();
					break;
				case 2:
					remove();
					break;
				case 3:
					
					break;
				case 9:
					rservice.save();
					run=false;
					break;
				}
			}
		}
		void add() {
			String comment = printString("댓글입력");
			Reply reply = new Reply(brdNo, comment, id);
			if (rservice.add(reply)) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}
		}
		void remove() {
			int rpNo = Integer.parseInt(printString("번호입력"));
			if (rservice.remove(brdNo, rpNo)) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}
		}
		void list() {
			System.out.println(result.showInfo());
			List<Reply> rplist= rservice.list(brdNo);
			for(Reply r: rplist) {
				System.out.println(r.listInfo()); 
			}
		}
	}
}
