package com.lesehome.modularrecyclerview.impl;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

import com.lesehome.modularrecyclerview.HViewHolder;
import com.lesehome.modularrecyclerview.IAdapterManager;
import com.lesehome.modularrecyclerview.IHItemAdapter;


public class HAdapterManager<DATAS> implements IAdapterManager<DATAS> {

    /**
     * Map for ViewType to AdapterDeleage
     */
    SparseArrayCompat<IHItemAdapter<DATAS>> adapterItems = new SparseArrayCompat();

    @Override
    public IAdapterManager add(@NonNull IHItemAdapter adapterItem) {
        if (adapterItem == null) {
            throw new NullPointerException("IHItemAdapter is null!");
        }

        int viewType = adapterItem.getItemViewType();

        if (adapterItems.get(viewType) != null) {
            throw new IllegalArgumentException(
                    "An IHItemAdapter is already registered for the viewType = " + viewType
                            + ". Already registered IHItemAdapter is " + adapterItems.get(viewType));
        }

        adapterItems.put(viewType, adapterItem);

        return this;
    }

    @Override
    public IAdapterManager remove(@NonNull IHItemAdapter adapterItem) {
        if (adapterItem == null) {
            throw new NullPointerException("IHItemAdapter is null");
        }

        IHItemAdapter<DATAS> queried = adapterItems.get(adapterItem.getItemViewType());
        if (queried != null && queried == adapterItem) {
            adapterItems.remove(adapterItem.getItemViewType());
        }
        return this;
    }

    @Override
    public IAdapterManager remove(int viewType) {
        adapterItems.remove(viewType);
        return this;
    }

    @Override
    public int getItemViewType(@NonNull DATAS items, int position) {
        if (items == null) {
            throw new NullPointerException("Items datasource is null!");
        }

        int adapterItemCount = adapterItems.size();
        for (int i = 0; i < adapterItemCount; i++) {
            IHItemAdapter<DATAS> delegate = adapterItems.valueAt(i);
            if (delegate.isForViewType(items, position)) {
                return delegate.getItemViewType();
            }
        }
        throw new IllegalArgumentException("No IHItemAdapter added that matches position=" + position + " in data source");
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        IHItemAdapter<DATAS> adapterItem = this.adapterItems.get(viewType);
        if (adapterItem == null) {
            throw new NullPointerException("No IHItemAdapter added for ViewType " + viewType);
        }

        HViewHolder vh = adapterItem.onCreateViewHolder(parent);

        if (vh == null) {
            throw new NullPointerException(
                    "HViewHolder returned from IHItemAdapter " + adapterItem + " for ViewType =" + viewType
                            + " is null!");
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DATAS items, int position, @NonNull HViewHolder viewHolder) {
        IHItemAdapter<DATAS> adapterItem = this.adapterItems.get(viewHolder.getItemViewType());

        if (adapterItem == null) {
            throw new NullPointerException(
                    "No IHItemAdapter added for ViewType " + viewHolder.getItemViewType());
        }
        adapterItem.onBindViewHolder(items, position, viewHolder);
    }
}
