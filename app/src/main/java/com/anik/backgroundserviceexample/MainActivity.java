package com.anik.backgroundserviceexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button start,stop;

    private PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=(Button)findViewById(R.id.btn_start);
        stop=(Button)findViewById(R.id.btn_stop);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(MainActivity.this,TheService.class);
              //  startService(in);

//start
                pendingIntent = PendingIntent.getService(MainActivity.this, 0, in, 0);



                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);



                Calendar calendar = Calendar.getInstance();

                calendar.setTimeInMillis(System.currentTimeMillis());

                calendar.add(Calendar.SECOND, 10);

               // alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + 5000, 10 * 1000, pendingIntent);


                Toast.makeText(MainActivity.this, "Start Alarm", Toast.LENGTH_LONG).show();

            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,TheService.class);

                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

                alarmManager.cancel(pendingIntent);

                // Tell the user about what we did.

                Toast.makeText(MainActivity.this, "Cancel!", Toast.LENGTH_LONG).show();

                stopService(in);
            }
        });
    }
}
