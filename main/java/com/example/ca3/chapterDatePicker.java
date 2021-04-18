package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class chapterDatePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_date_picker);
        DatePicker pickDate = findViewById(R.id.pickDate);
        TextView date = findViewById(R.id.date);

        pickDate.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.setText("Date is: "+dayOfMonth+"/"+monthOfYear+"/"+year);
            }
        });
    }
}