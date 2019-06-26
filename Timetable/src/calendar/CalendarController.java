package calendar;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.scene.control.skin.LabeledSkinBase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import DebugCalendar.CalanderLabel;
import javafx.fxml.Initializable;

/**
 * @author Marvin
 *
 *
 */

public class CalendarController implements Initializable

{    
	@FXML
    private ScrollPane taskList;
    @FXML
    private static HBox taskBox;
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
	private final static List<Label> Labels = new ArrayList<>();
	@FXML
	CalendarLabel label = new CalendarLabel();
	@FXML
	private Label LeapYearLabel;
	String Month = new String("Monat");
	String Day = new String("Tag");
	// AppointmentList
	// private final static HashMap<LocalDate, <String> appointments = new
	// HashMap<>();
	private static ArrayList<LocalDate> appointments = new ArrayList<>();

	public static ArrayList<LocalDate> getAppointments()
	{
		return appointments;
	}

	public static void setAppointments(ArrayList<LocalDate> appointments)
	{
		CalendarController.appointments = appointments;
	}

	public static ArrayList<String> getDescriptions()
	{
		return descriptions;
	}

	public static void setDescriptions(ArrayList<String> descriptions)
	{
		CalendarController.descriptions = descriptions;
	}

	private static ArrayList<String> descriptions = new ArrayList<>();
	// LocalDate Events
	private LocalDate currentDate = LocalDate.now();
	LocalDate startOfWeek = currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1);
	LocalDate endOfWeek = startOfWeek.plusDays(6);
	LocalDate start = currentDate.with(firstDayOfMonth());
	LocalDate end = currentDate.with(lastDayOfMonth());
	Month currentMonth = currentDate.getMonth();
	LocalDate crMonth = currentDate.withMonth(currentMonth.getValue());
	LocalDate year;
	LocalDate a = LocalDate.of(currentDate.getYear(), 2, 1);
	static LocalDate cacheDate;
	// ints that are needed for further calculation
	int maxlength = currentMonth.maxLength();
	int markedLabel = 0;
	int ab = 0;
	int Months = 1;
	int mMonths = 1;
	int CurrentYear = currentDate.getYear();
	int counter = 0;
	int backCounter = 2;
	int feb = a.getMonth().maxLength();// february.maxLength();
	// Color Strings
	static String AppointmentColor = "-fx-background-color: #b4ff96;";
	static String ResetColor = "-fx-background-color: White;";
	// Formats the date and time
	static DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("         E\n        d MMMM");

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

	// Event Listener on Button[#downLeftButton].onAction Switches back to the
	// previous Month
	@FXML
	public void dlbPress(ActionEvent event)
	{
		if (ab == maxlength)
		{
			ab = 0;
		}
		maxlength = currentMonth.maxLength();
		selectTimeLabel.setText(Integer.toString(CurrentYear++));
		switch (currentMonth)
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
			if (year.isLeapYear())
			{
				maxlength = 29;
				System.out.println("true");
			} else if (!year.isLeapYear())
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
			cacheDate = betweenweek;
			label.setText(betweenweek.format(dayFormatter));
			Labels.get(i).setText(betweenweek.format(dayFormatter));
			YearLabel.setText(Integer.toString(betweenweek.getYear()));
			currentMonth = betweenweek.getMonth();
			year = betweenweek;
			ab++;
			if (betweenweek.isLeapYear())
			{
				LeapYearLabel.setVisible(true);
			} else if (!betweenweek.isLeapYear())
			{
				LeapYearLabel.setVisible(false);
			}
			if (currentMonth == currentMonth.FEBRUARY)
			{
				if (year.isLeapYear())
				{
					Labels.get(29).setText("");
					Labels.get(30).setText("");
					Labels.get(31).setText("");
				} else if (!year.isLeapYear())
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
			} else
			// Resets the label if the array size do not fit the month size
			if (i < maxlength)
			{
				Labels.get(maxlength).setText("");
			}
			System.out.println(i + ". = " + maxlength);
			// marks the current date
			if (Labels.get(markedLabel).getText().toString().equals(currentDate.format(dayFormatter)))
			{
				Labels.get(markedLabel).setStyle("-fx-background-color: #428aff");
			} else if (!Labels.get(i).getText().toString().equals(currentDate.format(dayFormatter)))
			{
				Labels.get(markedLabel).setStyle(Labels.get(1).getStyle());
			}
			for (int a = 0; a < appointments.size(); a++)
			{
				if (betweenweek.format(dayFormatter).equals(appointments.get(a).format(dayFormatter)))
				{
					Labels.get(i).setStyle(AppointmentColor);
					Labels.get(i).setText("\n" + Labels.get(i).getText() + "\n" + " " + descriptions.get(a));
					break;
				}
				if (!betweenweek.format(dayFormatter).equals(appointments.get(a).format(dayFormatter)))
				{
					Labels.get(i).setStyle(Labels.get(1).getStyle());
				}
			}
		}
		Months--;
		mMonths++;
		System.out.println("mMonths = " + mMonths);
		System.out.println("Months = " + Months);
		System.out.println("crMonth = " + crMonth.getMonthValue());
		System.out.println("CurrentMonthValue = " + currentMonth.getValue());
		System.out.println("Counter = " + counter);
		System.out.println("Backcounter = " + backCounter);
		System.out.println("drbCounter = " + counter);
	}

	// Event Listener on Button[#downRigtButton].onAction Switches forward to the
	// next Month
	@FXML
	public void drbPress(ActionEvent event)
	{
		if (ab == maxlength)
		{
			ab = 0;
		}

		maxlength = currentMonth.maxLength();
		selectTimeLabel.setText(Integer.toString(CurrentYear++));
		switch (currentMonth)
		{
		case JANUARY:
			selectTimeLabel.setText("Februar");
			System.out.println("Januar");
			if (year.isLeapYear())
			{
				maxlength = 29;
				System.out.println("true");
			} else if (!year.isLeapYear())
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
			cacheDate = betweenweek;
			label.setText(betweenweek.format(dayFormatter));
			Labels.get(i).setText(betweenweek.format(dayFormatter));
			YearLabel.setText(Integer.toString(betweenweek.getYear()));
			currentMonth = betweenweek.getMonth();
			year = betweenweek;
			ab++;
			if (betweenweek.isLeapYear())
			{
				LeapYearLabel.setVisible(true);
			} else if (!betweenweek.isLeapYear())
			{
				LeapYearLabel.setVisible(false);
			}
			if (currentMonth == currentMonth.FEBRUARY)
			{
				if (year.isLeapYear())
				{
					Labels.get(29).setText("");
					Labels.get(30).setText("");
					Labels.get(31).setText("");
				} else if (!year.isLeapYear())
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
			} else if (i < maxlength)
			{
				Labels.get(maxlength).setText("");
			}
			System.out.println(i + ". = " + maxlength);
			if (Labels.get(markedLabel).getText().toString().equals(currentDate.format(dayFormatter)))
			{
				Labels.get(markedLabel).setStyle("-fx-background-color: #428aff");
			} else if (!Labels.get(i).getText().toString().equals(currentDate.format(dayFormatter)))
			{
				Labels.get(markedLabel).setStyle(Labels.get(1).getStyle());
			}
			for (int a = 0; a < appointments.size(); a++)
			{
				if (betweenweek.format(dayFormatter).equals(appointments.get(a).format(dayFormatter)))
				{
					Labels.get(i).setStyle(AppointmentColor);
					Labels.get(i).setText("\n" + Labels.get(i).getText() + "\n" + " " + descriptions.get(a));
					break;
				}
				if (!betweenweek.format(dayFormatter).equals(appointments.get(a).format(dayFormatter)))
				{
					Labels.get(i).setStyle(Labels.get(1).getStyle());
				}
			}
		}
		Months++;
		mMonths--;
		System.out.println("mMonths = " + mMonths);
		System.out.println("Months = " + Months);
		System.out.println("Size = " + appointments.size());
		System.out.println("counter = " + counter);
		System.out.println("Backcounter = " + backCounter);
	}

	// Initialize the calendar
	public void intitCalendar()
	{
		int a = 0;
		YearLabel.setText(Integer.toString(currentDate.getYear()));
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
					if (betweenweek.isLeapYear())
					{
						LeapYearLabel.setVisible(true);
					} else if (!betweenweek.isLeapYear())
					{
						LeapYearLabel.setVisible(false);
					}
				} else if (a <= maxlength)
				{
					Labels.add(label);
				}

			}
		}
		switch (currentMonth)
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

	// Marks the current date with a blue label
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

	// Static method gets called by the Appointmentscreator, to create an
	// appointment
	public static void addAppointment(LocalDate newAppointment, String description)
	{
		for (int i = 0; i < 32; i++)
		{
			if (Labels.get(i).getText().equals(newAppointment.format(dayFormatter)))
			{
				Labels.get(i).setStyle(AppointmentColor);
				Labels.get(i).setText("\n" + Labels.get(i).getText() + "\n" + " " + description);
				System.out.println(appointments + " = " + description);
			}
		}
		appointments.add(newAppointment);
		descriptions.add(description);
		System.out.println(appointments + " = " + description);
	}

	// Static Method gets called by the Category Controller, to erase an appointment
	public static void eraseAppointment(String compare)
	{

		for (int i = 0; i < Labels.size(); i++)
		{
			for (int a = 0; a < appointments.size(); a++)
			{
				if (Labels.get(i).getText().contains(compare))
				{
					Labels.get(i).setStyle(Labels.get(1).getStyle());
					Labels.get(i).setText(Labels.get(i).getText().replace(compare, ""));
					System.out.println("Hey das ist wahr");
				}

			}
		}
		for (int i = 0; i < appointments.size(); i++)
		{
			if (compare.equals(descriptions.get(i)))
			{
				descriptions.remove(i);
				appointments.remove(i);
			}
		}
	}

	// Static Method gets called by the Category Controller, to edit an appointment
	public static void editAppointment(String oldName, String newName)
	{
		for (int i = 0; i < Labels.size(); i++)
		{
			for (int a = 0; a < appointments.size(); a++)
			{
				if (Labels.get(i).getText().contains(oldName))
				{
					String oldNameCache = new String();
					oldNameCache = Labels.get(i).getText();
					String newNameCache = new String();
					newNameCache = newName.replace("Termin: ", "");
					String subCache = new String();
					subCache = oldNameCache.replace(oldName, "") + newNameCache;
					Labels.get(i).setText(Labels.get(i).getText().replace(oldName, "") + newName);
					System.out.println("Hey das ist wahr" + oldName + " - " + newName + " " + "newNameCache = "
							+ newNameCache + " " + " oldNameCache = " + oldNameCache + " " + "subCache = " + subCache);
					if (descriptions.get(a).contains(oldName))
					{
						descriptions.set(a, newName);
					}
				}

			}
		}
		for (int i = 0; i < appointments.size(); i++)
		{
			if (descriptions.get(i).contains(oldName))
			{
				descriptions.set(i, newName);
			}
		}
		System.out.println("Hey das ist wahr " + oldName + " " + newName);
	}
//	add new Button to Task Tab
	public static void taskList (Button newbtn) {
		taskBox.getChildren().add(newbtn);
		System.out.println("button created");
		
	}

	// Initialize the Calendar with all its components
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		selectTimeLabel.setText(Integer.toString(currentDate.getYear()));
		intitCalendar();
		markcurrentDate();
		// init some test appointments
		// addAppointment(crMonth = crMonth.plusDays(2), "Termin: Kino um 20:00 Uhr");
		// addAppointment(crMonth = crMonth.plusMonths(2).plusDays(20), "1Termin: Kino
		// um 20:00 Uhr");
		// addAppointment(crMonth = crMonth.plusMonths(2).plusDays(10), "2Termin: Kino
		// um 20:00 Uhr");
		// addAppointment(crMonth = crMonth.plusMonths(3).plusDays(3), "2Termin: Kino um
		// 20:00 Uhr");
		System.out.println("Das Datum lautet = " + crMonth.format(dayFormatter));
	}
	


}
