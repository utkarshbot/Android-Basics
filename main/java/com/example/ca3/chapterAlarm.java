package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ca3.AlarmBroadcaster.mp;

public class chapterAlarm extends AppCompatActivity {
    Button start,restart,cancel;
    EditText edt_pi;
    int inputTime;
    Intent intent;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_alarm);
        start = findViewById(R.id.start);
        restart = findViewById(R.id.repeat);
        cancel = findViewById(R.id.cancel);
        edt_pi = findViewById(R.id.input);

        intent = new Intent(chapterAlarm.this, AlarmBroadcaster.class);
        pendingIntent = PendingIntent.getBroadcast(chapterAlarm.this, 234, intent, 0);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_pi.length()!=0){
                    inputTime = Integer.parseInt(edt_pi.getText().toString());
                    alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(inputTime * 1000), pendingIntent);
                    Toast.makeText(chapterAlarm.this, "Alarm set in "+inputTime+" seconds", Toast.LENGTH_SHORT).show();
                }else{
                    edt_pi.setError("Invalid");
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                alarmManager.cancel(pendingIntent);
                Toast.makeText(chapterAlarm.this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, (1000*5),System.currentTimeMillis(), pendingIntent);
                Toast.makeText(chapterAlarm.this, "Repeating Alarm in 5 Seconds", Toast.LENGTH_SHORT).show();
            }
        });
    }
}