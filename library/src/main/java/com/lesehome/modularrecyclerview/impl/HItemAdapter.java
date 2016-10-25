package com.lesehome.modularrecyclerview.impl;


import com.lesehome.modularrecyclerview.IHItemAdapter;

public abstract class HItemAdapter<DATAS> implements IHItemAdapter<DATAS> {

    protected int viewType;

    public HItemAdapter(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public int getItemViewType() {
        return viewType;
    }
}
