package appointment;
import java.util.ArrayList;
import java.util.Date;
import base.Base;
import note.Note;

public class Appointment extends Base {
	private Date startpoint;
	private Date endpoint;
	private boolean allDay;
	private boolean regularlyOnOff;
	private int regularlyType;
	private String description;
	private boolean alarmOnOff;
	private Date alarmTime;
	private int notesPinned;
	private ArrayList<Note> notesLink;
	private boolean floating;
	
	public Appointment(String title, Date startpoint, Date endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, String description, boolean alarmOnOff, Date alarmTime, int notesPinned, 
			ArrayList<Note> notesLink, boolean floating){
		super(title);
		this.startpoint = startpoint; 
		this.endpoint = endpoint;
		this.allDay = allDay;
		this.regularlyOnOff = regularlyOnOff;
		this.regularlyType = regularlyType;
		this.description = description; 
		this.alarmOnOff = alarmOnOff; 
		this.alarmTime = alarmTime;
		this.notesPinned = notesPinned;
		this.notesLink = notesLink; 
		this.floating = floating;
	}
	
	


	public Date getStartpoint() {
		return startpoint;
	}



	public void setStartpoint(Date startpoint) {
		this.startpoint = startpoint;
	}



	public Date getEndpoint() {
		return endpoint;
	}



	public void setEndpoint(Date endpoint) {
		this.endpoint = endpoint;
	}



	public boolean isAllDay() {
		return allDay;
	}



	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}



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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isAlarmOnOff() {
		return alarmOnOff;
	}



	public void setAlarmOnOff(boolean alarmOnOff) {
		this.alarmOnOff = alarmOnOff;
	}



	public Date getAlarmTime() {
		return alarmTime;
	}



	public void setAlarmTime(Date alarmTime) {
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



	/** states all Appointment attributes in a String*/
	@Override
	public String toString(){
		return new String("title: "+this.getTitle()+" startpoint: "+startpoint+" endpoint: "+endpoint+" allDay: "+allDay+" regularlyOnOff: "+regularlyOnOff+
				" regularlyType: "+regularlyType+" description: "+description+" alarmOnOff: "+alarmOnOff+
				" alarmTime: "+alarmTime+" notesPinned: "+notesPinned+" notesLink: "+notesLink+" floating: "+floating);
	}
	
	/*	
	 * public calendarNotePinning{
	 * 
	 * 		//noteChoosing opens note overview and the user chooses the note to pin the appointment/terminated task to. 
	 * 		//The notesList-index from NoteOverview of the note is returned.
	 * 			int noteChoosingIndex = noteChoosing();
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
		
}
