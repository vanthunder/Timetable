/**
 * 
 */
package category;

import java.util.ArrayList;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Marvin
 *
 */
public class CategoriesHelper 
{

	/**
	 * @param args
	 */
	
	public CategoriesHelper()
	  {
		
	  }
	  
	  Image icon = new Image(
				getClass().getResourceAsStream("/images/Folder.png"));
	  
	  //Diese Methode erstellt die Oberkategorien
	  public ArrayList<TreeItem> getMainCategories()
	  {
		  ArrayList<TreeItem> mainCategories = new ArrayList <TreeItem>();
		  
		  TreeItem uni = new TreeItem("Uni", new ImageView(icon));
		  uni.getChildren().addAll(getUni());
		  
		  TreeItem freizeit = new TreeItem("Freizeit", new ImageView(icon));
		  freizeit.getChildren().addAll(getFreizeit());
		  
		  TreeItem sonstiges = new TreeItem("Sonstiges", new ImageView(icon));
		  sonstiges.getChildren().addAll(getSonstiges());
		  
		  
		  mainCategories.add(uni);
		  mainCategories.add(freizeit);
		  mainCategories.add(sonstiges);
		  
		  return mainCategories;
	  }
	  
	  //Diese  Methode erstellt die Unterkategorie Uni
	  private ArrayList<TreeItem> getUni()
	  {
		  ArrayList<TreeItem> uni = new ArrayList<TreeItem>();
		  
		  TreeItem mathe = new TreeItem("Mathe", new ImageView(icon));
		  mathe.getChildren().addAll(getMathe());
		  TreeItem englisch = new TreeItem("Englisch", new ImageView(icon));
		  englisch.getChildren().addAll(getEnglisch());
		  TreeItem design = new TreeItem("Design", new ImageView(icon));
		  design.getChildren().addAll(getDesign());
		  TreeItem informatik = new TreeItem("Informatik", new ImageView(icon));
		  informatik.getChildren().addAll(getInformatik());
		  
		  uni.add(mathe);
		  uni.add(englisch);
		  uni.add(design);
		  uni.add(informatik);
		  
		  return uni;
	  }
	  
	//Diese  Methode erstellt die Unterkategorie Freizeit
	  private ArrayList<TreeItem> getFreizeit()
	  {
		  ArrayList<TreeItem> freizeit = new ArrayList<TreeItem>();
		  
		  TreeItem aktivitäten = new TreeItem("Aktivitäten", new ImageView(icon));
		  TreeItem kino = new TreeItem("Kino", new ImageView(icon));
		  
		  
		  freizeit.add(aktivitäten);
		  freizeit.add(kino);
		  
		  
		  return freizeit;
	  }

	//Diese  Methode erstellt die Unterkategorie Sonstiges
	  private ArrayList<TreeItem> getSonstiges()
	  {
		  ArrayList<TreeItem> sonstiges = new ArrayList<TreeItem>();
		  
		  TreeItem termine = new TreeItem("Termine", new ImageView(icon));
		  TreeItem notizen = new TreeItem("Notizen", new ImageView(icon));
		  TreeItem aufgaben = new TreeItem("Aufgaben",new ImageView(icon));
		  
		  
		  sonstiges.add(termine);
		  sonstiges.add(notizen);
		  sonstiges.add(aufgaben);
		  
		  
		  return sonstiges;
	  }
	//Diese  Methode erstellt die Unterkategorien für das Unifach Mathe  
	  private ArrayList<TreeItem> getMathe()
	  {
		  ArrayList<TreeItem> mathe = new ArrayList<TreeItem>();
		  
		  TreeItem termin = new TreeItem("Termin", new ImageView(icon));
		  TreeItem notiz = new TreeItem("Notiz", new ImageView(icon));
		  TreeItem aufgabe = new TreeItem("Aufgabe", new ImageView(icon));
		  
		  
		  mathe.add(termin);
		  mathe.add(notiz);
		  mathe.add(aufgabe);
		  
		  
		  return mathe;
	  }
	//Diese  Methode erstellt die Unterkategorien für das Unifach Englisch 
	  private ArrayList<TreeItem> getEnglisch()
	  {
		  ArrayList<TreeItem> englisch = new ArrayList<TreeItem>();
		  
		  TreeItem termin = new TreeItem("Termin", new ImageView(icon));
		  TreeItem notiz = new TreeItem("Notiz", new ImageView(icon));
		  TreeItem aufgabe = new TreeItem("Aufgabe", new ImageView(icon));
		  
		  
		  englisch.add(termin);
		  englisch.add(notiz);
		  englisch.add(aufgabe);
		  
		  
		  return englisch;
	  }
	//Diese  Methode erstellt die Unterkategorien für das Unifach Design   
	  private ArrayList<TreeItem> getDesign()
	  {
		  ArrayList<TreeItem> design = new ArrayList<TreeItem>();
		  
		  TreeItem termin = new TreeItem("Termin", new ImageView(icon));
		  TreeItem notiz = new TreeItem("Notiz", new ImageView(icon));
		  TreeItem aufgabe = new TreeItem("Aufgabe", new ImageView(icon));
		  
		  
		  design.add(termin);
		  design.add(notiz);
		  design.add(aufgabe);
		  
		  
		  return design;
	  }
	//Diese  Methode erstellt die Unterkategorien für das Unifach Informatik
	  private ArrayList<TreeItem> getInformatik()
	  {
		  ArrayList<TreeItem> informatik = new ArrayList<TreeItem>();
		  
		  TreeItem termin = new TreeItem("Termin", new ImageView(icon));
		  TreeItem notiz = new TreeItem("Notiz", new ImageView(icon));
		  TreeItem aufgabe = new TreeItem("Aufgabe", new ImageView(icon));
		  
		  
		  informatik.add(termin);
		  informatik.add(notiz);
		  informatik.add(aufgabe);
		  
		  
		  return informatik;
	  }

}
