/**
 * 
 */
package category;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * @author Marvin
 *
 */
public class CategoriesController implements Initializable
{    /**
	 * @param args
	 */
	@FXML
	TreeView treeView;
	
	
	Image icon = new Image(
			getClass().getResourceAsStream("/images/Folder.png"));
	

	public void createTree(String... rootItem) 
	{
		CategoriesHelper helper = new CategoriesHelper();
	    ArrayList<TreeItem> mainCategories = helper.getMainCategories();
	    TreeItem root = new TreeItem("Kategorien", new ImageView(icon));
	    root.getChildren().addAll(mainCategories);
	    System.out.println("Test");
	    treeView.setRoot(root);
	}
	
	public TreeView initialize() 
	{
	 return treeView;	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		createTree();
	}
	
	

}
