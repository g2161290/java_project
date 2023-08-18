package co.yedam.api;

public class SystemExe {
	public static void main(StringExe[] args) {
		long start=System.currentTimeMillis();
		start = System.nanoTime();
		for(int i = 0;i < 1000000; i++) {
			System.out.println(i);
		}
		long end =System.nanoTime();
		System.out.println((end-start)+" ms");
	} 
}
