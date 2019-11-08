package com.example.galgeleg;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.galgeleg.Galgelogik.Galgelogik;

import java.util.Date;

public class SpilActivity extends AppCompatActivity {
    private Galgelogik galgelogik;
    private ImageView galgeImage;
    private TextView synligeBogstaver;
    private TextView brugteBogstaver;
    private EditText gæt;
    private Button submitGæt;
    private TextView resultat;
    private Date date;
    // TODO: 20-10-2019
    //Lav highscore ting
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);
        galgelogik = new Galgelogik();
        galgeImage = findViewById(R.id.imageView_galge);
        synligeBogstaver = findViewById(R.id.textView_synlige_bogstaver);
        brugteBogstaver = findViewById(R.id.textView_brugte_bogstaver2);
        gæt = findViewById(R.id.editText_gæt);
        submitGæt = findViewById(R.id.button_submit_gæt);
        resultat = findViewById(R.id.textView_Resultat);
        date = new Date();

        galgelogik.nulstil();
        submitGæt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(galgelogik.erSpilletSlut()){
                    nulstil();
                }
                else{
                String gættet = gæt.getText().toString();
                gæt.setText("");
                galgelogik.gætBogstav(gættet);
                synligeBogstaver.setText(galgelogik.getSynligtOrd());
                brugteBogstaver.setText(galgelogik.getBrugteBogstaver().toString());
                opdaterGalgeImage();
                slut(); }
                }
        });
    }
    private void nulstil(){
        galgelogik.nulstil();
        resultat.setText("");
        synligeBogstaver.setText("");
        brugteBogstaver.setText("");
        galgeImage.setImageResource(R.drawable.galge);
        submitGæt.setText("gæt");
    }
    private void slut(){
            if(galgelogik.erSpilletVundet()){
                Intent intent = new Intent(this, SpilVundetActivity.class);
                startActivity(intent);
                //resultat.setText("Spillet er vundet");
                //submitGæt.setText("Spil igen");
                //highscore kode
                //galgelogik.getAntalForkerteBogstaver();
                //galgelogik.getOrdet();
                //date.getTime();
            }
            else if(galgelogik.erSpilletTabt()) {
                Intent intent = new Intent(this, SpilTabtActivity.class);
                startActivity(intent);
                //resultat.setText("Spillet er tabt");
                //submitGæt.setText("Spil igen");
            }
    }
    private void opdaterGalgeImage(){
        switch (galgelogik.getAntalForkerteBogstaver()){
            case 0: galgeImage.setImageResource(R.drawable.galge);
                break;
            case 1:galgeImage.setImageResource(R.drawable.forkert1);
                break;
            case 2:galgeImage.setImageResource(R.drawable.forkert2);
                break;
            case 3:galgeImage.setImageResource(R.drawable.forkert3);
                break;
            case 4:galgeImage.setImageResource(R.drawable.forkert4);
                break;
            case 5:galgeImage.setImageResource(R.drawable.forkert5);
                break;
            case 6:galgeImage.setImageResource(R.drawable.forkert6);
                break;
        }
    }
}