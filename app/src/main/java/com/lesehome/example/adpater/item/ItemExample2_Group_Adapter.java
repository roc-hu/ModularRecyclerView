package com.lesehome.example.adpater.item;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lesehome.modularrecyclerview.HViewHolder;
import com.lesehome.modularrecyclerview.IHItemBean;
import com.lesehome.example.R;
import com.lesehome.example.bean.ItemGroupTitleBean;
import com.lesehome.modularrecyclerview.impl.HItemAdapter;

import java.util.List;

/**
 * Created by hcp on 16/5/13.
 */
public class ItemExample2_Group_Adapter extends HItemAdapter<List<IHItemBean>> {

    public ItemExample2_Group_Adapter(int viewType) {
        super(viewType);
    }

    @Override
    public boolean isForViewType(@NonNull List<IHItemBean> items, int position) {
        return items.get(position) instanceof ItemGroupTitleBean;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_example2_modular_group, parent, false);
        return new HViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull List<IHItemBean> items, int position, @NonNull HViewHolder holder) {
        ItemGroupTitleBean bean = (ItemGroupTitleBean) items.get(position);
        holder.setTag(bean);
        holder.helper.getItemView().setTag(bean);
        holder.helper.setText(R.id.tv_title,bean.title);
    }
}
