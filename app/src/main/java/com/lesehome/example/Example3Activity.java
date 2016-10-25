package com.lesehome.example;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.lesehome.example.DataSource.ExampleData;
import com.lesehome.example.adpater.Example3Adapter;
import com.lesehome.modularrecyclerview.decoration.LinearDividerItemDecoration;
import com.lesehome.modularrecyclerview.decoration.StickyHeaderDecoration;

public class Example3Activity extends BaseActivity {

    private RecyclerView recyclerView;
    private StickyHeaderDecoration decor;
    private Example3Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_3);
        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        Paint paint = new Paint();
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setPathEffect(new DashPathEffect(new float[]{25.0f, 25.0f}, 0));
        LinearDividerItemDecoration itemDecoration = new LinearDividerItemDecoration.Builder(this)
                .paint(paint)
                .showLastDivider()
                .build();

        recyclerView.addItemDecoration(itemDecoration);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Example3Adapter(ExampleData.getExample3());
        decor = new StickyHeaderDecoration(adapter);//设置浮动的分组

        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(decor,1);
    }
    @Override
    public void onDestroy() {
        decor.clearHeaderCache();
        super.onDestroy();
    }
}