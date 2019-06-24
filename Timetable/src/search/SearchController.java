package search;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class SearchController {
	
	@FXML
	VBox appointmentResults = new VBox();
	
	@FXML
	VBox taskResults = new VBox();
	
	@FXML
	VBox noteResults = new VBox();
	
	@FXML
	VBox eventResults = new VBox();

	public void setQuery(String searchThis) {
		// TODO Auto-generated method stub
		System.out.println(searchThis);
	}
}
