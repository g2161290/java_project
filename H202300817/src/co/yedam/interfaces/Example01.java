package co.yedam.interfaces;

public class Example01 {
	public static void main(String[] args) {
		int[][] intAry = new int[5][5]; // intAry[0]
		
		
		int r=1;
		for(int i=0;i<5; i++) {
			for(int j=4;j>=0;j--) {
				intAry[j][i]=r;
				r++;
			}
		}
		for(int i=0;i<5; i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%3d",intAry[i][j]);
			}
			System.out.println();
		}
	}
}
