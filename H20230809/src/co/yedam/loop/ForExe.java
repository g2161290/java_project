package co.yedam.loop;

public class ForExe {
	public static void main(String[] args) {
		int sum = 0;
		sum+=1;
		sum+=2;
		sum+=3;
		sum+=4;
		sum+=5;
		
		sum=0;
		for(int i=1; i<=5; i++) {
			sum+=i;
		}
		System.out.println(sum);
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		int sum3=0;
		for(int i=1; i<=100; i++) {
			if(i%3==0) {
				sum3+=i;
			}
		}
		System.out.println(sum3);
		
		for(int i=1; i<=10; i++) {
			for(int j=1;j<=10;j++) {
				if(4*i+5*j==60) {
					System.out.println("("+i+", "+j+")");
				}
			}
		}
		String star="";
		for(int i=1;i<=4;i++) {
			for(int j=1; j<=i; j++) {
			star+="*";	
			}
			star+="\n";
		}
		System.out.println(star);
		
		star="";
		for(int i=1;i<=4;i++) {
			for(int j=1; j<=4-i; j++) {
			star+=" ";	
			}
			for(int k=1; k<=i; k++) {
				star+="*";
			}
			star+="\n";
		}
		System.out.println(star);
	}
}
