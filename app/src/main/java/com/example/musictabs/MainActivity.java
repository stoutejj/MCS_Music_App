package com.example.musictabs;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabRock;
    TabItem tabClassic;
    TabItem tabPop;

    MusicAdapter musicAdapter;
    RecyclerView musicRecyclerView;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tab_layout);
        tabRock = findViewById(R.id.tab_rock);
        tabClassic = findViewById(R.id.tab_classic);
        tabPop = findViewById(R.id.tab_pop);
        viewPager = findViewById(R.id.view_pager);


        GetMusic service = RetrofitClient.getRetrofitInstance().create(GetMusic.class);

        Call<List<Music>> call = service.getAllMusic();
        call.enqueue(new Callback<List<Music>>() {


            @Override
            public void onResponse(Call<List<Music>> call, Response<List<Music>> response) {
                loadMusicList(response.body());
            }

            @Override
            public void onFailure(Call<List<Music>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();
                Log.d(TAG, t.getMessage());
            }
        });

    }

    private void loadMusicList(List<Music> musicList) {

        musicRecyclerView = findViewById(R.id.rock_recycler);
        musicAdapter = new MusicAdapter(musicList);

//Use a LinearLayoutManager with default vertical orientation//

        RecyclerView.LayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        MainActivity.this,
                LinearLayoutManager.VERTICAL,
                        false);

        musicRecyclerView.setLayoutManager(linearLayoutManager);
        musicAdapter.setMusicList(musicList);

        musicRecyclerView.setAdapter(musicAdapter);
    }
}



/*


                // viewPager.setAdapter((new ViewPagerAdapter(getSupportFragmentManager(),3)));
                //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

                //tabLayout.addOnTabSelectedListener((new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected (TabLayout.Tab tab){
            if (tab.getPosition() == 1) {

            } else if (tab.getPosition() == 2) {

            } else {

            }
        }

        @Override
        public void onTabUnselected (TabLayout.Tab tab){

        }

        @Override
        public void onTabReselected (TabLayout.Tab tab){

        }
    }));
}

 */

