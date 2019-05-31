package calendar;

import java.net.URL;
import java.util.ResourceBundle;

public interface CalendarControllerInterface {
	//calendarChoosing opens calendar overview and the user chooses the appointment/terminated task to pin the note to. 
	//The Calendarlist-index of the appointment/terminated task is returned.
	public int calendarChoosing();

	void initialize(URL arg0, ResourceBundle arg1);
}
