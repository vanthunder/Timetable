package save;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import appointment.Appointment;
import calendar.Calendar;
import creator.Creator;

public class Save {
	public static void saveCalendarList() throws IOException {
	ArrayList<Appointment> tmpCalendarList = Calendar.getCalendarList();
	FileOutputStream fos = new FileOutputStream("calendarListSAVE");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(tmpCalendarList);
    oos.close();
    fos.close();
	  }
	
	public static void loadCalendarList() throws IOException, ClassNotFoundException {
		ArrayList<Appointment> tempCalendarList = new ArrayList<Appointment>();
		FileInputStream fis = new FileInputStream("calendarListSAVE");
        ObjectInputStream ois = new ObjectInputStream(fis);

        tempCalendarList = (ArrayList) ois.readObject();

        ois.close();
        fis.close();
        Calendar.setCalendarList(tempCalendarList);
        Creator.updateCalendarControllerList();
	}
}
