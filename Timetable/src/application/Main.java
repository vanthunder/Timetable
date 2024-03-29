package application;

import javafx.application.Application;
import javafx.stage.Stage;
import save.Save;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;




public class Main extends Application 
{

	@Override
	public void start(Stage primaryStage) 
	{
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/fxml/calendarMain.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/CSS/application.css").toExternalForm());
			primaryStage.getIcons().add(new Image("/images/Kalender.png"));
			primaryStage.setTitle("Kalender");
			primaryStage.setScene(scene);
			primaryStage.show();
			Save.loadCalendarList();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
    {
		launch(args);
	}
}