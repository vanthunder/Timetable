package calendar;

import java.util.ArrayList;
import java.util.HashMap;

import appointment.Appointment;
import base.Base;
import event.Event;

public class Calendar {
	private static ArrayList<Appointment> calendarList = new ArrayList<Appointment>();
	//events are stored in a seperate list because they do not collide
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	private static HashMap<Integer, ArrayList<Appointment>> regularlyList = new HashMap<Integer, ArrayList<Appointment>>();
	
	
	
	
	public static ArrayList<Appointment> getCalendarList() {
		return calendarList;
	}

	public static void setCalendarList(ArrayList<Appointment> calendarList) {
		Calendar.calendarList = calendarList;
	}

	public static ArrayList<Event> getEventList() {
		return eventList;
	}

	public static void setEventList(ArrayList<Event> eventList) {
		Calendar.eventList = eventList;
	}

	public static HashMap<Integer, ArrayList<Appointment>> getRegularlyList() {
		return regularlyList;
	}

	public static void setRegularlyList(HashMap<Integer, ArrayList<Appointment>> regularlyList) {
		Calendar.regularlyList = regularlyList;
	}
	
	
	
	
	
}
