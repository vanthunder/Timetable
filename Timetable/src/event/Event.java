package event;

import java.time.LocalDateTime;

import base.Base;

public class Event extends Base {
	//ganztag start description
	private LocalDateTime startpoint;
	private LocalDateTime endpoint;
	private boolean allDay;
	private String description;
	
	public Event(String title, LocalDateTime startpoint, LocalDateTime endpoint, boolean allDay, String description) {
		super(title);
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.allDay = allDay;
		this.description = description;
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

	@Override
	public String toString() {
		return "startpoint: " + startpoint + "endpoint: " + endpoint + ", allDay: " + allDay + ", description: " + description + ", title: "
				+ getTitle();
	}
	
	
	
	
}
