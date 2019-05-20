package category;

import java.util.ArrayList;

import base.Base;
import javafx.scene.control.TreeItem;

public interface CategoryInterface {
	public ArrayList<TreeItem> getContentlist();
	public void setContentlist(ArrayList<TreeItem> contentlist);
}
