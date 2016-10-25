package com.lesehome.example.adpater.item;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lesehome.modularrecyclerview.HViewHolder;
import com.lesehome.modularrecyclerview.IHItemBean;
import com.lesehome.modularrecyclerview.OnItemListener;
import com.lesehome.example.R;
import com.lesehome.example.bean.ItemAdvBean;
import com.lesehome.modularrecyclerview.impl.HItemAdapter;

import java.util.List;

/**
 * Created by hcp on 16/5/13.
 */
public class ItemAdv_Adapter extends HItemAdapter<List<IHItemBean>> {

    public ItemAdv_Adapter(int viewType) {
        super(viewType);
    }

    @Override
    public boolean isForViewType(@NonNull List<IHItemBean> items, int position) {
        return items.get(position) instanceof ItemAdvBean;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modular_adv, parent, false);
        return new HViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull List<IHItemBean> items, int position, @NonNull HViewHolder holder) {
        ItemAdvBean bean = (ItemAdvBean) items.get(position);
        holder.setTag(bean);
//        holder.helper.setImageResource(R.id.iv_adv,R.drawable.adv);
        ImageView imageView = holder.helper.getView(R.id.iv_adv);
        Glide.with(imageView.getContext())
                .load(bean.url)
                .into(imageView);
        holder.setOnItemListener(new OnItemListener() {
            @Override
            public void onItemClick(View view, int position, int itemViewType) {
                if(view!=null && view.getTag() instanceof ItemAdvBean){
                    ItemAdvBean advBean = (ItemAdvBean) view.getTag();
                    Toast.makeText(view.getContext(), "link:"+advBean.link, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public boolean onItemLongClick(View view, int position, int itemViewType) {
                return false;
            }
        });
    }
}
