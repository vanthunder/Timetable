package appointment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import base.Base;
import note.Note;

public class Appointment extends Base {
	private LocalDateTime startpoint;
	private LocalDateTime endpoint;
	private boolean allDay;
	private boolean regularlyOnOff;
	private int regularlyType;
	private String description;
	private boolean alarmOnOff;
	private LocalDateTime alarmTime;
	private int notesPinned;
	private ArrayList<Note> notesLink;
	private boolean floating;
	public final DateTimeFormatter dateWithTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
	
	public Appointment(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, String description, boolean alarmOnOff, LocalDateTime alarmTime, int notesPinned, 
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
	
	




	/** states all Appointment attributes in a String*/
	@Override
	public String toString(){
		return new String("title: "+this.getTitle()+" startpoint: "+startpoint.format(dateWithTimeFormatter)+" endpoint: "+endpoint.format(dateWithTimeFormatter)+" allDay: "+allDay+" regularlyOnOff: "+regularlyOnOff+
				" regularlyType: "+regularlyType+" description: "+description+" alarmOnOff: "+alarmOnOff+
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (alarmOnOff ? 1231 : 1237);
		result = prime * result + ((alarmTime == null) ? 0 : alarmTime.hashCode());
		result = prime * result + (allDay ? 1231 : 1237);
		result = prime * result + ((dateWithTimeFormatter == null) ? 0 : dateWithTimeFormatter.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endpoint == null) ? 0 : endpoint.hashCode());
		result = prime * result + (floating ? 1231 : 1237);
		result = prime * result + ((notesLink == null) ? 0 : notesLink.hashCode());
		result = prime * result + notesPinned;
		result = prime * result + (regularlyOnOff ? 1231 : 1237);
		result = prime * result + regularlyType;
		result = prime * result + ((startpoint == null) ? 0 : startpoint.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (alarmOnOff != other.alarmOnOff)
			return false;
		if (alarmTime == null) {
			if (other.alarmTime != null)
				return false;
		} else if (!alarmTime.equals(other.alarmTime))
			return false;
		if (allDay != other.allDay)
			return false;
		if (dateWithTimeFormatter == null) {
			if (other.dateWithTimeFormatter != null)
				return false;
		} else if (!dateWithTimeFormatter.equals(other.dateWithTimeFormatter))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endpoint == null) {
			if (other.endpoint != null)
				return false;
		} else if (!endpoint.equals(other.endpoint))
			return false;
		if (floating != other.floating)
			return false;
		if (notesLink == null) {
			if (other.notesLink != null)
				return false;
		} else if (!notesLink.equals(other.notesLink))
			return false;
		if (notesPinned != other.notesPinned)
			return false;
		if (regularlyOnOff != other.regularlyOnOff)
			return false;
		if (regularlyType != other.regularlyType)
			return false;
		if (startpoint == null) {
			if (other.startpoint != null)
				return false;
		} else if (!startpoint.equals(other.startpoint))
			return false;
		return true;
	}
	

	public LocalDateTime getStartpoint() {
		return startpoint;
	}



	public void setStartpoint(LocalDateTime startpoint) {
		this.startpoint = startpoint;
	}



	public LocalDateTime getEndpoint() {
		return endpoint;
	}



	public void setEndpoint(LocalDateTime endpoint) {
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


