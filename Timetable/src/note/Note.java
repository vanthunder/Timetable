package note;

import java.util.ArrayList;
import base.Base;

public class Note extends Base {
	
	String title;
	private int pinned;
	private ArrayList pinnedAt;
	private ArrayList externList;
	private ArrayList photoList;
	private ArrayList gifList;
	private ArrayList soundList;
	private String textbox;
	private ArrayList videoList;
	
	public Note(String title, int pinned, ArrayList pinnedAt, ArrayList externList, ArrayList photoList, ArrayList gifList, ArrayList soundList, String textbox, ArrayList videoList) {
		super(title);
		this.title = title;
		this.pinned = pinned;
		this.pinnedAt = pinnedAt;
		this.externList = externList;
		this.photoList = photoList;
		this.gifList = gifList;
		this.soundList = soundList;
		this.textbox = textbox;
		this.videoList = videoList;
	}

}
