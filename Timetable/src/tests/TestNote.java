package tests;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import note.Note;

public class TestNote {

	public static void main(String[] args) {
		String title;
		final ArrayList photoList = null;
		final String textbox;
		final String filepath;
			
			Note serObj = new Note("Stupid Note", photoList, "Some stupid text", "Aber");
			
			Note.WriteObjectToFile(serObj);
			
			
	}
}
