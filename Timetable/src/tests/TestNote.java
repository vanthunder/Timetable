package tests;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import note.Note;

public class TestNote {

	public static void main(String[] args) {
		String title;
		final int pinned;
		final ArrayList pinnedAt = null;
		final ArrayList photoList = null;
		final ArrayList gifList = null;
		final ArrayList soundList = null;
		final String textbox;
		final ArrayList videoList = null;


			title ="Stupid Note";
			pinned=0;
			textbox="Some stupid text";
					  
		       
			
			Note serObj = new Note("Stupid Note", 0, pinnedAt, photoList, gifList, soundList, "Some stupid text", videoList, "Aber");
			
			Note.WriteObjectToFile(serObj);
			
			
	}
}
