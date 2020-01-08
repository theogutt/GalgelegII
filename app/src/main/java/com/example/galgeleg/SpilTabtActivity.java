package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpilTabtActivity extends AppCompatActivity {

    Button seHighscore;
    Button spilIgen;
    TextView ordetVar;
    String ord;
    boolean loaded = false;
    private SoundPool soundPool;
    int soundLose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_tabt);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }
        soundLose = soundPool.load(this, R.raw.lose,1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int sampleId,int status) {
                loaded = true;
                playSoundLose();
            }
        });
        seHighscore = findViewById(R.id.button_se_highscore2);
        spilIgen = findViewById(R.id.button_spil_igen2);
        ordetVar = findViewById(R.id.textView_ordetVar);
        ord = getIntent().getStringExtra("rigtigtOrd");
        ordetVar.setText("Ordet var: "+ord);


        seHighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seHighscore();
            }
        });
        spilIgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spilIgen();
            }
        });
    }
    public void seHighscore(){
        Intent intent = new Intent(this, HighscoreActivity.class);
        startActivity(intent);
    }
    public void spilIgen(){
        Intent intent = new Intent(this, SpilActivity.class);
        startActivity(intent);
    }
    public void playSoundLose(){
        if (loaded) {
            Log.i("Sound","should play");
            soundPool.play(soundLose, 1, 1, 0, 0, 1);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
