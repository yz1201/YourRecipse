package com.example.tyz1201.yourrecipes.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tyz1201.yourrecipes.R;
import com.example.tyz1201.yourrecipes.model.CookStepModel;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyz1201 on 2016/5/27.
 */
public class FoodDisplayAdapter extends BaseAdapter {
    private List<CookStepModel> models = new ArrayList<>();
    private Context context;

    public FoodDisplayAdapter(List<CookStepModel> models, Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dp_lv_step, null);
        SimpleDraweeView sdv = (SimpleDraweeView) view.findViewById(R.id.sdv_lvadapter_item_step);
        TextView textView = (TextView) view.findViewById(R.id.tv_lvadapter_item_step);

        sdv.setImageURI(Uri.parse(models.get(position).getImg()));
        textView.setText(models.get(position).getStep());

        return view;
    }
}
