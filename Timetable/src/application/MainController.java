package application;
import category.CategoriesController;
import javafx.fxml.FXML;
import note.NoteController;


public class MainController

{
    //Ruft den Controller f�r das Kategoriensystem auf
    @FXML 
    CategoriesController categoriesController = new CategoriesController();
    @FXML
    NoteController noteController = new NoteController();
    public void initialize() 
    {
        
    }

}
