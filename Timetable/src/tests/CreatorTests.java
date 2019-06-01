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

import appointment.Appointment;
import calendar.Calendar;
import category.Category;
import creator.Creator;
import note.Note;
import task.Task;

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
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, false, chosenCategory));
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
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, true, false, 0, 0, "beautiful from start to end", false, alarmTime, 0, notesLink, false, chosenCategory));
		
		
	}
	
	@Test
	void testAppointmentCalendarTransfer() {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, 0, 
				"beautiful from start to end", false, alarmTime, 0, notesLink, false, chosenCategory);
		
		
		assertEquals("title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 00:00 "
				+ "allDay: false regularlyOnOff: false regularlyType: 0 description: beautiful from start to end "
				+ "alarmOnOff: false alarmTime: 16.01.1998 00:00 notesPinned: 0 notesLink: [] floating: false", 
				Calendar.getCalendarList().get(0).toString());
	}
	
	
		//Tasks 
		@Test
		void testTaskregular() {
		LocalDateTime startpoint = LocalDateTime.of(2002,1,10,0,0);
		LocalDateTime endpoint = LocalDateTime.of(2002,1,14,0,0);
		LocalDateTime alarmTime = LocalDateTime.of(2002,1,12,0,0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		LocalDateTime feasibleTimeStart = LocalDateTime.of(2002,1,10,0,0);
		LocalDateTime periodStart = LocalDateTime.of(2002,1,10,0,0);
		boolean done = false;
		LocalDateTime feasibleTimeEnd = LocalDateTime.of(2002,1,16,0,0);
		LocalDateTime periodEnd = LocalDateTime.of(2002,1,20,0,0);
		int duration =0;
		boolean allDay = false;
		boolean regularlyOnOff = false;
		int regularlyType = 0;
		boolean alarmOnOff = false;
		int notesPinned = 0;
		boolean floating = false;
		boolean autoSortOnOff = false;
		
		assertEquals("Task [toString()=title: awesome Task startpoint: 10.01.2002 00:00 endpoint: 14.01.2002 00:00 allDay: false regularlyOnOff: false regularlyType: 0 description: awesome Description alarmOnOff: false alarmTime: 12.01.2002 00:00 notesPinned: 0 notesLink: [] floating: false, getStartpoint()=2002-01-10T00:00, getEndpoint()=2002-01-14T00:00, isAllDay()=false, isRegularlyOnOff()=false, getRegularlyType()=0, getDescription()=awesome Description, isAlarmOnOff()=false, getAlarmTime()=2002-01-12T00:00, getNotesPinned()=0, getNotesLink()=[], isFloating()=false, getTitle()=awesome Task, getClass()=class task.Task, autoSortOnOff=false, duration=0, done=false, feasibleTimeStart=0, feasibleTimeEnd=0, periodStart=2002-01-20T00:00, periodEnd=2002-01-20T00:00]",
				Creator.createTask("awesome Task", startpoint, endpoint, allDay, regularlyOnOff,
						regularlyType, "awesome Description", alarmOnOff, alarmTime, notesPinned,
						notesLink, floating, autoSortOnOff, duration, done,
						feasibleTimeStart, feasibleTimeEnd, periodStart, periodEnd));
		
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
