package com.lesehome.example.bean;

import com.lesehome.modularrecyclerview.IHItemBean;

/**
 * Created by hcp on 16/5/13.
 */
public class Item1Bean implements IHItemBean {

    public String title;
    public String content;

    public Item1Bean(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
