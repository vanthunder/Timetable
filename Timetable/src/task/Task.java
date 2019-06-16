package task;

import java.time.LocalDateTime;
import java.util.ArrayList;

import appointment.Appointment;
import note.Note;

public class Task extends Appointment implements Comparable{
	private boolean autoSortOnOff;
	private int duration;
	private boolean done;
	private int feasibleTimeStart;
	private int feasibleTimeEnd;
	private LocalDateTime periodStart;
	private LocalDateTime periodEnd;;


	public Task(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay, boolean regularlyOnOff,
			int regularlyType, int regularlyID, String description, boolean alarmOnOff, LocalDateTime alarmTime, 
			int notesPinned,ArrayList<Note> notesLink, boolean floating, boolean autoSortOnOff, int duration, boolean done, LocalDateTime periodStart, LocalDateTime periodEnd) {
		super(title, startpoint, endpoint, allDay, regularlyOnOff, regularlyType, regularlyID, description, alarmOnOff, alarmTime,
				notesPinned, notesLink, floating);
		this.autoSortOnOff = autoSortOnOff;
		this.duration = duration;
		this.done = done;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}

	public boolean getAutoSortOnOff() {
		return autoSortOnOff;
	}


	public void setAutoSortOnOff(boolean autoSortOnOff) {
		this.autoSortOnOff = autoSortOnOff;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public boolean getDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}
	
	public LocalDateTime getPeriodStart() {
		return periodStart;
	}


	public void setPeriodStart(LocalDateTime periodStart) {
		this.periodStart = periodStart;
	}


	public LocalDateTime getPeriodEnd() {
		return periodEnd;
	}


	public void setPeriodEnd(LocalDateTime periodEnd) {
		this.periodEnd = periodEnd;
		
	}


	@Override
	public String toString() {
		return "Task [toString()=" + super.toString() + ", getStartpoint()=" + getStartpoint() + ", getEndpoint()="
				+ getEndpoint() + ", isAllDay()=" + isAllDay() + ", isRegularlyOnOff()=" + isRegularlyOnOff()
				+ ", getRegularlyType()=" + getRegularlyType() +", getRegularlyID()=" + getRegularlyID() + ", getDescription()=" + getDescription()
				+ ", isAlarmOnOff()=" + isAlarmOnOff() + ", getAlarmTime()=" + getAlarmTime() + ", getNotesPinned()="
				+ getNotesPinned() + ", getNotesLink()=" + getNotesLink() + ", isFloating()=" + isFloating()
				+ ", getTitle()=" + getTitle() + ", getClass()=" + getClass() + ", autoSortOnOff=" + autoSortOnOff
				+ ", duration=" + duration + ", done=" + done + ", feasibleTimeStart=" + feasibleTimeStart
				+ ", feasibleTimeEnd=" + feasibleTimeEnd + ", periodStart=" + periodStart + ", periodEnd=" + periodEnd
				+ "]";
	}
	@Override
	public Task clone() throws CloneNotSupportedException{
		Task clonedTask = (Task) super.clone();
		clonedTask.setTitle(this.getTitle());
		clonedTask.setStartpoint(this.getStartpoint());
		clonedTask.setEndpoint(this.getEndpoint());
		clonedTask.setAllDay(this.isAllDay());
		clonedTask.setRegularlyOnOff(this.isRegularlyOnOff());
		clonedTask.setRegularlyType(this.getRegularlyType());
		clonedTask.setRegularlyID(this.getRegularlyID());
		clonedTask.setDescription(this.getDescription());
		clonedTask.setAlarmOnOff(this.isAlarmOnOff());
		clonedTask.setAlarmTime(this.getAlarmTime());
		clonedTask.setNotesPinned(this.getNotesPinned());
		clonedTask.setNotesLink(this.getNotesLink());
		clonedTask.setFloating(this.isFloating());
		
		return clonedTask;

}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}}
