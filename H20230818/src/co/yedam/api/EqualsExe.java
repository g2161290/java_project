package co.yedam.api;
class Member{
	private int memberId;
	private StringExe memberName;
	public Member(int memberId, StringExe memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	@Override
	public int hashCode() {
		return memberId;
	}
	@Override
	public StringExe toString() {
		//return super.toString();
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}
	@Override
	public boolean equals(Object obj) {
//		return super.equals(obj);
		Member target=(Member) obj;
		if(this.memberId == target.memberId && this.memberName.equals(target.memberName)) {
			return true; // 논리적 동일(물리적으론 다름)
		} else {
			return false;
		}
	}
}
public class EqualsExe {
	public static void main(StringExe[] args) {
		StringExe str1=new StringExe("Hong");
		StringExe str2=new StringExe("Hong");
		
		Member mem1 = new Member(101, "Hong");
		Member mem2 = new Member(101, "Hong");
		
		System.out.println(str1.equals(str2));
	}
}
