package com.example.thermostatapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.net.ConnectException;
import java.util.List;

import com.example.thermostatapp.dto.ThermostatModel;

/**
 * @Author DarkSeraphim
 */
public class SplashScreen extends Activity
{
    @Override
    public void onCreate(final Bundle savedInstance)
    {
    	
        super.onCreate(savedInstance);
        
        Bundle bundle;
        
        new AsyncTask<String, Void, ThermostatModel>()
        {

            @Override
            public void onPreExecute()
            {
               
            }

            @Override
            public ThermostatModel doInBackground(String...params)
            {
				try {
					return ThermostatModel.create();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
	                return null;
				}
            }

            @Override
            public void onPostExecute(ThermostatModel data)
            {
            	Log.d("debug", data.current_temperature);
                if(data != null)
                {
                	Bundle bundle = new Bundle();
                	bundle.putSerializable("ThermostatModel", data);
                	closeSplash(bundle);
                }
                
            }
        }.execute();

    }

    public void closeSplash(Bundle bundle)
    {
    	Intent i = new Intent(this, Home.class);
    	i.putExtra("Bundle", bundle);
        this.startActivity(i);
    }
}
