package com.example.musictabs;

public class Music {
    public String artistName;
    public String collectionName;
    public String artworkUrl;
    public String trackPrice;
    public String currency;

    public Music(String artistName,
                 String collectionName,
                 String artworkUrl,
                 String trackPrice,
                 String currency) {

        this.artistName = artistName;
        this.collectionName = collectionName;
        this.artworkUrl = artworkUrl;
        this.trackPrice = trackPrice;
        this.currency = currency;
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

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        this.artworkUrl = artworkUrl;
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
}