package task;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import creator.Creator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseDragEvent;
import note.Note;
import task.AutoSort;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.ChoiceBox;

public class CreateTaskController implements Initializable {
	Task newTask;
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
	private DatePicker pickPeriodStart;

	@FXML
	private Spinner<Integer> periodStartHour;

	@FXML
	private Spinner<Integer> periodStartMinute;

	@FXML
	private DatePicker pickPeriodEnd;

	@FXML
	private Spinner<Integer> periodEndHour;

	@FXML
	private Spinner<Integer> periodEndMinute;

	@FXML
	private ChoiceBox<TreeItem<String>> categoryChooser = new ChoiceBox<>();

	private static final int INIT_VALUE_HOURS = 1;
	private static final int INIT_VALUE_MINUTES = 1;
	private static final int INIT_VALUE_START_HOURS = 8;
	private static final int INIT_VALUE_START_MINUTES = 0;
	private static final int INIT_VALUE_END_HOURS = 20;
	private static final int INIT_VALUE_END_MINUTES = 0;
	private static final int INIT_VALUE_PERIOD_START_HOURS = 8;
	private static final int INIT_VALUE_PERIOD_START_MINUTES = 0;
	private static final int INIT_VALUE_PERIOD_END_HOURS = 20;
	private static final int INIT_VALUE_PERIOD_END_MINUTES = 0;
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
	SpinnerValueFactory<Integer> dateFactoryperiodStartHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23,
			0);
	SpinnerValueFactory<Integer> dateFactoryperiodStartMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,
			59, 0);
	SpinnerValueFactory<Integer> dateFactoryperiodEndHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23,
			0);
	SpinnerValueFactory<Integer> dateFactoryperiodEndMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59,
			0);

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
		autoSort = this.autoSortOnOff.isSelected();
	}

	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void saveTask(ActionEvent event) {

//		 This method saves the current Task and it's title as a category if a category
//		 is choosed in the choice box.
//		if (!categoryChooser.getSelectionModel().getSelectedItem().equals(null))
//
//		{
//			TreeItem<String> savePosition = categoryChooser.getSelectionModel().getSelectedItem();
//			TreeItem<String> newItem = new TreeItem<String>("Aufgabe: " + title.toString(), new ImageView(icon));
//			CategoriesController.insertCategoryByCreator(savePosition, newItem);
//		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		startHour.setValueFactory(dateFactoryStartHours);
		endHour.setValueFactory(dateFactoryEndHours);
		startMinute.setValueFactory(dateFactoryStartMinutes);
		endMinute.setValueFactory(dateFactoryEndMinutes);
		periodStartHour.setValueFactory(dateFactoryperiodStartHours);
		periodStartMinute.setValueFactory(dateFactoryperiodStartMinutes);
		periodEndHour.setValueFactory(dateFactoryperiodEndHours);
		periodEndMinute.setValueFactory(dateFactoryperiodEndMinutes);

		dateFactoryStartHours.setValue(INIT_VALUE_START_HOURS);
		dateFactoryStartHours.setValue(INIT_VALUE_END_HOURS);
		dateFactoryStartMinutes.setValue(INIT_VALUE_START_MINUTES);
		dateFactoryStartMinutes.setValue(INIT_VALUE_END_MINUTES);
		dateFactoryperiodStartHours.setValue(INIT_VALUE_PERIOD_START_HOURS);
		dateFactoryperiodStartMinutes.setValue(INIT_VALUE_PERIOD_START_MINUTES);
		dateFactoryperiodEndHours.setValue(INIT_VALUE_PERIOD_END_HOURS);
		dateFactoryperiodEndMinutes.setValue(INIT_VALUE_PERIOD_END_MINUTES);

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

		int regularType = 3;
		if (this.choiceRegular.getSelectionModel().getSelectedItem() == "taeglich") {
			regularType = 0;
		} else if (this.choiceRegular.getSelectionModel().getSelectedItem() == "woechentlich") {
			regularType = 1;
		} else if (this.choiceRegular.getSelectionModel().getSelectedItem() == "monatlich") {
			regularType = 2;
		}

		// Inserts the Categories to the choice box.
		for (int i = 0; i < CategoriesController.getMainCategories().size(); i++) {
			categoryChooser.getItems().addAll(CategoriesController.getMainCategories().get(i));

		}
		if (saveButton.isPressed()) {

			// set startPoint
			LocalTime startTime = LocalTime.of(startHour.getValueFactory().getValue(),
					startMinute.getValueFactory().getValue());
			LocalDate startDate = pickStart.getValue();
			LocalDateTime startpoint = startDate.atTime(startTime);

			// set endpoint
			LocalTime endTime = LocalTime.of(endHour.getValueFactory().getValue(),
					endMinute.getValueFactory().getValue());
			endTime.withHour(endHour.getValueFactory().getValue());
			LocalDate endDate = pickEnd.getValue();
			LocalDateTime endpoint = endDate.atTime(endTime);

//			set allDay 
			boolean allDay = false;

//			set duration
			int duration = INIT_VALUE_HOURS;

//			initialize RegularID
			int regularID = Creator.getRegularlyID();

			ArrayList<Note> notesLinks = null;
			boolean floating = false;
			int notesPinned = 0;
			
			if (!categoryChooser.getSelectionModel().getSelectedItem().equals(null))

			{
				TreeItem<String> savePosition = categoryChooser.getSelectionModel().getSelectedItem();
				TreeItem<String> newItem = new TreeItem<String>("Aufgabe: " + title.toString(), new ImageView(icon));
				CategoriesController.insertCategoryByCreator(savePosition, newItem);
			
		}
			
			if (!autoSort) {

				try {
					if (!autoSort) {
						Creator.createTask(title.getText(), null, startpoint, endpoint, allDay,
								regularOnOff.isSelected(), regularType, regularID, description.getText(), notesPinned,
								notesLinks, floating, autoSort, duration);
					
					} else if (autoSort) {
						Task thisTask =new Task(title.getText(), null, startpoint, allDay,
								regularOnOff.isSelected(), regularType, regularID, description.getText(), notesPinned,
								notesLinks, floating, autoSort, duration);
						AutoSort.autoSort(thisTask);
						System.out.println(thisTask);
					}
					

				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
