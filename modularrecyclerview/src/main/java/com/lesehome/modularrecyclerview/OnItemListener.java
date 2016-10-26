package com.lesehome.modularrecyclerview;

import android.view.View;

/**
 * HViewHolder Listener
 * <p>
 * Created by hcp on 16/6/3.
 */
public interface OnItemListener {
    void onItemClick(View view, int position, int itemViewType);
    boolean onItemLongClick(View view, int position, int itemViewType);
}
