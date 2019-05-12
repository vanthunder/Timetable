package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import category.Category;
import creator.Creator;
import note.Note;

class CreatorTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRegular() {
		Date startpoint = new Date(1998, 0, 14);
		Date endpoint = new Date(1998, 0, 15);
		Date alarmTime = new Date(1998, 0, 16);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, chosenCategory);
		assertEquals("title: sexy Appointment startpoint: Fri Jan 14 00:00:00 CET 3898 endpoint: Sat Jan 15 00:00:00 CET 3898 allDay: false regularlyOnOff: false regularlyType: 0 description: beautiful from start to end alarmOnOff: false alarmTime: Sun Jan 16 00:00:00 CET 3898 notesPinned: 0 notesLink: [] floating: false", 
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, chosenCategory));
	}
	
	//AllDay activated so startpoint's time should be 00:00:00 and enpoint's 24:00:00
	@Test
	void testAllDay() {
		Date startpoint = new Date(1998, 0, 14);
		Date endpoint = new Date(1998, 0, 15);
		Date alarmTime = new Date(1998, 0, 16);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, chosenCategory);
		assertEquals("title: sexy Appointment startpoint: Fri Jan 14 00:00:00 CET 3898 endpoint: Sat Jan 15 23:59:59 CET 3898 allDay: true regularlyOnOff: false regularlyType: 0 description: beautiful from start to end alarmOnOff: false alarmTime: Sun Jan 16 00:00:00 CET 3898 notesPinned: 0 notesLink: [] floating: false", 
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, true, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, chosenCategory));
	}
	
	//startpoint = endpoint so floating should be true
	@Test
	void testfloating() {
		Date startpoint = new Date(1998, 0, 14);
		Date endpoint = new Date(1998, 0, 14);
		Date alarmTime = new Date(1998, 0, 16);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, chosenCategory);
		assertEquals("title: sexy Appointment startpoint: Fri Jan 14 00:00:00 CET 3898 endpoint: Fri Jan 14 00:00:00 CET 3898 allDay: false regularlyOnOff: false regularlyType: 0 description: beautiful from start to end alarmOnOff: false alarmTime: Sun Jan 16 00:00:00 CET 3898 notesPinned: 0 notesLink: [] floating: true", 
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, chosenCategory));
	}
	
	//startpoint = endpoint so floating should be true
		@Test
		void testfloating2() {
			Date startpoint = new Date();
			Date endpoint = new Date();
			Date alarmTime = new Date(1998, 0, 16);
			ArrayList<Note> notesLink = new ArrayList<Note>();
			Category chosenCategory = new Category();
			
			Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, chosenCategory);
			assertEquals("title: sexy Appointment startpoint: "+new Date()+" endpoint: "+new Date()+" allDay: false regularlyOnOff: false regularlyType: 0 description: beautiful from start to end alarmOnOff: false alarmTime: Sun Jan 16 00:00:00 CET 3898 notesPinned: 0 notesLink: [] floating: true", 
					Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, chosenCategory));
		}
	

}
