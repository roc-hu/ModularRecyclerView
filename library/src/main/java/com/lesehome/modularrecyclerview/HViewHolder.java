package com.lesehome.modularrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lesehome.modularrecyclerview.helper.ViewHelper;

/**
 * RecyclerView.HViewHolder
 * <p/>
 * Created by hcp on 16/1/7.
 */
public class HViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener, View.OnLongClickListener {

    public ViewHelper helper;

    private Object tag;
    private OnItemListener onItemListener;

    public HViewHolder(View itemView) {
        super(itemView);
        helper = new ViewHelper(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == itemView.getId() && onItemListener != null) {
            v.setTag(getTag());
            onItemListener.onItemClick(
                    v, getAdapterPosition(), getItemViewType());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == itemView.getId() && onItemListener != null) {
            v.setTag(getTag());
            return onItemListener.onItemLongClick(
                    v, getAdapterPosition(), getItemViewType());
        }
        return false;
    }

    public OnItemListener getOnItemListener() {
        return onItemListener;
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }
}
