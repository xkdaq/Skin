package com.xuke.skin.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.xuke.skin.R;
import com.xuke.skin.adapter.FragmentViewPagerAdapter;
import com.xuke.skin.view.fragment.AccountFragment;
import com.xuke.skin.view.fragment.MarketFragment;
import com.xuke.skin.view.widget.FragementViewPager;
import com.xuke.skin.view.widget.bottombarlayout.BottomBarItem;
import com.xuke.skin.view.widget.bottombarlayout.BottomBarLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseMainActivity {

    @BindView(R.id.vp_content)
    FragementViewPager viewPager;
    @BindView(R.id.bbl_main)
    BottomBarLayout bblMain;
    @BindView(R.id.tab4_c2c)
    BottomBarItem tab4C2c;
    @BindView(R.id.tab5_account)
    BottomBarItem tab5Account;

    ArrayList<Fragment> fragmentList = new ArrayList<>();

    private FragmentViewPagerAdapter adpter;

    @Override
    protected int layoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

        dynamicAddView(tab4C2c, "mainIndicator_color", R.color.c_3b99ff);
        dynamicAddView(tab5Account, "mainIndicator_color", R.color.c_3b99ff);
        dynamicAddView(tab4C2c, "mipmap", R.mipmap.icon_c2c_selected);
        dynamicAddView(tab5Account, "mipmap", R.mipmap.icon_account_selected);


        MarketFragment marketFragment = new MarketFragment();
        AccountFragment accountFragment = new AccountFragment();

        fragmentList.add(marketFragment);
        fragmentList.add(accountFragment);
        //viewpager
        adpter = new FragmentViewPagerAdapter(getSupportFragmentManager(), viewPager, fragmentList);
        viewPager.setAdapter(adpter);
        bblMain.setViewPager(viewPager);
        bblMain.setCurrentItem(0);


    }
}
