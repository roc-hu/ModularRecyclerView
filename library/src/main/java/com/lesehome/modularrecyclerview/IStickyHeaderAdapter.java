package com.lesehome.modularrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


/**
 *The adapter to assist the {@link com.lesehome.example.modularrecycler.decoration.StickyHeaderDecoration} in creating and binding the header views.
 * @param <T>
 *
 *     Created by hcp on 16/6/2.
 */
public interface IStickyHeaderAdapter<T extends RecyclerView.ViewHolder> {

    /**
     * Returns the header id for the item at the given position.
     *
     * @param position the item position
     * @return the header id
     */
    long getHeaderId(int position);

    /**
     * Creates a new header ViewHolder.
     *
     * @param parent the header's view parent
     * @return a view holder for the created view
     */
    T onCreateHeaderViewHolder(ViewGroup parent);

    /**
     * Updates the header view to reflect the header data for the given position
     * @param viewholder the header view holder
     * @param position the header's item position
     */
    void onBindHeaderViewHolder(T viewholder, int position);
}
