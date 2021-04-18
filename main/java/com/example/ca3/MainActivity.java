package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =new Toolbar(MainActivity.this);
        setSupportActionBar(toolbar);
    }

    public void onLayoutCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterLayout.class));
    }

    public void onNotificationCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterNotification.class));
    }

    public void onAlarmCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterAlarm.class));
    }

    public void onFragmentCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterFragment.class));
    }

    public void onDateCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterDatePicker.class));
    }

    public void onSharedCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterSharedPrefernce.class));
    }

    public void onNavigationCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterNavigation.class));
    }

    public void onInternalCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterInternalStorage.class));
    }

    public void onProgressCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterProgrees.class));
    }

    public void onExternalCall(View view) {
        startActivity(new Intent(MainActivity.this,chapterExternalStorage.class));
    }
}