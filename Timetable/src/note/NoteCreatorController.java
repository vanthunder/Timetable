package note;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import calendar.CalendarController;
import category.CategoriesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

/**
 * 
 * @author Niklas
 *
 */

public class NoteCreatorController implements Initializable
{
	@FXML
	Button noteInsertImageButton = new Button();
	
	@FXML
	HBox imageList = new HBox();
	
	@FXML
	Button saveNoteButton = new Button();
	
	@FXML
	TextField noteTitle = new TextField();
	
	@FXML
	ChoiceBox<TreeItem<String>> categoryChooser = new ChoiceBox<TreeItem<String>>();
	
	@FXML
	ImageView currentImage = new ImageView();
	
	@FXML
	TextField noteDescription = new TextField();
	
	Image icon = new Image(getClass().getResourceAsStream("/images/NotizIcon.png"));
	
	@FXML
	public void noteInsertImageButtonPress(ActionEvent event) throws IOException 
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image File");
		File imageFile = fileChooser.showOpenDialog(null);
		Image image = new Image(imageFile.toURI().toString());
	    ImageView imageView = new ImageView(image);
	    imageList.getChildren().add(imageView);
	    currentImage.setImage(image);
	    System.out.println(imageList.getChildren());
	
	} 
	
	//This method saves the currently created Note
	public void saveNoteButtonPress(ActionEvent event)
	{   
		String title = noteTitle.getText();
		Image image = currentImage.getImage();
		String description = noteDescription.getText();
		String filepath = "notes/" + title;
		
		Note serObj = new Note(title, null, description, filepath);
		NotesViewController.update(title);
		Note.WriteObjectToFile(serObj);
		
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Speichern erfolgreich!");
        alert.setContentText("Die Noitz wurde erfolgreich gespeichert!");
        
		//This method saves the current Note and it's title as a category if a category is choosed in the choice box.
		if(!categoryChooser.getSelectionModel().getSelectedItem().equals(null))
		 {		
			TreeItem<String> savePosition = categoryChooser.getSelectionModel().getSelectedItem();
			TreeItem<String> newItem = new TreeItem<String>("Notiz: "+noteTitle.getText(), new ImageView(icon));
			CategoriesController.insertCategoryByCreator(savePosition, newItem);
		 }
		
	}
	//Initialize the NoteView with all its components
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{   //Inserts the Categories to the choice box.
		for(int i = 0; i < CategoriesController.getMainCategories().size(); i++)
		{
			categoryChooser.getItems().addAll(CategoriesController.getMainCategories().get(i));
		}
		
	}
}
