package co.yedam.generic;

public class Member {
	private int memberId;
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	private String memberName;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Member(int memberId, String memberName) {
		this.memberName=memberName;
		this.memberId=memberId;
		
	}
	
	}
