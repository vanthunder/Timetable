/**
 * 
 */
package category;

import base.base;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Marvin
 *
 */
public class ToObject
{
	Image icon = new Image(
			getClass().getResourceAsStream("/images/Folder.png"));
	 private final TreeItem<String> rootItem = new TreeItem();

	    public ToObject(base Base)
	    {
	        rootItem.setValue(Base.getTitle());
	        rootItem.setGraphic(new ImageView(icon));
	    }   

	    /**
	     * @return the rootItem
	     */
	    public TreeItem<String> getRootItem()
	    {
	        return rootItem;
	    }

}
