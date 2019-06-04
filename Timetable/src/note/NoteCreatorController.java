package note;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

public class NoteCreatorController implements Initializable
{
	//@FXML
	//private ImageView noteInsertImage = new ImageView();
	
	@FXML
	Button noteInsertImageButton = new Button();
	//Event for the link button
	
	@FXML
	HBox imageList = new HBox();
	
	public void noteInsertImageButtonPress(ActionEvent event) throws IOException 
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image File");
		File imageFile = fileChooser.showOpenDialog(null);
		Image image = new Image(imageFile.toURI().toString());
	ImageView imageView = new ImageView(image);
	imageList.getChildren().add(imageView);
	System.out.println(imageList.getChildren());
	
	} 
	//Initialize the NoteView with all its components
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
	/**	Image image = new Image("/images/u mad bro.jpg");
		
		noteInsertImage.setImage(image);
		*/}
}
