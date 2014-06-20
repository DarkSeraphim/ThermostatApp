package com.example.thermostatapp.dto;

public class SwitchModel {
	
	public SwitchType type;
	public boolean state;
	public String time;
	
	public SwitchModel(SwitchType type, boolean state, String time){
		this.type = type;
		this.state = state;
		this.time = time;
	}
}
