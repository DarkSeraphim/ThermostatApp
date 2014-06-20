package com.example.thermostatapp.util;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import com.example.thermostatapp.R;
import java.util.TreeMap;

/**
 * @Author DarkSeraphim
 */
public abstract class MenuBarActivity extends ActionBarActivity
{

    private AsyncTask task;

    public MenuBarActivity()
    {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
    }

    public void setRefreshTask(AsyncTask task)
    {
        this.task = task;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                break;
            case R.id.action_settings:
                break;
            case R.id.action_refresh:
                // TODO: Implement Updater
                task.execute();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
