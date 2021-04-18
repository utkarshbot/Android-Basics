package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class chapterInternalStorage extends AppCompatActivity {
    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_internal_storage);
        textmsg=(EditText)findViewById(R.id.editText1);
    }
    public void WriteBtn(View v) {
        // add-write text into file
        String msg = textmsg.getText().toString();
        try {
            if(msg.isEmpty()){
                textmsg.setError("Empty field");
            }
            else {
                FileOutputStream fileout = openFileOutput("mytextfile.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(textmsg.getText().toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "File saved successfully!",
                        Toast.LENGTH_SHORT).show();
                textmsg.setText("");
                finish();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void ReadBtn(View v) {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            textmsg.setText(s);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}