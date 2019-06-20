package task;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import appointment.Appointment;

import java.time.*;

import calendar.Calendar;


public class AutoSort {
	/*
	 * Rules: 1. no collision allowed:
	 * 
	 * do { CalendarList.nextObject(); for (int i = 0; i <=
	 * MINUTES(tmpEndpoint-tmpStarpoint); i++) { CalenderList.objectToCompare(); if
	 * (startpoint >= tmpStartpoint + i && tmpEndpoint >=endpoint) { i++; } else{
	 * return; }
	 * 
	 * } }while(ClaendarList.hasNext() == true;)
	 * 
	 * 2. only between 8.00 to 20.00 3. duration limit 3 hours 4. 45 minutes break
	 * after 3 hours
	 */

	public static void autoSort(Task currentTask) throws CloneNotSupportedException {
		ArrayList<Long> tmpDuration = splitDuration(currentTask);
		currentTask.setAutoSortID(getAutosortTaskID());
		ArrayList<Appointment> tmpCalendarList = Calendar.getCalendarList();
		HashMap<Integer, ArrayList<Task>> tmpAutoSortList = Calendar.getAutosortTaskList();
		ArrayList<Task> autoSortInnerList = new ArrayList<Task>();
		for (int j = 0; j < tmpDuration.size(); j++) {

			for (int i = 0; i < Calendar.getCalendarList().size() - 1; i++) {
				LocalDateTime endpointLastDate = Calendar.getCalendarList().get(i).getEndpoint();
				LocalTime checkEarly = LocalTime.of(8, 0);
				LocalTime checkLate = LocalTime.of(20, 0);
				LocalTime startTime = endpointLastDate.toLocalTime().plusMinutes(45);
				LocalTime endTime = startTime.plusMinutes(tmpDuration.get(j));
				LocalDate taskDate = endpointLastDate.toLocalDate();

				boolean startTimeInRange = startTime.isAfter(checkEarly) && startTime.isBefore(checkLate);
				boolean endTimeInRange = endTime.isAfter(checkEarly) && endTime.isBefore(checkLate);

				if (Calendar.getCalendarList().get(i).getEndpoint().until(
						Calendar.getCalendarList().get(i + 1).getStartpoint(),
						(TemporalUnit) TimeUnit.MINUTES) >= tmpDuration.get(j) + 90 && startTimeInRange
						&& endTimeInRange) {

					if (j == 0) {
						currentTask.setStartpoint(LocalDateTime.of(taskDate, startTime));
						currentTask.setEndpoint(LocalDateTime.of(taskDate, endTime));

						// add the new Task to the CalendarList
						tmpCalendarList.add(currentTask);
						autoSortInnerList.add(currentTask);
						Task.WriteObjectToFile(currentTask);
						break;
					} else {
						Task copy = (Task) currentTask.clone();
						copy.setStartpoint(LocalDateTime.of(taskDate, startTime));
						copy.setEndpoint(LocalDateTime.of(taskDate, endTime));

						// add the new Task to the CalendarList
						tmpCalendarList.add(copy);
						autoSortInnerList.add(copy);
						Task.WriteObjectToFile(copy);
						break;
					}

				}
			}
		}
		Calendar.setCalendarList(tmpCalendarList);

		tmpAutoSortList.put(currentTask.getAutoSortID(), autoSortInnerList);
		Calendar.setAutosortTaskList(tmpAutoSortList);
	}

	public static ArrayList<Long> splitDuration(Task currentTask) {
		ArrayList<Long> tmpDuration = new ArrayList<Long>();
		int durationWaste = currentTask.getDuration();
		if (currentTask.getDuration() > 180) {

			while (durationWaste >= 210) {
				tmpDuration.add((long) 180);
				tmpDuration.add((long) durationWaste - 180);
			}
			tmpDuration.add((long) durationWaste - 30);
			tmpDuration.add((long) 30);
		}
		return tmpDuration;
	}

	public static int getAutosortTaskID() {
		int autosortTaskID = 0;
		// get ID
		int j = 0;

		do {
			if (Calendar.getAutosortTaskList().containsKey(j) == false) {
				autosortTaskID = j;
				break;
			}
			j++;
		} while (j <= Calendar.getAutosortTaskList().size());

		return autosortTaskID;
	}


}
