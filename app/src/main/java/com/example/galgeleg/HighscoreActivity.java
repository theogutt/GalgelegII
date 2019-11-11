package com.example.galgeleg;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HighscoreActivity extends AppCompatActivity {
    private static RecyclerView recyclerView ;
    private static RecyclerView.Adapter adapter;
    private static RecyclerView.LayoutManager layoutManager;
    static ArrayList<ListeObjekt>liste = new ArrayList<>();
    private static int firstTime=0;

    // TODO: 20-10-2019
    //lave liste med highscores
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        if(firstTime==0) {
            liste.add(new ListeObjekt(R.drawable.forkert3, "Ord: Motorvej ", "Forsøg: 3"));
            liste.add(new ListeObjekt(R.drawable.forkert5, "Ord: bil ", "Forsøg: 5"));
            liste.add(new ListeObjekt(R.drawable.forkert1, "Ord: Skovsnegl ", "Forsøg: 1"));
            firstTime=1;
        }
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListeAdapter(liste);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
