package com.lesehome.modularrecyclerview;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

/**
 *
 * Item adapter接口
 *
 * Created by hcp on 16/5/13.
 */
public interface IHItemAdapter<DATAS> {

    int getItemViewType();

    boolean isForViewType(@NonNull DATAS items, int position);

    @NonNull
    HViewHolder onCreateViewHolder(ViewGroup parent);

    void onBindViewHolder(@NonNull DATAS items, int position, @NonNull HViewHolder holder);
}
