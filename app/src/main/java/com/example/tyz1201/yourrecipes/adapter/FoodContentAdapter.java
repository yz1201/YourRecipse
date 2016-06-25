package com.example.tyz1201.yourrecipes.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tyz1201.yourrecipes.R;
import com.example.tyz1201.yourrecipes.activity.DishKindContentActivity;
import com.example.tyz1201.yourrecipes.model.CookbookModel;
import com.example.tyz1201.yourrecipes.model.DishKindsModel;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class FoodContentAdapter extends BaseAdapter {
    private List<DishKindsModel> models = new ArrayList<>();
    private Context context;

    public FoodContentAdapter(List<DishKindsModel> models, Context context) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_fc_lv_foodcontent, null);
        Button button = (Button) view.findViewById(R.id.btn_fc_name);
        button.setText(models.get(position).getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DishKindContentActivity.class);
                intent.putExtra("messages", models.get(position));
                context.startActivity(intent);
            }
        });
        return view;
    }
}
