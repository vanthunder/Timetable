package Save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import note.Note;

public class save {
	
	public void saveNote(Note serObj) {
			 

		String title = serObj.getTitle();
		int counter=0;
		boolean created = false;
		
		do {
			
		String filepath = "C:\\Users\\Melanpiriks\\Desktop\\" + title + counter + ".txt";

		File tmpFilepath = new File(filepath);
		
		boolean exists = tmpFilepath.exists();
		
		if(exists) {
			counter++;
			continue;
		}
	
		serObj.setFilepath(filepath);
		
	    try {
	 
	            FileOutputStream fileOut = new FileOutputStream(filepath);
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	            objectOut.writeObject(serObj);
	            objectOut.close();
	            System.out.println("The Object  was succesfully written to a file");
	 
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
		
		created = true;
		
			
		} while (!created);
		
		
		
		
	}	
			}
		 
