package co.yedam.thread;

import java.awt.Toolkit;

public class BeepPrintExe {
	public static void main(String[] args) {
		// 스레드 생성.
		// 1. Runnable 인터페이스를 구현하는 객체를 Thread(생성자 매개값).
		// 2. Thread를 상속하는 클래스를 작성.
		Thread beep ;
		beep =new Thread(new BeepTask()); // 1. 
		beep = new WorkThread();  //2.
		//1-1. Runnable 인터페이스를 구현하는 익명객체 생성.
		//     Functional Interface.(구현할 메소드 한개만 존재)
		beep = new Thread(()-> {
				Toolkit toolkit=Toolkit.getDefaultToolkit();
				for(int i= 0;i<5;i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		});
		beep.start();
		
		for(int i= 0;i<5;i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
