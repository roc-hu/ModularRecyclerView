package com.lesehome.example.adpater;

import com.lesehome.modularrecyclerview.IHItemBean;
import com.lesehome.example.adpater.item.ItemAdv_Adapter;
import com.lesehome.example.adpater.item.ItemExample1_1_Adapter;
import com.lesehome.example.adpater.item.ItemExample1_2_Adapter;
import com.lesehome.modularrecyclerview.impl.HListAdapter;

import java.util.List;

/**
 * Created by hcp on 16/5/13.
 */
public class Example1Adapter extends HListAdapter<List<IHItemBean>> {

    public Example1Adapter(List<IHItemBean> items) {

        this.adapterManager.add(new ItemAdv_Adapter(0));
        this.adapterManager.add(new ItemExample1_1_Adapter(1));
        this.adapterManager.add(new ItemExample1_2_Adapter(2));
        setItems(items);
    }


    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(int position, IHItemBean item) {
        items.add(position, item);
        notifyItemInserted(position); //Attention!
    }
}
