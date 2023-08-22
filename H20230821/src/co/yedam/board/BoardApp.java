package co.yedam.board;

import java.util.List;
import java.util.Scanner;

public class BoardApp {

	Scanner sc = new Scanner(System.in);
	BoardService service = new BoardServiceJdbc();
	UserService uservice = new UserServiceImpl();

	public void start() {
		boolean run = true;
		User user=null;
		while (true) {
			String id = printString("id입력");
			String pw = printString("pw입력");
			user = new User(id, pw, null);
			run = uservice.checkLogin(user);
			if (run) {
				System.out.println("환영합니다.");
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
				register(user.getId());
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

	void register(String id) {
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
			System.out.print("조회페이지 입력(exit: 9)>> ");
			page = sc.nextInt();
			if (page == 9) {
				break;
			}

		}
	}

	void modify() {
		String brdNo = printString("번호입력");
		String content = printString("내용입력");
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
		if (service.modify(brd)) {
			System.out.println("수정성공");
		} else {
			System.out.println("수정실패");
		}
	}

	void remove() {
		String brdNo = printString("번호입력");
		if (service.remove(Integer.parseInt(brdNo))) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");
		}
	}

	void search() {
		String brdNo = printString("번호입력");
		Board result = service.search(Integer.parseInt(brdNo));
		if(result==null) {
			System.out.println("해당글번호가 없습니다.");
		}else {
			System.out.println(result.showInfo());
		}
		
	}
}
