package task;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.time.*;
import java.lang.*;
import java.util.*;

import calendar.Calendar;

public class AutoSort {
	/* Rules:
	 * 1. no collision allowed: 
	 * 
	 * 	do {
	 * 		CalendarList.nextObject(); 
	 * 		for (int i = 0; i <= MINUTES(tmpEndpoint-tmpStarpoint); i++)
	 *			{
	 * 				CalenderList.objectToCompare();
	 * 				if (startpoint >= tmpStartpoint + i && tmpEndpoint >=endpoint)
	 * 					{
	 * 						i++;
	 * 					}
	 * 				else{
	 * 					return; }
	 * 					
	 * 			}
	 * 		}while(ClaendarList.hasNext() == true;)
	 * 
	 * 2. only between 8.00 to 20.00
	 * 3. duration limit 3 hours
	 * 4. 45 minutes break after 3 hours
	 * */
	
	public static void autoSort(Task currentTask) {
		long tmpDuration = 0;
		for(int i=0; i<Calendar.getCalendarList().size()-1; i++) {
			
	        if(Calendar.getCalendarList().get(i).getEndpoint().until(Calendar.getCalendarList().get(i+1).getStartpoint(), (TemporalUnit) TimeUnit.MINUTES)>= tmpDuration+90  ){

	        }
	    }
	}
	
	public static ArrayList<Long> splitDuration(Task currentTask){
        ArrayList<Long> tmpDuration = new ArrayList<Long>();
        int durationWaste = currentTask.getDuration();
        if(currentTask.getDuration()>180) {

            while(durationWaste>=210) {
                tmpDuration.add((long)180);
                tmpDuration.add((long)durationWaste-180);
            }
            tmpDuration.add((long)durationWaste-30);
            tmpDuration.add((long)30);
        }
		return tmpDuration;
	}

	}


