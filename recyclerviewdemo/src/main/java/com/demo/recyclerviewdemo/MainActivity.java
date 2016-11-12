package com.demo.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.recyclerviewdemo.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rlv;

    private ArrayList<String> datas;

    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv = (RecyclerView) findViewById(R.id.rlv);
        //添加数据
        datas = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            datas.add("Data_" + i);
        }
        //设置适配器
        adapter = new RecyclerAdapter(this,datas);
        rlv.setAdapter(adapter);

        //设置布局管理器
        /**
         * LinearLayoutManager构造器参数: 上下文， 水平或竖直， 是否倒序
         */
        rlv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rlv.scrollToPosition(20);
    }



}
