package appointment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import note.Note;
import note.NoteOverview;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.security.auth.callback.LanguageCallback;

import calendar.Calendar;
import calendar.CalendarController;
import category.CategoriesController;
import category.Category;
import creator.Creator;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.CheckBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;

/**
 * 
 * @author Marc, Marvin 
 *
 */
public class AppointmentCreatorController implements Initializable {
	ObservableList<String> regularlyTypeList = FXCollections.observableArrayList("t�glich", "w�chentlich", "monatlich",
			"j�hrlich");

	// ObservableList<Note> notesChoiceList = FXCollections.observableArrayList();
	// ArrayList<Note> tempNotesList=NoteOverview.getNotesList();

	SpinnerValueFactory<Integer> dateFactoryStartHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
	SpinnerValueFactory<Integer> dateFactoryStartMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
	SpinnerValueFactory<Integer> dateFactoryEndHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
	SpinnerValueFactory<Integer> dateFactoryEndMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
	SpinnerValueFactory<Integer> regularlyAmountFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000,
			0);

	@FXML
	private TextField AppointmentTitle;
	@FXML
	private DatePicker AppointmentStartDate;
	@FXML
	private Spinner<Integer> AppointmentStartTimeMinutes;
	@FXML
	private Spinner<Integer> AppointmentStartTimeHours;
	@FXML
	private DatePicker AppointmentEndDate;
	@FXML
	private Spinner<Integer> AppointmentEndTimeMinutes;
	@FXML
	private Spinner<Integer> AppointmentEndTimeHours;
	@FXML
	private CheckBox AppointmentRegularlyOnOff;
	@FXML
	private ChoiceBox AppointmentRegularlyType;
	@FXML
	private Spinner<Integer> AppointmentRegularlyAmount;
	@FXML
	private Label AppointmentRegularlyAmountLabel;
	@FXML
	private CheckBox AppointmentAllDay;
	@FXML
	private TextArea AppointmentDescription;
	@FXML
	private Button AppointmentSave;
	@FXML
	private ChoiceBox<TreeItem<String>> chooseCategory = new ChoiceBox<>();
	Image icon = new Image(getClass().getResourceAsStream("/images/Kalender.png"));

	
	

	// Event Listener on Button[#AppointmentSave].onAction
	@FXML
	public void appointmentSavePress(ActionEvent event) throws CloneNotSupportedException, IOException {

		Appointment serObj = new Appointment("Stupid Appointment", null, null, false, false, 0, 0, "Some stupid text",
				0, null, false);

		

		
		// Save the current Category
		if (!chooseCategory.getSelectionModel().getSelectedItem().equals(null)) {
			TreeItem<String> savePosition = chooseCategory.getSelectionModel().getSelectedItem();
			TreeItem<String> newItem = new TreeItem<String>("Termin: " + AppointmentTitle.getText(),
					new ImageView(icon));
			CategoriesController.insertCategoryByCreator(savePosition, newItem);
		}

		// Save the appointment
		LocalDate save = AppointmentEndDate.getValue();
		CalendarController.addAppointment(save, AppointmentTitle.getText());
		String title = AppointmentTitle.getText();
		LocalDateTime startpoint = LocalDateTime.of(AppointmentStartDate.getValue(),
				LocalTime.of(AppointmentStartTimeHours.getValueFactory().getValue(),
						AppointmentStartTimeMinutes.getValueFactory().getValue()));
		LocalDateTime endpoint = LocalDateTime.of(AppointmentEndDate.getValue(),
				LocalTime.of(AppointmentEndTimeHours.getValueFactory().getValue(),
						AppointmentEndTimeMinutes.getValueFactory().getValue()));
		boolean allDay = AppointmentAllDay.isSelected();
		boolean regularlyOnOff = AppointmentRegularlyOnOff.isSelected();
		String regularlyTypeString = (String) AppointmentRegularlyType.getValue();
		int regularlyType = 10;
		if (regularlyTypeString == "t�glich") {
			regularlyType = 0;
		} else if (regularlyTypeString == "w�chentlich") {
			regularlyType = 1;
		} else if (regularlyTypeString == "monatlich") {
			regularlyType = 2;
		} else if (regularlyTypeString == "j�hrlich") {
			regularlyType = 3;
		}
		int regularlyAmount = AppointmentRegularlyAmount.getValue();
		String description = AppointmentDescription.getText();
		int notesPinned =
		0;
		ArrayList<Note> notesLink =
		null;
		boolean floating =
		false;
		if (startpoint == endpoint || endpoint.isBefore(startpoint) || startpoint == null || endpoint == null) {
			floating = true;
		}
		 TreeItem<String> chosenCategory = chooseCategory.getSelectionModel().getSelectedItem();

		System.out.println(regularlyTypeString + regularlyType);
		Creator.createAppointment(title, startpoint, endpoint, allDay, regularlyOnOff, regularlyType, regularlyAmount,
				description, notesPinned, notesLink, floating);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for (int i = 0; i < CategoriesController.getMainCategories().size(); i++) {
			chooseCategory.getItems().addAll(CategoriesController.getMainCategories().get(i));
		}
        /*
		 * for(int i=0; i<tempNotesList.size(); i++){
		 * notesChoiceList.add(tempNotesList.get(i)); } if
		 * (NoteOverview.getNotesList().get(0) != null) {
		 * AppoinmentPinNote1.setItems(notesChoiceList);
		 * AppoinmentPinNote2.setItems(notesChoiceList);
		 * AppoinmentPinNote3.setItems(notesChoiceList); }
		 */

		AppointmentStartTimeHours.setValueFactory(dateFactoryStartHours);
		AppointmentEndTimeHours.setValueFactory(dateFactoryEndHours);
		AppointmentStartTimeMinutes.setValueFactory(dateFactoryStartMinutes);
		AppointmentEndTimeMinutes.setValueFactory(dateFactoryEndMinutes);
		AppointmentRegularlyAmount.setValueFactory(regularlyAmountFactory);

		AppointmentRegularlyType.setItems(regularlyTypeList);

		AppointmentRegularlyOnOff.selectedProperty().bindBidirectional(AppointmentRegularlyType.visibleProperty());
		AppointmentRegularlyOnOff.selectedProperty().bindBidirectional(AppointmentRegularlyAmount.visibleProperty());
		AppointmentRegularlyOnOff.selectedProperty()
				.bindBidirectional(AppointmentRegularlyAmountLabel.visibleProperty());
		AppointmentRegularlyOnOff.setSelected(false);
	}
}
