package appointment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import base.Base;
import event.Event;
import note.Note;
import java.io.*;

public class Appointment extends Event implements Cloneable {
	private int notesPinned;
	private ArrayList<Note> notesLink;
	private boolean floating;
	
	public Appointment(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay,
			boolean regularlyOnOff, int regularlyType, int regularlyID, String description, boolean alarmOnOff, LocalDateTime alarmTime,
			int notesPinned, ArrayList<Note> notesLink, boolean floating) {
		super(title, startpoint, endpoint, allDay, description, regularlyOnOff, regularlyType, regularlyID, alarmOnOff, alarmTime);
		this.notesPinned = notesPinned;
		this.notesLink = notesLink;
		this.floating = floating;
	}

	/** states all Appointment attributes in a String*/
	@Override
	public String toString(){
		return new String("title: "+this.getTitle()+" startpoint: "+getStartpoint().format(dateWithTimeFormatter)+" endpoint: "+getEndpoint().format(dateWithTimeFormatter)+" allDay: "+isAllDay()+" regularlyOnOff: "+isRegularlyOnOff()+
				" regularlyType: "+getRegularlyType()+" description: "+getDescription()+" alarmOnOff: "+isAlarmOnOff()+
				" alarmTime: "+getAlarmTime().format(dateWithTimeFormatter)+" notesPinned: "+notesPinned+" notesLink: "+notesLink+" floating: "+floating);
	}
	
	/*	
	 * public calendarNotePinning{
	 * 
	 * 		//The method noteChoosing from NoteOverviewController opens note overview and the user chooses the note to pin the appointment/terminated task to. 
	 * 		//The notesList-index from NoteOverview of the note is returned.
	 * 			int noteChoosingIndex = NoteOverviewController.noteChoosing();
		       ArrayList<Note> tempNotesLink = this.getNotesLink();
		       ArrayList<Note> tempNotesList = NoteOverview.getNotesList();
		       tempNotesLink.add(tempNotesList[]));
		       this.setNotesLink(tempNotesLink());
		       this.notesPinned++;
		       
		       tempPinnedAt = tempNotesList[noteChoosingIndex].getPinnedAt;
		       tempCalendarList = NotesCalendar.getCalendarList();
		       tempPinnedAt.add(tempCalendarList[currentAppointment()]);
		       tempNotesList[noteChoosingIndex].setPinnedAt(tempPinnedAt);
		       // currentAppointment calls the index of the current opened appointment/terminated task in Calendar.calenderList
		 }*/
	





	public int getNotesPinned() {
		return notesPinned;
	}



	public void setNotesPinned(int notesPinned) {
		this.notesPinned = notesPinned;
	}



	public ArrayList<Note> getNotesLink() {
		return notesLink;
	}



	public void setNotesLink(ArrayList<Note> notesLink) {
		this.notesLink = notesLink;
	}



	public boolean isFloating() {
		return floating;
	}



	public void setFloating(boolean floating) {
		this.floating = floating;
	}
	
	
	@Override
	public Appointment clone() throws CloneNotSupportedException{
		Appointment clonedAppointment = (Appointment) super.clone();
		clonedAppointment.setTitle(this.getTitle());
		clonedAppointment.setStartpoint(this.getStartpoint());
		clonedAppointment.setEndpoint(this.getEndpoint());
		clonedAppointment.setAllDay(this.isAllDay());
		clonedAppointment.setRegularlyOnOff(this.isRegularlyOnOff());
		clonedAppointment.setRegularlyType(this.getRegularlyType());
		clonedAppointment.setRegularlyID(this.getRegularlyID());
		clonedAppointment.setDescription(this.getDescription());
		clonedAppointment.setAlarmOnOff(this.isAlarmOnOff());
		clonedAppointment.setAlarmTime(this.getAlarmTime());
		clonedAppointment.setNotesPinned(this.getNotesPinned());
		clonedAppointment.setNotesLink(this.getNotesLink());
		clonedAppointment.setFloating(this.isFloating());
		
		return clonedAppointment;
		
	}
}


