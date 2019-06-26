package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	void testAppointmentRegular() throws CloneNotSupportedException, IOException {
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
						"beautiful from start to end", 0, notesLink, false));
	}

	// AllDay activated so startpoint's time should be 00:00:00 and enpoint's
	// 24:00:00
	@Test
	void testAppointmentAllDay() throws CloneNotSupportedException, IOException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();

		assertEquals(
				"title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 23:59 allDay: true regularlyOnOff: false "
						+ "regularlyType: 0 regularlyID: 0 description: beautiful from start to end notesPinned: 0 notesLink: [] floating: false",
				Creator.createAppointment("sexy Appointment", startpoint, endpoint, true, false, 0, 0,
						"beautiful from start to end", 0, notesLink, false));

	}

	@Test
	void testAppointmentCalendarTransfer() throws CloneNotSupportedException, IOException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, false, 0, 0,
				"beautiful from start to end", 0, notesLink, false);
		System.out.println(Calendar.getCalendarList().size());

		assertEquals("title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 00:00 "
				+ "allDay: false regularlyOnOff: false regularlyType: 0 regularlyID: 0 description: beautiful from start to end "
				+ "notesPinned: 0 notesLink: [] floating: false", Calendar.getCalendarList().get(0).toString());
	}

	@Test
	void testAppointmentRegularlyDaily() throws CloneNotSupportedException, IOException {
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();
		Creator.createAppointment("sexy Appointment", startpoint, endpoint, false, true, 0, 10,
				"beautiful from start to end", 0, notesLink, false);

		for (int i = 0; i < 10; i++) {
			System.out.println(Calendar.getRegularlyList().get(0).get(i).toString());
		}
		assertEquals("title: sexy Appointment startpoint: 14.01.1998 00:00 endpoint: 15.01.1998 00:00 "
				+ "allDay: false regularlyOnOff: true regularlyType: 0 regularlyID: 0 description: beautiful from start to end "
				+ "notesPinned: 0 notesLink: [] floating: false", Calendar.getRegularlyList().get(0).get(0).toString());

	}

	// komisch
	@Test
	void testAppointmentRegularlyDailyAllDay() throws CloneNotSupportedException, IOException {
		System.out.println(Calendar.getRegularlyList().size());
		LocalDateTime startpoint = LocalDateTime.of(1998, 1, 14, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(1998, 1, 15, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(1998, 1, 16, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		Category chosenCategory = new Category();

		Creator.createAppointment("sexy Appointment", startpoint, endpoint, true, true, 0, 10,
				"beautiful from start to end", 0, notesLink, false);
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
	void testTaskregular() throws CloneNotSupportedException, IOException {
		LocalDateTime startpoint = LocalDateTime.of(2002, 1, 10, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(2002, 1, 14, 0, 0);
		LocalDateTime alarmTime = LocalDateTime.of(2002, 1, 12, 0, 0);

		ArrayList<Note> notesLink = new ArrayList<Note>();

		new Category();

		Category chosenCategory = new Category();
		LocalDateTime feasibleTimeStart = LocalDateTime.of(2002, 1, 10, 0, 0);
		LocalDateTime periodStart = LocalDateTime.of(2002, 1, 10, 0, 0);

		boolean done = false;

		LocalDateTime.of(2002, 1, 16, 0, 0);
		LocalDateTime.of(2002, 1, 20, 0, 0);
		int duration = 0;

		boolean allDay = false;
		boolean regularlyOnOff = false;
		int regularlyType = 0;
		int notesPinned = 0;
		boolean floating = false;
		boolean autoSortOnOff = false;

		Assertions.assertEquals(
				"Task [toString()=title: awesome Task startpoint: 10.01.2002 00:00 endpoint: 14.01.2002 00:00 allDay: false regularlyOnOff: false regularlyType: 0 regularlyID: 0 description: awesome Description notesPinned: 0 notesLink: [] floating: false, getStartpoint()=2002-01-10T00:00, getEndpoint()=2002-01-14T00:00, getPeriodStart()=null, getPeriodEnd()=null, isAllDay()=false, isRegisRegularlyOnOff()ularlyOnOff()=, getRegularlyType()=0, getRegularlyID()=0, getDescription()=awesome Description, getNotesPinned()=0, getNotesLink()=[], isFloating()=false, getTitle()=awesome Task, getClass()=class task.Task, autoSortOnOff=false, duration=0, done=false, periodStart=null, periodEnd=null, autoSortID=0]",
				Creator.createTask("awesome Task", null, startpoint, endpoint, allDay, regularlyOnOff, regularlyType, 0,
						"awesome Description", notesPinned, notesLink, floating, autoSortOnOff, duration, periodStart,
						periodStart));

	}

	// AutoSort
	@Test
	void testTaskAutoSort() throws CloneNotSupportedException, IOException {
		LocalDateTime startpoint = LocalDateTime.of(2002, 1, 10, 0, 0);
		LocalDateTime endpoint = LocalDateTime.of(2002, 1, 14, 0, 0);
		ArrayList<Note> notesLink = new ArrayList<Note>();
		new Category();
		LocalDateTime.of(2002, 1, 16, 0, 0);
		LocalDateTime.of(2002, 1, 20, 0, 0);
		int duration = 0;
		boolean allDay = false;
		boolean regularlyOnOff = false;
		int regularlyType = 0;
		int notesPinned = 0;
		boolean floating = false;
		boolean autoSortOnOff = false;

		LocalDateTime periodStart = LocalDateTime.of(2002, 1, 7, 0, 0);
		LocalDateTime periodEnd = LocalDateTime.of(2002, 1, 17, 0, 0);
		Task testTask = new Task("awesome Task", null, startpoint, allDay, regularlyOnOff, regularlyType, 0,
				"awesome Description", notesPinned, notesLink, floating, autoSortOnOff, duration, periodStart,
				periodEnd);

		boolean done = false;
		Assertions.assertEquals(
				"Task [toString()=title: awesome Task startpoint: 10.01.2002 00:00 endpoint: 14.01.2002 00:00 allDay: false regularlyOnOff: false regularlyType: 0 regularlyID: 0 description: awesome Description notesPinned: 0 notesLink: [] floating: false, getStartpoint()=2002-01-10T00:00, getEndpoint()=2002-01-14T00:00, getPeriodStart()=null, getPeriodEnd()=null, isAllDay()=false, isRegisRegularlyOnOff()ularlyOnOff()=, getRegularlyType()=0, getRegularlyID()=0, getDescription()=awesome Description, getNotesPinned()=0, getNotesLink()=[], isFloating()=false, getTitle()=awesome Task, getClass()=class task.Task, autoSortOnOff=false, duration=0, done=false, periodStart=null, periodEnd=null, autoSortID=0]",
				Creator.createTask("awesome Task", null, startpoint, endpoint, allDay, regularlyOnOff, regularlyType, 0,
						"awesome Description", notesPinned, notesLink, floating, autoSortOnOff, duration, endpoint,
						endpoint));

	}

	// AB HIER NOTES

	@Test
	void testnotecreation() throws CloneNotSupportedException {

		ArrayList photoList = new ArrayList();
		Category chosenCategory = new Category();

		Assert.assertEquals(
				"title: Stupid Note photoList: [] textbox: Some stupid text filepath: notes/Note Stupid Note.txt",
				Creator.createNote("Stupid Note", photoList, "Some stupid text", "Some stupid filepath",
						chosenCategory));
	}

}
