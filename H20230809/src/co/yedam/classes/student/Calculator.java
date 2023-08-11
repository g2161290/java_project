package co.yedam.classes.student;

public class Calculator {
	double pi = 3.14; //인스턴스 멤버.
	//인스턴스 멤버.
	public double sum (double n1, double n2) {
		return n1 + n2;
	}
	
	public double minus(double n1, double n2) {
		return n1 -n2;
	}
	
	public static double multi(double n1, double n2) {
		return n1* n2;
	}
	public static double divide(double n1, double n2) {
		return n1/n2;
	}
}
