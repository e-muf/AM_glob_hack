package com.example.eco_impulse.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.eco_impulse.R;
import com.example.eco_impulse.adapters.PagerController;
import com.example.eco_impulse.fragments.PostListFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1, tab2, tab3;
    PagerController pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tab1 = findViewById(R.id.opcion1);
        tab2 = findViewById(R.id.opcion2);
        tab3 = findViewById(R.id.opcion3);
        pagerAdapter = new PagerController(getSupportFragmentManager(),3);
        viewPager.setAdapter(pagerAdapter);
        getSupportActionBar().hide();
        //tabLayout.setupWithViewPager(viewPager);
        /*tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));*/
        /*Fragment fragment = new PostListFragment();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new PostListFragment()).commit();
        }

        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
            Log.i("MA-PushingFragment", "Pushed successful");
        }*/
    }
}
