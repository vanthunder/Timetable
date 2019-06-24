package task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

import appointment.Appointment;
import note.Note;

public class Task extends Appointment implements Comparable {
	private boolean autoSortOnOff;
	private int duration;
	private boolean done;
	private int feasibleTimeStart;
	private int feasibleTimeEnd;
	private LocalDateTime periodStart;
	private LocalDateTime periodEnd;;
	private int autoSortID;

	public Task(String title, String filepath, LocalDateTime startpoint, LocalDateTime endpoint,
			LocalDateTime periodStart, LocalDateTime periodEnd, boolean allDay, boolean regularlyOnOff,
			int regularlyType, int regularlyID, String description, int notesPinned, ArrayList<Note> notesLink,
			boolean floating, boolean autoSortOnOff, int duration, boolean done) {

		super(title, startpoint, periodEnd, allDay, regularlyOnOff, regularlyType, regularlyID, description,
				notesPinned, notesLink, floating);

		this.autoSortOnOff = autoSortOnOff;
		this.duration = duration;
		this.done = done;
	}

	public LocalDateTime getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodStart(LocalDateTime periodStart) {
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

	public LocalDateTime getPeriodStart() {
		return periodStart;
	}

	public void setPeriodEnd(LocalDateTime periodEnd) {
		this.periodEnd = periodEnd;

	}

	public int getAutoSortID() {
		return autoSortID;
	}

	public void setAutoSortID(int autoSortID) {
		this.autoSortID = autoSortID;
	}

	public static void WriteObjectToFile(Task serObj) {

		String tmpTitle = serObj.getTitle();
		int counter = 0;
		boolean created = false;

		do {

			String filepath = "Task " + tmpTitle + counter + ".txt";

			File tmpFilepath = new File(filepath);
//		GsonBuilder gbuild = new GsonBuilder();
//		Gson gson = gbuild.create();

			boolean exists = tmpFilepath.exists();

			if (exists) {
				counter++;
				continue;
			}

			serObj.setFilepath(filepath);

			try {

				FileOutputStream fileOut = new FileOutputStream(filepath);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
				objectOut.writeObject(serObj);
				objectOut.close();
				System.out.println("Die Aufgabe wurde erfolgreich gespeichert!");

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			created = true;

		} while (!created);
	}

	@Override
	public String toString() {
		return "Task [toString()=" + super.toString() + ", getStartpoint()=" + getStartpoint() + ", getEndpoint()="
				+ getEndpoint() + ", getPeriodStart()=" + getPeriodStart() + ", getPeriodEnd()=" + getPeriodEnd()
				+ ", isAllDay()=" + isAllDay() + ", isRegisRegularlyOnOff()ularlyOnOff()=" + ", getRegularlyType()="
				+ getRegularlyType() + ", getRegularlyID()=" + getRegularlyID() + ", getDescription()="
				+ getDescription() + ", getNotesPinned()=" + getNotesPinned() + ", getNotesLink()=" + getNotesLink()
				+ ", isFloating()=" + isFloating() + ", getTitle()=" + getTitle() + ", getClass()=" + getClass()
				+ ", autoSortOnOff=" + autoSortOnOff + ", duration=" + duration + ", done=" + done
				+ ", feasibleTimeStart=" + feasibleTimeStart + ", feasibleTimeEnd=" + feasibleTimeEnd + ", periodStart="
				+ periodStart + ", periodEnd=" + periodEnd + "autoSortID=" + autoSortID + "]";
	}

	@Override
	public Task clone() throws CloneNotSupportedException {
		Task clonedTask = (Task) super.clone();
		clonedTask.setTitle(this.getTitle());
		clonedTask.setStartpoint(this.getStartpoint());
		clonedTask.setEndpoint(this.getEndpoint());
		clonedTask.setAllDay(this.isAllDay());
		clonedTask.setRegularlyOnOff(this.isRegularlyOnOff());
		clonedTask.setRegularlyType(this.getRegularlyType());
		clonedTask.setRegularlyID(this.getRegularlyID());
		clonedTask.setDescription(this.getDescription());
		clonedTask.setNotesPinned(this.getNotesPinned());
		clonedTask.setNotesLink(this.getNotesLink());
		clonedTask.setFloating(this.isFloating());
		clonedTask.setAutoSortID(this.getAutoSortID());

		return clonedTask;

	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
