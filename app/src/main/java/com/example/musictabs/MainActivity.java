package com.example.musictabs;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
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
    ViewPagerAdapter viewPagerAdapter;
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
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


        //SETS TAB NAME AND ICON BASED ON POSITION
        tabLayout.getTabAt(0).setIcon(R.drawable.rock);
        tabLayout.getTabAt(0).setText("ROCK");

        tabLayout.getTabAt(1).setIcon(R.drawable.classic);
        tabLayout.getTabAt(1).setText("CLASSIC");


        tabLayout.getTabAt(2).setIcon(R.drawable.pop);
        tabLayout.getTabAt(2).setText("POP");


        //tabLayout.addTab(tabLayout.newTab().setCustomView(tabRock));


        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        networkCall(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position == 1){
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.darker_gray));
                }
                else if(position == 2){

                }
                else{

                }

                networkCall(position);
                Log.d(TAG, "TAB POSITION " + position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    public void networkCall(final int position) {

        GetMusic service = RetrofitClient.getRetrofitInstance().create(GetMusic.class);

        Call<Results> call;

        if (position == 0) {
            call = service.getRockMusic();
        } else if (position == 1) {
            call = service.getClassicMusic();
        } else {
            call = service.getPopMusic();
        }

        call.enqueue(new Callback<Results>() {


            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                viewPagerAdapter.updateMusicList(response.body().results, position);

                Toast.makeText(MainActivity.this,
                        "FOUND "+ response.body().getResultCount()+" RESULTS",
                        Toast.LENGTH_LONG).show();

                Log.d(TAG, response.body().results.toString());
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();
                Log.d(TAG, t.getMessage());
            }
        });

    }

}





