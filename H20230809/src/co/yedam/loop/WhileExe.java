package co.yedam.loop;

public class WhileExe {
	public static void main(String[] args) {
		boolean run=true;
		while(run) {
			int tmp=(int)(Math.random()*100);
			if(tmp>90) {
				//break;
				run=false;
			}
			System.out.println(tmp);
		}
		System.out.println("end");
		
		int i=1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
		int nun1;
		int nun2;
		
		while(true) {
			nun1=(int)(Math.random()*6)+1;
			nun2=(int)(Math.random()*6)+1;
			System.out.println(nun1+" "+nun2);
			if(nun1+nun2==5) {
				break;
			}
		}
	}
}
