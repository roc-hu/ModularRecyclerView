package com.lesehome.modularrecyclerview;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

/**
 *
 * 适配管理类
 *
 * Created by hcp on 16/5/13.
 */
public interface IAdapterManager<DATAS> {

    IAdapterManager<DATAS> add(@NonNull IHItemAdapter<DATAS> adapterItem);

    IAdapterManager<DATAS> remove(@NonNull IHItemAdapter<DATAS> adapterItem);

    IAdapterManager<DATAS> remove(int viewType);

    int getItemViewType(@NonNull DATAS items, int position);

    @NonNull
    HViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull DATAS items, int position, @NonNull HViewHolder viewHolder);
}
