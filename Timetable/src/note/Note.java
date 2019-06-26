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

/**
 * 
 * @author Niklas
 *
 */

public class Note extends Base {

	private static final long serialVersionUID = -8361123580583543165L;
	private String title;
	private ArrayList photoList;
	private String textbox;
	private String filepath;

	
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

	public Note(String title, ArrayList photoList, String textbox, String filepath) {
		super(title);
		this.setPhotoList(photoList);
		this.setTextbox(textbox);
		this.setFilepath(filepath);
	}
	
	// states all Note attributes in a String
	@Override
	public String toString(){
		return new String("title: " + this.getTitle() + " photoList: " + photoList +
				" textbox: " + textbox + " filepath: " + this.getFilepath());
	}

	//this method saves the note if given the right variable
	public static void WriteObjectToFile(Note serObj) {

		String tmpTitle = serObj.getTitle();

		String filepath = "notes/Note " + tmpTitle + ".txt";

		File tmpFilepath = new File(filepath);
		tmpFilepath.getParentFile().mkdirs();

		boolean exists = tmpFilepath.exists();

		if (exists) {
			File file = new File(filepath);

			if (file.delete()) {
				System.out.println("Erfolgreich aktualisiert");
			} else {
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

	//loads a single Note
	public static String noteLoad(Note serObj) {

		File folder = new File("notes");
		InputStream fileInput = null;

		try {
			fileInput = new FileInputStream("notes/" + "Note " + serObj.getTitle() + ".txt");
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			Note note = (Note) objectInput.readObject();
			System.out.println(note);
			objectInput.close();
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				fileInput.close();
			} catch (Exception e) {
			}
		}

		return serObj.toString();
	}

	//loads all Notes
	public static void noteAllLoad() {
		File folder = new File("notes");
		File[] fileList = folder.listFiles();

		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				InputStream fileInput = null;

				try {
					fileInput = new FileInputStream("notes/" + fileList[i].getName());
					ObjectInputStream objectInput = new ObjectInputStream(fileInput);
					Note note = (Note) objectInput.readObject();
					System.out.println(note);
					objectInput.close();
				} catch (IOException e) {
					System.err.println(e);
				} catch (ClassNotFoundException e) {
					System.err.println(e);
				} finally {
					try {
						fileInput.close();
					} catch (Exception e) {
					}
				}
			}
		}

	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}
