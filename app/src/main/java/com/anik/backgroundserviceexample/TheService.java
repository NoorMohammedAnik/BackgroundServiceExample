package com.anik.backgroundserviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Noor Mohammed on 03-Jan-2018.
 */

public class TheService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Toast.makeText(getApplicationContext(), "Not yet implemented",Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(), "Service created", Toast.LENGTH_LONG).show();

    }

//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        //return super.onStartCommand(intent, flags, startId);
//
//        Toast.makeText(getApplicationContext(), "Service started", Toast.LENGTH_LONG).show();
//        return START_NOT_STICKY;
//    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Toast.makeText(this, "MyAlarmService.onStart()", Toast.LENGTH_LONG).show();

    }


    @Override

    public boolean onUnbind(Intent intent) {

        Toast.makeText(this, "MyAlarmService.onUnbind()", Toast.LENGTH_LONG).show();

        return super.onUnbind(intent);

    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), "Service destroyed", Toast.LENGTH_SHORT).show();
    }
}
