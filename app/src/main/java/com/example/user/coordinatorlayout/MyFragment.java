package com.example.user.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        }
        initView();
        return view;
    }

    private void initView() {
        ListView lv = view.findViewById(R.id.lv);
        for (int i=0;i<100;i++){
            datas.add("1000"+i);
        }
        lv.setAdapter(new MyListViewAdapter(getContext(),datas));
    }

}
