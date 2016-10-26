package com.lesehome.modularrecyclerview.impl;

import com.lesehome.modularrecyclerview.AbsListAdapter;

import java.util.List;


public class HListAdapter<DATAS extends List<?>> extends AbsListAdapter<DATAS> {

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
