package com.lesehome.example.bean;

import com.lesehome.modularrecyclerview.IHItemBean;

/**
 * Created by hcp on 16/5/13.
 */
public class ItemAdvBean implements IHItemBean {

    public String url;
    public String link;

    public ItemAdvBean(String url, String link) {
        this.url = url;
        this.link = link;
    }
}
