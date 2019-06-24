package note;

import java.util.ArrayList;

import org.junit.experimental.theories.Theories;

public class NoteOverview {
	private static ArrayList<Note> notesList;
	
	
	public static ArrayList<Note> getNotesList() {
		return notesList;
	}

	
	public static void setNotesList(ArrayList<Note> notesList) {
		NoteOverview.notesList = notesList;
		
	}

}
