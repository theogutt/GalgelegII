package com.example.galgeleg;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import static android.content.Context.MODE_PRIVATE;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<ListObjectSvaerhedsgrad> svaerhedsgradList;

    public static class ListViewHolder extends  RecyclerView.ViewHolder{
        public TextView linje;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            linje=itemView.findViewById(R.id.textView_linje);
        }
    }

    public ListAdapter(ArrayList<ListObjectSvaerhedsgrad>svaerhedsgradList){
        this.svaerhedsgradList = svaerhedsgradList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.svaerhedsgrad,parent, false);
        ListViewHolder listeViewHolder = new ListViewHolder(view);
        return listeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListObjectSvaerhedsgrad currObjekt = svaerhedsgradList.get(position);

        holder.linje.setText(currObjekt.getLinje());
    }

    @Override
    public int getItemCount() {
        return svaerhedsgradList.size();
    }
}

