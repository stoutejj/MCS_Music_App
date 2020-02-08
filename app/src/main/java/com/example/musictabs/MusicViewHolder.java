package com.example.musictabs;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    TextView artistName;
    TextView collectionName;
    TextView trackPrice;

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);

        artistName = itemView.findViewById(R.id.tv_artist_name);
        collectionName = itemView.findViewById(R.id.tv_collection_name);
        trackPrice = itemView.findViewById(R.id.tv_track_price);
    }

    void onBind(Music music) {
        artistName.setText(music.getArtistName());
        collectionName.setText(music.getCollectionName());
        trackPrice.setText(music.getTrackPrice() + "" + music.getCurrency());
    }
}
