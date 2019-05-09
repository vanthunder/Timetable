package Notiz;

import java.util.ArrayList;

public class Notiz extends Konstrukt {
	
	private int angeheftet;
	private ArrayList<Termin> angeheftetAn;
	private ArrayList externList;
	private ArrayList fotoList;
	private ArrayList gifList;
	private ArrayList soundList;
	private String textfeld;
	private ArrayList videoList;
	
	public Notiz(boolean angeheftet, ArrayList angeheftetAn, ArrayList externList, ArrayList fotoList, ArrayList gifList, ArrayList soundList, String textfeld, ArrayList videoList) {
		this.angeheftet = angeheftet;
		this.angeheftetAn = angeheftetAn;
		this.externList = externList;
		this.fotoList = fotoList;
		this.gifList = gifList;
		this.soundList = soundList;
		this.textfeld = textfeld;
		this.videoList = videoList;
	}

}
