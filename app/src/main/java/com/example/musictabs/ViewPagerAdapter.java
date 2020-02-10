package com.example.musictabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    RockFragment rockFragment = new RockFragment();
    ClassicFragment classicFragment = new ClassicFragment();
    PopFragment popFragment = new PopFragment();

    public ViewPagerAdapter(FragmentManager fragmentManager, int numOfTabs){
        super(fragmentManager, numOfTabs);
        this.numOfTabs = numOfTabs;
    }




    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return rockFragment; //check whether if new is needed
            case 1:
                return classicFragment;
            case 2:
                return popFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    public void updateMusicList(List<Music> musicList, int position){

        switch (position) {
            case 0:
                rockFragment.setMusicList(musicList);
                break;
            case 1:
                classicFragment.setMusicList(musicList);
                break;
            case 2:
                popFragment.setMusicList(musicList);
                break;
            default:
                break;
        }

        getItem(position);
    }
}


