package appointment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import base.Base;
import event.Event;
import note.Note;

public class Appointment extends Event {
	private boolean regularlyOnOff;
	private int regularlyType;
	private boolean alarmOnOff;
	private LocalDateTime alarmTime;
	private int notesPinned;
	private ArrayList<Note> notesLink;
	private boolean floating;
	public final DateTimeFormatter dateWithTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
	
	public Appointment(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, String description, boolean alarmOnOff, LocalDateTime alarmTime, int notesPinned, 
			ArrayList<Note> notesLink, boolean floating){
		super(title, startpoint, endpoint, allDay, description);
		this.regularlyOnOff = regularlyOnOff;
		this.regularlyType = regularlyType;
		this.alarmOnOff = alarmOnOff; 
		this.alarmTime = alarmTime;
		this.notesPinned = notesPinned;
		this.notesLink = notesLink; 
		this.floating = floating;
	}
	
	




	/** states all Appointment attributes in a String*/
	@Override
	public String toString(){
		return new String("title: "+this.getTitle()+" startpoint: "+getStartpoint().format(dateWithTimeFormatter)+" endpoint: "+getEndpoint().format(dateWithTimeFormatter)+" allDay: "+isAllDay()+" regularlyOnOff: "+regularlyOnOff+
				" regularlyType: "+regularlyType+" description: "+getDescription()+" alarmOnOff: "+alarmOnOff+
				" alarmTime: "+alarmTime.format(dateWithTimeFormatter)+" notesPinned: "+notesPinned+" notesLink: "+notesLink+" floating: "+floating);
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
	






	public boolean isRegularlyOnOff() {
		return regularlyOnOff;
	}



	public void setRegularlyOnOff(boolean regularlyOnOff) {
		this.regularlyOnOff = regularlyOnOff;
	}



	public int getRegularlyType() {
		return regularlyType;
	}



	public void setRegularlyType(int regularlyType) {
		this.regularlyType = regularlyType;
	}


	
	public boolean isAlarmOnOff() {
		return alarmOnOff;
	}



	public void setAlarmOnOff(boolean alarmOnOff) {
		this.alarmOnOff = alarmOnOff;
	}



	public LocalDateTime getAlarmTime() {
		return alarmTime;
	}



	public void setAlarmTime(LocalDateTime alarmTime) {
		this.alarmTime = alarmTime;
	}



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

		
}


