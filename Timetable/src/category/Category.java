package category;

import java.util.ArrayList;

import base.Base;

public class Category implements CategoryInterface{
	private ArrayList<Base> contentlist = new ArrayList<Base>();

	public ArrayList<Base> getContentlist() {
		return contentlist;
	}

	public void setContentlist(ArrayList<Base> contentlist) {
		this.contentlist = contentlist;
	}
	
	
}
