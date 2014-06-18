package com.example.thermostatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Home extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}
	
	public void toManageThermostat(View view){
		Intent intent = new Intent(this, ManageThermostat.class);
		startActivity(intent);
	}
	
	public void toManageWeekProgram(View view){
		Intent intent = new Intent(this, ManageWeekProgram.class);
		startActivity(intent);
	}
}
