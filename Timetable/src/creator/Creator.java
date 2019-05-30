package creator;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import category.Category;
import appointment.Appointment;
import base.Base;
import calendar.Calendar;
import note.Note;
import task.Task;

public class Creator {
	/**This method is called by createAppointmentUI() which is located in a Controller.
	 * createAppointmentUI opens the appointment-creation-menu. As soon as the user clicks on "save appointment" in that menu, 
	 * the data that the user gave in the appointment creation menu, will be converted and transferred to this method. 
	 * This method creates an appointment out of that data and saves it in the chosen category and in the calendar.
	 */
	public static String createAppointment(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, int regularlyAmount, String description, boolean alarmOnOff, LocalDateTime alarmTime, int notesPinned, ArrayList<Note> notesLink, boolean floating, Category chosenCategory) {
		
		
		
		
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
					regularlyType, description, alarmOnOff, alarmTime, notesPinned, notesLink, floating);
			
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
			
			
			//Save.save(); as soon as the appointment is created, the program will save the data
			
			//Testreturn to proof if the Appointment object got the data it should have:
		//return newAppointment.toString();
			return newAppointment.toString();
	}
	
	/*public static String createTask(String title, Date startpoint, Date endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, String description, boolean alarmOnOff, Date alarmtime, int notesPinned, 
			ArrayList<Note> notesLink, boolean floating,boolean autoSortOnOff,int duration,boolean done,int feasibleTimeStart,int feasibleTimeEnd,Date periodStart, Date periodEnd) {
		
		floating = false;
		if(startpoint == endpoint) {
			floating = true;
		}

		
		if(periodStart.compareTo(periodEnd)<0){
			
			long diffInMinutes = Math.abs(endpoint.getTime() - startpoint.getTime());
		    long diff = TimeUnit.DAYS.convert(diffInMinutes, TimeUnit.MINUTES);
		    duration = (int) diff;
		};
		
		Task newTask = new Task(title,startpoint,endpoint,allDay,regularlyOnOff,regularlyType,description,alarmOnOff,alarmtime,notesPinned,notesLink,floating,autoSortOnOff,duration,done,feasibleTimeStart,feasibleTimeEnd,periodStart,periodEnd );
		
		return newTask.toString();
	}*/
		
	
	
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
}
	

