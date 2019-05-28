package calendar;

import java.util.ArrayList;

import appointment.Appointment;

public interface CalendarInterface {
	public ArrayList<Appointment> getCalendarList();
	public void setCalendarList(ArrayList<Appointment> calenderList);
}
