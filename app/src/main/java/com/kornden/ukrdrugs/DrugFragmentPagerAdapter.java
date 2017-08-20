package com.kornden.ukrdrugs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by kornd on 20-Aug-17.
 */

public class DrugFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] tabTitles = {"нацперелік", "Доступні\nліки"};
    public DrugFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                return new NationalListFragment();
            case 1:
                return new AffordableDrugsFragment();

        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}