package com.xuke.skin.entity;

import java.io.Serializable;

/**
 * Created by kekex on 2018/8/21.
 * Markets的tab标题类
 */
public class MarketsEntity implements Serializable {

    public String title;
    public String type;


    public MarketsEntity(String title, String type) {
        this.title = title;
        this.type = type;
    }
}
