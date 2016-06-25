package com.example.tyz1201.yourrecipes.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tyz1201.yourrecipes.R;
import com.example.tyz1201.yourrecipes.adapter.FoodDisplayAdapter;
import com.example.tyz1201.yourrecipes.model.CookbookModel;
import com.example.tyz1201.yourrecipes.util.ListViewPramas;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by tyz1201 on 2016/5/18.
 */
public class FoodDisplayActivity extends AppCompatActivity {
    private CookbookModel model;
    private TextView textViewIntroduce;
    private String[] strsTags, strsIngredientsName, strsIngredients, strsBurdensName, strsBurdens;
    private LinearLayout tagsLayout;
    private String tags = "", ingredients = "";
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_food_display);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        model = (CookbookModel) intent.getSerializableExtra("messages");  //数据获取

        initContentView();

        strsTags = model.getTags().split(";");
        for (int i = 0; i < strsTags.length; i++) {
            tags = tags + strsTags[i] + "\b" + "\b";
            if ((i + 1) % 5 == 0) {
                tags = tags + "\n";
            }
            TextView textView = (TextView) findViewById(R.id.tv_dp_tags);
            textView.setText(tags);
        }

        strsIngredientsName = model.getIngredients().split(";");
        strsBurdensName = model.getBurden().split(";");


        for (int i = 0; i < strsIngredientsName.length; i++) {
            count++;
            strsIngredients = strsIngredientsName[i].split(",");
            ingredients = ingredients + strsIngredients[0] + "\b" + "\b" + "\b" + "\b" + strsIngredients[1] + "\b" + "\b" + "\b" + "\b" + "\b" + "\b";
            if (count % 3 == 0) {
                ingredients = ingredients + "\n";
            }
        }
        Log.d("ysjzyt", "长度：" + strsIngredientsName.length);

        for (int i = 0; i < strsBurdensName.length; i++) {
            count++;
            if (count % 3 == 0) {
                ingredients = ingredients + "\n";
            }
            strsBurdens = strsBurdensName[i].split(",");
            ingredients = ingredients + strsBurdens[0] + "\b" + "\b" + "\b" + "\b" + strsBurdens[1] + "\b" + "\b" + "\b" + "\b" + "\b" + "\b";
        }
        TextView textView = (TextView) findViewById(R.id.tv_dp_material);
        textView.setText(ingredients);

        ListView listView = (ListView) findViewById(R.id.lv_dp_howtodo);
        FoodDisplayAdapter lvAdapter = new FoodDisplayAdapter(model.getSteps(), this);
        listView.setAdapter(lvAdapter);
        ListViewPramas.setListViewHeightBasedOnChildren(listView, lvAdapter);
    }

    private void initContentView() {
        SimpleDraweeView sdv = (SimpleDraweeView) findViewById(R.id.sdv_fd_true);
        TextView textViewName = (TextView) findViewById(R.id.tv_fd_name);
        textViewIntroduce = (TextView) findViewById(R.id.tv_fd_intro);
        tagsLayout = (LinearLayout) findViewById(R.id.ll_fd_tags);

        sdv.setImageURI(Uri.parse(model.getAlbums().get(0)));
        textViewName.setText(model.getTitle());
        textViewIntroduce.setText(model.getImtro());
        textViewIntroduce.setOnLongClickListener(new View.OnLongClickListener() {
            boolean flag = true;

            @Override
            public boolean onLongClick(View v) {
                if (flag) {
                    flag = false;
                    textViewIntroduce.setEllipsize(null);
                    textViewIntroduce.setSingleLine(flag);
                } else {
                    flag = true;
                    textViewIntroduce.setEllipsize(TextUtils.TruncateAt.END);
                    textViewIntroduce.setLines(2);
                }
                return false;
            }
        });

    }
}


/**
 * 妄图做出 一行五个标签 分多行效果，失败！
 */

//int count = 0;
//for (int i = 0; i < strsTags.length; i++) {
//        count++;
//        LinearLayout layout = (LinearLayout) LayoutInflater.from(FoodDisplayActivity.this).inflate(R.layout.item_display_tags, tagsLayout);
//
//        TextView textView0, textView1, textView2, textView3, textView4;
//        textView0 = (TextView) layout.findViewById(R.id.tv_dp_tags0);
//        textView1 = (TextView) layout.findViewById(R.id.tv_dp_tags1);
//        textView2 = (TextView) layout.findViewById(R.id.tv_dp_tags2);
//        textView3 = (TextView) layout.findViewById(R.id.tv_dp_tags3);
//        textView4 = (TextView) layout.findViewById(R.id.tv_dp_tags4);
//
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
//        textView0.setLayoutParams(params);
//
//        textView0.setLayoutParams(params);
//        textView1.setLayoutParams(params);
//        textView2.setLayoutParams(params);
//        textView3.setLayoutParams(params);
//        textView4.setLayoutParams(params);
//
//        switch (count) {
//        case 5:
//        textView0.setText(strsTags[0]);
//        textView1.setText(strsTags[1]);
//        textView2.setText(strsTags[2]);
//        textView3.setText(strsTags[3]);
//        textView4.setText(strsTags[4]);
//        case 10:
//        textView0.setText(strsTags[5]);
//        textView1.setText(strsTags[6]);
//        textView2.setText(strsTags[7]);
//        textView3.setText(strsTags[8]);
//        textView4.setText(strsTags[9]);
//        case 15:
//        textView0.setText(strsTags[10]);
//        textView1.setText(strsTags[11]);
//        textView2.setText(strsTags[12]);
//        textView3.setText(strsTags[13]);
//        textView4.setText(strsTags[14]);
//        case 20:
//        textView0.setText(strsTags[15]);
//        textView1.setText(strsTags[16]);
//        textView2.setText(strsTags[17]);
//        textView3.setText(strsTags[18]);
//        textView4.setText(strsTags[19]);
//        break;
//default:
//        break;
//        }
//        Log.d("ysjzyt", "第几次了：" + count);
//        }