package com.example.musictabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public ViewPagerAdapter(FragmentManager fragmentManager, int numOfTabs){
        super(fragmentManager, numOfTabs);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new RockFragment(); //check whether if new is needed
            case 1:
                return new ClassicFragment();
            case 2:
                return new PopFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
