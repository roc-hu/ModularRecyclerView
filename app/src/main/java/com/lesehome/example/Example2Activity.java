package com.lesehome.example;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lesehome.example.DataSource.ExampleData;
import com.lesehome.example.adpater.Example2Adapter;
import com.lesehome.modularrecyclerview.OnItemListener;
import com.lesehome.modularrecyclerview.helper.ViewHelper;
import com.lesehome.modularrecyclerview.decoration.LinearDividerItemDecoration;

public class Example2Activity extends BaseActivity {

    private RecyclerView recyclerView;
    private Example2Adapter adapter;

    private ViewHelper viewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_2);
        viewHelper = new ViewHelper(getWindow().getDecorView());

        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Paint paint = new Paint();
        paint.setStrokeWidth(2);
        paint.setColor(Color.GRAY);
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

        adapter = new Example2Adapter(ExampleData.getItemAdv(),ExampleData.getExample2());
        adapter.setOnItemListener(new OnItemListener() {
            @Override
            public void onItemClick(View view, int position, int itemViewType) {
                String content = "Click:" + position;
                if (view.getTag() != null) {
                    content = view.getTag().getClass().getSimpleName();
                }
                Toast.makeText(view.getContext(), content,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, int position, int itemViewType) {
                Toast.makeText(view.getContext(), "LongClick:" + position, Toast.LENGTH_SHORT).show();
                adapter.removeItem(position);
                return true;
            }
        });
        recyclerView.setAdapter(adapter);
    }
}