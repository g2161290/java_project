package co.yedam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BoardApp {
	Scanner sc = new Scanner(System.in);
	List<Board> boardList = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

	public BoardApp() {
		loadFile();
	}

	public void start() {
		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.수정 3.조회 4.삭제 5.목록 9.종료");
			System.out.print("선택>> ");
			int menu = 0;
			try {
				menu = sc.nextInt();
			} catch (InputMismatchException e) {
			} finally {
				sc.nextLine();
			}
			switch (menu) {
			case 1:
				register();
				break;
			case 2:
				modify();
				break;
			case 3:
				search();
				break;
			case 4:
				remove();
				break;
			case 5:
				list();
				break;
			case 9:
				saveFile();
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		sc.close();
	}

	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return sc.nextLine();
	}

	void register() {
		String title = printString("제목");
		String content = printString("내용");
		String writer = printString("작성자");
		Board board = new Board(title, content, writer);
		int brdNo = 0;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() > brdNo) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		board.setBrdNo(brdNo + 1);
		board.setWriteDate(new Date());
		boardList.add(board);
	}

	void modify() {
		int brdNo = checkInt();
		String content = printString("내용");
		boardList.get(brdNo).setContent(content);
		System.out.println("수정완료");
	}

	void search() {
		int brdNo = checkInt();
		System.out.println(boardList.get(brdNo).showInfo());
	}

	void remove() {
		int brdNo = checkInt();
		boardList.remove(brdNo);
	}

	void list() {
		int page = 1;
		while (true) {
			try {
				for (int i = (page - 1) * 5; i < page * 5; i++) {
					if (boardList.get(i) != null) {
						System.out.println(boardList.get(i).listInfo());
					}
				}
			} catch (IndexOutOfBoundsException e) {
			}
			int lastPage = (int) Math.ceil(boardList.size() / 5.0);
			for (int i = 1; i <= lastPage; i++) {
				if (page == i) {
					System.out.printf(" [" + i + "] ");
				} else {
					System.out.printf("  " + i + "  ");
				}
			}
			System.out.println();
			System.out.print("조회페이지 입력(exit: 0)>> ");
			try {
				page = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				continue;
			}
			if (page == 0) {
				break;
			}
		}
	}

	private void loadFile() {
		try {
			FileReader fr = new FileReader("c:/temp/boardList.dat");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}

				String[] data = line.split(" ");
				boardList.add(new Board(Integer.parseInt(data[0]), data[1], data[2], data[3], sdf.parse(data[4])));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}

	private void saveFile() {

		try {
			FileWriter fw = new FileWriter("c:/temp/boardList.dat");
			for (Board b : boardList) {
				String line = b.getBrdNo() + " " + b.getTitle() + " " + b.getContent() + " " + b.getWriter() + " "
						+ sdf.format(b.getWriteDate());
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int checkInt() {
		while (true) {
			String no = printString("글번호");
			try {
				int brdNo = Integer.parseInt(no);
				for (int i = 0; i < boardList.size(); i++) {
					if (boardList.get(i).getBrdNo() == brdNo) {
						return i;
					}
					if (i == boardList.size() - 1) {
						System.out.println("없는 번호입니다.");
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}
		}
	}
}
