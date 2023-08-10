package co.yedam.array;

public class CalendarExe {
	public static void main(String[] args) {
		int month=8;
		String[] days= {"Sun","Mon","Tue","Wen","Thr","Fri","Sat"};
		for(int i=0; i<days.length;i++) {
			System.out.printf("%4s",days[i]);
		}
		int space=getFirstDay(month);
		System.out.printf("\n");
		for(int i=0; i<space; i++) {
			System.out.printf("%4s"," ");
		}
		for(int i=1; i<=getLastDate(month); i++) {
			System.out.printf("%4d", i);
			if((i+space)%7==0) {
				System.out.printf("\n");
			}
		}
	}
	public static int getFirstDay(int month) {
		int day = 0 ;
		for(int i=1; i<month;i++) {
			day = (getLastDate(i)+day)%7;
		}
		return day;
	}
	
	public static int getLastDate(int month) {
		if( (month<8&&month%2==1) || (month>7&&month%2==0) ) {
			return 31;
		}else if(month==2) {
			return 28;
		} else {
			return 30;
		}
	}
}
