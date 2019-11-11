package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpilTabtActivity extends AppCompatActivity {

    Button seHighscore;
    Button spilIgen;
    TextView ordetVar;
    String ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_tabt);

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
}
