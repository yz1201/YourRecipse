package com.example.tyz1201.yourrecipes.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tyz1201.yourrecipes.R;
import com.example.tyz1201.yourrecipes.activity.FoodDisplayActivity;
import com.example.tyz1201.yourrecipes.model.CookbookModel;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyz1201 on 2016/5/18.
 */
public class DkcAdapter extends BaseAdapter {
    private Context context;
    private List<CookbookModel> models = new ArrayList<>();

    public DkcAdapter(Context context, List<CookbookModel> models) {
        this.context = context;
        this.models = models;
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
        final View view = LayoutInflater.from(context).inflate(R.layout.item_dkc_adapter, null);
        SimpleDraweeView sdv = (SimpleDraweeView) view.findViewById(R.id.sdv);
        TextView textViewName = (TextView) view.findViewById(R.id.tv_dkc_adapter_name);
        TextView textViewMaterial = (TextView) view.findViewById(R.id.tv_dkc_adapter_material);

        sdv.setImageURI(Uri.parse(models.get(position).getAlbums().get(0)));
        textViewName.setText(models.get(position).getTitle());
        textViewName.setTextColor(context.getResources().getColor(R.color.white));
        textViewMaterial.setTextColor(context.getResources().getColor(R.color.white));
        textViewMaterial.setText(models.get(position).getIngredients() + models.get(position).getBurden());

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_item_list);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDisplayActivity.class);
                intent.putExtra("messages", models.get(position));
                context.startActivity(intent);
            }
        });
        return view;
    }
}
