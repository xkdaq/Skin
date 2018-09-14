package com.xuke.skin.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.xuke.skin.R;
import com.xuke.skin.adapter.MarketsFragmentAdapter;
import com.xuke.skin.entity.MarketsEntity;
import com.xuke.skin.util.UIUtils;
import com.xuke.skin.view.widget.FragementViewPager;
import com.xuke.skin.view.widget.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by kekex on 2018/8/21.
 * Market
 */
public class MarketFragment extends BaseFragment {

    @BindView(R.id.iv_markets_favourites)
    ImageView ivMarketsFavourites;
    @BindView(R.id.iv_markets_search)
    ImageView ivMarketsSearch;
    @BindView(R.id.tab_markets)
    PagerSlidingTabStrip tabMarkets;
    @BindView(R.id.vp_markets)
    FragementViewPager vpMarkets;

    private Map<String, Fragment> fragments = new HashMap<>();

    @Override
    protected int layoutResID() {
        return R.layout.fragment_market;
    }

    @Override
    protected void initData() {
        initView();
        List<MarketsEntity> marketsEntities = new ArrayList<>();
        marketsEntities.add(new MarketsEntity("Favorites", "1"));
        marketsEntities.add(new MarketsEntity("IDRD", "2"));
        marketsEntities.add(new MarketsEntity("BTC", "3"));
        marketsEntities.add(new MarketsEntity("ETC", "4"));
        marketsEntities.add(new MarketsEntity("EOS", "5"));

        for (int i = 0; i < marketsEntities.size(); i++) {
            MarketsEntity subMainBean = marketsEntities.get(i);
            MarketsListFragment marketsListFragment = new MarketsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", subMainBean.title);
            marketsListFragment.setArguments(bundle);
            fragments.put(subMainBean.title, marketsListFragment);
        }
        MarketsFragmentAdapter adapter = new MarketsFragmentAdapter(getFragmentManager(), marketsEntities, fragments);
        vpMarkets.setAdapter(adapter);
        tabMarkets.setViewPager(vpMarkets);

    }

    private void initView() {
        //设置短线
        //tabMarkets.setMiniIndicator();
        //设置tab的分割线是透明的
        tabMarkets.setDividerColor(getResources().getColor(R.color.transparent));
        //设置tab底部线的高度
        tabMarkets.setUnderlineHeight(0);
        //设置tab Indicator的高度
        tabMarkets.setIndicatorHeight(UIUtils.dip2Px(context, 2));
        //设置tab标题文字的大小
        tabMarkets.setTextSize(16);
        tabMarkets.setTextColor(getResources().getColor(R.color.c_9b9b9b));
        //设置TabIndicator的颜色
        tabMarkets.setSelectedTextColor(getResources().getColor(R.color.c_3b99ff));
        tabMarkets.setIndicatorColor(getResources().getColor(R.color.c_3b99ff));
        tabMarkets.setBackgroundColor(getResources().getColor(R.color.bg_tab));
        //每个tab左右之间的距离
        tabMarkets.setTabPaddingLeftRight(50);
        //tab不要自动大写
        tabMarkets.setAllCaps(false);
    }


    @OnClick({R.id.iv_markets_favourites, R.id.iv_markets_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_markets_favourites:
                //编辑收藏
                //判断用户是否登录
                break;
            case R.id.iv_markets_search:
                //搜索
                //判断用户是否登录
                break;
        }
    }
}
