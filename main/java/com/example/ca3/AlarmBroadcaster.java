package com.example.ca3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmBroadcaster extends BroadcastReceiver {
     static MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.song);
        mp.start();
        Toast.makeText(context, "Alarm Ringing", Toast.LENGTH_SHORT).show();
    }
}
