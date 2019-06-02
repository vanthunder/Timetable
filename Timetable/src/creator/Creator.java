package creator;
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

public class Creator {
	
	public static String createEvent(String title, LocalDateTime startpoint, LocalDateTime endpoint, String description, 
			boolean regularlyOnOff, int regularlyType, int regularlyID, boolean alarmOnOff, LocalDateTime alarmTime) {
		//event exists always the whole day
		startpoint = startpoint.withHour(0).withMinute(0);
		endpoint = endpoint.withHour(23).withMinute(59);
		Event newEvent = new Event(title, startpoint, endpoint, true, description, 
				regularlyOnOff, regularlyType, regularlyID, alarmOnOff, alarmTime);
		
		//event is saved in Calendar
		ArrayList<Event> tempEventList = Calendar.getEventList();
		tempEventList.add(newEvent);
		//tempCalendarList.sort();
		Calendar.setEventList(tempEventList);
		
		//the event will be saved in the chosen Category:
		/*
		*ArrayList<Base> tempContentlist = chosenCategory.getContentlist();
		*tempContentlist.add(newEvent);
		*chosenCategory.setContentlist(tempContentlist);
		*/
		
		return newEvent.toString();
	}
	
	/**This method is called by createAppointmentUI() which is located in a Controller.
	 * createAppointmentUI opens the appointment-creation-menu. As soon as the user clicks on "save appointment" in that menu, 
	 * the data that the user gave in the appointment creation menu, will be converted and transferred to this method. 
	 * This method creates an appointment out of that data and saves it in the chosen category and in the calendar.
	 * 
	 */
	public static String createAppointment(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, int regularlyAmount, String description, boolean alarmOnOff, 
			LocalDateTime alarmTime, int notesPinned, ArrayList<Note> notesLink, boolean floating, Category chosenCategory) throws CloneNotSupportedException {

		
		
		
		
		if(allDay) {
			startpoint = startpoint.withHour(0).withMinute(0);
			endpoint = endpoint.withHour(23).withMinute(59);
			
			
		}
		
		//its better to have a method that does that in controller
		/*boolean floating = false;
		if(startpoint.equals(endpoint)) {
			floating = true;
		}*/
			
		
			Appointment newAppointment = new Appointment(title, startpoint, endpoint, allDay, regularlyOnOff, 
					regularlyType, 0, description, alarmOnOff, alarmTime, notesPinned, notesLink, floating);
			
			//the appointment will be saved in the Category:
			/*chosenCategory.contentlist.add(newAppointment);	<- this would be much easier than the way I've done it below, 
			*														but don't work when contentList is private
			*ArrayList<Base> tempContentlist = chosenCategory.getContentlist();
			*tempContentlist.add(newAppointment);
			*chosenCategory.setContentlist(tempContentlist);
			*/
			
			//newAppointment is only added to calendar if floating is false

			ArrayList<Base> tempCalendarList = Calendar.getCalendarList();
			tempCalendarList.add(newAppointment);
			//tempCalendarList.sort();
			Calendar.setCalendarList(tempCalendarList);
			
			int regularlyID = 0;
			if(regularlyOnOff) {
				HashMap<Integer, ArrayList<Base>> tempRegularlyList = Calendar.getRegularlyList();
				ArrayList<Base> regularlyInnerList = new ArrayList<Base>();
				
				//täglich
				if(newAppointment.getRegularlyType() == 0) {
					for(int i=0; i<regularlyAmount; i++) {
						if(i==0) {
							regularlyInnerList.add(newAppointment);
						}
						else {
							Event copy = (Event) newAppointment.clone();
							copy.setStartpoint(copy.getStartpoint().plusDays(i));
							//has to be transferred to calenderList and category
						}
					}
				}
				
				
				tempRegularlyList.put(regularlyID, regularlyInnerList);
			}
			
			
			//Save.save(); as soon as the appointment is created, the program will save the data
			
			//Testreturn to proof if the Appointment object got the data it should have:
		//return newAppointment.toString();
			return newAppointment.toString();
	}
	
	public static String createTask(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay,
			boolean regularlyOnOff, int regularlyType, String description, boolean alarmOnOff, LocalDateTime alarmTime,
			int notesPinned, ArrayList<Note> notesLink, boolean floating, boolean autoSortOnOff, int duration,
			boolean done, LocalDateTime feasibleTimeStart, LocalDateTime feasibleTimeEnd, LocalDateTime periodStart, LocalDateTime periodEnd) {


	
		
		floating = false;
		if(startpoint == endpoint) {
			floating = true;


		
		if(periodEnd.isAfter(periodStart)==true){
			
			long diffInMinutes = Math.abs(endpoint.getMinute() - startpoint.getMinute());
		    long diff = TimeUnit.DAYS.convert(diffInMinutes, TimeUnit.MINUTES);
		    duration = (int) diff;
		}
	}
		Task newTask = new Task(title, startpoint, endpoint, allDay, regularlyOnOff, regularlyType, description, alarmOnOff, alarmTime,
				notesPinned, notesLink, floating, done, duration, done, duration, duration, periodEnd, periodEnd);
		
		return newTask.toString();
}
		
	
	
	/**This method is called by createNoteUI() which is located in a Controller.
	 * createNoteUI opens the note-creation-menu. As soon as the user clicks on "save note" in that menu, 
	 * the data that the user gave in the note creation menu, will be converted and transferred to this method. 
	 * This method creates a note out of the data and saves it in the chosen category.
	 */
	public static String createNote(String title, int pinned, ArrayList pinnedAt, ArrayList photoList, ArrayList gifList, 
			ArrayList soundList, String textbox, ArrayList videoList, Category chosenCategory) {
		
			Note newNote = new Note(title, pinned, pinnedAt, photoList, gifList, soundList, textbox, videoList);
		
	
		return newNote.toString();
	}


	public static int getRegularlyID(){
		int regularlyID = 0;
		// get regularlyID
		for(int j=0; j<Calendar.getRegularlyList().size(); j++) {
			if (Calendar.getRegularlyList().get(j)== null) {
				regularlyID = j;
				return j;
			}
		}
		return 0;
	}
	
	
}
	

