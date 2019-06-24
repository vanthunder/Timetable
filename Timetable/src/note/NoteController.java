package note;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class NoteController implements Initializable {
	
	@FXML
	private ImageView noteInsertImage = new ImageView();
	
	@FXML
	Button linkButton = new Button();
	
	public void linkButtonPress(ActionEvent event) {
		
	}
	
	@FXML
	Button noteInsertImageButton = new Button();
	
	public void noteInsertImageButtonPress(ActionEvent event) {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image File");
		fileChooser.showOpenDialog(noteInsertImageButton.getScene().getWindow());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
