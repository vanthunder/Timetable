package task;

import java.time.LocalDateTime;
import java.util.ArrayList;

import appointment.Appointment;
import note.Note;

public class Task extends Appointment{
	private boolean autoSortOnOff;
	private int duration;
	private boolean done;
	private int feasibleTimeStart;
	private int feasibleTimeEnd;
	private LocalDateTime periodStart;
	private LocalDateTime periodEnd;;


	public Task(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay, boolean regularlyOnOff,
			int regularlyType, String description, boolean alarmOnOff, LocalDateTime alarmTime, int notesPinned,
			ArrayList<Note> notesLink, boolean floating, boolean autoSortOnOff, int duration, boolean done,
			int feasibleTimeStart, int feasibleTimeEnd, LocalDateTime periodStart, LocalDateTime periodEnd) {
		super(title, startpoint, endpoint, allDay, regularlyOnOff, regularlyType, description, alarmOnOff, alarmTime,
				notesPinned, notesLink, floating);
		this.autoSortOnOff = autoSortOnOff;
		this.duration = duration;
		this.done = done;
		this.feasibleTimeStart = feasibleTimeStart;
		this.feasibleTimeEnd = feasibleTimeEnd;
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


	public int getFeasibleTimeStart() {
		return feasibleTimeStart;
	}


	public void setFeasibleTimeStart(int feasibleTimeStart) {
		this.feasibleTimeStart = feasibleTimeStart;
	}


	public int getFeasibleTimeEnd() {
		return feasibleTimeEnd;
	}


	public void setFeasibleTimeEnd(int feasibleTimeEnd) {
		this.feasibleTimeEnd = feasibleTimeEnd;
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
				+ ", getRegularlyType()=" + getRegularlyType() + ", getDescription()=" + getDescription()
				+ ", isAlarmOnOff()=" + isAlarmOnOff() + ", getAlarmTime()=" + getAlarmTime() + ", getNotesPinned()="
				+ getNotesPinned() + ", getNotesLink()=" + getNotesLink() + ", isFloating()=" + isFloating()
				+ ", getTitle()=" + getTitle() + ", getClass()=" + getClass() + ", autoSortOnOff=" + autoSortOnOff
				+ ", duration=" + duration + ", done=" + done + ", feasibleTimeStart=" + feasibleTimeStart
				+ ", feasibleTimeEnd=" + feasibleTimeEnd + ", periodStart=" + periodStart + ", periodEnd=" + periodEnd
				+ "]";
	}

}
