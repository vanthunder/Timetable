package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
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
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		
		
		assertEquals("title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 00:00 allDay: false regularlyOnOff: false regularlyType: 0 description: beautiful from start to end alarmOnOff: false alarmTime: 16.01.1998 00:00 notesPinned: 0 notesLink: [] floating: false", 
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, false, chosenCategory));
	}
	
	//AllDay activated so startpoint's time should be 00:00:00 and enpoint's 24:00:00
	@Test
	void testAllDay() {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		
		
		assertEquals("title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 23:59 allDay: true regularlyOnOff: false regularlyType: 0 description: beautiful from start to end alarmOnOff: false alarmTime: 16.01.1998 00:00 notesPinned: 0 notesLink: [] floating: false", 
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, true, false, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, false, chosenCategory));
	}
	
	
		//Tasks 
		@Test
		void testTaskregular() {
		LocalDateTime startpoint = LocalDateTime.of(2002,0,10,0,0);
		LocalDateTime endpoint = LocalDateTime.of(2002,0,14,0,0);
		LocalDateTime alarmTime = LocalDateTime.of2002,0,12,0,0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		
		Creator.createTask("TaskTester1", startpoint, endpoint,false, false, 0, "erster Test",false, alarmTime, notesLink, chosenCategory, duration, done, feasibleTimeStart, feasibleTimeEnd, periodStart, periodEnd);
		assertEquals("title: TaskTester1"+new Date()+" endpoint:"+newDate()+" allDay: false regularlyOnOff: false regularType: 0 description: erster Test alarmOnOff: false alarmTime: Mon Jan 12 00:00:00 CET 3898 notePinned: 0 noteLink: [] floating: true",
				Creator.createTask("TaskTester1", startpoint, endpoint, false, false, 0, "erster Test", false, alarmTime, noteLink, chosenCategory))
		
		}
		
		
		//AB HIER NOTES
		
		
		
		@Test
		void testnotecreation () {
			
			ArrayList pinnedAt = new ArrayList();
			ArrayList photoList = new ArrayList();
			ArrayList gifList = new ArrayList();
			ArrayList soundList = new ArrayList();
			ArrayList videoList = new ArrayList();
			Category chosenCategory = new Category();
			
			assertEquals("title: Stupid Note pinned: 0 pinnedAt: [] photoList: [] gifList: [] soundList: [] textbox: Some stupid text videoList: []",
		            Creator.createNote("Stupid Note", 0, pinnedAt, photoList, gifList, soundList, "Some stupid text", videoList, chosenCategory));
		}
	

}
