package com.sirclub.btcbysir_club.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SaNO0K on 26/01/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<Integer> mFragmentIcon = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void AddFrag(Fragment fragment,Integer icon){
        mFragmentList.add(fragment);
        mFragmentIcon.add(icon);
    }

    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getPageIconResId(int position) {
        return mFragmentIcon.get(position);
    }
}
