package task;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


public class TaskController implements Initializable {
	@FXML
	private static AnchorPane taskField;
	@FXML
	private ScrollPane taskList;
	@FXML
	private static HBox taskBox;
	Button newButton;
	public static ArrayList<Button> buttonList = new ArrayList<Button>();



	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{

		
		
	}
	
}
