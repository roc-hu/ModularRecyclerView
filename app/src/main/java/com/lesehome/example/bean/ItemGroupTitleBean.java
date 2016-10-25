package com.lesehome.example.bean;

import com.lesehome.modularrecyclerview.IHItemBean;

/**
 * Created by hcp on 16/5/13.
 */
public class ItemGroupTitleBean implements IHItemBean{

    public String title;

    public ItemGroupTitleBean(String title) {
        this.title = title;
    }
}
