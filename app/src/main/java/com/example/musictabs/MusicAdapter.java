package com.example.musictabs;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder>{

    private List<Music> musicList;
    int position;
    private static final String TAG = "MusicAdapter";

    public void setMusicList(List<Music> musicList){
        this.musicList = musicList;
        //Log.d(TAG, "SET MUSIC LIST" + musicList.toString());
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.item_layout,
                        parent,
                        false);
/*
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =
                Log.d(TAG, "ON CLICK "+musicList.get(position).getArtistName());
            }
        });
*/



        MusicViewHolder holder = new MusicViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {

        holder.onBind(musicList.get(position));

    }

    /**
     * Will be a number representation of many rows
     * that will be printed in to you recycler view
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return musicList != null ? musicList.size() : 0;
    }

}
