package com.example.thermostatapp;

import com.example.thermostatapp.dto.*;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class AddSwitchesToScrollViewAdapter extends BaseAdapter{
	Context context;
	int day = 0;
	
	ThermostatModel dataModel;
	SwitchModel[] switchesForToday;
		
	private static LayoutInflater inflater = null;
	
	public AddSwitchesToScrollViewAdapter(Context context, ThermostatModel data, int day) {
	    this.context = context;
	    this.dataModel = data;
	    this.day = day;
	    inflater = (LayoutInflater) context
	            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return dataModel.weekProgram.daysOfWeek.length;
	}
	
	@Override
	public Object getItem(int arg0) {
		return dataModel.weekProgram.daysOfWeek[arg0];
	}
	
	@Override
	public long getItemId(int arg0) {
		return arg0;
	}
	
	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {		
		//initialise fields
		View vi = convertView;
	    if (vi == null){
	        vi = inflater.inflate(R.layout.switchperday, null);
	    }
		final SwitchModel switcher = switchesForToday[position];
		final ImageView image = (ImageView)vi.findViewById(R.id.DayNightImage);
	    final Bitmap imageToShow;
		
	    // set time
	    final EditText timeIndicator = (EditText)vi.findViewById(R.id.timerIndicator);
	    timeIndicator.setText(switcher.time);
	    
	    // set bitmap image
	    if(switcher.type == SwitchType.day){
	    	imageToShow = BitmapFactory.decodeResource(context.getResources(), R.drawable.sun);
	    } else {
	    	imageToShow = BitmapFactory.decodeResource(context.getResources(), R.drawable.moon);
	    }
	    image.setImageBitmap(imageToShow);

	    //init switch
	    Switch statusSwitch = (Switch)vi.findViewById(R.id.switchSwitch);
	    statusSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Bitmap imageReplacement;
				if(isChecked){
					if(switcher.type == SwitchType.day){
						imageReplacement = BitmapFactory.decodeResource(context.getResources(), R.drawable.sun);
					} else {
						imageReplacement = BitmapFactory.decodeResource(context.getResources(), R.drawable.moon);
					}
				} else {
					imageReplacement = BitmapFactory.decodeResource(context.getResources(), R.drawable.item_disabled);
				}
				
				image.setImageBitmap(imageReplacement);	
				timeIndicator.setEnabled(isChecked);				
			}
		});
	    return vi;
	}
}