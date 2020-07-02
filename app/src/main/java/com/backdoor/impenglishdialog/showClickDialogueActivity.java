package com.backdoor.impenglishdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class showClickDialogueActivity extends AppCompatActivity {

    private String Eng, Ban;
    private TextView textViewEng, textViewBan;
    ImageView playSound;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_click_dialogye);

        textViewEng = findViewById(R.id.textViewEng);
        textViewBan = findViewById(R.id.textViewBan);
        playSound = findViewById(R.id.playSound);


        if (getIntent().hasExtra("dialogueEnd") && getIntent().hasExtra("dialogueBan")) {
            Eng = getIntent().getStringExtra("dialogueEnd");
            Ban = getIntent().getStringExtra("dialogueBan");
        }

        textViewEng.setText(Eng);
        textViewBan.setText(Ban);

        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(showClickDialogueActivity.this, new TextToSpeech.OnInitListener() {

                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            int result = tts.setLanguage(Locale.US);
                            if (result == TextToSpeech.LANG_MISSING_DATA ||
                                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                Log.e("error", "This Language is not supported");
                            } else {
                                ConvertTextToSpeech();
                            }
                        } else
                            Log.e("error", "Initilization Failed!");
                    }
                });

            }
        });
    }

    private void ConvertTextToSpeech() {
        String text = textViewEng.getText().toString();
        if ("".equals(text)) {
            text = "Content not available";
        }
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}