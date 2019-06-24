package base;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;

public abstract class Base implements Serializable {
	private String title;
	private String filepath;
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
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
