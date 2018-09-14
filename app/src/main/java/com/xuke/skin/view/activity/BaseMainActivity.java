package com.xuke.skin.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by kekex on 2018/8/20.
 * MainActivity的基类
 */

public abstract class BaseMainActivity extends AppCompatActivity {

    protected Activity context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(layoutResID());
        ButterKnife.bind(this);
        //初始化数据
        initData();

    }


    /**
     * 设置布局资源
     */
    protected abstract int layoutResID();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 如果要全屏,重写这个方法返回false
     */
    public Boolean isfits() {
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
