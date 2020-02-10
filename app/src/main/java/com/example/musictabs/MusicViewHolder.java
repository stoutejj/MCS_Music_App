package com.example.musictabs;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    TextView artistName;
    TextView collectionName;
    TextView trackPrice;
    ImageView artwork;

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);

        artistName = itemView.findViewById(R.id.tv_artist_name);
        collectionName = itemView.findViewById(R.id.tv_collection_name);
        trackPrice = itemView.findViewById(R.id.tv_track_price);
        artwork = itemView.findViewById(R.id.artwork);
    }

    void onBind(Music music) {
        artistName.setText(music.getArtistName());
        collectionName.setText(music.getCollectionName());
        trackPrice.setText(music.getTrackPrice() + "" + music.getCurrency());
        Picasso.get().load(music.getArtworkUrl60()).into(artwork);


    }
}
