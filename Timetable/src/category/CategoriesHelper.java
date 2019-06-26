/**
 * 
 */
package category;

import java.io.Serializable;
import java.util.ArrayList;

import base.Base;
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
    //Imports an image for the folder icon
	Image icon = new Image(getClass().getResourceAsStream("/images/Folder.png"));
	//Base Base1 = new Base("!! Debug Item !!")
	{
	};
	//ToObject toObject = new ToObject(Base1);

	// This Method creates the maincategories
	public ArrayList<TreeItem> getMainCategories()
	{
		ArrayList<TreeItem> mainCategories = new ArrayList<TreeItem>();

		TreeItem uni = new TreeItem("Uni", new ImageView(icon));
		uni.getChildren().addAll(getUni());

		TreeItem freizeit = new TreeItem("Freizeit", new ImageView(icon));
		freizeit.getChildren().addAll(getFreizeit());

		TreeItem sonstiges = new TreeItem("Sonstiges", new ImageView(icon));
		sonstiges.getChildren().addAll(getSonstiges());

		mainCategories.add(uni);
		mainCategories.add(freizeit);
		mainCategories.add(sonstiges);
		//mainCategories.add(toObject.getRootItem());

		return mainCategories;
	}

	// This method creates the child category Uni
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

	// This method creates the child category Freizeit
	private ArrayList<TreeItem> getFreizeit()
	{
		ArrayList<TreeItem> freizeit = new ArrayList<TreeItem>();

		TreeItem aktivitäten = new TreeItem("Aktivitäten", new ImageView(icon));
		TreeItem kino = new TreeItem("Kino", new ImageView(icon));

		freizeit.add(aktivitäten);
		freizeit.add(kino);

		return freizeit;
	}

	// This method creates the child category Freizeit
	private ArrayList<TreeItem> getSonstiges()
	{
		ArrayList<TreeItem> sonstiges = new ArrayList<TreeItem>();

		TreeItem termine = new TreeItem("Termine", new ImageView(icon));
		TreeItem notizen = new TreeItem("Notizen", new ImageView(icon));
		TreeItem aufgaben = new TreeItem("Aufgaben", new ImageView(icon));

		sonstiges.add(termine);
		sonstiges.add(notizen);
		sonstiges.add(aufgaben);

		return sonstiges;
	}

	// This method creates the child category Mathe
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

	// This method creates the child category Englisch
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

	// This method creates the child category Design
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

	// This method creates the child category Informatik
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
