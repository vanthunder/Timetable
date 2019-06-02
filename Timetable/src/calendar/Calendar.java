package calendar;

import java.util.ArrayList;
import java.util.HashMap;

import base.Base;
import event.Event;

public class Calendar {
	private static ArrayList<Base> calendarList = new ArrayList<Base>();
	//events are stored in a seperate list because they do not collide
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	private static HashMap<Integer, ArrayList<Base>> regularlyList = new HashMap<Integer, ArrayList<Base>>();
	
	
	
	
	public static ArrayList<Base> getCalendarList() {
		return calendarList;
	}

	public static void setCalendarList(ArrayList<Base> calendarList) {
		Calendar.calendarList = calendarList;
	}

	public static ArrayList<Event> getEventList() {
		return eventList;
	}

	public static void setEventList(ArrayList<Event> eventList) {
		Calendar.eventList = eventList;
	}

	public static HashMap<Integer, ArrayList<Base>> getRegularlyList() {
		return regularlyList;
	}

	public static void setRegularlyList(HashMap<Integer, ArrayList<Base>> regularlyList) {
		Calendar.regularlyList = regularlyList;
	}
	
	
	
	
	
}
