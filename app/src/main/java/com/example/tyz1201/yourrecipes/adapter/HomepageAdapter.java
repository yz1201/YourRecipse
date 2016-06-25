package com.example.tyz1201.yourrecipes.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tyz1201.yourrecipes.R;
import com.example.tyz1201.yourrecipes.activity.FoodContentActivity;
import com.example.tyz1201.yourrecipes.model.CbTagsModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class HomepageAdapter extends BaseAdapter {

    List<CbTagsModel> models = new ArrayList<>();
    Context context;

    public HomepageAdapter(List<CbTagsModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hg_gridview_tags, null);
        CardView cardView = (CardView) view.findViewById(R.id.cardview_hg_adapter_tagsl);
        TextView textView = (TextView) view.findViewById(R.id.tv_hg_adapter_tags);

        textView.setText(models.get(position).getName());
        textView.setTextColor(view.getResources().getColor(R.color.black));

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodContentActivity.class);
                intent.putExtra("messages",  models.get(position));
                context.startActivity(intent);
            }
        });

        return view;
    }
}
