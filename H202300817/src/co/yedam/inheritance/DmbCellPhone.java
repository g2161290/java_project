package co.yedam.inheritance;

public class DmbCellPhone extends CellPhone {
	private int channel;
	
	public void changeChannel(int channel) {
		this.channel = channel;
	}
	
	public void turnOnDmb() {
		System.out.println("DMB 폰을 켭니다.");
	}
}
