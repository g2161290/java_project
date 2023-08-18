package co.yedam;

public class Friend {
	private String name;
	private String phone;
	private int birth;
	private double height;
	
	public Friend(String name, String phone, int birth, double height) {
		this.name=name;
		this.phone =phone;
		this.birth=birth;
		this.height=height;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
}
