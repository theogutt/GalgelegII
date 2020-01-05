package com.example.galgeleg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class ListeAdapter extends RecyclerView.Adapter<ListeAdapter.ListeViewHolder> {
    private ArrayList<ListeObjekt> highscoreList;

    public static class ListeViewHolder extends  RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView linje1;
        public TextView linje2;
        public TextView linjeDato;


        public ListeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            linje1=itemView.findViewById(R.id.textView_linje1);
            linje2=itemView.findViewById(R.id.textView_linje2);
            linjeDato=itemView.findViewById(R.id.textView_linjeDato);
        }
    }

    public ListeAdapter(ArrayList<ListeObjekt>highscoreList){
        this.highscoreList = highscoreList;
    }

    @NonNull
    @Override
    public ListeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.highscores,parent, false);
        ListeViewHolder listeViewHolder = new ListeViewHolder(view);
        return listeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListeViewHolder holder, int position) {
        ListeObjekt currObjekt = highscoreList.get(position);

        holder.imageView.setImageResource(currObjekt.getImageInt());
        holder.linje1.setText(currObjekt.getLinje1());
        holder.linje2.setText(currObjekt.getLinje2());
        holder.linjeDato.setText(currObjekt.getLinjeDato());
        Collections.sort(highscoreList);
    }

    @Override
    public int getItemCount() {
        return highscoreList.size();
    }
}
