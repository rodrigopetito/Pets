package com.rodrigopetito.pets.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rodrigopetito.pets.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragmentList;
    private List<String> titles;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragmentList = new ArrayList<>();
        this.titles = new ArrayList<>();
    }


    public void addFragment (BaseFragment fragment) {
        this.fragmentList.add(fragment);
    }

    public void setTitles(List<String> titles) {

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getFragmentTitle();
    }


}
