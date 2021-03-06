package com.example.user.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zitan on 2018/5/11.
 */

public class MyFragment extends Fragment {

    private View view;
    private List<String> datas=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null) {
            view = inflater.inflate(R.layout.myfragment, container, false);
            initView();
        }
        return view;
    }

    private void initView() {
        RecyclerView lv = view.findViewById(R.id.lv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        // 设置布局管理器

        lv.setLayoutManager(layoutManager);
        for (int i=0;i<100;i++){
            datas.add("1000"+i);
        }
        lv.setAdapter(new MyViewAdapter(getContext(),datas));

    }

}
