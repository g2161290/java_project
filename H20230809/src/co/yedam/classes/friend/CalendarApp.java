package co.yedam.classes.friend;

import java.util.Calendar;

public class CalendarApp {
	public void showCalendar(int year, int month) {
		// Sun Mon Tue Wed Thr Fri Sat
		String[] days= {"Sun","Mon","Tue","Wen","Thr","Fri","Sat"};
		for(int i=0; i<days.length;i++) {
			System.out.printf("%4s",days[i]);
		}
		System.out.printf("\n");
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		int space=cal.get(Calendar.DAY_OF_WEEK)-1;
		for(int i=0; i<space; i++) {
			System.out.printf("%4s"," ");
		}
		for(int i=1; i<=cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			if((i+space)%7==0) {
				System.out.printf("\n");
			}
		}
	}
}
