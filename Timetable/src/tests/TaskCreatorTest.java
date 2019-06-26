package tests;



import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import calendar.Calendar;
import creator.Creator;
import note.Note;

class TaskCreatorTest {
	




	@Test
	void test() throws CloneNotSupportedException, IOException {
		String title = "testTitel";
		String filepath = "";
		String description = "Testdescription";
		LocalDateTime startpoint =LocalDateTime.of(2019,7,13,8,0);
		LocalDateTime endpoint =LocalDateTime.of(2019,7,14,8,0);

		ArrayList<Note> notesList = new ArrayList<Note>();
		
		int duration = 30;
		LocalDateTime periodStart = LocalDateTime.now();
		LocalDateTime periodEnd = LocalDateTime.now();
		
		Creator.createTask(title, filepath, startpoint, endpoint, false, false, 0, 0, description, 0, notesList, false, false, duration, periodStart, periodEnd);
		System.out.println(Calendar.getCalendarList().get(0));
		System.out.println(Calendar.getCalendarList().get(0).getTitle());
		System.out.println(Calendar.getCalendarList().get(0).getStartpoint());
		System.out.println(Calendar.getCalendarList().get(0).getEndpoint());
		
		fail("Not yet implemented");
	}

}
