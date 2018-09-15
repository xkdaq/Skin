package com.xuke.skin.skinattr;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.xuke.skin.view.widget.bottombarlayout.BottomBarItem;
import com.xuke.skin.view.widget.bottombarlayout.BottomBarLayout;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.utils.SkinResourcesUtils;

public class TabMainAttr extends SkinAttr {

    @Override
    protected void applySkin(View view) {
        if (view instanceof BottomBarItem) {
            BottomBarItem tl = (BottomBarItem) view;
            if (isColor()) {
                int color = SkinResourcesUtils.getColor(attrValueRefId);
                tl.setmTextColorSelected(color);
            }

            if (isDrawable()) {
                Drawable drawable = SkinResourcesUtils.getDrawable(attrValueRefId);
                tl.setmIconSelectedDrawable(drawable);
            }

            BottomBarLayout parent = (BottomBarLayout) tl.getParent();
            int currentItem = parent.getCurrentItem();
            parent.resetState();
            BottomBarItem bottomItem = parent.getBottomItem(currentItem);
            if (bottomItem != null) {
                bottomItem.setStatus(true);
            }

        }
    }
}
