package com.lesehome.example.bean;

import com.lesehome.modularrecyclerview.IHItemBean;

/**
 * Created by hcp on 16/5/13.
 */
public class Item2Bean implements IHItemBean {

    public int iconResId;
    public String title;
    public String content;

    public Item2Bean(int iconResId, String title, String content) {
        this.iconResId = iconResId;
        this.title = title;
        this.content = content;
    }
}
