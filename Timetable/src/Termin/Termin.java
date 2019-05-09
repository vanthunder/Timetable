package Termin;
import java.util.ArrayList;
import java.util.Date;
import Notiz.Notiz;
import Konstrukt.Konstrukt;

public class Termin extends Konstrukt {
	String titel; 
	Date startpunkt;
	Date endpunkt;
	boolean ganztag;
	boolean regelmaessigAnAus;
	int regelmaessig;
	String beschreibung;
	boolean alarmAnAus;
	Date alarmzeit;
	Boolean notizAngeheftet;
	ArrayList<Notiz> notizLink;
	boolean schwebend;
	
	public Termin(String titel, Date startpunkt, Date endpunkt, boolean ganztag, boolean regelmaessigAnAus, 
			int regelmaessig, String beschreibung, boolean alarmAnAus, Date alarmzeit, Boolean notizAngeheftet, 
			ArrayList<Notiz> notizLink, boolean schwebend){
		super(titel);
		this.titel = titel;
		this.startpunkt = startpunkt; 
		this.endpunkt = endpunkt;
		this.ganztag = ganztag;
		this.regelmaessig = regelmaessig;
		this.beschreibung = beschreibung; 
		this.alarmAnAus = alarmAnAus; 
		this.alarmzeit = alarmzeit;
		this.notizAngeheftet = notizAngeheftet;
		this.notizLink = notizLink; 
		this.schwebend = schwebend;
	}
}
