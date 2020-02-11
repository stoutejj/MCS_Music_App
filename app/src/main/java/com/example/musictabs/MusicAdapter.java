package com.example.musictabs;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder>{

    private List<Music> musicList;
    private static final String TAG = "MusicAdapter";
    PreviewMusicListener previewMusicListener;

    public void setMusicList(List<Music> musicList, PreviewMusicListener previewMusicListener){
        this.musicList = musicList;
        this.previewMusicListener = previewMusicListener;
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


        MusicViewHolder holder = new MusicViewHolder(view);

        return holder;
    }




    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, final int position) {

        holder.onBind(musicList.get(position),previewMusicListener);
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
