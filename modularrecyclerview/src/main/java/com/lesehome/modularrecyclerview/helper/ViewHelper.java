package com.lesehome.modularrecyclerview.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.text.Html;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 *
 * view 方法简化类
 *
 * Created by hcp on 16/5/30.
 */
public class ViewHelper {

    private final SparseArray<View> views;

    private View itemView;
//    private ImageLoader imageLoader;

    private Object tag;

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public ViewHelper(View itemView) {
        this.itemView = itemView;
//        this.imageLoader = imageLoader;
        this.views = new SparseArray<>();
    }
    public <T extends View> T getView(@IdRes int viewId) {
        return retrieveView(viewId);
    }

    /**
     * 设置 TextView 文本.
     */
    public ViewHelper setText(@IdRes int viewId, CharSequence value) {
        TextView view = retrieveView(viewId);
        view.setText(value);
        return this;
    }

    /**
     * 设置 ImageView 图片资源.
     */
    public ViewHelper setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ImageView view = retrieveView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    /**
     * 设置 view 背景颜色.
     */
    public ViewHelper setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        View view = retrieveView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * 设置 view 背景资源.
     */
    public ViewHelper setBackgroundRes(@IdRes int viewId, @ColorRes int backgroundRes) {
        View view = retrieveView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    /**
     * 设置 TextView 文本颜色.
     */
    public ViewHelper setTextColor(@IdRes int viewId, @ColorInt int textColor) {
        TextView view = retrieveView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    /**
     * 设置 TextView 文本颜色.
     */
    public ViewHelper setTextColorRes(@IdRes int viewId, @ColorRes int textColorRes) {
        TextView view = retrieveView(viewId);
        view.setTextColor(itemView.getResources().getColor(textColorRes));
        return this;
    }

    /**
     * 设置 ImageView 图片资源.
     */
    public ViewHelper setImageDrawable(@IdRes int viewId, @DrawableRes Drawable drawable) {
        ImageView view = retrieveView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * 设置 ImageView 图片资源 来自于URL
     */
//    public ViewHelper setImageUrl(@IdRes int viewId, String imageUrl) {
//        ImageView view = retrieveView(viewId);
//        if(imageLoader!=null) {
//            imageLoader.display(view.getContext(), imageUrl, view);
//        }
//        return this;
//    }

    /**
     * 设置 ImageView 图片资源
     */
    public ViewHelper setImageBitmap(@IdRes int viewId, Bitmap bitmap) {
        ImageView view = retrieveView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 设置 View 的Alpha.
     * Alpha between 0-1.
     */
    public ViewHelper setAlpha(@IdRes int viewId, @FloatRange(from = 0.0, to = 1.0) float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            retrieveView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            retrieveView(viewId).startAnimation(alpha);
        }
        return this;
    }

    /**
     * 设置 view 展示 (true) or 隐藏 (false).
     */
    public ViewHelper setVisible(@IdRes int viewId, boolean visible) {
        View view = retrieveView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    /**
     * Add links into a TextView.
     */
    public ViewHelper linkify(@IdRes int viewId) {
        TextView view = retrieveView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    /**
     * Apply the typeface to the given viewId, and enable subpixel rendering.
     */
    public ViewHelper setTypeface(@IdRes int viewId, Typeface typeface) {
        TextView view = retrieveView(viewId);
        view.setTypeface(typeface);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        return this;
    }

    /**
     * Apply the typeface to all the given viewIds, and enable subpixel rendering.
     */
    public ViewHelper setTypeface(Typeface typeface, @IdRes int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = retrieveView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    /**
     * 设置 ProgressBar.
     */
    public ViewHelper setProgress(@IdRes int viewId, int progress) {
        ProgressBar view = retrieveView(viewId);
        view.setProgress(progress);
        return this;
    }

    /**
     * 设置 ProgressBar progress 和 max.
     */
    public ViewHelper setProgress(@IdRes int viewId, int progress, int max) {
        ProgressBar view = retrieveView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    /**
     * 设置 ProgressBar max.
     */
    public ViewHelper setMax(@IdRes int viewId, int max) {
        ProgressBar view = retrieveView(viewId);
        view.setMax(max);
        return this;
    }

    /**
     * 设置 RatingBar 的rating.
     */
    public ViewHelper setRating(@IdRes int viewId, float rating) {
        RatingBar view = retrieveView(viewId);
        view.setRating(rating);
        return this;
    }

    /**
     * 设置 RatingBar rating and max.
     */
    public ViewHelper setRating(@IdRes int viewId, float rating, int max) {
        RatingBar view = retrieveView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    /**
     * 设置 view 的 OnClickListener.
     */
    public ViewHelper setOnClickListener(@IdRes int viewId, View.OnClickListener listener) {
        View view = retrieveView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置 view 的 OnTouchListener.
     */
    public ViewHelper setOnTouchListener(@IdRes int viewId, View.OnTouchListener listener) {
        View view = retrieveView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    /**
     * 设置 view 的 OnLongClickListener.
     */
    public ViewHelper setOnLongClickListener(@IdRes int viewId, View.OnLongClickListener listener) {
        View view = retrieveView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }


    /**
     * 设置 CompoundButton 的 OnCheckedChangeListener.
     */
    public ViewHelper setOnCheckedChangeListener(
            @IdRes int viewId, CompoundButton.OnCheckedChangeListener listener) {
        CompoundButton view = retrieveView(viewId);
        view.setOnCheckedChangeListener(listener);
        return this;
    }

    /**
     * 设置 view 的 tag.
     */
    public ViewHelper setTag(@IdRes int viewId, Object tag) {
        View view = retrieveView(viewId);
        view.setTag(tag);
        return this;
    }

    /**
     * 设置 view 的 tag.
     */
    public ViewHelper setTag(@IdRes int viewId, int key, Object tag) {
        View view = retrieveView(viewId);
        view.setTag(key, tag);
        return this;
    }

    /**
     * 设置 CompoundButton／CheckedTextView checked.
     */
    public ViewHelper setChecked(@IdRes int viewId, boolean checked) {
        View view = retrieveView(viewId);
        // View unable cast to Checkable
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setChecked(checked);
        } else if (view instanceof CheckedTextView) {
            ((CheckedTextView) view).setChecked(checked);
        }
        return this;
    }

    /**
     * 设置对应id的控件的html文本内容
     */
    public ViewHelper setHtml(@IdRes int viewId, String source) {
        TextView view = retrieveView(viewId);
        view.setText(Html.fromHtml(source));
        return this;
    }

    /**
     * itemView
     */
    public View getItemView() {
        return itemView;
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T retrieveView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public interface ImageLoader {
        void display(Context context, String imageUrl, ImageView imageView);
    }
}
