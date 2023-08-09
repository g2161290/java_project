package co.yedam.array;

public class ArrayExe2 {
	public static void main(String[] args) {
		
		int num1, num2, num3;
		num1=56;
		num2=72;
		num3=67;
		int max=0;
		if(num1>num2) {
			max=num1;
		} else {
			max=num2;
		}
		if(max<num3) {
			max=num3;
		}
		System.out.println(max);
		max=0;
		int[] intAry= {num1, num2, num3};
		for(int i=0; i<intAry.length;i++) {
			if(max<intAry[i]) {
				max=intAry[i];
			}
		}
		System.out.println(max);
		
		int ary[]=new int[5];
		int sum=0;
		for(int i=0; i<5;i++) {
		ary[i]=(int)(Math.random()*100)+1;
		sum+=ary[i];
		}
		double avg=sum/5.0;
		System.out.println(avg);
	}
	
}
