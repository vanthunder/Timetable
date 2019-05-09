package appointment;
import java.util.ArrayList;
import java.util.Date;
import base.Base;
import note.Note;

public class Appointment extends Base {
	String title; 
	Date startpoint;
	Date endpoint;
	boolean allDay;
	boolean regularlyOnOff;
	int regularlyType;
	String description;
	boolean alarmOnOff;
	Date alarmTime;
	int notesPinned;
	ArrayList<Note> notesLink;
	boolean floating;
	
	public Appointment(String title, Date startpoint, Date endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, String description, boolean alarmOnOff, Date alarmtime, int notePinned, 
			ArrayList<Note> noteLink, boolean floating){
		super(title);
		this.title = title;
		this.startpoint = startpoint; 
		this.endpoint = endpoint;
		this.allDay = allDay;
		this.regularlyOnOff = regularlyOnOff;
		this.regularlyType = regularlyType;
		this.description = description; 
		this.alarmOnOff = alarmOnOff; 
		this.alarmTime = alarmTime;
		this.notePinned = notePinned;
		this.noteLink = noteLink; 
		this.floating = floating;
	}
}
