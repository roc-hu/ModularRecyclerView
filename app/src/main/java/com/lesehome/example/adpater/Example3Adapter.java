package com.lesehome.example.adpater;


import android.util.Log;

import com.lesehome.modularrecyclerview.HViewHolder;
import com.lesehome.example.R;
import com.lesehome.example.bean.ItemGroupContentBean;
import com.lesehome.example.bean.ItemGroupTitleBean;
import com.lesehome.modularrecyclerview.impl.HStickyHeaderAdapter;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by hcp on 16/5/13.
 */
public class Example3Adapter extends HStickyHeaderAdapter<ItemGroupTitleBean,ItemGroupContentBean> {

    private static final String TAG = "Example3Adapter";

    public Example3Adapter(LinkedHashMap<ItemGroupTitleBean, LinkedList<ItemGroupContentBean>> map) {
        super(map);
    }

    @Override
    public int contentViewId() {
        return R.layout.item_example2_modular_group_content;
    }

    @Override
    public void onBindContentViewHolder(HViewHolder holder, ItemGroupContentBean bean, int position) {
        holder.helper.getItemView().setTag(bean);
        holder.helper.setText(R.id.tv_title, bean.title);
        holder.helper.setText(R.id.tv_content, bean.content);
        Log.i(TAG, "onBindViewHolder: position->"+position+"*" + bean.getClass().getSimpleName());
    }

    @Override
    public int titleViewId() {
        return R.layout.item_example2_modular_group;
    }

    @Override
    public void onBindTitleViewHolder(HViewHolder holder, ItemGroupTitleBean bean, int position) {
        holder.helper.getItemView().setTag(bean);
        holder.helper.setText(R.id.tv_title, bean.title);
        Log.i(TAG, "onBindHeaderViewHolder: position->"+position+"*" + bean.getClass().getSimpleName());

    }
}
