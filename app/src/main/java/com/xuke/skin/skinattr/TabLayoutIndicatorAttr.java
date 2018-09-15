package com.xuke.skin.skinattr;

import android.view.View;

import com.xuke.skin.view.widget.PagerSlidingTabStrip;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.utils.SkinResourcesUtils;

public class TabLayoutIndicatorAttr extends SkinAttr {

    @Override
    protected void applySkin(View view) {
        if (view instanceof PagerSlidingTabStrip) {
            PagerSlidingTabStrip tl = (PagerSlidingTabStrip) view;
            if (isColor()) {
                int color = SkinResourcesUtils.getColor(attrValueRefId);
                tl.setSelectedTextColor(color);
                tl.setIndicatorColor(color);
            }
        }
    }
}
