package com.example.texttospeechconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // Initialize variables
    EditText input;
    Button speakbtn, clearbtn;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature((Window.FEATURE_NO_TITLE));
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Assign Variables
        input = findViewById(R.id.inputid);
        speakbtn = findViewById(R.id.speakid);
        clearbtn = findViewById(R.id.clearid);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS){
                    //Select Language
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);

                }
            }
        });
        speakbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Get EditText Value
               String s = input.getText().toString();

               //Text Convert To Speech
                int speech = textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        clearbtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
            }
        }));

    }
}