package application;
import java.io.IOException;
import category.CategoriesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import note.NoteController;


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
  
	public void initialize() 
    {
        
    }

}
