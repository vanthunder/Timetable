/**
 * 
 */
package category;
import java.net.URL;

import java.time.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeView.EditEvent;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * @author Marvin
 * @param <T>
 *
 */
public class CategoriesController<T> implements Initializable
{   
/**
     * @param args
     */
    //Call the treeView component
    @FXML
    TreeView treeView = new TreeView();
    @FXML
    TextArea Log = new TextArea();
    @FXML
    TextField newCategory = new TextField(); 
    @FXML
    Button insertCategory = new Button();
    @FXML
    TextField categoryName = new TextField();
    @FXML
    ColorPicker colorPicker = new ColorPicker();
    @FXML
    Label logLabel = new Label();
    //Import an icon image for the treeView structure
    Image icon = new Image(
            getClass().getResourceAsStream("/images/Folder.png"));
    String text = "";
    String value;
    CategoriesHelper helper = new CategoriesHelper();
    ArrayList<TreeItem> mainCategories = helper.getMainCategories();
    TreeItem root = new TreeItem("Kategorien", new ImageView(icon));
    //Method to create an treeView
    public void createTree(String... rootItem) 
    {
    treeView.setEditable(true);
    treeView.setCellFactory(TextFieldTreeCell.forTreeView());
    treeView.getSelectionModel().selectFirst();
    root.getChildren().addAll(mainCategories);
    treeView.setRoot(root);
     // Set editing related event handlers (OnEditStart)
        treeView.setOnEditStart(new EventHandler<TreeView.EditEvent>()
        {
            @Override
            public void handle(EditEvent event) 
            {
                editStart(event);
            }
        });
 
        // Set editing related event handlers (OnEditCommit)
        treeView.setOnEditCommit(new EventHandler<TreeView.EditEvent>()
        {
            @Override
            public void handle(EditEvent event) 
            {
                editCommit(event);
            }
        });
 
        // Set editing related event handlers (OnEditCancel)
        treeView.setOnEditCancel(new EventHandler<TreeView.EditEvent>()
        {
            @Override
            public void handle(EditEvent event) 
            {
                editCancel(event);
            }
        });
    Log.setPrefRowCount(15);
    Log.setPrefColumnCount(25);
    }
    //Returns the tree
    public TreeView initialize() 
    {
     return treeView;   
    }
    //Method for inserting an Item
    public void insertCategoryPress(ActionEvent event)
    {
        text=categoryName.getText();
        if(text.equals(""))
        {
            writeMessage("Das Textfeld darf nicht leer sein!"); 
        }     
        else
        if(!text.equals(""))
        {   boolean check = true;
            text=categoryName.getText();
            TreeItem<TreeItem> parent = (TreeItem<TreeItem>) treeView.getSelectionModel().getSelectedItem();
            if(parent == null)
            {
                writeMessage("Bitte wähle eine Kategorie aus\nder du eine Unterkategorie annhängen willst!");
            }
            else
            if(!(parent == null))    
            {
                for(TreeItem child : parent.getChildren())
                {
                    if(child.getValue().equals(text))
                    {
                      writeMessage("Der Name "+text+" exestiert bereits!");
                      check = false;
                    }
                }
                if(check == true && !text.equals("Sonstiges") && !text.equals("sonstiges"))
                {
                    System.out.println("true");
                    TreeItem newCategory = new TreeItem(text, new ImageView(icon));
                    parent.getChildren().add(newCategory);
                    if(!parent.isExpanded())
                    {
                        parent.setExpanded(true);
                    }
                }
                else
                if(check == true && text.equals("Sonstiges") || text.equals("sonstiges"))
                {
                    writeMessage("Du kannst die Kategorie Sonstiges nicht erstellen,\nda schon eine Hauptkategorie Sonstiges vorhanden ist!");
                    
                }    
            }
        }    
    }
    //Method for the colorpicker
    public void colorPick(ActionEvent event)
    {
    	TreeItem newValue = null;
    	String newName = "TEST";
    	String Text = "\u001B[47m";
    	Color newColor;
    	newColor = colorPicker.getValue();
    	newName=newColor.toString();
    	TreeItem<TreeItem> parent = (TreeItem<TreeItem>) treeView.getSelectionModel().getSelectedItem();
    	Log.setText(Text);
    	//parent.setStyle("-fx-background-color: #0093ff;");
    	//System.out.println(parent.getValue());
    	//parent.getValue().setValue();
    	//newValue.setFill
    	
    	//newValue.setGraphic(colorPicker);
    	//newValue.setGraphic(colorPicker);
    	System.out.println(newName+"Text");
        Log.setText(("<html><font color=\"red\">hello world!</font></html>"));
    	
    	System.out.println(Text+"hello world!");
    }
    // Helper Methods for the Event Handlers
    public void eraseCategoryPress(ActionEvent event)
    {
        TreeItem<T> currentCategory = (TreeItem<T>) treeView.getSelectionModel().getSelectedItem();
        
        if(currentCategory == null)
        {
            writeMessage("Wähle eine Kategorie aus um sie zu löschen!");
        }
        else
        if(!(currentCategory == null))
        {
            TreeItem parent = currentCategory.getParent();
            if(parent == null)
            {
               writeMessage("Du kannst den Root nicht entfernen!"); 
            }
            else
            if(!(parent == null))
            {
                if(currentCategory.getValue().equals("Sonstiges"))
                {
                   writeMessage("Du kannst die Kategorie "+ currentCategory.getValue()+ " nicht löschen!");
                } 
                else
                if(!currentCategory.getValue().equals("Sonstiges"))
                {
                  parent.getChildren().remove(currentCategory);
                  writeMessage("Die Kategorie "+currentCategory.getValue()+" wurde gelöscht!");
                }
            }
        }
    }
    private void editStart(TreeView.EditEvent event) 
    {
        writeMessage("Started editing: " + event.getTreeItem() );
    }
     
    private void editCommit(TreeView.EditEvent event) 
    {
        writeMessage(event.getTreeItem() + " changed." +
                " old = " + event.getOldValue() +
                ", new = " + event.getNewValue());
        System.out.println(event.getOldValue()+" "+event.getNewValue());
    }
     
    private void editCancel(TreeView.EditEvent e) 
    {
        writeMessage("Cancelled editing: " + e.getTreeItem() );
    }
     
    // Method for Logging
    private void writeMessage(String msg)
    {   Long millis = new Long(11);
    	Duration.ofMillis(millis);
    	this.Log.appendText(msg + "\n");
        this.logLabel.setText(msg);
    	PauseTransition wait = new PauseTransition(javafx.util.Duration.seconds(2));
    	wait.setOnFinished((e) -> {
            this.Log.setText("");;
            this.logLabel.setText("");
            //wait.playFromStart();
        });
        wait.play();
    } 
     //Initialize the treeview with all its components
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
    	createTree();
    }
}