package com.lesehome.example.test;

import android.graphics.Bitmap;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.lesehome.example.App;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Loading and Caching on Background Threads:https://github.com/bumptech/glide/wiki/Loading-and-Caching-on-Background-Threads
 *
 * Created by hcp on 16/6/3.
 */
public class ImageLoader {
    private void getImage(String url){
        FutureTarget<File> future = Glide.with(App.get())
                .load(url)
                .downloadOnly(500, 500);
        try {
            File cacheFile = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Bitmap myBitmap = Glide.with(App.get())
                    .load(url)
                    .asBitmap()
                    .centerCrop()
                    .into(500, 500)
                    .get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
