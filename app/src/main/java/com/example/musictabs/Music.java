package com.example.musictabs;

public class Music {
    public String artistName;
    public String collectionName;
    public String artworkUrl60;
    public String trackPrice;
    public String currency;
    public String previewUrl;



    public Music(String artistName,
                 String collectionName,
                 String artworkUrl,
                 String trackPrice,
                 String currency,
                 String previewUrl) {

        this.artistName = artistName;
        this.collectionName = collectionName;
        this.artworkUrl60 = artworkUrl;
        this.trackPrice = trackPrice;
        this.currency = currency;
        this.previewUrl = previewUrl;
    }


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }
}