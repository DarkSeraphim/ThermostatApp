package com.example.thermostatapp.dto;

import java.net.ConnectException;

import org.thermostatapp.util.*;

public class ThermostatModel {
	public String current_day;
	public String time;
	public String current_temperature;
	
	public String target_temperature;
	
	public String day_temperature;
	public String night_temperature;
	public String week_program_state;
	public WeekProgramModel weekProgram;
	
	public ThermostatModel(){
		this.current_day = HeatingSystem.get("current_day");
		this.time = HeatingSystem.get("time");
		this.current_temperature = HeatingSystem.get("currentTemperature");
		this.day_temperature = HeatingSystem.get("day_temperature");
		this.night_temperature = HeatingSystem.get("target_temperature");
		this.weekProgram = new WeekProgramModel();
		try {
			this.week_program_state = HeatingSystem.get("weekProgramState");
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
