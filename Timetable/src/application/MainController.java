package application;

import java.io.IOException;
import java.time.LocalDate;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import DebugCalendar.DebugCalendarController;
import category.CategoriesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import note.NoteController;
import task.TaskCreatorController;


public class MainController extends Main

{
    //Ruft den Controller für das Kategoriensystem auf
    @FXML 
    CategoriesController categoriesController = new CategoriesController();
    @FXML
    NoteController noteController = new NoteController();
    @FXML
    Button appointmentButton = new Button();
    @FXML
    Button taskButton = new Button();
    @FXML
    Button notesButton = new Button();
    @FXML
    TextField Search = new TextField();
    @FXML
    Button Test = new Button();
    @FXML
    DatePicker datePicker = new DatePicker();
    @FXML
    BorderPane Root1 = new BorderPane();
    @FXML
    DebugCalendarController debugCalendarController = new DebugCalendarController();
    
  

    
    
    
    public void appointmentButtonPress (ActionEvent event)
    {
    	
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AppointmentCreator.fxml"));
	    	Parent root1;
			root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.getIcons().add(new Image("/images/Kalender.png"));
			stage.setTitle("Neuer Termin");
	    	stage.setScene(new Scene(root1));
	    	stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
			{
				
			}
		} catch (IOException e)
		{
			
		}
		
    	
    }
    public void taskButtonPress (ActionEvent event)
    {
    	
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/TaskCreator.fxml"));
	    	Parent root1;
			root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.getIcons().add(new Image("/images/Aufgabe.png"));
			stage.setTitle("Neue Aufgabe");
	    	stage.setScene(new Scene(root1));  
	    	stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
		} catch (IOException e)
		{
			
		}
    	
    }
    public void notesButtonPress (ActionEvent event)
    {
    	
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NoteCreator.fxml"));
	    	Parent root1;
			root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.getIcons().add(new Image("/images/Notiz.png"));
			stage.setTitle("Neue Notiz");
	    	stage.setScene(new Scene(root1));  
	    	stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
		} catch (IOException e)
		{
			
		}
    }
    public void searchClicked (MouseEvent event)
    {
    	Search.setPrefWidth(250);	
    }
    public void searchKey (KeyEvent event)
    {
       
       if (Search.getText().isEmpty())
	   {
		Search.setPrefWidth(150);
	   }
    	else
    	Search.setPrefWidth(250);
    	
    }
    
	public void searchExit (MouseEvent event)
    {     
    	if(Search.getText().isEmpty() && !Search.isFocused())
     {
        Search.setPrefWidth(150);
     }
     
    }
	public void initialize() 
    {   
		
    }

}
