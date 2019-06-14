package Save;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import note.Note;

public class save {
	
	public void saveNote(Object serObj) {
			 
					String filepath = "\\Desktop";
			    try {
			 
			            FileOutputStream fileOut = new FileOutputStream(filepath);
			            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			            objectOut.writeObject(serObj);
			            objectOut.close();
			            System.out.println("The Object  was succesfully written to a file");
			 
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			    }
			}
		 
