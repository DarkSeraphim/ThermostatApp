package com.example.thermostatapp.util;

import android.os.AsyncTask;

/**
 * @Author DarkSeraphim
 */
public class Updater<Params, Progress, Result> extends AsyncTask<Params, Progress, Result>
{

    private Params[] params;

    private final FakeAsyncTask<Params, Progress, Result> fakeTask;

    private final long interval;

    private long start = -1;

    private Updater(FakeAsyncTask<Params, Progress, Result> fakeTask, long interval)
    {
        this.fakeTask = fakeTask;
        this.interval = interval;
    }

    public void start(Params...params)
    {
        this.start(-1, params);
    }

    public void start(long delay, Params...params)
    {
        if(delay > 0)
        {
            try
            {
                Thread.sleep(delay);
            }
            catch(InterruptedException ex)
            {
                // Shh
            }
        }
        this.params = params;
        this.execute(params);
    }

    @Override
    public void onPreExecute()
    {
        this.start = System.currentTimeMillis();
        super.onPreExecute();
        this.fakeTask.onPreExecute();
    }

    @Override
    public Result doInBackground(Params...params)
    {
        return this.fakeTask.doBackgroundTask(params);
    }

    @Override
    public void onCancelled(Result result)
    {
        this.fakeTask.onCancelled();
    }

    @Override
    public void onPostExecute(Result result)
    {
        this.fakeTask.onPostExecute(result);
        long delta = System.currentTimeMillis() - start;
        long sleep = this.interval - delta;
        this.start(sleep, this.params);
    }

}
