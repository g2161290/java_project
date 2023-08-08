package co.yedam.variable;

public class VariableExe2 {
	public static void main(String[] args) {
		int num1 = 10;
	String str= "홍길동;";
			str="김길동";
	Person hong = new Person();
	hong.name="홍길동";
	hong.age=20;
	hong.weight=67.8;
	
	hong = new Person();
	System.out.println("이름은 " + hong.name+", 나이는 "+hong.age + ", 몸무게는 "+hong.weight);
	
	VariableExe3 exe3 = new VariableExe3();
	exe3.showInfo();
	exe3.helloMsg();
	}

}
