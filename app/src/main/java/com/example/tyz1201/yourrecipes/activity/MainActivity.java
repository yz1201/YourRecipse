package com.example.tyz1201.yourrecipes.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;


import com.example.tyz1201.yourrecipes.R;
import com.example.tyz1201.yourrecipes.adapter.HomepageAdapter;
import com.example.tyz1201.yourrecipes.model.CookbookTagsModel;
import com.example.tyz1201.yourrecipes.util.InterfaceSchdule;
import com.example.tyz1201.yourrecipes.util.NetworkRequest;
import com.example.tyz1201.yourrecipes.util.SetWebDataOnUI;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private CookbookTagsModel cookbookTagsModel;
    private HomepageAdapter homepageAdapter;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.tv_hg_title);
        textView.setText("我的菜谱");
        textView.setTextColor(getResources().getColor(R.color.text_color_black));

        gridView = (GridView) findViewById(R.id.gridview_hg_tags);
        InterfaceSchdule.createThread(MainActivity.this, new SetWebDataOnUI() {
            @Override
            public void GetWebData() {
                String gson = NetworkRequest.getRequestData("http://apis.juhe.cn/cook/category?key=142ab5bfe0797b3bfb88a54e6ad37877");
                cookbookTagsModel = new Gson().fromJson(gson, CookbookTagsModel.class);
                Log.d("ysjzyt",gson);
            }

            @Override
            public void InitUI() {
                Log.d("ysjzyt","zzzz");
                homepageAdapter = new HomepageAdapter(cookbookTagsModel.getResult(), MainActivity.this);
                gridView.setAdapter(homepageAdapter);
            }
        });

    }

}
