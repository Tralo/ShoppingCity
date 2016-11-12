package com.demo.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.demo.recyclerviewdemo.adapter.MyItemDecoration;
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
//        rlv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        rlv.setLayoutManager(new GridLayoutManager(MainActivity.this,2/*,GridLayoutManager.HORIZONTAL,true*/));
        rlv.setLayoutManager(new LinearLayoutManager(this));
//        rlv.scrollToPosition(20);
        //设置分割线
        rlv.addItemDecoration(new MyItemDecoration(MainActivity.this,MyItemDecoration.VERTICAL_LIST));

        //设置点击某一条的事件
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String data) {
                Toast.makeText(MainActivity.this,"data == " + data + ", position ==" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }






}
