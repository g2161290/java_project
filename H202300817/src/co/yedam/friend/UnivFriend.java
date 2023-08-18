package co.yedam.friend;

public class UnivFriend extends Friend{
	private String univ;
	private String major;
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name,phone);
		this.univ=univ;
		this.major=major;
	}
	
	public String getuniv() {
		return univ;
	}
	public void setuniv(String univ) {
		this.univ = univ;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String showInfo() {
		return super.showInfo()+" 학교 "+univ+" 전공 "+major;
	}
}
