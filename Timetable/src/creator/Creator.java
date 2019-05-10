package creator;
import java.util.ArrayList;
import java.util.Date;
import category.Category;
import appointment.Appointment;
import base.Base;
import note.Note;

public class Creator {
	/**This method is called by createAppointmentUI() which is located in a Controller.
	 * createAppointmentUI opens the appointment-creation-menu. As soon as the user clicks on "save appointment" in that menu, 
	 * the data, that the user gave in the appointment creation menu, will be convertedand transferred to this method. 
	 * This method creates an appointment out of that data and saves it in the chosen Category and in the calendar.
	 */
	public static String createAppointment(String title, Date startpoint, Date endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, String description, boolean alarmOnOff, Date alarmTime, int notesPinned, ArrayList<Note> notesLink, Category chosenCategory) {
		
		
		
		
		if(allDay) {
			startpoint.setHours(0);
			endpoint.setHours(24);
		}
		
		boolean floating = false;
		if(startpoint == endpoint) {
			floating = true;
		}
			
		
			Appointment newAppointment = new Appointment(title, startpoint, endpoint, allDay, regularlyOnOff, 
					regularlyType, description, alarmOnOff, alarmTime, notesPinned, notesLink, floating);
			
			//the appointment will be saved in the Category:
			/*chosenCategory.contentlist.add(newAppointment);	<- this would be much easier than the way I've done it below, 
			*														but don't work when contentList is private
			*ArrayList<Base> tempContentlist = chosenCategory.getContentlist();
			*tempContentlist.add(newAppointment);
			*chosenCategory.setContentlist(tempContentlist);
			*/
			
			/*
			*ArrayList<Base/event> tempCalendarList = Calendar.getCalendarList();
			*tempCalendarList.add(newAppointment);
			*Calendar.setCalendarList(tempCalendarList);
			*/
			
			//Save.save(); as soon as the appointment is created, the program will save the data
			
			//Testreturn to proof if the Appointment object got the data it should have:
		return newAppointment.toString();
	}
	
	
}
