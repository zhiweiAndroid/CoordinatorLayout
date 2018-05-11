package com.example.user.coordinatorlayout;

import android.content.Context;
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

class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private List<String> datas;
    public MyListViewAdapter(Context context, List<String> datas) {
        this.context=context;
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size()>0?datas.size():0;
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.my_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(datas.get(position));
        return convertView;
    }

    private static class ViewHolder {
        TextView tv;
        public ViewHolder(View convertView) {
           tv=convertView.findViewById(R.id.tv);
        }
    }

}
