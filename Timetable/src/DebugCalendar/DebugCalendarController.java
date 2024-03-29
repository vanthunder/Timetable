package DebugCalendar;

import java.net.URL;
import java.util.ResourceBundle;

import javax.jws.soap.SOAPBinding.Use;
import javax.security.auth.callback.LanguageCallback;
import javax.xml.bind.ValidationEvent;
import static java.time.temporal.TemporalAdjusters.*;
import org.omg.CORBA.Current;

import com.sun.javafx.scene.control.skin.LabeledSkinBase;
import com.sun.media.jfxmedia.events.MarkerEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class DebugCalendarController implements Initializable
{
	@FXML
	private GridPane Calendar = new GridPane();
	@FXML
	private BorderPane PaneCalendar = new BorderPane();
	@FXML
	private final List<Label> Labels = new ArrayList<>();
	@FXML
	CalanderLabel label = new CalanderLabel();
	@FXML
	private Label MonthLabel;
	@FXML
	private Button NextYear;
	@FXML
	private Label YearLabel;
	// LocalDate Events
	private YearMonth actualYearMonth;
	private LocalDate currentDate = LocalDate.now();
	LocalDate startOfWeek = currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1);
	LocalDate endOfWeek = startOfWeek.plusDays(6);
	LocalDate start = currentDate.with(firstDayOfMonth());
	LocalDate end = currentDate.with(lastDayOfMonth());
	Month currentMonth = currentDate.getMonth();
	Month january = Month.JANUARY;
	Month february = Month.FEBRUARY;
	Month march = Month.MARCH;
	Month april = Month.APRIL;
	Month may = Month.MAY;
	Month june = Month.JUNE;
	Month july = Month.JULY;
	Month august = Month.AUGUST;
	Month september = Month.SEPTEMBER;
	Month october = Month.OCTOBER;
	Month november = Month.NOVEMBER;
	Month december = Month.DECEMBER;
	LocalDate crMonth = currentDate.withMonth(currentMonth.getValue());
	LocalDate year;
	// LocalDate helper integers;
	int maxlength = currentMonth.maxLength();
	int markedLabel = 0;
	int ab = 0;
	int Months = 1;
	int mMonths = 1;
	int CurrentYear = currentDate.getYear();
	int feb = february.maxLength();
	int currentMonthValue = currentMonth.getValue();
	

	DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("         E\n        d MMM");

	// Event Listener on Button[#LastYear].onAction
	@FXML
	public void LastYearPress(ActionEvent event)
	{
		if (ab == maxlength)
		{
			ab = 0;
		}	
		maxlength = currentMonth.maxLength();
		MonthLabel.setText(Integer.toString(CurrentYear++));
			 switch(currentMonth)
		     {
		      case JANUARY:
		    	  MonthLabel.setText("Dezember");
		    	  System.out.println("Januar");
		    	  maxlength = 31;
		    	  break;
		      case FEBRUARY:
		    	  MonthLabel.setText("Januar");
		    	  System.out.println("Februar");
		    	  maxlength = 31;
		    	  break;
		      case MARCH:
		    	  MonthLabel.setText("Februar");
		    	  System.out.println("M�rz");
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
		    	  MonthLabel.setText("M�rz");
		    	  System.out.println("April");
		    	  maxlength = 31;
		    	  break;
		      case MAY:
		    	  MonthLabel.setText("April");
		    	  System.out.println("Mai");
		    	  maxlength = 30;
		    	  break;
		      case JUNE:
		    	  MonthLabel.setText("Mai");
		    	  System.out.println("Juni");
		    	  maxlength = 31;
		    	  break;
		      case JULY:
		    	  MonthLabel.setText("Juni");
		    	  System.out.println("July");
		    	  maxlength = 30;
		    	  break;
		      case AUGUST:
		    	  MonthLabel.setText("July");
		    	  System.out.println("August");
		    	  maxlength = 31;
		    	  break;
		      case SEPTEMBER:
		    	  MonthLabel.setText("August");
		    	  System.out.println("September");
		    	  maxlength = 31;
		    	  break;
		      case OCTOBER:
		    	  MonthLabel.setText("September");
		    	  System.out.println("Oktober");
		    	  maxlength = 30;
		    	  break;
		      case NOVEMBER:
		    	  MonthLabel.setText("Oktober");
		    	  System.out.println("November");
		    	  maxlength = 31;
		    	  break;
		      case DECEMBER:
		    	  MonthLabel.setText("November");
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
			
			
			/*
			 * 
			 * 
			 * 
			 * maxlength = currentMonth.maxLength();
			if (!(ab == maxlength))
			{
				LocalDate betweenweek = start.minusMonths(mMonths).minusDays(i);
				//LocalDate betweenweek = currentMonth.minus(1);
				if (betweenweek.getMonth().toString().equals("FEBRUARY"))
				{
					maxlength = feb-1;
					Labels.get(28).setText("");
					Labels.get(29).setText("");
					Labels.get(30).setText("");
					Labels.get(31).setText("");
				}
				//if()
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
					else
				currentMonth = betweenweek.getMonth();
				label.setText(betweenweek.format(dayFormatter));
				Labels.get(i).setText(betweenweek.format(dayFormatter));
				
				System.out.println(betweenweek.getDayOfWeek());
				// label.setText(betweenweek.format(dayFormatter));
				// Labels.add(label);
				ab++;
				System.out.println("NOCHMAL");
				YearLabel.setText(Integer.toString(betweenweek.getYear()));
				MonthLabel.setText(betweenweek.getMonth().toString());
				if (Labels.get(i) == null)
				{
					CalanderLabel label = new CalanderLabel();
					Labels.add(label);
				}
				else
				if (i < maxlength)
				{
						System.out.println("TESTSETSETSTESTESTESETSETSETSETST");
						Labels.get(maxlength).setText("");
				}
					
					
						
				
		}
		
		*
		*
		*
		*/
		
		
		Months--;
		mMonths++;
		System.out.println("mMonths = "+mMonths);
		System.out.println("Months = "+Months);
		System.out.println("crMonth = "+ crMonth.getMonthValue());
		System.out.println("CurrentMonthValue = "+currentMonthValue);
		
	}

	// Event Listener on Button[#NextYear].onAction
	@FXML
	public void NextYearPress(ActionEvent event)
	{
		if (ab == maxlength)
		{
			ab = 0;
		}	
		maxlength = currentMonth.maxLength();
		MonthLabel.setText(Integer.toString(CurrentYear++));
			 switch(currentMonth)
		     {
		      case JANUARY:
		    	  MonthLabel.setText("Februar");
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
		    	  MonthLabel.setText("M�rz");
		    	  System.out.println("Februar");
		    	  maxlength = 31;
		    	  break;
		      case MARCH:
		    	  MonthLabel.setText("April");
		    	  System.out.println("M�rz");
		    	  maxlength = 30;
		    	  break;
		      case APRIL:
		    	  MonthLabel.setText("Mai");
		    	  System.out.println("April");
		    	  maxlength = 31;
		    	  break;
		      case MAY:
		    	  MonthLabel.setText("Juni");
		    	  System.out.println("Mai");
		    	  maxlength = 30;
		    	  break;
		      case JUNE:
		    	  MonthLabel.setText("Juli");
		    	  System.out.println("Juni");
		    	  maxlength = 31;
		    	  break;
		      case JULY:
		    	  MonthLabel.setText("August");
		    	  System.out.println("July");
		    	  maxlength = 31;
		    	  break;
		      case AUGUST:
		    	  MonthLabel.setText("September");
		    	  System.out.println("August");
		    	  maxlength = 30;
		    	  break;
		      case SEPTEMBER:
		    	  MonthLabel.setText("Oktober");
		    	  System.out.println("September");
		    	  maxlength = 31;
		    	  break;
		      case OCTOBER:
		    	  MonthLabel.setText("November");
		    	  System.out.println("Oktober");
		    	  maxlength = 30;
		    	  break;
		      case NOVEMBER:
		    	  MonthLabel.setText("Dezember");
		    	  System.out.println("November");
		    	  maxlength = 31;
		    	  break;
		      case DECEMBER:
		    	  MonthLabel.setText("Januar");
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
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * if (ab == maxlength)
		 *
		{
			ab = 0;
		}
		
		maxlength = currentMonth.maxLength();
		MonthLabel.setText(Integer.toString(CurrentYear++));
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
				MonthLabel.setText(betweenweek.getMonth().toString());
				if (Labels.get(i) == null)
				{
					CalanderLabel label = new CalanderLabel();
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
		*
		*
		*
		*
		*/
		Months++;
		mMonths--;
		System.out.println("mMonths = "+mMonths);
		System.out.println("Months = "+Months);
	}

	// Fills every row and column with a label. label itself contains the actual
	// date.
	public void calendar()
	{
		int a = 0;
		YearLabel.setText(Integer.toString(currentDate.getYear()));
		// currentDate.getYear();
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				currentDate.getYear();
				CalanderLabel label = new CalanderLabel();
				label.setTextAlignment(TextAlignment.CENTER);
				// label.setText(currentDate.format(dayFormatter));
				label.setTextAlignment(TextAlignment.CENTER);
				label.setAlignment(Pos.CENTER);
				Calendar.setAlignment(Pos.CENTER);
				label.setTextAlignment(TextAlignment.CENTER);
				Calendar.add(label, j, i);
				MonthLabel.setText(currentDate.getMonth().toString());
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

	public void markCurrentDate()
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

	/*
	 * Only for debug and testing
	 * 
	 * public void createCalendar() {
	 * 
	 * Calendar.setGridLinesVisible(true);
	 * //PaneCalendar.centerProperty().set(Calendar);
	 * 
	 * 
	 * for(int e = 1; e<8; e++) { for(int i = 1; i<6; i++) { if(i==1) {
	 * calenderLabel.setText("TEST"); Calendar.setConstraints(calenderLabel, e, i);
	 * Calendar.setRowIndex(calenderLabel, e); } else if(i==2) { //Calendar.add(new
	 * Label(e+7+ " test  "),e, i); Calendar.setConstraints(calenderLabel, e, i); }
	 * if(i==3) { //Calendar.add(new Label(e+14+ " test  "),e, i);
	 * Calendar.setConstraints(calenderLabel, e, i); } else if(i==4) {
	 * //Calendar.add(new Label(e+21+" test  "),e, i);
	 * Calendar.setConstraints(calenderLabel, e, i); } if(i==5) { if((e<=3)) {
	 * //Calendar.add(new Label(e+29+" test  "),e, i);
	 * Calendar.setConstraints(calenderLabel, e, i); } }
	 * Calendar.setStyle("-fx-background-color: black, white; ");
	 * Calendar.setNodeOrientation(NodeOrientation.INHERIT);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * } public void debugcreation() { GridPane gridPane = new GridPane();
	 * 
	 * }
	 */

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		MonthLabel.setText(Integer.toString(currentDate.getYear()));
		calendar();
		markCurrentDate();
		System.out.println(currentDate.format(dayFormatter) + "TEST     !!!!");
		//currentDate.plusMonths(1);
		System.out.println(currentDate.plusMonths(3));
		System.out.println(markedLabel);
	}
}
