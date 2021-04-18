package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class chapterProgrees extends AppCompatActivity {
    ProgressBar progressBar;
    Button start,reset;
    private ProgressBar mprogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_progrees);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setProgress(0);

       mprogressBar =new ProgressBar(chapterProgrees.this);
        mprogressBar.setMax(100);
mprogressBar.setIndeterminate(true);

    start = findViewById(R.id.start);
    reset = findViewById(R.id.reset);
    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final int totalTime = 100;
            Thread t = new Thread(){
                @Override
                public void run() {
                    int jumpTime = 0;
                    while (jumpTime < totalTime){
                        try{
                            sleep(200);
                            jumpTime += 5;
                            progressBar.setProgress(jumpTime);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.start();
        }
    });
    reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            progressBar.setProgress(0);
        }
    });
    }
}