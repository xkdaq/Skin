package com.xuke.skin.view.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.xuke.skin.R;

import butterknife.BindView;

/**
 * Created by kekex on 2018/8/21.
 * Markets列表的fragment
 */
public class MarketsListFragment extends BaseFragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int layoutResID() {
        return R.layout.fragment_marketslist;
    }

    @Override
    protected void initData() {

        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString("title");
            tvTitle.setText(title);

        }

    }
}
