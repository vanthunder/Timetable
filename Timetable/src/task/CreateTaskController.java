package task;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import category.CategoriesController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseDragEvent;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ChoiceBox;

public class CreateTaskController implements Initializable {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField title;
	@FXML
	private TextField description;
	@FXML
	private DatePicker pickStart;
	@FXML
	private DatePicker pickEnd;
	@FXML
	private TextField hoursField;
	@FXML
	private TextField minutesField;
	@FXML
	private Spinner<Integer> startHour;
	@FXML
	private Spinner<Integer> endHour;
	@FXML
	private Spinner<Integer> startMinute;
	@FXML
	private Spinner<Integer> endMinute;
	@FXML
	private Slider durationHours;
	@FXML
	private Slider durationMinutes;
	@FXML
	private CheckBox regularOnOff;
	@FXML
	private ChoiceBox<String> choiceRegular;
	@FXML
	private CheckBox autoSortOnOff;
	@FXML
	private Button saveButton;
	@FXML
	private Button updateStartButton;
	@FXML
	private Button updateEndButton;

	@FXML
	private ChoiceBox<TreeItem<String>> categoryChooser = new ChoiceBox<>();

	private static final int INIT_VALUE_HOURS = 1;
	private static final int INIT_VALUE_MINUTES = 1;
	private static final int INIT_VALUE_START_HOURS = 8;
	private static final int INIT_VALUE_START_MINUTES = 0;
	private static final int INIT_VALUE_END_HOURS = 20;
	private static final int INIT_VALUE_END_MINUTES = 0;
	private static int INIT_SLIDER_DURATION;

	boolean regularlyOnOff;
	boolean autoSort = true;
	LocalTime endTime = null;
	LocalTime startTime = null;

	Image icon = new Image(getClass().getResourceAsStream("/images/AufgabeIcon.png"));

	ObservableList<String> regularlyType = FXCollections.observableArrayList("taeglich", "woechentlich", "monatlich");

	SpinnerValueFactory<Integer> dateFactoryStartHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
	SpinnerValueFactory<Integer> dateFactoryStartMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
	SpinnerValueFactory<Integer> dateFactoryEndHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
	SpinnerValueFactory<Integer> dateFactoryEndMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);

	// Event Listener on TextField[#hoursField].onAction
	@FXML
	public void hoursField(ActionEvent event) {
		INIT_SLIDER_DURATION = Integer.valueOf(hoursField.getText()) * 60 + Integer.valueOf(minutesField.getText());

	}

	// Event Listener on TextField[#minutesField].onAction
	@FXML
	public void minutesField(ActionEvent event) {
		INIT_SLIDER_DURATION = Integer.valueOf(hoursField.getText()) * 60 + Integer.valueOf(minutesField.getText());
	}

	// Event Listener on Slider[#durationSlider].onMouseDragReleased
	@FXML
	public void slideDuration(MouseDragEvent event) {
		INIT_SLIDER_DURATION = Integer.valueOf(hoursField.getText()) * 60 + Integer.valueOf(minutesField.getText());
	}

	// Event Listener on CheckBox[#regularOnOff].onAction
	@FXML
	public void regularSwitch(ActionEvent event) {
		regularlyOnOff = regularOnOff.isSelected();
	}

	@FXML
	void updateEnd(ActionEvent event) {

		endHour.getValueFactory().setValue(startHour.getValueFactory().getValue() + (int) durationHours.getValue());
		endMinute.getValueFactory()
				.setValue(startMinute.getValueFactory().getValue() + (int) durationMinutes.getValue());
	}

	@FXML
	void updateStart(ActionEvent event) {

		startHour.getValueFactory().setValue(endHour.getValueFactory().getValue() - (int) durationHours.getValue());
		startMinute.getValueFactory()
				.setValue(endMinute.getValueFactory().getValue() - (int) durationMinutes.getValue());
	}

	@FXML
	public void autosortSwitch(ActionEvent event) {
		autoSort = this.regularOnOff.isSelected();
	}

	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void saveTask(ActionEvent event) {
		String titleText = this.title.getText();
		String filepath = null;
		int duration = INIT_SLIDER_DURATION;

		LocalDate startDate = this.pickStart.getValue();
		LocalDate endDate = this.pickEnd.getValue();

		startTime.withHour(new Integer(startHour.getValueFactory().getValue()));
		startTime.withMinute(new Integer(startMinute.getValueFactory().getValue()));

		endTime.withHour(new Integer(endHour.getValueFactory().getValue()));
		endTime.withMinute(new Integer(endMinute.getValueFactory().getValue()));

		LocalDateTime startpoint = startTime.atDate(startDate);
		LocalDateTime endpoint = endTime.atDate(endDate);

		int regularType;
		if (this.choiceRegular.getSelectionModel().getSelectedItem() == "taeglich") {
			regularType = 0;
		} else if (this.choiceRegular.getSelectionModel().getSelectedItem() == "woechentlich") {
			regularType = 1;
		} else if (this.choiceRegular.getSelectionModel().getSelectedItem() == "monatlich") {
			regularType = 2;
		} else {
			regularType = 3;
		}

		String descriptionText = this.description.getText();
		int notesPinned = 0;
		ArrayList<note.Note> notesLink = null;
		boolean done = false;
		LocalDateTime periodStart = null;
		LocalDateTime periodEnd = null;
		boolean allDay = false;
		boolean alarmOnOff = false;
		LocalDateTime alarmTime = null;
		int regularlyID = 0;
		boolean floating = false;
		Task newTask = new Task(titleText, filepath, startpoint, endpoint, periodStart, periodEnd, allDay,
				regularlyOnOff, regularType, regularlyID, descriptionText, notesPinned, notesLink, floating, autoSort,
				duration, done);

		if (!autoSort) {

//					titleText, filepath, startpoint, endpoint, allDay, regularlyOnOff, regularType,
//					regularlyID, descriptionText, alarmOnOff, alarmTime, notesPinned, notesLink, floating, autoSort,
//					duration, done
		} else {

		}

		// This method saves the current Task and it's title as a category if a category
		// is choosed in the choice box.
		if (!categoryChooser.getSelectionModel().getSelectedItem().equals(null))

		{
			TreeItem<String> savePosition = categoryChooser.getSelectionModel().getSelectedItem();
			TreeItem<String> newItem = new TreeItem<String>("Aufgabe: " + title.toString(), new ImageView(icon));
			CategoriesController.insertCategoryByCreator(savePosition, newItem);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.startHour.setValueFactory(dateFactoryStartHours);
		this.endHour.setValueFactory(dateFactoryEndHours);
		this.startMinute.setValueFactory(dateFactoryStartMinutes);
		this.endMinute.setValueFactory(dateFactoryEndMinutes);

		dateFactoryStartHours.setValue(INIT_VALUE_START_HOURS);
		dateFactoryStartHours.setValue(INIT_VALUE_END_HOURS);
		dateFactoryStartMinutes.setValue(INIT_VALUE_START_MINUTES);
		dateFactoryStartMinutes.setValue(INIT_VALUE_END_MINUTES);

		choiceRegular.setVisible(false);
		regularOnOff.setSelected(false);

		while (regularOnOff.isSelected() == true) {
			choiceRegular.setVisible(true);
		}

		choiceRegular.setItems(regularlyType);

		durationHours.setValue(INIT_VALUE_HOURS);
		durationMinutes.setValue(INIT_VALUE_MINUTES);

		hoursField.setText(new Integer(INIT_VALUE_HOURS).toString());
		minutesField.setText(new Integer(INIT_VALUE_MINUTES).toString());

		startHour.getValueFactory().setValue(INIT_VALUE_START_HOURS);
		startMinute.getValueFactory().setValue(INIT_VALUE_START_MINUTES);
		endHour.getValueFactory().setValue((INIT_VALUE_END_HOURS));
		endMinute.getValueFactory().setValue((INIT_VALUE_END_MINUTES));
		autoSortOnOff.selectedProperty().set(autoSort);

		regularOnOff.selectedProperty().bindBidirectional(choiceRegular.visibleProperty());
		hoursField.textProperty().bindBidirectional(durationHours.valueProperty(), NumberFormat.getNumberInstance());
		minutesField.textProperty().bindBidirectional(durationMinutes.valueProperty(),
				NumberFormat.getNumberInstance());
		autoSortOnOff.selectedProperty().bindBidirectional(startHour.disableProperty());
		autoSortOnOff.selectedProperty().bindBidirectional(startMinute.disableProperty());
		autoSortOnOff.selectedProperty().bindBidirectional(endHour.disableProperty());
		autoSortOnOff.selectedProperty().bindBidirectional(endMinute.disableProperty());
		autoSortOnOff.selectedProperty().bindBidirectional(pickStart.disableProperty());
		autoSortOnOff.selectedProperty().bindBidirectional(pickEnd.disableProperty());
		
		autoSortOnOff.setSelected(true);

		// Inserts the Categories to the choice box.
		for (int i = 0; i < CategoriesController.getMainCategories().size(); i++) {
			categoryChooser.getItems().addAll(CategoriesController.getMainCategories().get(i));
		}
	}
}
