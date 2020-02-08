package com.example.musictabs;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetMusic {
    //Specify the request type and pass the relative URL
    //https://itunes.apple.com/search?term=classick&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50
    @GET("search?term=classick&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50")

    //Wrap the response in a Call object with the type of the expected result
    Call<List<Music>> getAllMusic();

}
