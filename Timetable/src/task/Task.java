package task;

import java.util.ArrayList;
import java.util.Date;

import appointment.Appointment;
import note.Note;

public class Task extends Appointment{
	private boolean autoSortOnOff;
	private int duration;
	private boolean done;
	private int feasibleTimeStart;
	private int feasibleTimeEnd;
	private Date periodStart;
	private Date periodEnd;;
	public Task(String title, Date startpoint, Date endpoint, boolean allDay, boolean regularlyOnOff, 
			int regularlyType, String description, boolean alarmOnOff, Date alarmtime, int notesPinned, 
			ArrayList<Note> notesLink, boolean floating,boolean autoSortOnOff,int duration,boolean done,int feasibleTimeStart,int feasibleTimeEnd,Date periodStart, Date periodEnd){
		
		super(title, periodEnd, periodEnd, done, done, feasibleTimeEnd, description, done, periodEnd, feasibleTimeEnd, notesLink, done);
		
		this.autoSortOnOff = autoSortOnOff;
		this.done = done;
		this.duration = duration;
		this.feasibleTimeEnd = feasibleTimeEnd;
		this.feasibleTimeStart = feasibleTimeStart;
		this.periodEnd = periodEnd;
		this.periodStart = periodStart;
		
		
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


	public Date getPeriodStart() {
		return periodStart;
	}


	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}


	public Date getPeriodEnd() {
		return periodEnd;
	}


	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
		
	}
	public String toString(){
		return new String("title: "+this.getTitle()+" startpoint: "+getStartpoint()+" endpoint: "+getEndpoint()+" allDay: "+isAllDay()+" regularlyOnOff: "+isRegularlyOnOff()+
				" regularlyType: "+getRegularlyType()+" description: "+getDescription()+" alarmOnOff: "+isAlarmOnOff()+
				" alarmTime: "+getAlarmTime()+" notesPinned: "+getNotesPinned()+" notesLink "+getNotesLink()+" floating: "+isFloating()+" autosort: "+getAutoSortOnOff()+" duration: "+getDuration()+" finished: "+getDone()+" feasibleTimeStart: "+getFeasibleTimeStart()+" feasibleTimeEnd: "+getFeasibleTimeEnd()+" periodStart: "+getPeriodStart()+" Period End: "+getPeriodEnd());

	}
	

}
