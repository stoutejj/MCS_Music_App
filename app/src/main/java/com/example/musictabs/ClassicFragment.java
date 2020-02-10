package com.example.musictabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClassicFragment extends Fragment {
    RecyclerView classicRecyclerView;
    List<Music> musicList = new ArrayList<>();
    MusicAdapter musicAdapter = new MusicAdapter();
    private static final String TAG = "ClassicFragment";


    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
        musicAdapter.setMusicList(musicList);
        Log.d(TAG, "SET MUSIC LIST" + musicList.toString());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.classic_fragment,
                container,
                false);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        getActivity(),
                        LinearLayoutManager.VERTICAL,
                        false);

        classicRecyclerView = view.findViewById(R.id.classic_recycler_view);

        classicRecyclerView.setLayoutManager(linearLayoutManager);

        classicRecyclerView.setAdapter(musicAdapter);

        return view;

    }
}
