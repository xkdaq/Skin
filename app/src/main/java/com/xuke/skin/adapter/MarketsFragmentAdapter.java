package com.xuke.skin.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.xuke.skin.entity.MarketsEntity;

import java.util.List;
import java.util.Map;


/**
 * Created by kekex on 2018/8/22.
 * Markets页viewpager的adapter
 */
public class MarketsFragmentAdapter extends FragmentPagerAdapter {

    private List<MarketsEntity> keys;

    private Map<String, Fragment> fragments;


    public MarketsFragmentAdapter(FragmentManager fm, List<MarketsEntity> keys, Map<String, Fragment> fragments) {
        super(fm);
        this.keys = keys;
        this.fragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return keys.get(position).title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(keys.get(position).title);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        View view = (View) object;
        ((ViewPager) container).removeView(view);
        view = null;
    }
}
