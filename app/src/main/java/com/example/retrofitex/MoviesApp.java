package com.example.retrofitex;

import android.app.Application;
import android.os.SystemClock;
import android.util.Log;

public class MoviesApp extends Application {
    private static final String TAG="MoviesApp";

    @Override
    public void onCreate(){
        super.onCreate();
        long startTime= SystemClock.elapsedRealtime();

        //intialization code here
        long elapsed=SystemClock.elapsedRealtime()-startTime;
        Log.i(TAG,"Intialized in " +elapsed+"ms");
    }

}
