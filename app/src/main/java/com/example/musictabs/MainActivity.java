package com.example.musictabs;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements PreviewMusicListener{
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tab_layout);
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

        networkCall(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //CHANGES THE COLOR OF THE TABS AND VIEW PAPER BASED ON THE GENRE OF MUSIC SELECTED

                if(position == 0){
                    viewPager.setBackgroundColor(Color.parseColor("#ffffff"));
                    tabLayout.setBackgroundColor(Color.parseColor("#ffffff"));

                }
                else if(position == 1){
                    viewPager.setBackgroundColor(Color.parseColor("#89cff0"));
                    tabLayout.setBackgroundColor(Color.parseColor("#89cff0"));
                }
                else{
                    viewPager.setBackgroundColor(Color.parseColor("#ffff00"));
                    tabLayout.setBackgroundColor(Color.parseColor("#ffff00"));
                }

                networkCall(position);
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
                viewPagerAdapter.updateMusicList(response.body().results, position,MainActivity.this);

                Toast.makeText(MainActivity.this,
                        "FOUND "+ response.body().getResultCount()+" RESULTS",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void previewMusic(Music music) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(music.getPreviewUrl()), "audio/*");
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

    }}
}

