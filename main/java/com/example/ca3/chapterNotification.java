package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class chapterNotification extends AppCompatActivity {
    NotificationManager notificationManager;

    public static final String channel_ID = "My Channel";
    public static final int notification_ID = 1;
    public static final String myKey = "my Key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_notification);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    public void sendNotification(View view) {
        myNotificationChannel();

        Intent i = new Intent(chapterNotification.this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(chapterNotification.this, 1, i, PendingIntent.FLAG_ONE_SHOT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel_ID);
        builder.setSmallIcon(R.drawable.notifiaction)
                .setContentTitle("Tutorial Point")
                .setContentText("Generated Notification")
                .build();

        builder .setContentIntent(pi);
        builder.setAutoCancel(true);
        notificationManager.notify(notification_ID, builder.build());

    }
    public void myNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String name = "Channel Name";
            String desc = "Channel Description";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(channel_ID, name, importance);
            notificationChannel.setDescription(desc);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.canShowBadge();

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}