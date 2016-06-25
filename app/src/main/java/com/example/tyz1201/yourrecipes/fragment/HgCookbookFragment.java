//package com.example.tyz1201.yourrecipes.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.tyz1201.yourrecipes.model.CbTagsModel;
//
//import java.io.Serializable;
//
///**
// * Created by tyz1201 on 2016/5/12.
// */
//public class HgCookbookFragment extends Fragment {
//    public static HgCookbookFragment newInstance(CbTagsModel cbTagsModel) {
//        Bundle args = new Bundle();
//        args.putSerializable("messages", (Serializable) cbTagsModel);
//        HgCookbookFragment fragment = new HgCookbookFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Bundle bundle = getArguments();
//        CbTagsModel models = (CbTagsModel) bundle.get("messages");
//        View view = inflater.inflate(R.i,null);
//
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//}
