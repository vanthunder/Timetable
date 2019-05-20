/**
 * 
 */
package note;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


/**
 * @author 
 *
 */
public class NoteController implements Initializable
{
	@FXML
	Button linkButton = new Button();
	//Event for the link button
	public void linkButtonPress(ActionEvent event) {
		
	/**	Class<? extends ActionEvent> clazz = event.getClass();

		   for(Field field : clazz.getDeclaredFields()) {
		       //you can also use .toGenericString() instead of .getName(). This will
		       //give you the type information as well.

		       System.out.println(field.getName());
		       Calendar.CalendarList[p];*/
	} 
	//Initialize the NoteView with all its components
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		// TODO Auto-generated method stub
		
	}

	

}
