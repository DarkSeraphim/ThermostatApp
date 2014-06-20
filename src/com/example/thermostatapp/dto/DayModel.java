package com.example.thermostatapp.dto;

import android.Manifest.permission;
import android.app.admin.DeviceAdminInfo;

public class DayModel {
	public String day;
	
	public DayModel(String name){
		this.day = name;		
	}
	
	public SwitchModel switchOne = new SwitchModel(SwitchType.night, false, "00:00");
	public SwitchModel switchTwo = new SwitchModel(SwitchType.night, false, "00:00");
	public SwitchModel switchThree = new SwitchModel(SwitchType.night, false, "00:00");
	public SwitchModel switchfour = new SwitchModel(SwitchType.night, false, "00:00");
	public SwitchModel switchFive = new SwitchModel(SwitchType.night, false, "00:00");
	
	public SwitchModel switchSix = new SwitchModel(SwitchType.day, false, "00:00");
	public SwitchModel switchSeven = new SwitchModel(SwitchType.day, false, "00:00");
	public SwitchModel switchEight = new SwitchModel(SwitchType.day, false, "00:00");
	public SwitchModel switchNine = new SwitchModel(SwitchType.day, false, "00:00");
	public SwitchModel switchTen = new SwitchModel(SwitchType.day, false, "00:00");
}
