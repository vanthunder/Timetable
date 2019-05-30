package calendar;

import java.util.ArrayList;

import base.Base;

public class Calendar {
	private static ArrayList<Base> calendarList = new ArrayList<Base>();
	
	
	public static ArrayList<Base> getCalendarList() {
		return calendarList;
	}

	public static void setCalendarList(ArrayList<Base> calendarList) {
		Calendar.calendarList = calendarList;
	}
	
	
}
