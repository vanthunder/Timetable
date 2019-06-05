/**
 * 
 */
package DebugCalendar;

import java.time.LocalDate;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * @author Marvin
 *
 */
public class CalanderLabel extends Label
{

	/**
	 * @param args
	 */
	private LocalDate date;
	
	private String labedate;
	
	public CalanderLabel()
	{ 
		
	}
	
     public String getLabedate()
	{
		return labedate;
	}


    public LocalDate getDate() 
     {
         return date;
     }

     public void setDate(LocalDate date) 
     {
         this.date = date;
     }
}
