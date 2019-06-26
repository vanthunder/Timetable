package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import calendar.Calendar;
import creator.Creator;
import note.Note;
import save.Save;

class SaveTest {
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, true, 0, 10,
				"beautiful from start to end", 0, notesLink, false);
		Creator.createAppointment("sexy Appointment2", startpoint, endpoint, false, true, 2, 100,
				"beautiful from start to end", 0, notesLink, false);
	}
	
	
	@Test
	void test() throws IOException, ClassNotFoundException {
		Save.saveCalendarList();
		ArrayList<Appointment> emptyCalendarList = new ArrayList<Appointment>();
		Calendar.setCalendarList(emptyCalendarList);
		Save.loadCalendarList();
		System.out.println(Calendar.getCalendarList().get(0));
		System.out.println(Calendar.getCalendarList().get(10));
		fail("Not yet implemented");
	}

}
