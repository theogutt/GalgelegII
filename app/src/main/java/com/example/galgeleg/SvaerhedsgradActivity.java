package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.galgeleg.Galgelogik.Galgelogik;

public class SvaerhedsgradActivity extends AppCompatActivity {
    Button offline;
    Button dr;
    Button regneark;
    TextView sværhedsgrad;
    private Galgelogik galgelogik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svaerhedsgrad);

        offline = findViewById(R.id.button_offline);
        dr = findViewById(R.id.button_dr);
        regneark =findViewById(R.id.button_regneark);
        sværhedsgrad=findViewById(R.id.textView_sværhedsgrader);
        galgelogik = new Galgelogik();

        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offline();
            }
        });
        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dr();
            }
        });
        regneark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regneark();
            }
        });
    }
    public void offline(){
        galgelogik = new Galgelogik();
    }
    public void dr(){
        try {
            galgelogik.hentOrdFraDr();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void regneark(){
        try {
            galgelogik.hentOrdFraRegneark("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
