package com.example.musictabs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder>{

    private List<Music> musicList;

    public MusicAdapter(List<Music> musicList) {

        this.musicList = musicList;

    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }


    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.item_layout,
                        parent,
                        false);

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
