package com.lesehome.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lesehome.example.DataSource.ExampleData;
import com.lesehome.example.adpater.Example1Adapter;
import com.lesehome.modularrecyclerview.OnItemListener;
import com.lesehome.modularrecyclerview.decoration.LinearDividerItemDecoration;
import com.lesehome.modularrecyclerview.helper.ViewHelper;

public class Example1Activity extends BaseActivity {

    private static final String TAG = "Example1Activity";

    private Context context;

    private RecyclerView recyclerView;
    private Example1Adapter adapter;

    private ViewHelper viewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_1);
        viewHelper = new ViewHelper(getWindow().getDecorView());

        context = this;

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

        adapter = new Example1Adapter(ExampleData.getExample1());
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
        floatTopView(recyclerView);
    }

    private void floatTopView(RecyclerView mRecyclerView) {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView == null)
                    return;
                if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager))
                    return;
                if (!(recyclerView.getParent() instanceof ViewGroup))
                    return;
                if (recyclerView.getAdapter() == null)
                    return;

                if (recyclerView.getAdapter().getItemCount() > 0) {
                    LinearLayoutManager lManager = (LinearLayoutManager)
                            recyclerView.getLayoutManager();
                    int position = lManager.findFirstVisibleItemPosition();
                    View view = lManager.findViewByPosition(position);
                    int type = lManager.getItemViewType(view);


                    StringBuilder builder = new StringBuilder();
                    builder.append("[onScrolled]-->{ ");
                    builder.append("dx").append(":").append(dx).append(" , ");
                    builder.append("dy").append(":").append(dy).append(" , ");
                    builder.append("type").append(":").append(type).append(" , ");
                    builder.append("position").append(":").append(position).append(" , ");

                    builder.append(" }");
                    Log.i(TAG, builder.toString());

                    final ViewGroup parent = (ViewGroup) recyclerView.getParent();

                    parent.removeView(ivTop);
                    if(position !=0 && String.valueOf(position).endsWith("0")){
                        setFloatView(view);
                        parent.addView(ivTop);
                    }
                }

            }
        });
    }

    private ImageView ivTop;

    /**
     * 设置浮动的view展示
     *
     * @param view
     */
    private void setFloatView(View view) {
        if (ivTop == null) {
            ivTop = new ImageView(recyclerView.getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            ivTop.setLayoutParams(params);
            ivTop.setOnClickListener(null);
            ivTop.setBackgroundColor(Color.LTGRAY);
        }

        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();  //启用DrawingCache并创建位图
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache()); //创建一个DrawingCache的拷贝，因为DrawingCache得到的位图在禁用后会被回收
        view.setDrawingCacheEnabled(false);  //禁用DrawingCahce否则会影响性能
        ivTop.setImageBitmap(bitmap);
    }
}