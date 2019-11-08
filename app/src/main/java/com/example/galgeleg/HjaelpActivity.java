package com.example.galgeleg;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HjaelpActivity extends AppCompatActivity {

    private TextView textView_sværhedsgrader;
    private TextView textView_offline;


    // TODO: 20-10-2019 få styr på teksten i layoutet
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hjaelp);

        textView_sværhedsgrader = findViewById(R.id.textView_sværhedsgrader);
        textView_offline = findViewById(R.id.textView_offline);
        textView_sværhedsgrader.setText("Sværhedsgrader: Vælg mellem offline, DR og sværhedsgraderne 1-12, hvor 1 er det nemmeste." +
                " DR henter ord fra dr.dk's forside.");
        textView_offline.setText("Offline: Vælg sværhedsgrad offline, hvis du ikke har netværksforbindelse,  da de andre indstillinger kræver det.");
    }
}
