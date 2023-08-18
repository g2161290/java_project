package co.yedam.abstracts;

public class MainExe {
	public static void main(String[] args) {
		//Animal animal=new Animal("");
		Animal animal =new Dog("멍멍이");
		animal.sound();
		
		animal=new Cat("야옹이");
		animal.sound();
	}
}
