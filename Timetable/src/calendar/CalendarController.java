package calendar;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.ValidationEvent;
import static java.time.temporal.TemporalAdjusters.*;
import org.omg.CORBA.Current;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.Date;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.PseudoClass;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;



public class CalendarController implements Initializable

{   @FXML
	private GridPane Calendar;
	@FXML
	private Button upLeftButton;
	@FXML
	private Label timeformat;
    @FXML
	private Button upRightButton;
	@FXML
	private Button downLeftButton;
	@FXML
	private Label selectTimeLabel;
	@FXML
	private Button downRigtButton;
	@FXML
	private Label YearLabel;
	@FXML
	private final List<Label> Labels = new ArrayList<>();
	@FXML
	CalendarLabel label = new CalendarLabel();

	
	String Month = new String("Monat");
	String Day = new String("Tag");
	
	 // LocalDate Events
		private YearMonth actualYearMonth;
		private LocalDate currentDate = LocalDate.now();
		LocalDate startOfWeek = currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1);
		LocalDate endOfWeek = startOfWeek.plusDays(6);
		LocalDate start = currentDate.with(firstDayOfMonth());
		LocalDate end = currentDate.with(lastDayOfMonth());
		Month currentMonth = currentDate.getMonth();
		LocalDate a = LocalDate.of(currentDate.getYear(),2, 1);
		//Month month = Month.a.get;
		//Month february = Month.valueOf(1)//Month.FEBRUARY;
     // LocalDate helper integers;
		int maxlength = currentMonth.maxLength();
		int markedLabel = 0;
		int ab = 0;
		int Months = 1;
		int mMonths = 0;
		int CurrentYear = currentDate.getYear();
		int feb = a.getMonth().maxLength();//february.maxLength();

		DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("         E\n        d MMM");

    // Event Listener on Button[#upLeftButton].onAction
	@FXML
	public void urlPress(ActionEvent event) 
	{   if(timeformat.getText().equals(Month))
		{
			timeformat.setText(Day);
		}
		else
		if (timeformat.getText().equals(Day))
		{
			timeformat.setText(Month);
		}
	}
	// Event Listener on Button[#upRightButton].onAction
	@FXML
	public void urbPress(ActionEvent event) 
	{
		if(timeformat.getText().equals(Month))
		{
			timeformat.setText(Day);
		}
		else
		if (timeformat.getText().equals(Day))
		{
			timeformat.setText(Month);
		}
	}
	// Event Listener on Button[#downLeftButton].onAction
	@FXML
	public void dlbPress(ActionEvent event) 
	{
		// selectTimeLabel.setText(Integer.toString(CurrentYear--));
				if (ab == maxlength)
				{
					ab = 0;
				}

				// selectTimeLabel.setText(Integer.toString(CurrentYear++));
				for (int i = 0; i <maxlength; i++)
				{
					
					maxlength = currentMonth.maxLength();
					if (!(ab == maxlength))
					{
						LocalDate betweenweek = start.minusMonths(mMonths).minusDays(i);
						if (betweenweek.getMonth().toString().equals("FEBRUARY"))
						{
							maxlength = feb-1;
							Labels.get(28).setText("");
							Labels.get(29).setText("");
							Labels.get(30).setText("");
							Labels.get(31).setText("");
						}
						if (Labels.get(markedLabel).getText().toString().equals(currentDate.format(dayFormatter)))
						{

							Labels.get(markedLabel).setStyle("-fx-background-color: #428aff");
							
							System.out.println("WAhr111111111111111111111111111111111111111111");
						}
						else
							if (!Labels.get(i).getText().toString().equals(currentDate.format(dayFormatter)))
							{
		                        Labels.get(markedLabel).setStyle(Labels.get(1).getStyle());
								System.out.println("WAhr");
							}
						
						currentMonth = betweenweek.getMonth();
						label.setText(betweenweek.format(dayFormatter));
						Labels.get(i).setText(betweenweek.format(dayFormatter));

						System.out.println(betweenweek.getDayOfWeek());

						ab++;
						System.out.println(betweenweek.getMonth());
						System.out.println(Labels.get(i).getText().toString());
						YearLabel.setText(Integer.toString(betweenweek.getYear()));
						selectTimeLabel.setText(betweenweek.getMonth().toString());
						if (Labels.get(i) == null)
						{
							CalendarLabel label = new CalendarLabel();
							// label.setText(betweenweek.format(dayFormatter));
							Labels.add(label);
						} 
						else 
						if 
						(i < maxlength)
						{
							System.out.println("TESTSETSETSTESTESTESETSETSETSETST");
							Labels.get(maxlength).setText("");
						}
						
					}

					System.out.println(maxlength);

				}
				Months--;
				mMonths++;	
	}
	// Event Listener on Button[#downRigtButton].onAction
	@FXML
	public void drbPress(ActionEvent event)
	{
		if (ab == maxlength)
		{
			ab = 0;
		}
		maxlength = currentMonth.maxLength();
		selectTimeLabel.setText(Integer.toString(CurrentYear++));
		for (int i = 0; i < maxlength; i++)
		{
			
			maxlength = currentMonth.maxLength();
			if (!(ab == maxlength))
			{
				LocalDate betweenweek = start.plusMonths(Months).plusDays(i);
				if (betweenweek.getMonth().toString().equals("FEBRUARY"))
				{
					maxlength = feb-1;
					Labels.get(28).setText("");
					Labels.get(29).setText("");
					Labels.get(30).setText("");
					Labels.get(31).setText("");
				}
				if (Labels.get(markedLabel).getText().toString().equals(currentDate.format(dayFormatter)))
				{

					Labels.get(markedLabel).setStyle("-fx-background-color: #428aff");
					
					System.out.println("WAhr111111111111111111111111111111111111111111");
				}
				else
					if (!Labels.get(i).getText().toString().equals(currentDate.format(dayFormatter)))
					{

						Labels.get(markedLabel).setStyle(Labels.get(1).getStyle());
						System.out.println("WAhr");
					}
			
				currentMonth = betweenweek.getMonth();
				label.setText(betweenweek.format(dayFormatter));
				Labels.get(i).setText(betweenweek.format(dayFormatter));
				
				System.out.println(betweenweek.getDayOfWeek());
				// label.setText(betweenweek.format(dayFormatter));
				// Labels.add(label);
				ab++;
				System.out.println("NOCHMAL");
				YearLabel.setText(Integer.toString(betweenweek.getYear()));
				selectTimeLabel.setText(betweenweek.getMonth().toString());
				if (Labels.get(i) == null)
				{
					CalendarLabel label = new CalendarLabel();
					Labels.add(label);
				}
				else
				if (i < maxlength)
				{
						System.out.println("TESTSETSETSTESTESTESETSETSETSETST");
						Labels.get(maxlength).setText("");
				}
					
					
						
					
		}
		}
		Months++;
		mMonths--;
	}

	
	public void intitCalendar()
	{
		int a = 0;
		YearLabel.setText(Integer.toString(currentDate.getYear()));
		// currentDate.getYear();
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				currentDate.getYear();
				CalendarLabel label = new CalendarLabel();
				label.setTextAlignment(TextAlignment.CENTER);
				// label.setText(currentDate.format(dayFormatter));
				label.setTextAlignment(TextAlignment.CENTER);
				label.setAlignment(Pos.CENTER);
				Calendar.setAlignment(Pos.CENTER);
				label.setTextAlignment(TextAlignment.CENTER);
				Calendar.add(label, j, i);
				selectTimeLabel.setText(currentDate.getMonth().toString());
				if (!(a == maxlength))
				{
					LocalDate betweenweek = start.plusDays(a);
					System.out.println("TEST");
					label.setText("TEST");
					label.setText(betweenweek.format(dayFormatter));
					Labels.add(label);

					System.out.println(betweenweek.getDayOfWeek());

					a++;

				} else if (a <= maxlength)
				{
					// label.setText("TEST");
					Labels.add(label);
				}

			}
		}
    }
	public void markcurrentDate()
	{
		for (int i = 0; i < Labels.size(); i++)
		{
			System.out.println(Labels.get(i).getText());
			if (Labels.get(i).getText().equals(currentDate.format(dayFormatter)))
			{
				Labels.get(i).setStyle("-fx-background-color: #428aff");
				markedLabel = i;
				System.out.println("True");
			}
		}
	}
	
	
	 //Initialize the Calendar with all its components
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
    	selectTimeLabel.setText(Integer.toString(currentDate.getYear()));
		intitCalendar();
		markcurrentDate();
    }

}
