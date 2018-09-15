package com.xuke.skin.view.fragment;

import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xuke.skin.R;

import butterknife.BindView;
import butterknife.OnClick;
import solid.ren.skinlibrary.SkinLoaderListener;
import solid.ren.skinlibrary.loader.SkinManager;

/**
 * Created by kekex on 2018/8/21.
 * Account
 */
public class AccountFragment extends BaseFragment {

    @BindView(R.id.tv_account_name)
    TextView tvAccountName;
    @BindView(R.id.cv_account_fund)
    CardView cvAccountFound;
    @BindView(R.id.cv_account_rp)
    CardView cvAccountRp;
    @BindView(R.id.cv_account_auth)
    CardView cvAccountAuth;
    @BindView(R.id.cv_account_security)
    CardView cvAccountSecurity;
    @BindView(R.id.cv_account_setting)
    CardView cvAccountSetting;

    @Override
    protected int layoutResID() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initData() {


    }


    @OnClick({R.id.cv_account_fund, R.id.cv_account_rp, R.id.cv_account_auth, R.id.cv_account_security, R.id.cv_account_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cv_account_fund:
                //基金Fund
                break;
            case R.id.cv_account_rp:
                //推荐计划Referral Program
                //正在开发中
                break;
            case R.id.cv_account_auth:
                //身份验证Identity Authentication
                break;
            case R.id.cv_account_security:
                //安全Security
                SkinManager.getInstance().restoreDefaultTheme();
                break;
            case R.id.cv_account_setting:
                //设置Setting
                SkinManager.getInstance().loadSkin("theme-20180915.skin",
                        new SkinLoaderListener() {
                            @Override
                            public void onStart() {
                                Log.i("SkinLoaderListener", "正在切换中");
                            }

                            @Override
                            public void onSuccess() {
                                Log.i("SkinLoaderListener", "切换成功");
                            }

                            @Override
                            public void onFailed(String errMsg) {
                                Log.i("SkinLoaderListener", "切换失败:" + errMsg);
                            }

                            @Override
                            public void onProgress(int progress) {
                                Log.i("SkinLoaderListener", "皮肤文件下载中:" + progress);

                            }
                        }
                );
                break;
        }
    }

}
