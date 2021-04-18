package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chapterSharedPrefernce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_shared_prefernce);
    }

    public void showExample(View view) {
        startActivity(new Intent(chapterSharedPrefernce.this,exampleShared.class));
    }
}