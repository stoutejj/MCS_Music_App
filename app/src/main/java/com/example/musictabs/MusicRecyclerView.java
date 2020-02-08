package com.example.musictabs;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicRecyclerView extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Music> musicList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        MusicAdapter musicAdapter = new MusicAdapter(musicList);

        musicAdapter.setMusicList(musicList);

        recyclerView.setAdapter(musicAdapter);

    }
}


