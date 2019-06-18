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
	private TextField title;
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
	private Slider durationSlider;
	@FXML
	private Slider durationSlider1;
	@FXML
	private CheckBox regularOnOff;
	@FXML
	private ChoiceBox<String> choiceRegular;
	@FXML
	private CheckBox autoSortOnOff;
	@FXML
	private Button saveButton;
	@FXML
	private ChoiceBox<TreeItem<String>> categoryChooser = new ChoiceBox<>();
	

	// Event Listener on TextField[#hoursField].onAction
	@FXML
	public void hoursField(ActionEvent event) {

		
	}
	// Event Listener on TextField[#minutesField].onAction
	@FXML
	public void minutesField(ActionEvent event) {

	}
	// Event Listener on Slider[#durationSlider].onMouseDragReleased
	@FXML
	public void slideDuration(MouseDragEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on CheckBox[#regularOnOff].onAction
	@FXML
	public void regularSwitch(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on CheckBox[#autoSortOnOff].onAction
	@FXML
	public void autosortSwitch(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void saveTask(ActionEvent event) 
	{
		// TODO Autogenerated
		//This method saves the current Note and it's title as a category if a category is choosed in the choice box.
		if(!categoryChooser.getSelectionModel().getSelectedItem().equals(null))
		{		
		  TreeItem<String> savePosition = categoryChooser.getSelectionModel().getSelectedItem();
		  TreeItem<String> newItem = new TreeItem<String>("Aufgabe: "+title.getText(), new ImageView(icon));
		  CategoriesController.insertCategoryByCreator(savePosition, newItem);
		}
	}


	Image icon = new Image(getClass().getResourceAsStream("/images/Aufgabe.png"));
	
	ObservableList<String> regularlyType= FXCollections.observableArrayList("täglich", "wöchentlich", "monatlich");

	
	public static final int INIT_VALUE_HOURS = 1;
	public static final int INIT_VALUE_MINUTES = 1;
	public static final int INIT_VALUE_START_HOURS = 8;
	public static final int INIT_VALUE_START_MINUTES = 0;
	public static final int INIT_VALUE_END_HOURS = 20;
	public static final int INIT_VALUE_END_MINUTES = 0;
	LocalDate startDate;
	LocalDate endDate;
	SpinnerValueFactory<Integer> dateFactoryHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,23,0);
	SpinnerValueFactory<Integer> dateFactoryMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		
		this.startHour.setValueFactory(dateFactoryHours);
		this.endHour.setValueFactory(dateFactoryHours);
		this.startMinute.setValueFactory(dateFactoryMinutes);
		this.endMinute.setValueFactory(dateFactoryMinutes);
		
		final Spinner<Integer> startHours = new Spinner<Integer>();
		dateFactoryHours.setValue(INIT_VALUE_START_HOURS);
		final Spinner<Integer> endHours = new Spinner<Integer>();
		dateFactoryHours.setValue(INIT_VALUE_END_HOURS);
		final Spinner<Integer> startMinutes = new Spinner<Integer>();
		dateFactoryMinutes.setValue(INIT_VALUE_START_MINUTES);
		final Spinner<Integer> endMinutes = new Spinner<Integer>();
		dateFactoryMinutes.setValue(INIT_VALUE_END_MINUTES);
		
		
		dateFactoryHours.setWrapAround(true);
		dateFactoryHours.setWrapAround(true);
		dateFactoryMinutes.setWrapAround(true);
		dateFactoryMinutes.setWrapAround(true);
		
		
		choiceRegular.setVisible(false);
		regularOnOff.setSelected(false);
			
		if(regularOnOff.isSelected()==true)	
		{
			choiceRegular.setVisible(true);
		}	
		
		choiceRegular.setItems(regularlyType);
		
		durationSlider.setValue(INIT_VALUE_HOURS);
		durationSlider1.setValue(INIT_VALUE_MINUTES);

		hoursField.setText(new Integer(INIT_VALUE_HOURS).toString());
		minutesField.setText(new Integer(INIT_VALUE_MINUTES).toString());
		
		startHours.getValueFactory().setValue(INIT_VALUE_START_HOURS);
		startMinutes.getValueFactory().setValue(INIT_VALUE_START_MINUTES);
		endHours.getValueFactory().setValue(INIT_VALUE_END_HOURS);
		endMinutes.getValueFactory().setValue(INIT_VALUE_END_MINUTES);
		
		//regularOnOff.selectedProperty().bindBidirectional(choiceRegular.visibleProperty());
		hoursField.textProperty().bindBidirectional(durationSlider.valueProperty(), NumberFormat.getNumberInstance());
		minutesField.textProperty().bindBidirectional(durationSlider1.valueProperty(), NumberFormat.getNumberInstance());
		
		//Inserts the Categories to the choice box.
		for(int i = 0; i < CategoriesController.getMainCategories().size(); i++)
		{
	      categoryChooser.getItems().addAll(CategoriesController.getMainCategories().get(i));
		}
	}
}
