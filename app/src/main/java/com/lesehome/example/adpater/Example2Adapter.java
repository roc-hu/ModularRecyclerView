package com.lesehome.example.adpater;

import com.lesehome.modularrecyclerview.IHItemBean;
import com.lesehome.example.adpater.item.ItemAdv_Adapter;
import com.lesehome.example.adpater.item.ItemExample2_GroupContent_Adapter;
import com.lesehome.example.adpater.item.ItemExample2_Group_Adapter;
import com.lesehome.example.bean.ItemAdvBean;
import com.lesehome.modularrecyclerview.impl.HListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hcp on 16/5/13.
 */
public class Example2Adapter extends HListAdapter<List<IHItemBean>> {

    public Example2Adapter(ItemAdvBean advBean, Map<IHItemBean, List<IHItemBean>> map) {

        this.adapterManager.add(new ItemAdv_Adapter(0));
        this.adapterManager.add(new ItemExample2_Group_Adapter(1));
        this.adapterManager.add(new ItemExample2_GroupContent_Adapter(2));

        List<IHItemBean> items = new ArrayList<>();
        items.add(advBean);

        for (Map.Entry<IHItemBean, List<IHItemBean>> entry : map.entrySet()) {
            items.add(entry.getKey());
            for (IHItemBean iItemBean : entry.getValue()) {
                items.add(iItemBean);
            }
        }
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
