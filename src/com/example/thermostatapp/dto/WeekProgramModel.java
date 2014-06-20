package com.example.thermostatapp.dto;

public class WeekProgramModel {
	public Boolean state = false;
	
	public String[] daysOfWeekStrings = new String[] {"Monday", "Tueseday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	public DayModel[] daysOfWeek = new DayModel[7];
	
	public WeekProgramModel(){
		for(int i = 0; i<daysOfWeekStrings.length; i++){
			this.daysOfWeek[i] = new DayModel(daysOfWeekStrings[i]);
		}
	}	
}
