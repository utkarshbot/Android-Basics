package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class chapterExternalStorage extends AppCompatActivity {
    EditText editTextFileName,editTextData;
    Button saveButton,readButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_external_storage);
        editTextFileName=findViewById(R.id.editText1);
        editTextData=findViewById(R.id.editText2);
        saveButton=findViewById(R.id.button1);
        readButton=findViewById(R.id.button2);

        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String filename=editTextFileName.getText().toString();
                String data=editTextData.getText().toString();

                FileOutputStream fos;
                if(!filename.isEmpty() && !data.isEmpty()){
                    try {
                        File myFile = new File("/sdcard/"+filename);
                        myFile.createNewFile();
                        FileOutputStream fOut = new FileOutputStream(myFile);
                        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                        myOutWriter.append(data);
                        myOutWriter.close();
                        fOut.close();
                        Toast.makeText(getApplicationContext(),filename + "saved",Toast.LENGTH_LONG).show();
                    }
                    catch (FileNotFoundException e) {e.printStackTrace();}
                    catch (IOException e) {e.printStackTrace();
                    }

                }
                else{
                    editTextFileName.setError("Invalid Input");
                    editTextData.setError("Invalid Input");
                }

            }
        });

        //Performing action on Read Button
        readButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String filename=editTextFileName.getText().toString();
                StringBuffer stringBuffer = new StringBuffer();
                String aDataRow = "";
                String aBuffer = "";
                try {
                    File myFile = new File("/sdcard/"+filename);
                    FileInputStream fIn = new FileInputStream(myFile);
                    BufferedReader myReader = new BufferedReader(
                            new InputStreamReader(fIn));
                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";
                    }
                    myReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),aBuffer,Toast.LENGTH_LONG).show();
            }
        });
    }
}