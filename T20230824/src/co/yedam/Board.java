package co.yedam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private int brdNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;

	public Board() {

	}

	public Board(int brdNo, String title, String content, String writer, Date writeDate) {
		super();
		this.brdNo = brdNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public Board(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String listInfo() {
		return "글번호: " + brdNo + " 제목: " + title + " 작성자: " + writer;
	}

	public String showInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		return "글번호: " + brdNo + " 제목: " + title + "\n내용: " + content + "\n작성자 :" + writer + " 작성일자: "
				+ sdf.format(writeDate);
	}
}
