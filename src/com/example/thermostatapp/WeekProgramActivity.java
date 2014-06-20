package com.example.thermostatapp;

import com.example.thermostatapp.dto.*;
import com.vanwifferensoftwaredesign.daychallenge.Challenge;
import com.vanwifferensoftwaredesign.daychallenge.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WeekProgramActivity extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_weekprogram);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		ThermostatModel model = (ThermostatModel) bundle.get("ThermostatModel");
	}
}


class AddSwitchesToScrollViewAdapter extends BaseAdapter{
	Context context;
	
	ThermostatModel data;
	SwitchModel[] switchesForToday;
	
	private static LayoutInflater inflater = null;
	
	public AddSwitchesToScrollViewAdapter(Context context, ThermostatModel data, String day) {
	    this.context = context;
	    this.data = data;
	   
	    inflater = (LayoutInflater) context
	            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return data.weekProgram.daysOfWeek.length;
	}
	
	@Override
	public Object getItem(int arg0) {
		return data[arg0];
	}
	
	@Override
	public long getItemId(int arg0) {
		return arg0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		Challenge challenge = data[position];
		
	    if (vi == null){
	        vi = inflater.inflate(R.layout.listitem, null);
	    }
	    
	    TextView header = (TextView) vi.findViewById(R.id.HeaderText);
	    header.setText(challenge.getText());
	    vi.setBackgroundColor(challenge.getBackgroundColor());
	    
	    TextView amountOfDays = (TextView) vi.findViewById(R.id.amountOfDays);
	    amountOfDays.setText("Days Running: " + challenge.getDaysRunning());
	    
	    TextView highScore = (TextView) vi.findViewById(R.id.highScore);
	    if(challenge.getHighScore() != 0){
	    	highScore.setText("Highscore: " + challenge.getHighScore() + " days");
	    }
	    return vi;
	}
}