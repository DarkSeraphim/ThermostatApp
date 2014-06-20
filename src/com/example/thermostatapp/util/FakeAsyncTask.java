package com.example.thermostatapp.util;

/**
 * @Author DarkSeraphim
 */
public interface FakeAsyncTask<Params, Progress, Result>
{
    public void onPreExecute();

    public Result doBackgroundTask(Params...params);

    public void onCancelled();

    public void onPostExecute(Result result);
}
