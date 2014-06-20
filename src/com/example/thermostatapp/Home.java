package com.example.thermostatapp;

import com.example.thermostatapp.dto.ThermostatModel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Button buttonToWeekProgram = (Button) findViewById(R.id.manage_weekprogram_button);
		
		ThermostatModel model = (ThermostatModel)getIntent().getExtras().getBundle("Bundle").get("ThermostatModel");
		Log.d("Debug - Home.java", model.current_temperature);
		
		buttonToWeekProgram.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
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
