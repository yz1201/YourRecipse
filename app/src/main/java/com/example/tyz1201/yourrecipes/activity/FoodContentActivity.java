package com.example.tyz1201.yourrecipes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tyz1201.yourrecipes.R;
import com.example.tyz1201.yourrecipes.adapter.FoodContentAdapter;
import com.example.tyz1201.yourrecipes.model.CbTagsModel;
import com.example.tyz1201.yourrecipes.model.CookWebModel;
import com.example.tyz1201.yourrecipes.model.DishKindsModel;
import com.example.tyz1201.yourrecipes.util.InterfaceSchdule;
import com.example.tyz1201.yourrecipes.util.NetworkRequest;
import com.example.tyz1201.yourrecipes.util.SetWebDataOnUI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class FoodContentActivity extends AppCompatActivity {
    private CbTagsModel models;
    private FoodContentAdapter foodContentAtapter;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_fdcontent);
        super.onCreate(savedInstanceState);

        TextView textView = (TextView) findViewById(R.id.tv_fc_title);
        Intent intent = getIntent();
        models = (CbTagsModel) intent.getSerializableExtra("messages");

        textView.setText(models.getName());
        gridView = (GridView) findViewById(R.id.gridview_fc_kinds);
        foodContentAtapter = new FoodContentAdapter(models.getList(), FoodContentActivity.this);
        gridView.setAdapter(foodContentAtapter);
    }

}

