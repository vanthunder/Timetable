package note;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;

import javafx.event.ActionEvent;

import javafx.scene.layout.GridPane;
import task.CreateTaskController;
import javafx.scene.control.*;

/**
 * 
 * @author Niklas und Marvin
 *
 */

public class NotesViewController implements Initializable
{
	@FXML
	private GridPane NoteContent;
	@FXML
	private static GridPane Cache = new GridPane();
	@FXML
	private Button backButton;
	@FXML
	notesLabel Label = new notesLabel();
	@FXML
	private Button forwardButton;
	@FXML
	static ArrayList<Label> notesLabels = new ArrayList<>();
	static ArrayList<String> notes = new ArrayList<String>();
	int globalCounter = 0;
	
	public static ArrayList<String> getNotes()
	{
		return notes;
	}
	public static void setNotes(ArrayList<String> notes)
	{
		NotesViewController.notes = notes;
	}
	// goes back in the Overview
	@FXML
	public void backButtonPress(ActionEvent event) 
	{
		globalCounter = globalCounter-9;
		if(globalCounter < 0)
		{
		   globalCounter = 0;
		}	
		if(!(globalCounter > notes.size()))
		{
			for(int a = 0; a<9 ; a++)
			{
			   int cache = globalCounter+a;
			   if(cache >= notes.size())
			   {
				   notesLabels.get(a).setText("");  
			   }
			   if(cache < notes.size())
			   {
				   System.out.println(a+" GlobalCounter = "+cache);
				   notesLabels.get(a).setText(notes.get(cache));  
			   }
			 }	
		}
	}
	// goes forward in the Overview
	@FXML
	public void forwardButtonPress(ActionEvent event) 
	{
		// TODO Autogenerated
		if(!(globalCounter > notes.size()))
		{
			globalCounter = globalCounter+9;
			if(!(globalCounter > notes.size()))
			{
				for(int a = 0; a<9 ; a++)
				{
				   int cache = globalCounter+a;
				   if(cache >= notes.size())
				   {
					   notesLabels.get(a).setText("");  
				   }
				   if(cache < notes.size())
				   {
					   System.out.println(a+" GlobalCounter = "+cache);
					   notesLabels.get(a).setText(notes.get(cache));  
				   }
				 }	
			}
			if(globalCounter > notes.size())
			{
			  globalCounter = globalCounter-9;
			}	
		}	
	}
	
	//adds a Note Label
	@FXML
	public void createNotesView()
	{
		for (int i = 1; i < 10; i++)
		{
			Label notelabel = new Label();
			if(i < notes.size())
			{
			notelabel.setText(notes.get(i));
			notesLabels.add(notelabel);
			}
			if(i<10)
			{
				NoteContent.add(notelabel, 0, i);
			}
		}	
		
	}
	
	//updates the Overview so it displays new Notes
	public static void update(String note)
	{
	   Label noteLabel = new Label();
	   noteLabel.setText(note);
	   notesLabels.add(noteLabel);
	   for(int i = 0; i < notesLabels.size(); i++)
	   {
		   if(notesLabels.get(i).getText().equals(""))
		   {
			   notesLabels.get(i).setText(note);
			   notes.add(note);
			   break;
		   } 
	   }
	   
	   
	}
	
	//makes a basic Overview that can be edited with creating new Notes
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine zweite Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine zweite Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine zweite Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine zweite Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine zweite Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine zweite Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine zweite Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		notes.add("Note: Das ist eine zweite Test Notiz");
		notes.add("Note: Das ist eine Test Notiz");
		createNotesView();		
		
	}
}
