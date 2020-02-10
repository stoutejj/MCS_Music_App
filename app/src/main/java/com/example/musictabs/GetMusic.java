package com.example.musictabs;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetMusic {

    // GETS ROCK MUSIC LIST
    @GET("https://itunes.apple.com/search?term=rock&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50")
    Call<Results> getRockMusic();

    // GETS CLASSIC MUSIC LIST
    @GET("https://itunes.apple.com/search?term=classick&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50")
    Call<Results> getClassicMusic();

    // GETS POP MUSIC LIST
    @GET("https://itunes.apple.com/search?term=pop&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50")
    Call<Results> getPopMusic();




}
