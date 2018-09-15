package com.xuke.skin;

import com.xuke.skin.skinattr.TabLayoutIndicatorAttr;
import com.xuke.skin.skinattr.TabMainAttr;

import solid.ren.skinlibrary.SkinConfig;
import solid.ren.skinlibrary.base.SkinBaseApplication;

/**
 * Created by kekex on 2018/9/14.
 *
 */

public class MyApplication extends SkinBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinConfig.setCanChangeStatusColor(true);
        //SkinConfig.setCanChangeFont(true);
        SkinConfig.setDebug(true);

        SkinConfig.enableGlobalSkinApply();


        SkinConfig.addSupportAttr("tabLayoutIndicator", new TabLayoutIndicatorAttr());

        SkinConfig.addSupportAttr("mainIndicator_color", new TabMainAttr());

        SkinConfig.addSupportAttr("mipmap", new TabMainAttr());
    }
}
