package com.example.thermostatapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import java.util.List;

/**
 * @Author DarkSeraphim
 */
public class SplashScreen extends Activity
{
    @Override
    public void onCreate(final Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        new AsyncTask<String, Void, List<String>>()
        {

            @Override
            public void onPreExecute()
            {
            }

            @Override
            public List<String> doInBackground(String...params)
            {
                // Welke data willen we hebben?
                return null;
            }

            @Override
            public void onPostExecute(List<String> data)
            {
                if(data != null)
                {
                    // Parse data
                }
                closeSplash();
            }
        }.execute();

    }

    public void closeSplash()
    {
        Intent i = new Intent(this, Home.class);
        this.startActivity(i);
    }
}
