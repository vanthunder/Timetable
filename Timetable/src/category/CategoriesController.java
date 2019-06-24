/**
 * 
 */
package category;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import calendar.CalendarController;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

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
	// Call the treeView component
	@FXML
	TreeView<String> treeView = new TreeView<String>();
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
	@FXML
	Button restButton = new Button();
	@FXML
	Button UpButton = new Button();
	@FXML
	Button DownButton = new Button();
	Category category = new Category();
	// Import an icon image for the treeView structure
	Image icon = new Image(getClass().getResourceAsStream("/images/Folder.png"));
	Image appointmentIcon = new Image(getClass().getResourceAsStream("/images/Kalender.png"));
	Image taskIcon = new Image(getClass().getResourceAsStream("/images/AufgabeIcon.png"));
	Image notesIcon = new Image(getClass().getResourceAsStream("/images/NotizIcon.png"));
	String text = "";
	String value;
	static CategoriesHelper helper = new CategoriesHelper();
	static ArrayList<TreeItem> mainCategories = helper.getMainCategories();
	TreeItem root = new TreeItem("Kategorien", new ImageView(icon));
	private TreeItem<String> newItem;

	// Method to create an treeView
	public void createTree(String... rootItem)
	{
		System.out.println(mainCategories);
		root.setExpanded(true);
		treeView.setCellFactory(TextFieldTreeCell.forTreeView());
		treeView.setEditable(true);
		treeView.getSelectionModel().selectFirst();
		root.getChildren().addAll(mainCategories);
		treeView.setRoot(root);
		TreeItem<String> parent = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
		// Set editing related event handlers (OnEditStart)
		treeView.setOnEditStart(event -> editStart(event));

		// Set editing related event handlers (OnEditCommit)
		treeView.setOnEditCommit(event -> editCommit(event));

		// Set editing related event handlers (OnEditCancel)
		treeView.setOnEditCancel(event -> editCancel(event));
	}

	/**
	 * @return the mainCategories
	 */
	public static ArrayList<TreeItem> getMainCategories()
	{
		return mainCategories;
	}

	/**
	 * @param mainCategories the mainCategories to set
	 */
	public void setMainCategories(ArrayList<TreeItem> mainCategories)
	{
		this.mainCategories = mainCategories;
	}

	// Returns the tree
	public TreeView<String> initialize()
	{
		return treeView;
	}

	// Static Method gets called by different creators like Appointemnt, Note or
	// Task, to create a category
	public static void insertCategoryByCreator(TreeItem<String> savePosition, TreeItem<String> newItem)
	{
		savePosition.getChildren().addAll(newItem);
	}

	// Method for inserting an Item
	public void insertCategoryPress(ActionEvent event)
	{
		text = categoryName.getText();
		if (text.equals(""))
		{
			writeMessage("Das Textfeld darf nicht leer sein!");
		} else if (!text.equals(""))
		{
			boolean check = true;
			text = categoryName.getText();
			TreeItem<String> parent = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
			if (parent == null)
			{
				writeMessage("Bitte wähle eine Kategorie aus\nder du eine Unterkategorie annhängen willst!");
			} else if (!(parent == null))
			{
				for (TreeItem<String> child : parent.getChildren())
				{
					if (child.getValue().equals(text))
					{
						writeMessage("Der Name " + text + " exestiert bereits!");
						check = false;
					}
				}
				if (check == true && !text.equals("Sonstiges") && !text.equals("sonstiges"))
				{
					
					TreeItem<String> newCategory = new TreeItem<String>(text, new ImageView(icon));
					parent.getChildren().add(newCategory);
					writeMessage("Es wurde eine neue Kategorie mit dem Namen: " + "'"
							+ newCategory.getValue().toString() + "'" + " erstellt!");
					if (!parent.isExpanded())
					{
						parent.setExpanded(true);
					}
				} else if (check == true && text.equals("Sonstiges") || text.equals("sonstiges"))
				{
					writeMessage("Du kannst die Kategorie Sonstiges nicht erstellen,\nda schon eine Hauptkategorie Sonstiges vorhanden ist!");
                }
			}
		}
	}

	// Resets the current Category to a the default look
	public void resetButtonPress(ActionEvent event)
	{
		TreeItem<String> parent = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
		if (!(parent == null))
		{
			if (!parent.getValue().toString().contains("Termin:") || !parent.getValue().toString().contains("Aufgabe:") || !parent.getValue().toString().contains("Notiz:"))
			{
				TreeItem<String> current = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
				TreeItem<String> reset = new TreeItem<String>("test", new ImageView(icon));
				current.setGraphic(reset.getGraphic());
				writeMessage("Die Farbe wurde zurückgesetzt!");
			}
			
			if (parent.getValue().toString().contains("Termin:"))
			{
			    TreeItem<String> current = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
				TreeItem<String> reset = new TreeItem<String>("test", new ImageView(appointmentIcon));
				current.setGraphic(reset.getGraphic());
				writeMessage("Die Farbe wurde zurückgesetzt!");
			}
			
			if (parent.getValue().toString().contains("Aufgabe:"))
			{
				TreeItem<String> current = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
				TreeItem<String> reset = new TreeItem<String>("test", new ImageView(taskIcon));
				current.setGraphic(reset.getGraphic());
				writeMessage("Die Farbe wurde zurückgesetzt!");
			}
			
			if (parent.getValue().toString().contains("Notiz:"))
			{
				TreeItem<String> current = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
				TreeItem<String> reset = new TreeItem<String>("test", new ImageView(notesIcon));
				current.setGraphic(reset.getGraphic());
				writeMessage("Die Farbe wurde zurückgesetzt!");
			}
		} 
		else
		writeMessage("Bitte wähle eine Kategorie aus um die Farbe zu reseten!");
	}

	// Changes the color of a selected treeitem to a selected color of the
	// colorpicker
	public void colorPick(ActionEvent event)
	{
		String hex = "#" + Integer.toHexString(colorPicker.getValue().hashCode());
		Color newColor;
		newColor = colorPicker.getValue();
		TreeItem<String> parent = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
		Label label = new Label();
		if (parent == null)
		{
			writeMessage("Du musst eine Kategorie auswählen!");
		} 
		else 
		if (!(parent == null))
		{
			if (!parent.getValue().toString().contains("Termin:") || !parent.getValue().toString().contains("Aufgabe:") || !parent.getValue().toString().contains("Notiz:"))
			{
				label.setText("  ");
				label.setTextFill(newColor);
				parent.setGraphic(label);
				label.setGraphic(new ImageView(icon));
				parent.getGraphic().setStyle("-fx-background-color:" + hex + ";");
				writeMessage("Eine Farbe wurde für die Kategorie: " + "'" + parent.getValue().toString() + "'" + " ausgewählt!");
			}
			
			if (parent.getValue().toString().contains("Termin:"))
			{
				label.setText("  ");
				label.setTextFill(newColor);
				parent.setGraphic(label);
				label.setGraphic(new ImageView(appointmentIcon));
				parent.getGraphic().setStyle("-fx-background-color:" + hex + ";");
				writeMessage("Eine Farbe wurde für die Kategorie: " + "'" + parent.getValue().toString() + "'" + " ausgewählt!");
			}
			
			if (parent.getValue().toString().contains("Aufgabe:"))
			{
				label.setText("  ");
				label.setTextFill(newColor);
				parent.setGraphic(label);
				label.setGraphic(new ImageView(taskIcon));
				parent.getGraphic().setStyle("-fx-background-color:" + hex + ";");
				writeMessage("Eine Farbe wurde für die Kategorie: " + "'" + parent.getValue().toString() + "'" + " ausgewählt!");
			}
			
			if (parent.getValue().toString().contains("Notiz:"))
			{
				label.setText("  ");
				label.setTextFill(newColor);
				parent.setGraphic(label);
				label.setGraphic(new ImageView(notesIcon));
				parent.getGraphic().setStyle("-fx-background-color:" + hex + ";");
				writeMessage("Eine Farbe wurde für die Kategorie: " + "'" + parent.getValue().toString() + "'" + " ausgewählt!");
			}
		}
	}

	// Deletes a selected treeItem
	public void eraseCategoryPress(ActionEvent event)
	{
		TreeItem<T> currentCategory = (TreeItem<T>) treeView.getSelectionModel().getSelectedItem();
		TreeItem<T> parent1 = (TreeItem<T>) treeView.getSelectionModel().getSelectedItem();
		TreeItem<T> moveItem = (TreeItem<T>) treeView.getTreeItem(3);
		if (currentCategory == null)
		{
			writeMessage("Wähle eine Kategorie aus um sie zu löschen!");
		} else if (!(currentCategory == null))
		{
			TreeItem parent = currentCategory.getParent();
			if (parent == null)
			{
				writeMessage("Du kannst den Root nicht entfernen!");
			} else if (!(parent == null))
			{
				if (currentCategory.getValue().equals("Sonstiges"))
				{
					writeMessage("Du kannst die Kategorie " + currentCategory.getValue() + " nicht löschen!");
				} else if (!currentCategory.getValue().equals("Sonstiges"))
				{
					parent.getChildren().remove(currentCategory);
					writeMessage("Die Kategorie " + currentCategory.getValue() + " wurde gelöscht!");
					if (currentCategory.getValue().toString().contains("Termin:"))
					{
						String cache = new String();
						String newCache = new String();
						cache = currentCategory.getValue().toString();
						newCache = cache.replace("Termin: ", "");
						CalendarController.eraseAppointment(newCache);
					}
				}
			}
		}
	}

	// Moves a selected treeitem up
	public void UpButtonPress(ActionEvent event)
	{
		TreeItem<T> parent1 = (TreeItem<T>) treeView.getSelectionModel().getSelectedItem();
		if (!(parent1 == null))
		{
			
			if (parent1 != null)
			{
				TreeItem item = parent1;
				int index = item.getParent().getChildren().indexOf(item);
				if (index != item.getParent().getChildren().size() + 1)
				{
					TreeItem safeItem = (TreeItem) item.getParent().getChildren().get(index - 1);
					item.getParent().getChildren().set(index - 1, item);
					item.getParent().getChildren().set(index, safeItem);

				}
				treeView.getSelectionModel().select(item);
			}

		} else
			writeMessage("Bitte wähle eine Kategorie aus,\num sie nach oben zu verschieben!");
	}

	// Moves a selected treeitem down
	public void DownButtonPress(ActionEvent event)
	{
		TreeItem<T> parent1 = (TreeItem<T>) treeView.getSelectionModel().getSelectedItem();
		if (!(parent1 == null))
		{
			if (parent1 != null)
			{
				TreeItem item = parent1;
				int index = item.getParent().getChildren().indexOf(item);
				if (index != item.getParent().getChildren().size() - 1)
				{
					TreeItem safeItem = (TreeItem) item.getParent().getChildren().get(index + 1);
					item.getParent().getChildren().set(index + 1, item);
					item.getParent().getChildren().set(index, safeItem);

				}
				treeView.getSelectionModel().select(item);
			}

			
		} else
			writeMessage("Bitte wähle eine Kategorie aus,\num sie nach unten zu verschieben!");
	}

	// Event handler for start editing
	private void editStart(TreeView.EditEvent event)
	{
		writeMessage("Started editing: " + event.getTreeItem());
	}

	// Event handler for commiting
	private void editCommit(TreeView.EditEvent event)
	{
		writeMessage(event.getTreeItem() + " changed." + " old = " + event.getOldValue() + ", new = " + event.getNewValue());
		if (event.getOldValue().toString().contains("Termin:"))
		{
			String cache = new String();
			cache = event.getOldValue().toString();
			String subCache = cache.replace("Termin: ", "");
			String nextCache = event.getNewValue().toString();
			String nextSubCache = nextCache.replace("Termin: ", "");
			CalendarController.editAppointment(subCache, nextSubCache);
			String newValue = event.getNewValue().toString();
			if (!event.getNewValue().toString().contains("Termin: "))
			{
				writeMessage("Du darfst 'Termin: ' nicht löschen!");
			}
		}
     }

	// Event handler for cancelling
	private void editCancel(TreeView.EditEvent e)
	{
		writeMessage("Cancelled editing: " + e.getTreeItem());
	}

	// Method for Logging
	private void writeMessage(String msg)
	{
		Long millis = new Long(11);
		Duration.ofMillis(millis);
		this.logLabel.setText(msg);
		PauseTransition wait = new PauseTransition(javafx.util.Duration.seconds(2));
		wait.setOnFinished((e) ->
		{
			this.logLabel.setText("");
		});
		wait.play();
	}

	// Initialize the treeview with all its components
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		createTree();
	}
}