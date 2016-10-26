package com.lesehome.modularrecyclerview.impl;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lesehome.modularrecyclerview.HViewHolder;
import com.lesehome.modularrecyclerview.IStickyHeaderAdapter;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by hcp on 16/5/13.
 */
public abstract class HStickyHeaderAdapter<TITLE, DATA> extends RecyclerView.Adapter<HViewHolder> implements
        IStickyHeaderAdapter<HViewHolder> {

    private static final String TAG = "HStickyHeaderAdapter";

    private List<DATA> mDatas;
    private List<TITLE> mHeaderDatas;
    private Map<Integer, Integer> mHeaderIndexs;//key:item-index, value:title-index

    public HStickyHeaderAdapter(LinkedHashMap<TITLE, LinkedList<DATA>> map) {
        this.mHeaderDatas = new LinkedList<>();
        this.mDatas = new LinkedList<>();
        this.mHeaderIndexs = new LinkedHashMap<>();
        int mPosition = 0;
        int mTitleIndex = 0;
        for (Map.Entry<TITLE, LinkedList<DATA>> entry : map.entrySet()) {
            mHeaderDatas.add(entry.getKey());
            for (DATA data : entry.getValue()) {
                mDatas.add(data);
                mHeaderIndexs.put(mPosition, mTitleIndex);
                mPosition++;
            }
            mTitleIndex++;
        }
    }

    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(contentViewId(), parent, false);
        return new HViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HViewHolder holder, int position) {
        onBindContentViewHolder(holder, getItem(position), position);
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public long getHeaderId(int position) {
        return mHeaderIndexs.get(position) != null ? mHeaderIndexs.get(position) : 0;
    }

    @Override
    public HViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(titleViewId(), parent, false);
        return new HViewHolder(itemView);
    }

    @Override
    public void onBindHeaderViewHolder(HViewHolder holder, int position) {
        onBindTitleViewHolder(holder, getTitle(position), position);
    }

    public DATA getItem(int position) {
        return mDatas != null ? mDatas.get(position) : null;
    }

    public TITLE getTitle(int position) {
        int headerId = (int) getHeaderId(position);
        return mHeaderDatas != null ? mHeaderDatas.get(headerId) : null;
    }

    /**
     * 内容布局的资源
     *
     * @return
     */
    public abstract
    @LayoutRes
    int contentViewId();

    /**
     * 内容布局绑定数据
     *
     * @param holder
     * @param position
     */
    public abstract void onBindContentViewHolder(HViewHolder holder, DATA data, int position);

    /**
     * 浮动头部布局的资源
     *
     * @return
     */
    public abstract
    @LayoutRes
    int titleViewId();

    /**
     * 浮动头部布局绑定数据
     *
     * @param holder
     * @param position
     */
    public abstract void onBindTitleViewHolder(HViewHolder holder, TITLE title, int position);
}
