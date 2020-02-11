package com.example.musictabs;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    TextView artistName;
    TextView collectionName;
    TextView trackPrice;
    ImageView artwork;
    CardView cardView;

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);

        artistName = itemView.findViewById(R.id.tv_artist_name);
        collectionName = itemView.findViewById(R.id.tv_collection_name);
        trackPrice = itemView.findViewById(R.id.tv_track_price);
        artwork = itemView.findViewById(R.id.artwork);
        cardView = itemView.findViewById(R.id.card_view);
    }

    void onBind(final Music music, final PreviewMusicListener previewMusicListener) {
        artistName.setText(music.getArtistName());
        collectionName.setText(music.getCollectionName());
        trackPrice.setText(music.getTrackPrice() + "" + music.getCurrency());
        Picasso.get().load(music.getArtworkUrl60()).into(artwork);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previewMusicListener.previewMusic(music);

            }
        });

    }
}
