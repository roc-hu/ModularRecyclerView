package com.lesehome.example.test;

import android.content.Context;
import android.os.AsyncTask;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;

/**
 *
 * Glide 下载文件 支持Gif
 *
 * https://github.com/bumptech/glide/wiki/Downloading-custom-sizes-with-Glide
 * https://github.com/licheedev/Custom-Glide-ModelLoader-Demo
 *
 * Created by hcp on 16/6/3.
 */
public class SaveImageTask extends AsyncTask<String, Void, File> {
    private final Context context;

    public SaveImageTask(Context context) {
        this.context = context;
    }

    @Override
    protected File doInBackground(String... params) {
        String url = params[0]; // should be easy to extend to share multiple images at once
        try {
            return Glide
                    .with(context)
                    .load(url)
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get() // needs to be called on background thread
                    ;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(File result) {
        if (result == null) {
            return;
        }
        String path = result.getPath();
    }
}
