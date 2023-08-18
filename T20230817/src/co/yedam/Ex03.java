package co.yedam;

public class Ex03 {
	public static void main(String[] args) {
		int numbers[]=new int[5];
		int max=0;
		int min=10;
		
		for(int i=0;i<5;i++) {
			numbers[i]=(int) ((Math.random()*10)+1);
			if(numbers[i]>max) {
				max=numbers[i];
			}
			if(numbers[i]<min) {
				min=numbers[i];
			}
		}
		for(int i=0;i<5;i++) {
			System.out.println(numbers[i]);
		}
		System.out.println("최소값: "+min+" 최대값: "+max);
		
	}
}
