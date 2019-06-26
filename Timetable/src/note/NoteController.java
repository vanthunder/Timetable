package note;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * @author Niklas
 *
 */

public class NoteController implements Initializable
{
	
	@FXML
	private ImageView noteInsertImage = new ImageView();
	
	@FXML
	Button linkButton = new Button();
	
	public void linkButtonPress(ActionEvent event) {
		
	}
	
	@FXML
	Button noteInsertImageButton = new Button();
	
	//This button inserts an image into the Note
	public void noteInsertImageButtonPress(ActionEvent event) 
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image File");
		fileChooser.showOpenDialog(noteInsertImageButton.getScene().getWindow());
	} 
	
	//Initialize the NoteView with all its components
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
	}

	

}
