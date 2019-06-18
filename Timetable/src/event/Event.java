package event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import appointment.Appointment;
import base.Base;
import calendar.Calendar;

public class Event extends Base implements Cloneable {
	//ganztag start description
	private LocalDateTime startpoint;
	private LocalDateTime endpoint;
	private boolean allDay;
	private String description;
	private boolean regularlyOnOff;
	private int regularlyType;
	private int regularlyID;
	private boolean alarmOnOff;
	private LocalDateTime alarmTime;
	
	
	

	public Event(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay, String description,
			boolean regularlyOnOff, int regularlyType, int regularlyID, boolean alarmOnOff, LocalDateTime alarmTime) {
		super(title);
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.allDay = allDay;
		this.description = description;
		this.regularlyOnOff = regularlyOnOff;
		this.regularlyType = regularlyType;
		this.regularlyID = regularlyID;
		this.alarmOnOff = alarmOnOff;
		this.alarmTime = alarmTime;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getRegularlyID() {
		return regularlyID;
	}

	public void setRegularlyID(int regularlyID) {
		this.regularlyID = regularlyID;
	}

	

	@Override
	public String toString() {
		return "title: " + getTitle()+", startpoint: " + startpoint.format(Calendar.dateWithTimeFormatter) + ", endpoint: " 
				+ endpoint.format(Calendar.dateWithTimeFormatter) + ", allDay: " + allDay + ", description: "
				+ description + ", regularlyOnOff: " + regularlyOnOff + ", regularlyType: " + regularlyType
				+ ", regularlyID: " + regularlyID + ", alarmOnOff: " + alarmOnOff + ", alarmTime: " 
				+ alarmTime.format(Calendar.dateWithTimeFormatter);
	}
	
	public Event clone() throws CloneNotSupportedException{
		Event clonedAppointment = (Event) super.clone();
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
		
		return clonedAppointment;
		
	}
	
	
	
	
	
	
	
}
