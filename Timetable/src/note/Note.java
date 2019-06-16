package note;

import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

import base.Base;
import task.Task;
import appointment.Appointment;
import javafx.scene.image.Image;

public class Note extends Base implements Serializable {
	
	String title;
	private int pinned;
	private ArrayList <Appointment> pinnedAt;
	private ArrayList photoList;
	private ArrayList gifList;
	private ArrayList soundList;
	private String textbox;
	private ArrayList videoList;

	public int getPinned() {
		return pinned;
	}

	public void setPinned(int pinned) {
		this.pinned = pinned;
	}

	public ArrayList getPinnedAt() {
		return pinnedAt;
	}

	public void setPinnedAt(ArrayList pinnedAt) {
		this.pinnedAt = pinnedAt;
	}

	public ArrayList getPhotoList() {
		return photoList;
	}

	public void setPhotoList(ArrayList photoList) {
		this.photoList = photoList;
	}

	public ArrayList getGifList() {
		return gifList;
	}

	public void setGifList(ArrayList gifList) {
		this.gifList = gifList;
	}

	public ArrayList getSoundList() {
		return soundList;
	}

	public void setSoundList(ArrayList soundList) {
		this.soundList = soundList;
	}

	public String getTextbox() {
		return textbox;
	}

	public void setTextbox(String textbox) {
		this.textbox = textbox;
	}

	public ArrayList getVideoList() {
		return videoList;
	}

	public void setVideoList(ArrayList videoList) {
		this.videoList = videoList;
	}

	public Note(String title, int pinned, ArrayList pinnedAt, ArrayList photoList, ArrayList gifList, ArrayList soundList, String textbox, ArrayList videoList, String filepath) {
		super(title);
		this.title = title;
		this.setPinned(pinned);
		this.setPinnedAt(pinnedAt);
		this.setPhotoList(photoList);
		this.setGifList(gifList);
		this.setSoundList(soundList);
		this.setTextbox(textbox);
		this.setVideoList(videoList);
		this.setFilepath(filepath);
	}
	
	/** states all Note attributes in a String*/
	@Override
	public String toString(){
		return new String("title: " + this.getTitle() +" pinned: " + pinned + " pinnedAt: " + pinnedAt + " photoList: " + photoList + " gifList: " + gifList +
				" soundList: " + soundList + " textbox: " + textbox + " videoList: " + videoList + " filepath: " + this.getFilepath());
	}

	public static void WriteObjectToFile(Note serObj) {
		
		String title = serObj.getTitle();
		int counter=0;
		
		String filepath = "C:\\Users\\Melanpiriks\\Desktop\\" + title + counter + ".bin";

		File tmpFilepath = new File(filepath);
		
		boolean exists = tmpFilepath.exists();
		
		while(exists == false) 
		{
			for(int i=0;  i >= 0; i++) {
			
			counter=i;
			filepath = "C:\\Users\\Melanpiriks\\Desktop\\" + title + counter + ".bin";
			}
		
			
		}
		
		
		
		serObj.setFilepath(filepath);
		
	    try {
	 
	            FileOutputStream fileOut = new FileOutputStream(filepath);
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	            objectOut.writeObject(serObj);
	            objectOut.close();
	            System.out.println("The Object  was succesfully written to a file");
	 
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
	}	
	
	
	/*	
	 * public noteCalendarPinning{
	 * 		//The method calendarChoosing from CalendarController opens calendar overview and the user chooses the appointment/terminated task to pin the note to. 
	 * 		//The Calendarlist-index of the appointment/terminated task is returned.
	 * 			int calendarChoosingIndex = CalendarController.calendarChoosing();
		        ArrayList<Appointment> tempPinnedAt = this.getPinnedAt();
		       ArrayList<Appointment> tempCalendarList = Calendar.getCalendarList();
		       tempPinnedAt.add(tempCalendarList[calendarChoosingIndex]));
		       this.setPinnedAt(tempPinnedAt());
		       this.pinned++;
		       
		       tempNotesLink = tempCalendarList[calendarChoosingIndex].getNotesLink;
		       tempNotesList = NotesOverview.getNotesList();
		       tempNotesLink.add(tempNotesList[currentNote()]);
		       tempCalendarList[calendarChoosingIndex].setNotesLink(tempNotesLink);
		       // current note calls the index of the current opened note in NoteOverview.notesList
		       
		 }*/

}

