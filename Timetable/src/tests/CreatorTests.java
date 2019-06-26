package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import calendar.Calendar;
import category.Category;
import creator.Creator;
import note.Note;
import task.AutoSort;
import task.Task;

public class CreatorTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Calendar.getCalendarList().clear();
		Calendar.getRegularlyList().clear();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEventRegular() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);

		assertEquals(
				"title: hi, startpoint: 14.01.1998 00:00, endpoint: 15.01.1998 23:59, allDay: true, description: best event of the year, "
						+ "regularlyOnOff: false, regularlyType: 0, regularlyID: 0",
				Creator.createEvent("hi", startpoint, endpoint, "best event of the year", false, 0, 0));
	}

	@Test
	void testEventCalendarTransfer() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);

		Creator.createEvent("hi", startpoint, endpoint, "best event of the year", false, 0, 0);
		assertEquals(
				"title: hi, startpoint: 14.01.1998 00:00, endpoint: 15.01.1998 23:59, allDay: true, description: best event of the year, "
						+ "regularlyOnOff: false, regularlyType: 0, regularlyID: 0, ",
				Calendar.getEventList().get(0).toString());
	}

	@Test
	void testEventRegularlyDaily() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);

		assertEquals(Creator.createEvent("hi", startpoint, endpoint, "best event of the year", true, 0, 5),
				Calendar.getRegularlyList().get(0).get(0));
	}

	@Test
	void testAppointmentRegular() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();

		assertEquals(
				"title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 00:00 allDay: false regularlyOnOff: false "
						+ "regularlyType: 0 regularlyID: 0 description: beautiful from start to end "
						+ "notesPinned: 0 notesLink: [] floating: false",
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, 0,
						"beautiful from start to end", 0, notesLink, false, chosenCategory));
	}

	// AllDay activated so startpoint's time should be 00:00:00 and enpoint's
	// 24:00:00
	@Test
	void testAppointmentAllDay() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();

		assertEquals(
				"title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 23:59 allDay: true regularlyOnOff: false "
						+ "regularlyType: 0 regularlyID: 0 description: beautiful from start to end notesPinned: 0 notesLink: [] floating: false",
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, true, false, 0, 0,
						"beautiful from start to end", 0, notesLink, false, chosenCategory));

	}

	@Test
	void testAppointmentCalendarTransfer() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, 0,
				"beautiful from start to end", 0, notesLink, false, chosenCategory);
		System.out.println(Calendar.getCalendarList().size());

		assertEquals("title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 00:00 "
				+ "allDay: false regularlyOnOff: false regularlyType: 0 regularlyID: 0 description: beautiful from start to end "
				+ "notesPinned: 0 notesLink: [] floating: false", Calendar.getCalendarList().get(0).toString());
	}

	@Test
	void testAppointmentRegularlyDaily() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, true, 0, 10,
				"beautiful from start to end", 0, notesLink, false, chosenCategory);

		for (int i = 0; i < 10; i++) {
			System.out.println(Calendar.getRegularlyList().get(0).get(i).toString());
		}
		assertEquals("title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 00:00 "
				+ "allDay: false regularlyOnOff: true regularlyType: 0 regularlyID: 0 description: beautiful from start to end "
				+ "notesPinned: 0 notesLink: [] floating: false", Calendar.getRegularlyList().get(0).get(0).toString());

	}

	// komisch
	@Test
	void testAppointmentRegularlyDailyAllDay() throws CloneNotSupportedException {
		System.out.println(Calendar.getRegularlyList().size());
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();

		Creator.createAppointment("sexy Appointment", startpoint, endpoint, true, true, 0, 10,
				"beautiful from start to end", 0, notesLink, false, chosenCategory);
		// for(int i=0; i<10;i++) {
		// System.out.println(Calendar.getRegularlyList().get(0).get(i).toString());
		// }
		System.out.println(Calendar.getRegularlyList().size());

		assertEquals("title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 23:59 "
				+ "allDay: true regularlyOnOff: true regularlyType: 0 regularlyID: 0 description: beautiful from start to end "
				+ "notesPinned: 0 notesLink: [] floating: false", Calendar.getRegularlyList().get(0).get(0).toString());

	}

	
	

	// Tasks
	@Test
	void testTaskregular() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(2002, 1, 10, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(2002, 1, 14, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(2002, 1, 12, 0, 0);

		ArrayList<Note> notesLink = new ArrayList<Note>();

		new Category();

		Category chosenCategory = new Category();
		LocalDateTime feasibleTimeStart = LocalDateTime.of(2002, 1, 10, 0, 0);
		LocalDateTime periodStart = LocalDateTime.of(2002, 1, 10, 0, 0);

		boolean done = false;

		LocalDateTime.of(2002,1,16,0,0);
		LocalDateTime.of(2002,1,20,0,0);
		int duration =0;

		boolean allDay = false;
		boolean regularlyOnOff = false;
		int regularlyType = 0;
		int notesPinned = 0;
		boolean floating = false;
		boolean autoSortOnOff = false;
	
		
		Assertions.assertEquals("Task [toString()=title: awesome Task startpoint: 10.01.2002 00:00 endpoint: 14.01.2002 00:00 allDay: false regularlyOnOff: false regularlyType: 0 regularlyID: 0 description: awesome Description notesPinned: 0 notesLink: [] floating: false, getStartpoint()=2002-01-10T00:00, getEndpoint()=2002-01-14T00:00, getPeriodStart()=null, getPeriodEnd()=null, isAllDay()=false, isRegisRegularlyOnOff()ularlyOnOff()=, getRegularlyType()=0, getRegularlyID()=0, getDescription()=awesome Description, getNotesPinned()=0, getNotesLink()=[], isFloating()=false, getTitle()=awesome Task, getClass()=class task.Task, autoSortOnOff=false, duration=0, done=false, periodStart=null, periodEnd=nullautoSortID=0]",
				Creator.createTask("awesome Task", null, startpoint, endpoint, allDay, regularlyOnOff,
						regularlyType, 0, "awesome Description", notesPinned, 
						notesLink, floating, autoSortOnOff, duration));
		
		}
		
		//AutoSort
		@Test
		void testTaskAutoSort() throws CloneNotSupportedException {
		LocalDateTime startpoint = LocalDateTime.of(2002,1,10,0,0);
		LocalDateTime endpoint = LocalDateTime.of(2002,1,14,0,0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		new Category();
		LocalDateTime.of(2002,1,16,0,0);
		LocalDateTime.of(2002,1,20,0,0);
		int duration =0;
		boolean allDay = false;
		boolean regularlyOnOff = false;
		int regularlyType = 0;
		int notesPinned = 0;
		boolean floating = false;
		boolean autoSortOnOff = false;

		
		Task testTask = new Task("awesome Task", null, startpoint, allDay, regularlyOnOff,
				regularlyType, 0, "awesome Description", notesPinned, 
				notesLink, floating, autoSortOnOff, duration);
			
	

		boolean done = false;
		Assertions.assertEquals("Task [toString()=title: awesome Task startpoint: 10.01.2002 00:00 endpoint: 14.01.2002 00:00 allDay: false regularlyOnOff: false regularlyType: 0 regularlyID: 0 description: awesome Description notesPinned: 0 notesLink: [] floating: false, getStartpoint()=2002-01-10T00:00, getEndpoint()=2002-01-14T00:00, getPeriodStart()=null, getPeriodEnd()=null, isAllDay()=false, isRegisRegularlyOnOff()ularlyOnOff()=, getRegularlyType()=0, getRegularlyID()=0, getDescription()=awesome Description, getNotesPinned()=0, getNotesLink()=[], isFloating()=false, getTitle()=awesome Task, getClass()=class task.Task, autoSortOnOff=false, duration=0, done=false, periodStart=null, periodEnd=nullautoSortID=0]",
				Creator.createTask("awesome Task", null, startpoint, endpoint, allDay, regularlyOnOff,
						regularlyType, 0, "awesome Description", notesPinned, 
						notesLink, floating, autoSortOnOff, duration));
		
		}
		
		
		//AB HIER NOTES
		
		
		
		private void assertEquals(Task testTask, Object autoSort) {
			// TODO Auto-generated method stub
			
		}




		assertEquals(
				"Task [toString()=title: awesome Task startpoint: 10.01.2002 00:00 endpoint: 14.01.2002 00:00 allDay: false regularlyOnOff: false regularlyType: 0 regularlyID: 0 description: awesome Description alarmOnOff: false alarmTime: 12.01.2002 00:00 notesPinned: 0 notesLink: [] floating: false, getStartpoint()=2002-01-10T00:00, getEndpoint()=2002-01-14T00:00, isAllDay()=false, isRegularlyOnOff()=false, getRegularlyType()=0, getRegularlyID()=0, getDescription()=awesome Description, isAlarmOnOff()=false, getAlarmTime()=2002-01-12T00:00, getNotesPinned()=0, getNotesLink()=[], isFloating()=false, getTitle()=awesome Task, getClass()=class task.Task, autoSortOnOff=false, duration=0, done=false, feasibleTimeStart=0, feasibleTimeEnd=0, periodStart=2002-01-20T00:00, periodEnd=2002-01-20T00:00]",
				Creator.createTask("awesome Task", null, startpoint, endpoint, allDay, regularlyOnOff, regularlyType, 0,
						"awesome Description", alarmOnOff, alarmTime, notesPinned, notesLink, floating, autoSortOnOff,
						duration, done));

	}

	// AB HIER NOTES

	@Test
	void testnotecreation() {

		ArrayList photoList = new ArrayList();
		Category chosenCategory = new Category();

		assertEquals("title: Stupid Note photoList: [] textbox: Some stupid text filepath: Some stupid filepath",
				Creator.createNote("Stupid Note", photoList, "Some stupid text", "Some stupid filepath", chosenCategory));
	}

	
}
