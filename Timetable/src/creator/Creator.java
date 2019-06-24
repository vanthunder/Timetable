package creator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import category.Category;
import event.Event;
import appointment.Appointment;
import base.Base;
import calendar.Calendar;
import note.Note;
import task.Task;

public class Creator implements Serializable {

	public static String createEvent(String title, LocalDateTime startpoint, LocalDateTime endpoint, String description,
			boolean regularlyOnOff, int regularlyType, int regularlyAmount, boolean alarmOnOff, LocalDateTime alarmTime)
			throws CloneNotSupportedException {
		// event exists always the whole day
		startpoint = startpoint.withHour(0).withMinute(0);
		endpoint = endpoint.withHour(23).withMinute(59);
		Event newEvent = new Event(title, startpoint, endpoint, true, description, regularlyOnOff, regularlyType, 0);

		startpoint = startpoint.withHour(0).withMinute(0);
		endpoint = endpoint.withHour(23).withMinute(59);

		// event is saved in Calendar
		ArrayList<Event> tempEventList = Calendar.getEventList();
		tempEventList.add(newEvent);
		// tempCalendarList.sort();
		Calendar.setEventList(tempEventList);

		// its better to have a method that does that in controller
		/*
		 * boolean floating = false; if(startpoint.equals(endpoint)) { floating = true;
		 * }
		 */

		// the appointment will be saved in the Category:
		/*
		 * chosenCategory.contentlist.add(newAppointment); <- this would be much easier
		 * than the way I've done it below, but don't work when contentList is private
		 * ArrayList<Base> tempContentlist = chosenCategory.getContentlist();
		 * tempContentlist.add(newAppointment);
		 * chosenCategory.setContentlist(tempContentlist);
		 */

		// newAppointment is only added to calendar if floating is false

		

		if (regularlyOnOff) {

			newEvent.setRegularlyID(getRegularlyID());

			HashMap<Integer, ArrayList<Base>> tempRegularlyList = Calendar.getRegularlyList();
			ArrayList<Base> regularlyInnerList = new ArrayList<Base>();
			ArrayList<Event> tempEventList2 = Calendar.getEventList();

			// täglich
			if (newEvent.getRegularlyType() == 0) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newEvent);
						tempEventList2.add(newEvent);
					} else {
						Appointment copy = (Appointment) newEvent.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusDays(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempEventList2.add(copy);

						// has to be transferred to category!!!
					}
				}
			}

			// wöchentlich
			else if (newEvent.getRegularlyType() == 1) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newEvent);
					} else {
						Appointment copy = (Appointment) newEvent.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusWeeks(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempEventList2.add(copy);
						
						// has to be transferred to category!!!
					}
				}
			}

			// monatlich
			else if (newEvent.getRegularlyType() == 2) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newEvent);
					} else {
						Appointment copy = (Appointment) newEvent.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusMonths(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempEventList2.add(copy);
						
						// has to be transferred to category!!!
					}
				}
			}
			// jährlich
			else if (newEvent.getRegularlyType() == 3) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newEvent);
					} else {
						Appointment copy = (Appointment) newEvent.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusYears(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempEventList2.add(copy);
						
						// has to be transferred to category!!!
					}
				}
			}
			tempRegularlyList.put(getRegularlyID(), regularlyInnerList);
			Calendar.setRegularlyList(tempRegularlyList);
			Calendar.setEventList(tempEventList2);

//Save.save(); as soon as the appointment is created, the program will save the data

			// Testreturn to proof if the Appointment object got the data it should have:
			// return newAppointment.toString();

		}

		return newEvent.toString();
	}

	/**
	 * This method is called by createAppointmentUI() which is located in a
	 * Controller. createAppointmentUI opens the appointment-creation-menu. As soon
	 * as the user clicks on "save appointment" in that menu, the data that the user
	 * gave in the appointment creation menu, will be converted and transferred to
	 * this method. This method creates an appointment out of that data and saves it
	 * in the chosen category and in the calendar.
	 * 
	 */

	public static String createAppointment(String title, LocalDateTime startpoint, LocalDateTime endpoint,
			boolean allDay, boolean regularlyOnOff, int regularlyType, int regularlyAmount, String description, int notesPinned, ArrayList<Note> notesLink, boolean floating,
			Category chosenCategory) throws CloneNotSupportedException {

		if (allDay) {
			startpoint = startpoint.withHour(0).withMinute(0);
			endpoint = endpoint.withHour(23).withMinute(59);
		}

		// its better to have a method that does that in controller
		/*
		 * boolean floating = false; if(startpoint.equals(endpoint)) { floating = true;
		 * }
		 */

		Appointment newAppointment = new Appointment(title, startpoint, endpoint, allDay, regularlyOnOff, regularlyType,
				0, description, notesPinned, notesLink, floating);

		// the appointment will be saved in the Category:
		/*
		 * chosenCategory.contentlist.add(newAppointment); <- this would be much easier
		 * than the way I've done it below, but don't work when contentList is private
		 * ArrayList<Base> tempContentlist = chosenCategory.getContentlist();
		 * tempContentlist.add(newAppointment);
		 * chosenCategory.setContentlist(tempContentlist);
		 */

		// newAppointment is only added to calendar if floating is false

		ArrayList<Appointment> tempCalendarList = Calendar.getCalendarList();
		tempCalendarList.add(newAppointment);
		// tempCalendarList.sort();
		Calendar.setCalendarList(tempCalendarList);

		if (regularlyOnOff) {

			HashMap<Integer, ArrayList<Base>> tempRegularlyList = Calendar.getRegularlyList();
			ArrayList<Base> regularlyInnerList = new ArrayList<Base>();
			ArrayList<Appointment> tempCalendarList2 = Calendar.getCalendarList();

			// täglich
			if (newAppointment.getRegularlyType() == 0) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newAppointment);
					} else {
						Appointment copy = (Appointment) newAppointment.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusDays(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);
						
						// has to be transferred to category!!!
					}
				}
			}

			// wöchentlich
			else if (newAppointment.getRegularlyType() == 1) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newAppointment);
					} else {
						Appointment copy = (Appointment) newAppointment.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusWeeks(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);
						
						// has to be transferred to category!!!
					}
				}
			}

			// monatlich
			else if (newAppointment.getRegularlyType() == 2) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newAppointment);
					} else {
						Appointment copy = (Appointment) newAppointment.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusMonths(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);
						
						// has to be transferred to category!!!
					}
				}
			}
			// jährlich
			else if (newAppointment.getRegularlyType() == 3) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newAppointment);
					} else {
						Appointment copy = (Appointment) newAppointment.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusYears(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);
						
						// has to be transferred to category!!!
					}
				}
			}
			tempRegularlyList.put(getRegularlyID(), regularlyInnerList);
			Calendar.setRegularlyList(tempRegularlyList);
			Calendar.setCalendarList(tempCalendarList2);

//Save.save(); as soon as the appointment is created, the program will save the data

			// Testreturn to proof if the Appointment object got the data it should have:
			// return newAppointment.toString();

		}
		return newAppointment.toString();

	}

	public static String createTask(String title, String filepath, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay,
			boolean regularlyOnOff, int regularlyType, int regularlyID, String description, boolean alarmOnOff,
			LocalDateTime alarmTime, int notesPinned, ArrayList<Note> notesLink, boolean floating,
			boolean autoSortOnOff, int duration, boolean done)
			throws CloneNotSupportedException {

		floating = false;
		if (startpoint == endpoint) {
			floating = true;

		}
		int regularlyAmount = 0;
		Task newTask = new Task(title, filepath, startpoint, endpoint, allDay, regularlyOnOff, regularlyType,
				regularlyAmount, description, alarmOnOff, alarmTime, notesPinned, notesLink, floating, done, duration,
				done);

		ArrayList<Appointment> tempCalendarList = Calendar.getCalendarList();
		tempCalendarList.add(newTask);
		// tempCalendarList.sort();
		Calendar.setCalendarList(tempCalendarList);

		if (regularlyOnOff) {

			HashMap<Integer, ArrayList<Base>> tempRegularlyList = Calendar.getRegularlyList();
			ArrayList<Base> regularlyInnerList = new ArrayList<Base>();
			ArrayList<Appointment> tempCalendarList2 = Calendar.getCalendarList();


			// täglich
			if (newTask.getRegularlyType() == 0) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newTask);
						Task.WriteObjectToFile(newTask);
					} else {
						Appointment copy = (Appointment) newTask.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusDays(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);

						// has to be transferred to category!!!

						Task.WriteObjectToFile(newTask);
					}
				}
			}

			// wöchentlich
			else if (newTask.getRegularlyType() == 1) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newTask);
						Task.WriteObjectToFile(newTask);
					} else {
						Appointment copy = (Appointment) newTask.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusWeeks(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);
						// has to be transferred to category!!!

						Task.WriteObjectToFile(newTask);

					}
				}
			}

			// monatlich
			else if (newTask.getRegularlyType() == 2) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newTask);
						Task.WriteObjectToFile(newTask);
					} else {
						Appointment copy = (Appointment) newTask.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusMonths(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);
						// has to be transferred to category!!!

						Task.WriteObjectToFile(newTask);
					}
				}
			}
			// jährlich
			else if (newTask.getRegularlyType() == 3) {
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newTask);
						Task.WriteObjectToFile(newTask);
					} else {
						Appointment copy = (Appointment) newTask.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusYears(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);

						// has to be transferred to category!!!

						Task.WriteObjectToFile(newTask);
					}
				}
			}
			tempRegularlyList.put(getRegularlyID(), regularlyInnerList);
			Calendar.setRegularlyList(tempRegularlyList);
			Calendar.setCalendarList(tempCalendarList2);

//Save.save(); as soon as the appointment is created, the program will save the data

			// Testreturn to proof if the Appointment object got the data it should have:
			// return newAppointment.toString();

		}
		return newTask.toString();
	}

	/**
	 * This method is called by createNoteUI() which is located in a Controller.
	 * createNoteUI opens the note-creation-menu. As soon as the user clicks on
	 * "save note" in that menu, the data that the user gave in the note creation
	 * menu, will be converted and transferred to this method. This method creates a
	 * note out of the data and saves it in the chosen category.
	 */
	public static String createNote(String title, int pinned, ArrayList pinnedAt, ArrayList photoList,
			ArrayList gifList, ArrayList soundList, String textbox, ArrayList videoList, String filepath,
			Category chosenCategory) {

		Note newNote = new Note("Stupid Note", 0, pinnedAt, photoList, gifList, soundList, "Some stupid text", videoList, "Aber");

		Note.WriteObjectToFile(newNote);

		return newNote.toString();


	}

	public static int getRegularlyID() {
		int regularlyID = 0;
		// get regularlyID
		int j = 0;

		do {
			if (Calendar.getRegularlyList().containsKey(j) == false) {
				regularlyID = j;
				break;
			}
			j++;
		} while (j <= Calendar.getRegularlyList().size());

		return regularlyID;
	}

}
