package com.example.thermostatapp.util;

import android.os.AsyncTask;

/**
 * @Author DarkSeraphim
 */
public class Updater extends Thread
{

    private boolean running = true;

    private final AsyncTask task;

    private final long interval;

    private Updater(AsyncTask task, long interval)
    {
        this.task = task;
        this.interval = interval;
    }

    @Override
    public void start()
    {
        this.running = true;
        super.start();
    }

    @Override
    public void run()
    {
        long start, delta, sleep;
        while(this.running)
        {
            start = System.currentTimeMillis();
            this.task.execute();
            delta = System.currentTimeMillis() - start;
            sleep = this.interval - delta;
            if(sleep > 0)
            {
                try
                {
                    Thread.sleep(sleep);
                }
                catch(InterruptedException ex)
                {
                    // Shh
                }
            }
        }
    }

    public void cancel()
    {
        this.running = false;
    }
}
