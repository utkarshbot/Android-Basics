package com.example.ca3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class chapterLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_layout);
        setUpViewpager();
    }

    private void setUpViewpager() {
        SectionsPagerAdapter adapter =
                new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Linear());
        adapter.addFragment(new Relative());
        adapter.addFragment(new Grid());

        ViewPager vp = findViewById(R.id.view_pager);
        vp.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        //pass the viewpager to the tab layout
        tabLayout.setupWithViewPager(vp);
        tabLayout.setBackgroundColor(getColor(R.color.orange));
        tabLayout.setTabTextColors(getColor(R.color.white),getColor(R.color.black));

        //set the tab index and set text, icon, etc..
        tabLayout.getTabAt(0).setText("Linear");
        tabLayout.getTabAt(1).setText("Relative");
        tabLayout.getTabAt(2).setText("Grid");
    }

    class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        public SectionsPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment){
            mFragmentList.add(fragment);
        }
    }
}