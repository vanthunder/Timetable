package Ersteller;
import java.util.ArrayList;
import java.util.Date;
import Termin.Termin;
import Notiz.Notiz;

public class Ersteller {
	/**terminErstellenUI() im TerminController ruft das Termin erstellen Fenster auf. 
	 * Sobald auf speichern gedrückt wird übergibt es die vom Nutzer eingetragenen Parameter an Ersteller.terminErstellen()
	 */
	public static void terminErstellen(String titel, Date startpunkt, Date endpunkt, boolean ganztag, boolean regelmaessigAnAus, 
			int regelmaessig, String beschreibung, boolean alarmAnAus, Date alarmzeit, Boolean notizAngeheftet, ArrayList<Notiz> notizLink) {
		
		boolean schwebend;
		
		if(ganztag) {
			startpunkt.setHours(0);
			endpunkt.setHours(24);
		}
			
			Termin neuerTermin = new Termin(String titel, Date startpunkt, Date endpunkt, boolean ganztag, boolean regelmaessigAnAus, 
					int regelmaessig, String beschreibung, boolean alarmAnAus, Date alarmzeit, Boolean notizAngeheftet, ArrayList<Notiz> notizLink, boolean schwebend);
		
		
	}
	
	
}
