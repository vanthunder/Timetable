package application;
import java.net.URL;
import java.util.ResourceBundle;

import category.CategoriesController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class MainController

{
	//Ruft den Controller für das Kategoriensystem auf
	@FXML 
	CategoriesController categoriesController = new CategoriesController();

	public void initialize() 
	{
		
    }

}
