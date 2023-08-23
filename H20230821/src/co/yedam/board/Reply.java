package co.yedam.board;

public class Reply {
	private int rpNo;
	private int brdNo;
	private String rpContent;
	private String rpWriter;
	public Reply(int brdNo, String rpContent, String rpWriter) {
		super();
		this.brdNo = brdNo;
		this.rpContent = rpContent;
		this.rpWriter = rpWriter;
	}
	public int getRpNo() {
		return rpNo;
	}
	public void setRpNo(int rpNo) {
		this.rpNo = rpNo;
	}
	public int getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}
	public String getRpContent() {
		return rpContent;
	}
	public void setRpContent(String rpContent) {
		this.rpContent = rpContent;
	}
	public String getRpWriter() {
		return rpWriter;
	}
	public void setRpWriter(String rpWriter) {
		this.rpWriter = rpWriter;
	}
	public String listInfo() {
		return " "+rpNo+". "+rpContent+" "+rpWriter;
	}
}
