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

import DebugCalendar.CalanderLabel;
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

{
	@FXML
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
	@FXML
	private Label LeapYearLabel;

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
	LocalDate crMonth = currentDate.withMonth(currentMonth.getValue());
	LocalDate year;
	LocalDate a = LocalDate.of(currentDate.getYear(), 2, 1);
	// Month month = Month.a.get;
	// Month february = Month.valueOf(1)//Month.FEBRUARY;
	// LocalDate helper integers;
	int maxlength = currentMonth.maxLength();
	int markedLabel = 0;
	int ab = 0;
	int Months = 1;
	int mMonths = 1;
	int CurrentYear = currentDate.getYear();
	int feb = a.getMonth().maxLength();// february.maxLength();

	DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("         E\n        d MMM");

	// Event Listener on Button[#upLeftButton].onAction
	@FXML
	public void urlPress(ActionEvent event)
	{
		if (timeformat.getText().equals(Month))
		{
			timeformat.setText(Day);
		} else if (timeformat.getText().equals(Day))
		{
			timeformat.setText(Month);
		}
	}

	// Event Listener on Button[#upRightButton].onAction
	@FXML
	public void urbPress(ActionEvent event)
	{
		if (timeformat.getText().equals(Month))
		{
			timeformat.setText(Day);
		} else if (timeformat.getText().equals(Day))
		{
			timeformat.setText(Month);
		}
	}

	// Event Listener on Button[#downLeftButton].onAction
	@FXML
	public void dlbPress(ActionEvent event)
	{
		if (ab == maxlength)
		{
			ab = 0;
		}	
		maxlength = currentMonth.maxLength();
		selectTimeLabel.setText(Integer.toString(CurrentYear++));
			 switch(currentMonth)
		     {
		      case JANUARY:
		    	  selectTimeLabel.setText("Dezember");
		    	  System.out.println("Januar");
		    	  maxlength = 31;
		    	  break;
		      case FEBRUARY:
		    	  selectTimeLabel.setText("Januar");
		    	  System.out.println("Februar");
		    	  maxlength = 31;
		    	  break;
		      case MARCH:
		    	  selectTimeLabel.setText("Februar");
		    	  System.out.println("März");
		    	  if(year.isLeapYear())
		    	  {
		    		  maxlength = 29;
		    		  System.out.println("true");
		    	  }
		    	  else 
		    	  if(!year.isLeapYear())
			      {
			    	 maxlength = 28;
			    	 System.out.println("false");
			      }
		    	  break;
		      case APRIL:
		    	  selectTimeLabel.setText("März");
		    	  System.out.println("April");
		    	  maxlength = 31;
		    	  break;
		      case MAY:
		    	  selectTimeLabel.setText("April");
		    	  System.out.println("Mai");
		    	  maxlength = 30;
		    	  break;
		      case JUNE:
		    	  selectTimeLabel.setText("Mai");
		    	  System.out.println("Juni");
		    	  maxlength = 31;
		    	  break;
		      case JULY:
		    	  selectTimeLabel.setText("Juni");
		    	  System.out.println("July");
		    	  maxlength = 30;
		    	  break;
		      case AUGUST:
		    	  selectTimeLabel.setText("Juli");
		    	  System.out.println("August");
		    	  maxlength = 31;
		    	  break;
		      case SEPTEMBER:
		    	  selectTimeLabel.setText("August");
		    	  System.out.println("September");
		    	  maxlength = 31;
		    	  break;
		      case OCTOBER:
		    	  selectTimeLabel.setText("September");
		    	  System.out.println("Oktober");
		    	  maxlength = 30;
		    	  break;
		      case NOVEMBER:
		    	  selectTimeLabel.setText("Oktober");
		    	  System.out.println("November");
		    	  maxlength = 31;
		    	  break;
		      case DECEMBER:
		    	  selectTimeLabel.setText("November");
		    	  System.out.println("Dezember");
		    	  maxlength = 30;
		    	  break;
		     }
		          LocalDate betweenweek = start.minusMonths(mMonths);
		    	  for (int i = 0; i < maxlength; i++)
		    	  {     
		    		    betweenweek = start.minusMonths(mMonths).plusDays(i);
		    		    label.setText(betweenweek.format(dayFormatter));
					    Labels.get(i).setText(betweenweek.format(dayFormatter));
					    YearLabel.setText(Integer.toString(betweenweek.getYear()));
					    currentMonth = betweenweek.getMonth();
					    year = betweenweek;
						ab++;
						if(betweenweek.isLeapYear())
						{
							LeapYearLabel.setVisible(true);
						}
						else
					    if(!betweenweek.isLeapYear())
					    {
						    LeapYearLabel.setVisible(false);
					    }
						if (currentMonth == currentMonth.FEBRUARY)
						{
							if(year.isLeapYear())
							{
								Labels.get(29).setText("");
								Labels.get(30).setText("");
								Labels.get(31).setText("");
							}
							else
							if(!year.isLeapYear())
							{
								Labels.get(28).setText("");
								Labels.get(29).setText("");
								Labels.get(30).setText("");
								Labels.get(31).setText("");
							}
							}
						if (Labels.get(i) == null)
						{
							CalanderLabel label = new CalanderLabel();
							Labels.add(label);
						}
						else
						if (i < maxlength)
						{
							Labels.get(maxlength).setText("");
						}
						    System.out.println(i +". = "+maxlength);
				        if (Labels.get(markedLabel).getText().toString().equals(currentDate.format(dayFormatter)))
					    {
                            Labels.get(markedLabel).setStyle("-fx-background-color: #428aff");
					    }
					    else
						if (!Labels.get(i).getText().toString().equals(currentDate.format(dayFormatter)))
						{
                            Labels.get(markedLabel).setStyle(Labels.get(1).getStyle());
						}
		               }
		    	Months--;
		  		mMonths++;
		  		System.out.println("mMonths = "+mMonths);
		  		System.out.println("Months = "+Months);
		  		System.out.println("crMonth = "+ crMonth.getMonthValue());
		  		System.out.println("CurrentMonthValue = "+currentMonth.getValue());
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
			 switch(currentMonth)
		     {
		      case JANUARY:
		    	  selectTimeLabel.setText("Februar");
		    	  System.out.println("Januar");
		    	  if(year.isLeapYear())
		    	  {
		    		  maxlength = 29;
		    		  System.out.println("true");
		    	  }
		    	  else 
		    	  if(!year.isLeapYear())
			      {
			    	 maxlength = 28;
			    	 System.out.println("false");
			      }
		    	  break;
		      case FEBRUARY:
		    	  selectTimeLabel.setText("März");
		    	  System.out.println("Februar");
		    	  maxlength = 31;
		    	  break;
		      case MARCH:
		    	  selectTimeLabel.setText("April");
		    	  System.out.println("März");
		    	  maxlength = 30;
		    	  break;
		      case APRIL:
		    	  selectTimeLabel.setText("Mai");
		    	  System.out.println("April");
		    	  maxlength = 31;
		    	  break;
		      case MAY:
		    	  selectTimeLabel.setText("Juni");
		    	  System.out.println("Mai");
		    	  maxlength = 30;
		    	  break;
		      case JUNE:
		    	  selectTimeLabel.setText("Juli");
		    	  System.out.println("Juni");
		    	  maxlength = 31;
		    	  break;
		      case JULY:
		    	  selectTimeLabel.setText("August");
		    	  System.out.println("Juli");
		    	  maxlength = 31;
		    	  break;
		      case AUGUST:
		    	  selectTimeLabel.setText("September");
		    	  System.out.println("August");
		    	  maxlength = 30;
		    	  break;
		      case SEPTEMBER:
		    	  selectTimeLabel.setText("Oktober");
		    	  System.out.println("September");
		    	  maxlength = 31;
		    	  break;
		      case OCTOBER:
		    	  selectTimeLabel.setText("November");
		    	  System.out.println("Oktober");
		    	  maxlength = 30;
		    	  break;
		      case NOVEMBER:
		    	  selectTimeLabel.setText("Dezember");
		    	  System.out.println("November");
		    	  maxlength = 31;
		    	  break;
		      case DECEMBER:
		    	  selectTimeLabel.setText("Januar");
		    	  System.out.println("Dezember");
		    	  maxlength = 31;
		    	  break;
		     }
		          LocalDate betweenweek = start.plusMonths(Months);
		    	  for (int i = 0; i < maxlength; i++)
		    	  {     
		    		    betweenweek = start.plusMonths(Months).plusDays(i);
		    		    label.setText(betweenweek.format(dayFormatter));
					    Labels.get(i).setText(betweenweek.format(dayFormatter));
					    YearLabel.setText(Integer.toString(betweenweek.getYear()));
					    currentMonth = betweenweek.getMonth();
					    year = betweenweek;
						ab++;
						if(betweenweek.isLeapYear())
						{
							LeapYearLabel.setVisible(true);
						}
						else
					    if(!betweenweek.isLeapYear())
					    {
						    LeapYearLabel.setVisible(false);
					    }
						if (currentMonth == currentMonth.FEBRUARY)
						{
							if(year.isLeapYear())
							{
								Labels.get(29).setText("");
								Labels.get(30).setText("");
								Labels.get(31).setText("");
							}
							else
							if(!year.isLeapYear())
							{
								Labels.get(28).setText("");
								Labels.get(29).setText("");
								Labels.get(30).setText("");
								Labels.get(31).setText("");
							}
							}
						if (Labels.get(i) == null)
						{
							CalanderLabel label = new CalanderLabel();
							Labels.add(label);
						}
						else
						if (i < maxlength)
						{
							Labels.get(maxlength).setText("");
						}
						    System.out.println(i +". = "+maxlength);
				        if (Labels.get(markedLabel).getText().toString().equals(currentDate.format(dayFormatter)))
					    {
                            Labels.get(markedLabel).setStyle("-fx-background-color: #428aff");
					    }
					    else
						if (!Labels.get(i).getText().toString().equals(currentDate.format(dayFormatter)))
						{
                            Labels.get(markedLabel).setStyle(Labels.get(1).getStyle());
						}
		               }
		     Months++;
		     mMonths--;
		     System.out.println("mMonths = "+mMonths);
		     System.out.println("Months = "+Months);
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
					
                    LeapYearLabel.setVisible(false);
					System.out.println(betweenweek.getDayOfWeek());
					a++;
					if(betweenweek.isLeapYear())
					{
						LeapYearLabel.setVisible(true);
					}
					else
				    if(!betweenweek.isLeapYear())
				    {
					    LeapYearLabel.setVisible(false);
				    }
				} else 
					if (a <= maxlength)
				{
					// label.setText("TEST");
					Labels.add(label);
				}

			}
		}
		 switch(currentMonth)
	     {
	      case JANUARY:
	    	  selectTimeLabel.setText("Januar");
	    	  System.out.println("Januar");
	    	  break;
	      case FEBRUARY:
	    	  selectTimeLabel.setText("Februar");
	    	  System.out.println("Februar");
	    	  break;
	      case MARCH:
	    	  selectTimeLabel.setText("März");
	    	  System.out.println("März");
	    	  break;
	      case APRIL:
	    	  selectTimeLabel.setText("April");
	    	  System.out.println("April");
	    	  break;
	      case MAY:
	    	  selectTimeLabel.setText("Mai");
	    	  System.out.println("Mai");
	    	  break;
	      case JUNE:
	    	  selectTimeLabel.setText("Juni");
	    	  System.out.println("Juni");
	    	  break;
	      case JULY:
	    	  selectTimeLabel.setText("Juli");
	    	  System.out.println("Juli");
	    	  break;
	      case AUGUST:
	    	  selectTimeLabel.setText("August");
	    	  System.out.println("August");
	    	  break;
	      case SEPTEMBER:
	    	  selectTimeLabel.setText("September");
	    	  System.out.println("September");
	    	  break;
	      case OCTOBER:
	    	  selectTimeLabel.setText("Oktober");
	    	  System.out.println("Oktober");
	    	  break;
	      case NOVEMBER:
	    	  selectTimeLabel.setText("November");
	    	  System.out.println("November");
	    	  break;
	      case DECEMBER:
	    	  selectTimeLabel.setText("Dezember");
	    	  System.out.println("Dezember");
	    	  break;
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

	// Initialize the Calendar with all its components
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		selectTimeLabel.setText(Integer.toString(currentDate.getYear()));
		intitCalendar();
		markcurrentDate();
	}

}
