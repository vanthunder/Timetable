package calendar;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalendarController implements CalendarControllerInterface

{
	@FXML
	private Button upLeftButton;
	@FXML
	private Label timeformat;
    @FXML
	private Button upRightButton;
	@FXML
	private Button downLeftButton;
	@FXML
	private Label selectTime;
	@FXML
	private Button downRigtButton;
	ArrayList<String> TFormat = new ArrayList<>(Arrays.asList("Jahr",
                                                              "Monat",
                                                              "Woche",
                                                              "Tag"));
    ListIterator<String> currentTFormat = TFormat.listIterator();
    
   // Event Listener on Button[#upLeftButton].onAction
	@FXML
	public void urlPress(ActionEvent event) 
	{   
		if(currentTFormat.hasPrevious())
	    {
			String previous = currentTFormat.previous();
		    timeformat.setText("  "+previous+"  ");
	    }
		
	}
	// Event Listener on Button[#upRightButton].onAction
	@FXML
	public void urbPress(ActionEvent event) 
	{
		if(currentTFormat.hasNext())
		{   
			String next = currentTFormat.next();
			timeformat.setText("  "+next+"  ");
		}
	}
	// Event Listener on Button[#downLeftButton].onAction
	@FXML
	public void dlbPress(ActionEvent event) 
	{
		
	}
	// Event Listener on Button[#downRigtButton].onAction
	@FXML
	public void drbPress(ActionEvent event)
	{
		
	}

	@Override
	public int calendarChoosing()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	 //Initialize the Calendar with all its components
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
    	
    }

}
