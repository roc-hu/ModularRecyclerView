package com.lesehome.modularrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lesehome.modularrecyclerview.impl.HAdapterManager;


public abstract class AbsListAdapter<DATAS> extends RecyclerView.Adapter<HViewHolder> {

    protected IAdapterManager<DATAS> adapterManager = new HAdapterManager<>();
    protected OnItemListener onItemListener;

    protected DATAS items;

    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HViewHolder viewHolder = adapterManager.onCreateViewHolder(parent, viewType);
        viewHolder.setOnItemListener(getOnItemListener());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HViewHolder viewHolder, int position) {
        adapterManager.onBindViewHolder(items, position, viewHolder);
    }

    @Override
    public int getItemViewType(int position) {
        return adapterManager.getItemViewType(items, position);
    }

    public DATAS getItems() {
        return items;
    }

    public void setItems(DATAS items) {
        this.items = items;
    }

    public OnItemListener getOnItemListener() {
        return onItemListener;
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }
}
