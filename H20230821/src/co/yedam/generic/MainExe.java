package co.yedam.generic;

public class MainExe {
	public static void main(String[] args) {
		Box<String> box= new Box<String>();
		box.set("Hello");
		String result = box.get();
		
		Box<Integer> ibox = new Box<Integer>();
		ibox.set(10); // 10 (integer)
		Integer iresult = ibox.get();
	}
}
