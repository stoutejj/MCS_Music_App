package com.example.musictabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RockFragment extends Fragment {
    RecyclerView rockRecyclerView;
    List<Music> musicList = new ArrayList<>();
    MusicAdapter musicAdapter = new MusicAdapter();
    private static final String TAG = "RockFragment";


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

        View view = inflater.inflate(R.layout.rock_fragment,
                container,
                false);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        getActivity(),
                        LinearLayoutManager.VERTICAL,
                        false);

        rockRecyclerView = view.findViewById(R.id.rock_recycler);



        rockRecyclerView.setLayoutManager(linearLayoutManager);


        rockRecyclerView.setAdapter(musicAdapter);

        return view;

    }
}
