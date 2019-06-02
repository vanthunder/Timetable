package task;
import creator.Creator;
import javafx.application.Application;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.Slider;

import javafx.scene.input.MouseDragEvent;

import javafx.scene.input.InputMethodEvent;

public abstract class TaskCreatorController {
	
	
	private static int duration = 0;
	@FXML
	private static TextField durationCurrentValue;

	@FXML
	private static Slider durationSlider;
	
	
	public void EventHandling() {

		
	}

	// Event Listener on TextField[#durationCurrentValue].onInputMethodTextChanged
	@FXML
	public static void onTextChanged(InputMethodEvent eventText) {

		String durationText=durationCurrentValue.getPromptText();
		duration = Integer.parseInt(durationText);
		durationSlider.setValue(duration);	
	}
	


	// Event Listener on Slider[#durationSlider].onMouseDragReleased
	@FXML
	public static void onSliderChanged(MouseDragEvent eventSlider) {
		double sliderValue = durationSlider.getValue();
		String valueToText;
		valueToText = String.valueOf(duration);
		durationCurrentValue.setPromptText(valueToText);
		duration = (int)sliderValue;

	}

	public static int getDuration() {
		InputMethodEvent eventText = null;
		MouseDragEvent eventSlider= null;
		
		durationCurrentValue.getOnInputMethodTextChanged().handle(eventText);
		durationSlider.getOnMouseDragReleased().handle(eventSlider);
		
		
		onTextChanged(eventText);
		onSliderChanged(eventSlider);
		

		
		
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
