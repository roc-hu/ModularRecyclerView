package com.lesehome.example;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.volley.VolleyUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.config.AppInitialization;

import java.io.InputStream;


/**
 * Created by hcp on 16/6/3.
 */
public class App extends Application {

    private static App _instance;
    private static RequestQueue mRequestQueue;
//    private static OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = (App) getApplicationContext();
        init(this);
        AppInitialization.init(this);
    }
    private void init(Context context){

        //Glide 配置项目
        Glide.get(context).register(GlideUrl.class, InputStream.class,
                new VolleyUrlLoader.Factory(getRequestQueue()));
//        Glide.get(context).register(GlideUrl.class, InputStream.class,
//                new OkHttpUrlLoader.Factory(getOkHttpClient()));
//        Glide End
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Glide.get(this).trimMemory(level);
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(get());
        }
        return mRequestQueue;
    }
//    public static OkHttpClient getOkHttpClient() {
//        if (okHttpClient == null) {
//            okHttpClient = new OkHttpClient();
//        }
//        return okHttpClient;
//    }

    public static App get() {
        return _instance;
    }
}
