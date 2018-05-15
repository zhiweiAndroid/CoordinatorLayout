package com.example.user.coordinatorlayout;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zitan on 2018/5/11.
 */

class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.MyHolder>{
    private Context context;
    private List<String> datas;
    public MyViewAdapter(Context context, List<String> datas) {
        this.context=context;
        this.datas=datas;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.my_item,null));
    }

    @Override
    public int getItemCount() {
        return datas!=null?datas.size():0;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tv.setText(datas.get(position));
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,SecondActivity.class));
            }
        });
    }


    public static class MyHolder  extends RecyclerView.ViewHolder {
        TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }

}
