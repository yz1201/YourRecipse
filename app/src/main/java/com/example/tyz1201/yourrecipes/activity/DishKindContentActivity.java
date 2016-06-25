package com.example.tyz1201.yourrecipes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.example.tyz1201.yourrecipes.R;
import com.example.tyz1201.yourrecipes.adapter.DkcAdapter;
import com.example.tyz1201.yourrecipes.model.CookWebModel;
import com.example.tyz1201.yourrecipes.model.DishKindsModel;
import com.example.tyz1201.yourrecipes.util.InterfaceSchdule;
import com.example.tyz1201.yourrecipes.util.NetworkRequest;
import com.example.tyz1201.yourrecipes.util.SetWebDataOnUI;
import com.google.gson.Gson;

/**
 * Created by tyz1201 on 2016/5/17.
 */
public class DishKindContentActivity extends AppCompatActivity {
    private DishKindsModel model;
    private CookWebModel cookWebModel;
    private ListView listView;
    private DkcAdapter dkcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dkc);

        Intent intent = getIntent();
        model = (DishKindsModel) intent.getSerializableExtra("messages");

        Toolbar toolbar = (Toolbar) findViewById(R.id.common_toolbar);
        toolbar.setTitle(model.getName());
        toolbar.setTitleTextColor(getResources().getColor(R.color.text_color_black));
        listView = (ListView) findViewById(R.id.lv_dkc_food);
        initData();
    }

    private void initData() {
        InterfaceSchdule.createThread(DishKindContentActivity.this, new SetWebDataOnUI() {
            @Override
            public void GetWebData() {
                String gson = NetworkRequest.getRequestData("http://apis.juhe.cn/cook/index?key=142ab5bfe0797b3bfb88a54e6ad37877&cid=" + model.getId());
                cookWebModel = new Gson().fromJson(gson, CookWebModel.class);
            }

            @Override
            public void InitUI() {
                dkcAdapter = new DkcAdapter(DishKindContentActivity.this, cookWebModel.getResult().getData());
                listView.setAdapter(dkcAdapter);
            }
        });
    }
}
