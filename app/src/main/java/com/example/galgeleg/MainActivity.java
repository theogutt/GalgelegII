package com.example.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.galgeleg.Galgelogik.Galgelogik;

public class MainActivity extends AppCompatActivity {
    private Galgelogik galgelogik;

    private Button highscoreButton;
    private Button spilButton;
    private Button hjaelpButton;
    private Button svaerhedsgradButton;



    //Hovedmenu
    @Override
    // TODO: 20-10-2019
    //lav sværhedsgrader som dropdownmenu inde på hovedmenuen

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        galgelogik = new Galgelogik();
        svaerhedsgradButton = findViewById(R.id.button_svaerhedsgrad);
        svaerhedsgradButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSvaerhedsgradActivity();
            }
        });
        spilButton = findViewById(R.id.button_spil);
        spilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSpilActivity();
            }
        });
        highscoreButton = findViewById(R.id.button_highscore);
        highscoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHighscoreActivity();
            }
        });
        hjaelpButton = findViewById(R.id.button_hjaelp);
        hjaelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHjaelpActivity();
            }
        });
    }

    public void openHjaelpActivity() {
        Intent intent = new Intent(this, HjaelpActivity.class);
        startActivity(intent);
    }
    public void openSpilActivity() {
        Intent intent = new Intent(this, SpilActivity.class);
        startActivity(intent);
    }
    public void openHighscoreActivity() {
        Intent intent = new Intent(this, HighscoreActivity.class);
        startActivity(intent);
    }
    public void openSvaerhedsgradActivity() {
        Intent intent = new Intent(this, SvaerhedsgradActivity.class);
        startActivity(intent);
    }
    public void vælgSværhedsgrad() throws Exception {
        int sværhedsgrad = 11;// hent data fra dropdown menu
        switch(sværhedsgrad){
            case 1: galgelogik.hentOrdFraRegneark("1"); break;
            case 2: galgelogik.hentOrdFraRegneark("2"); break;
            case 3:galgelogik.hentOrdFraRegneark("3"); break;
            case 4: galgelogik.hentOrdFraRegneark("4"); break;
            case 5: galgelogik.hentOrdFraRegneark("5"); break;
            case 6: galgelogik.hentOrdFraRegneark("6"); break;
            case 7: galgelogik.hentOrdFraRegneark("7"); break;
            case 8: galgelogik.hentOrdFraRegneark("8"); break;
            case 9: galgelogik.hentOrdFraRegneark("9"); break;
            case 10: galgelogik.hentOrdFraRegneark("10"); break;
            case 11: galgelogik.hentOrdFraRegneark("11"); break;
            case 12: galgelogik.hentOrdFraRegneark("12"); break;
            case 13: galgelogik.hentOrdFraDr(); break;
            case 14: galgelogik.muligeOrd.clear();
            offlineOrd();//test om det virker uden denne metode
            break;
        }
    }
    public void offlineOrd(){
        galgelogik.muligeOrd.add("bil");
        galgelogik.muligeOrd.add("computer");
        galgelogik.muligeOrd.add("programmering");
        galgelogik. muligeOrd.add("motorvej");
        galgelogik.muligeOrd.add("busrute");
        galgelogik.muligeOrd.add("gangsti");
        galgelogik. muligeOrd.add("skovsnegl");
        galgelogik.muligeOrd.add("solsort");
        galgelogik.muligeOrd.add("nitten");
    }
}
