package com.lesehome.example;

import android.os.Bundle;
import android.widget.ListView;

import com.lesehome.example.DataSource.ExampleData;
import com.lesehome.example.bean.Item1Bean;
import com.lesehome.modularrecyclerview.helper.CommonAdapter;
import com.lesehome.modularrecyclerview.helper.ViewHelper;

public class Example4Activity extends BaseActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_4);
        init();
    }

    private void init() {
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new CommonAdapter<Item1Bean>(this, R.layout.item_example1_modular_1,
                ExampleData.getItem1Bean()) {
            @Override
            public void convert(ViewHelper holder, int position, Item1Bean bean) {
                holder.setText(R.id.tv_title, bean.title);
                holder.setText(R.id.tv_content, bean.content);
            }
        });
    }

}