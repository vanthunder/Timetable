package base;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;

/**
 * 
 * @author Marc
 *
 */
public abstract class Base implements Serializable {
	private String title;

	
	
	public Base() {}

	public Base(String title){
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
