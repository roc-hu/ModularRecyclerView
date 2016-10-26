package com.lesehome.modularrecyclerview.helper;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 公共的Adapter List适配器
 * <p>
 * Created by hcp on 16/5/30.
 */
public abstract class CommonAdapter<DATA> extends BaseAdapter {

    protected Context mContext;
    protected List<DATA> mDatas = null;//数据源List<T>
    private int mLayoutId;//布局文件ID

    public CommonAdapter(Context context,@LayoutRes int layoutId, List<DATA> datas) {
        this.mContext = context;
        this.mDatas = datas;
        this.mLayoutId = layoutId;
    }

    @Override
    public int getCount() {
        if (mDatas != null) {
            return mDatas.size();
        }
        return 0;
    }

    @Override
    public DATA getItem(int position) {
        if (mDatas != null) {
            return mDatas.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //初始化ViewHolder，加载我们的item布局文件
        ViewHelper holder = get(mContext, convertView, parent, mLayoutId);
        convert(holder, position, getItem(position));
        return holder.getItemView();
    }

    /**
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @return
     */
    private static ViewHelper get(Context context, View convertView,
                                  @Nullable final ViewGroup parent,
                                  @LayoutRes int layoutId) {
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            ViewHelper holder = new ViewHelper(convertView);
            convertView.setTag(holder);
            return holder;
        } else {
            ViewHelper holder = (ViewHelper) convertView.getTag();
            return holder;
        }
    }

    /**
     * 需实现的抽象方法
     *
     * @param holder
     * @param data
     */
    public abstract void convert(ViewHelper holder, int position, DATA data);
}
