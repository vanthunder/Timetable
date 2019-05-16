package note;

import java.util.ArrayList;
import base.Base;
import task.Task;
import appointment.Appointment;

public class Note extends Base {
	
	String title;
	private int pinned;
	private ArrayList <Appointment> pinnedAt;
	private ArrayList photoList;
	private ArrayList gifList;
	private ArrayList soundList;
	private String textbox;
	private ArrayList videoList;
	
	public int getPinned() {
		return pinned;
	}

	public void setPinned(int pinned) {
		this.pinned = pinned;
	}

	public ArrayList getPinnedAt() {
		return pinnedAt;
	}

	public void setPinnedAt(ArrayList pinnedAt) {
		this.pinnedAt = pinnedAt;
	}

	public ArrayList getPhotoList() {
		return photoList;
	}

	public void setPhotoList(ArrayList photoList) {
		this.photoList = photoList;
	}

	public ArrayList getGifList() {
		return gifList;
	}

	public void setGifList(ArrayList gifList) {
		this.gifList = gifList;
	}

	public ArrayList getSoundList() {
		return soundList;
	}

	public void setSoundList(ArrayList soundList) {
		this.soundList = soundList;
	}

	public String getTextbox() {
		return textbox;
	}

	public void setTextbox(String textbox) {
		this.textbox = textbox;
	}

	public ArrayList getVideoList() {
		return videoList;
	}

	public void setVideoList(ArrayList videoList) {
		this.videoList = videoList;
	}

	public Note(String title, int pinned, ArrayList pinnedAt, ArrayList photoList, ArrayList gifList, ArrayList soundList, String textbox, ArrayList videoList) {
		super(title);
		this.title = title;
		this.setPinned(pinned);
		this.setPinnedAt(pinnedAt);
		this.setPhotoList(photoList);
		this.setGifList(gifList);
		this.setSoundList(soundList);
		this.setTextbox(textbox);
		this.setVideoList(videoList);
	}
	
	/** states all Note attributes in a String*/
	@Override
	public String toString(){
		return new String("title: " + this.getTitle() +" pinned: " + pinned + " pinnedAt: " + pinnedAt + " photoList: " + photoList + " gifList: " + gifList +
				" soundList: " + soundList + " textbox: " + textbox + " videoList: " + videoList);
	}
	

}
