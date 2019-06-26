package task;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import creator.Creator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

//@ Erwin
public class TaskController implements Initializable {
	@FXML
	private ListView<Button> listvieww;
	@FXML
	private static AnchorPane taskField;
	@FXML
	private ScrollPane taskList;

	@FXML
	private static HBox taskBox;

	private static ObservableList<Button> buttons = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buttons.addAll(Creator.getTaskButtons());
		for (int i = 0; i <= buttons.size(); i++) {
			Button btnNumber = new Button();
			btnNumber.setText(String.valueOf(i));
			
		    btnNumber.setOnAction((ActionEvent)->{
		        System.out.println(btnNumber.getText());
		    });
		    taskBox.getChildren().add(btnNumber);
		
		   
		}
	}
}

