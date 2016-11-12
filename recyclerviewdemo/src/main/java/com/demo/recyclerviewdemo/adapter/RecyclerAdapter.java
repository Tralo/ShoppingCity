package com.demo.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.recyclerviewdemo.MainActivity;
import com.demo.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adventurer on 16-11-12.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private RecyclerAdapter.OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(RecyclerAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    private Context context;
    private List<String> datas;

    public RecyclerAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    /**
     * 相当于getView方法中创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item_view,null);
        return new MyViewHolder(itemView);
    }

    /**
     * 相当于getView方法中绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        //根据位置得到数据,再设置
        holder.tv_title.setText(datas.get(position));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(int pos,String data) {
        datas.add(pos,data);
        notifyItemInserted(pos);

    }

    public void removeData(int i) {
        if(datas.size() > i + 1){
            datas.remove(i);
            notifyItemRemoved(i);
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_icon;
        private TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            //设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(context,"data == " + datas.get(getLayoutPosition()),Toast.LENGTH_SHORT).show();
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(view,getLayoutPosition(),datas.get(getLayoutPosition()));
                    }
                }
            });
            iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"图片被点击类  data == " + datas.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * 点击RecyclerView的item点击回调接口
     */
    public interface  OnItemClickListener{
        void onItemClick(View view,int position,String data);
    }
}
