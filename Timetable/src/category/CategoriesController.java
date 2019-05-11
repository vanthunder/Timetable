/**
 * 
 */
package category;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeView.EditEvent;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 * @author Marvin
 *
 */
public class CategoriesController implements Initializable
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
    //Import an icon image for the treeView structure
    Image icon = new Image(
            getClass().getResourceAsStream("/images/Folder.png"));
    String text;
    String value;
    boolean i = false;
    CategoriesHelper helper = new CategoriesHelper();
    ArrayList<TreeItem> mainCategories = helper.getMainCategories();
    TreeItem root = new TreeItem("Kategorien", new ImageView(icon));
    //Method to create an treeView
    public void createTree(String... rootItem) 
    {
    treeView.setEditable(true);
    treeView.setCellFactory(TextFieldTreeCell.forTreeView());
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
        i = true;
        System.out.println(text);
        System.out.println("Button insertCategory pressed!");
        TreeItem parent = new TreeItem(text);
        root.getChildren().addAll(parent);
        treeView.setRoot(root);
    }
    // Helper Methods for the Event Handlers
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
    {
        this.Log.appendText(msg + "\n");
    } 
     //Initialize the treeview with all its components
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {createTree();
}
}