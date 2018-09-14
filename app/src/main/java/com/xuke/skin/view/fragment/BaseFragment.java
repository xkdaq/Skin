package com.xuke.skin.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by kekex on 2018/8/21.
 * fragment的基类
 */

public abstract class BaseFragment extends Fragment {

    protected Context context;
    protected LayoutInflater layoutInflater;
    Unbinder unbinder;
    public FragmentManager fragmentManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            handlerArguments(arguments);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutResID(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        fragmentManager = getActivity().getSupportFragmentManager();
        layoutInflater = LayoutInflater.from(context);
        initData();
    }

    /**
     * 设置Fragment布局Id
     */
    protected abstract int layoutResID();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 处理从Activity传过来的参数
     */
    protected void handlerArguments(Bundle arguments) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
