package category;

import java.util.ArrayList;

import base.Base;
import javafx.scene.control.TreeItem;

public class Category implements CategoryInterface
{
	

	private ArrayList<TreeItem> contentlist = new ArrayList<TreeItem>();
    
	
	public ArrayList<TreeItem> getContentlist() 
	{
		return contentlist;
	}

	public void setContentlist(ArrayList<TreeItem> contentlist) 
	{
		this.contentlist = contentlist;
	}
	
	
}
