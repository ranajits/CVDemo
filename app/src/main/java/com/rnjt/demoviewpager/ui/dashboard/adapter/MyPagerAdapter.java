package com.rnjt.demoviewpager.ui.dashboard.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rnjt.demoviewpager.ui.dashboard.Fragment.DemoFragment;
import com.rnjt.demoviewpager.ui.dashboard.Fragment.HomeFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(FragmentManager fm ) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch(position) {

            case 0: return HomeFragment.newInstance("FirstFragment, Instance 1");
            case 1: return DemoFragment.newInstance("SecondFragment, Instance 1");
            case 2: return DemoFragment.newInstance("ThirdFragment, Instance 1");
            case 3: return DemoFragment.newInstance("ThirdFragment, Instance 2");
            case 4: return DemoFragment.newInstance("ThirdFragment, Instance 3");
            default: return DemoFragment.newInstance("ThirdFragment, Default");
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
