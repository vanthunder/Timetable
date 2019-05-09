package creator;
import java.util.ArrayList;
import java.util.Date;
import category.Category;
import appointment.Appointment;
import note.Note;

public class Creator {
	/**terminErstellenUI() im TerminController ruft das Termin erstellen Fenster auf. 
	 * Sobald auf speichern gedrückt wird übergibt es die vom Nutzer eingetragenen Parameter an Ersteller.terminErstellen()
	 */
	public static void terminErstellen(String title, Date startpoint, Date endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, String description, boolean alarmOnOff, Date alarmTime, int notesPinned, ArrayList<Note> notesLink, Category chosenCategory) {
		
		
		
		
		if(allDay) {
			startpoint.setHours(0);
			endpoint.setHours(24);
		}
		
		boolean floating = false;
		if(startpoint == endpoint) {
			floating = true;
		}
			
		//Termin wird später in der jeweiligen Kategorie gespeichert
			Appointment newAppointment = new Appointment(title, startpoint, endpoint, allDay, regularlyOnOff, 
					regularlyType, description, alarmOnOff, alarmTime, notesPinned, notesLink, floating);
		
		
	}
	
	
}
