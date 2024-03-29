package creator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.IntBinaryOperator;

import category.Category;
import event.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import appointment.Appointment;
import base.Base;
import calendar.Calendar;
import calendar.CalendarController;
import note.Note;
import note.NotesViewController;
import save.Save;
import task.AutoSort;
import task.Task;

//@Erwin @Niklas @Marc
public class Creator implements Serializable {

	public static String createEvent(String title, LocalDateTime startpoint, LocalDateTime endpoint, String description,
			boolean regularlyOnOff, int regularlyType, int regularlyAmount) throws CloneNotSupportedException {
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
	 * @throws IOException
	 * 
	 */

	public static String createAppointment(String title, LocalDateTime startpoint, LocalDateTime endpoint,
			boolean allDay, boolean regularlyOnOff, int regularlyType, int regularlyAmount, String description,
			int notesPinned, ArrayList<Note> notesLink, boolean floating)
			throws CloneNotSupportedException, IOException {

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

						
					}
				}
			}
			tempRegularlyList.put(getRegularlyID(), regularlyInnerList);
			Calendar.setRegularlyList(tempRegularlyList);
			Calendar.setCalendarList(tempCalendarList2);
			updateCalendarControllerList();
			Save.saveCalendarList();


		}
		return newAppointment.toString();

	}

	private static ObservableList<Button> taskButtons = FXCollections.observableArrayList();

	public static ObservableList<Button> getTaskButtons() {
		return taskButtons;
	}

	public static void setTaskButtons(ObservableList<Button> taskButtons) {
		Creator.taskButtons = taskButtons;
	}
//@Erwin
	public static String createTask(String title, String filepath, LocalDateTime startpoint, LocalDateTime endpoint,
			boolean allDay, boolean regularlyOnOff, int regularlyType, int regularlyID, String description,
			int notesPinned, ArrayList<Note> notesLink, boolean floating, boolean autoSortOnOff, int duration,
			LocalDateTime periodStart, LocalDateTime periodEnd) throws CloneNotSupportedException, IOException {

		floating = false;
		if (startpoint == endpoint) {
			floating = true;

		}
		int regularlyAmount = 0;
		Duration.between(endpoint, endpoint).toDays();

		Task newTask = new Task(title, startpoint, endpoint, allDay, regularlyOnOff, regularlyType, regularlyID,
				description, notesPinned, notesLink, floating, autoSortOnOff, duration, periodStart, periodEnd);

		ArrayList<Appointment> tempCalendarList = Calendar.getCalendarList();
		tempCalendarList.add((Appointment) newTask);
		// tempCalendarList.sort();
		Calendar.setCalendarList(tempCalendarList);

		if (regularlyOnOff) {

			HashMap<Integer, ArrayList<Base>> tempRegularlyList = Calendar.getRegularlyList();
			ArrayList<Base> regularlyInnerList = new ArrayList<Base>();
			ArrayList<Appointment> tempCalendarList2 = Calendar.getCalendarList();

			// täglich
			if (newTask.getRegularlyType() == 0) {
				regularlyAmount = (int) Duration.between(endpoint, endpoint).toDays();
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {

						regularlyInnerList.add(newTask);

						for (int i1 = 1; i1 <= taskButtons.size(); i1++) {
							Button btn = new Button();
							btn.setMinWidth(200);
							btn.setMinHeight(50);
							btn.setText(newTask.getTitle() + " Start: " + newTask.getStartpoint() + " Ende: "
									+ newTask.getEndpoint());
							taskButtons.add(btn);

						}

					} else {
						Appointment copy = (Appointment) newTask.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusDays(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);
						for (int i1 = 1; i1 <= taskButtons.size(); i1++) {
							Button btn = new Button();
							btn.setMinWidth(200);
							btn.setMinHeight(50);
							btn.setText(newTask.getTitle() + " Start: " + newTask.getStartpoint() + " Ende: "
									+ newTask.getEndpoint());
							taskButtons.add(btn);

						}

					}
				}
			}

			// wöchentlich
			else if (newTask.getRegularlyType() == 1) {
				regularlyAmount = Math.round((int) Duration.between(endpoint, endpoint).toDays() / 7);
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {

						regularlyInnerList.add(newTask);

						for (int i1 = 1; i1 <= taskButtons.size(); i1++) {
							Button btn = new Button();
							btn.setMinWidth(200);
							btn.setMinHeight(50);
							btn.setText(newTask.getTitle() + " Start: " + newTask.getStartpoint() + " Ende: "
									+ newTask.getEndpoint());
							taskButtons.add(btn);

						}

					} else {
						Appointment copy = (Appointment) newTask.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusWeeks(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);

						for (int i1 = 1; i1 <= taskButtons.size(); i1++) {
							Button btn = new Button();
							btn.setMinWidth(200);
							btn.setMinHeight(50);
							btn.setText(newTask.getTitle() + " Start: " + newTask.getStartpoint() + " Ende: "
									+ newTask.getEndpoint());
							taskButtons.add(btn);
						}

					}
				}
			}

			// monatlich
			else if (newTask.getRegularlyType() == 2) {
				regularlyAmount = Math.round((int) Duration.between(endpoint, endpoint).toDays() / 30);
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {

						regularlyInnerList.add(newTask);

						for (int i1 = 1; i1 <= taskButtons.size(); i1++) {
							Button btn = new Button();
							btn.setMinWidth(200);
							btn.setMinHeight(50);
							btn.setText(newTask.getTitle() + " Start: " + newTask.getStartpoint() + " Ende: "
									+ newTask.getEndpoint());
							taskButtons.add(btn);
						}

					} else {
						Appointment copy = (Appointment) newTask.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusMonths(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);

						for (int i1 = 1; i1 <= taskButtons.size(); i1++) {
							Button btn = new Button();
							btn.setMinWidth(200);
							btn.setMinHeight(50);
							btn.setText(newTask.getTitle() + " Start: " + newTask.getStartpoint() + " Ende: "
									+ newTask.getEndpoint());
							taskButtons.add(btn);
						}

					}
				}
			}
			// jährlich
			else if (newTask.getRegularlyType() == 3) {
				regularlyAmount = Math.round((int) Duration.between(endpoint, endpoint).toDays() / 365);
				for (int i = 0; i <= regularlyAmount; i++) {
					if (i == 0) {
						regularlyInnerList.add(newTask);
					} else {
						Appointment copy = (Appointment) newTask.clone();
						LocalDateTime tempStartpoint = copy.getStartpoint();
						tempStartpoint = tempStartpoint.plusYears(i);
						copy.setStartpoint(tempStartpoint);
						copy.setRegularlyID(getRegularlyID());
						regularlyInnerList.add(copy);

						tempCalendarList2.add(copy);

						for (int i1 = 1; i1 <= taskButtons.size(); i1++) {
							Button btn = new Button();
							btn.setMinWidth(200);
							btn.setMinHeight(50);
							btn.setText(newTask.getTitle() + " Start: " + newTask.getStartpoint() + " Ende: "
									+ newTask.getEndpoint());
							taskButtons.add(btn);
						}
					}

				}
			}
			tempRegularlyList.put(getRegularlyID(), regularlyInnerList);
			Calendar.setRegularlyList(tempRegularlyList);
			Calendar.setCalendarList(tempCalendarList2);
			updateCalendarControllerList();
			Save.saveCalendarList();

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
	public static String createNote(String title, ArrayList photoList, String textbox, String filepath,
			Category chosenCategory) {

		Note newNote = new Note("Stupid Note", photoList, "Some stupid text", "Aber");

		Note.WriteObjectToFile(newNote);
		NotesViewController.getNotes().add(Note.noteLoad(newNote));

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

	public static void updateCalendarControllerList() {
		ArrayList<Appointment> tmpCalendarList = Calendar.getCalendarList();
		ArrayList<LocalDate> tmpControllerListAppointment = new ArrayList<LocalDate>();
		ArrayList<String> tmpControllerListDescription = new ArrayList<String>();
		for (int i = 0; i < tmpCalendarList.size(); i++) {
			tmpControllerListAppointment.add(tmpCalendarList.get(i).getStartpoint().toLocalDate());
			if (tmpCalendarList.get(i).getEndpoint() != null) {
				tmpControllerListAppointment.add(tmpCalendarList.get(i).getEndpoint().toLocalDate());
				tmpControllerListDescription.add(tmpCalendarList.get(i).getTitle());
			}
			tmpControllerListDescription.add(tmpCalendarList.get(i).getTitle());
		}
		CalendarController.setDescriptions(tmpControllerListDescription);
		CalendarController.setAppointments(tmpControllerListAppointment);

	}

	public static void deleteFromCalendarList(String title) {
		ArrayList<Integer> deleteIDs = new ArrayList<Integer>();
		ArrayList<Appointment> tmpCalendarList = Calendar.getCalendarList();
		for (int i = 0; i < tmpCalendarList.size(); i++) {
			if (tmpCalendarList.get(i).getTitle().equals(title)) {
				deleteIDs.add(i);
			}
		}
		for (int i = 0; i < deleteIDs.size(); i++) {
			tmpCalendarList.remove(deleteIDs.get(i));
		}
		Calendar.setCalendarList(tmpCalendarList);
		updateCalendarControllerList();
	}

	public static ArrayList<Button> taskButtons() {

		return taskButtons();
	}
}