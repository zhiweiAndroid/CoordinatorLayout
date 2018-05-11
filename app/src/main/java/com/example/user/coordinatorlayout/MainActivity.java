package com.example.user.coordinatorlayout;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private Toolbar toolbar;
    private TabLayout tableLayout;
    private AppBarLayout appBarLayout;
    private List<Fragment> fragments=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
        initToolbar();
        initTab();
        initListener();
    }

    private void initFragment() {
     MyFragment myFragment=new MyFragment();
     fragments.add(myFragment);
     fragments.add(myFragment);
     fragments.add(myFragment);
    }

    private void initView() {
        vp = findViewById(R.id.viewpager);
        toolbar = findViewById(R.id.toolbar);
        tableLayout = findViewById(R.id.tabs);
        appBarLayout = findViewById(R.id.app_bar_layout);
    }

    private void initTab() {
        vp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragments));
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tableLayout));
        tableLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(vp));
    }



    private void initToolbar() {
            toolbar.setTitle("CoordinatorLayout");
            // 将toolBar和actionBar进行关联
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });


    }


    private void initListener() {
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"hello world!",Snackbar.LENGTH_SHORT)
                        .setAction("cancle", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg="";
        switch (item.getItemId()){
            case R.id.web:
                msg="跳转浏览器";
                break;
            case R.id.weibo:
                msg="跳转微博";
                break;
            case R.id.setting:
                msg="跳转设置中心";
                break;
        }
        if (!TextUtils.isEmpty(msg)){
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
