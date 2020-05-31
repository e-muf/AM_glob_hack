package com.example.eco_impulse.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.eco_impulse.fragments.FragmentPerfil;
import com.example.eco_impulse.fragments.MeetingsListFragment;
import com.example.eco_impulse.fragments.PostListFragment;

public class PagerController extends FragmentPagerAdapter {
    int numofTabs;
    public PagerController(@NonNull FragmentManager fm, int behavior){
        super(fm, behavior);
        this.numofTabs = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                return new PostListFragment();
            case 1:
                return new MeetingsListFragment();
            case 2:
                fragment = new FragmentPerfil();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return numofTabs;
    }
}
