package calendar;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import appointment.Appointment;
import base.Base;
import event.Event;
import task.Task;
import task.AutoSort;

public class Calendar {
	private static ArrayList<Appointment> calendarList = new ArrayList<Appointment>();
	//events are stored in a seperate list because they do not collide
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	private static HashMap<Integer, ArrayList<Base>> regularlyList = new HashMap<Integer, ArrayList<Base>>();
	private static HashMap<Integer, ArrayList<Task>> autosortTaskList = new HashMap<Integer, ArrayList<Task>>();
	public static final DateTimeFormatter dateWithTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
	public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	
	
	
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

	public static HashMap<Integer, ArrayList<Base>> getRegularlyList() {
		return regularlyList;
	}

	public static void setRegularlyList(HashMap<Integer, ArrayList<Base>> regularlyList) {
		Calendar.regularlyList = regularlyList;
	}

	public static HashMap<Integer, ArrayList<Task>> getAutosortTaskList() {
		return autosortTaskList;
	}

	public static void setAutosortTaskList(HashMap<Integer, ArrayList<Task>> autosortTaskList) {
		Calendar.autosortTaskList = autosortTaskList;
	}
	
	
	
	
	
}
