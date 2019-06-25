package note;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import base.Base;
import task.Task;
import appointment.Appointment;
import javafx.scene.image.Image;

public class Note extends Base {

	private static final long serialVersionUID = -8361123580583543165L;
	private String title;
	private int pinned;
	private ArrayList <Appointment> pinnedAt;
	private ArrayList photoList;
	private String textbox;

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

	public String getTextbox() {
		return textbox;
	}

	public void setTextbox(String textbox) {
		this.textbox = textbox;
	}

	public Note(String title, int pinned, ArrayList pinnedAt, ArrayList photoList, String textbox, String filepath) {
		super(title);
		this.setPinned(pinned);
		this.setPinnedAt(pinnedAt);
		this.setPhotoList(photoList);
		this.setTextbox(textbox);
		this.setFilepath(filepath);
	}
	
	/** states all Note attributes in a String*/
	@Override
	public String toString(){
		return new String("title: " + this.getTitle() +" pinned: " + pinned + " pinnedAt: " + pinnedAt + " photoList: " + photoList +
				" textbox: " + textbox + " filepath: " + this.getFilepath());
	}

	public static void WriteObjectToFile(Note serObj) {
		
		String tmpTitle = serObj.getTitle();
	
			String filepath = "notes/Note " + tmpTitle + ".txt";

			File tmpFilepath = new File(filepath);
			tmpFilepath.getParentFile().mkdirs();
		
			boolean exists = tmpFilepath.exists();
		
			if(exists) {
				File file = new File(filepath); 
        
				if(file.delete()) 
			{ 
				System.out.println("Erfolgreich aktualisiert"); 
			} 
			else
			{ 
				System.out.println("Fehler beim aktualisieren"); 
			
			}
			}
	
		serObj.setFilepath(filepath);
		
	    try {
	 
	            FileOutputStream fileOut = new FileOutputStream(filepath);
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	            objectOut.writeObject(serObj);
	            objectOut.close();
	            System.out.println("Die Notiz wurde erfolgreich gespeichert!");
	 
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
		
		
				
	}

	public static String noteLoad(Note serObj) {
		
		File folder = new File("notes");
		InputStream fileInput = null;

				try
				{
				  fileInput = new FileInputStream("notes/" + "Note "+ serObj.getTitle() + ".txt");
				  ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				  Note note = (Note) objectInput.readObject();
				  System.out.println( note );
				  objectInput.close();
				}
				catch (IOException e) { System.err.println(e); }
				catch (ClassNotFoundException e) { System.err.println(e); }
				finally {try {fileInput.close();} catch (Exception e) { } }
				
			return serObj.toString();
    }
	
	
	public static void noteAllLoad() {
		File folder = new File("notes");
		File[] fileList = folder.listFiles();

		for (int i = 0; i < fileList.length; i++) {
		  if (fileList[i].isFile()) 
		  {
			  InputStream fileInput = null;

				try
				{
				  fileInput = new FileInputStream("notes/"+ fileList[i].getName() );
				  ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				  Note note = (Note) objectInput.readObject();
				  System.out.println(note);
				  objectInput.close();
				}
				catch (IOException e) {System.err.println(e); }
				catch ( ClassNotFoundException e ) { System.err.println(e); }
				finally {try {fileInput.close();} catch (Exception e) { } }
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
}

