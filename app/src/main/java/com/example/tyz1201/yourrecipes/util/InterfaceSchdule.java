package com.example.tyz1201.yourrecipes.util;

import android.app.Activity;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class InterfaceSchdule {
    public static void createThread(final Activity activity, final SetWebDataOnUI setWebDataOnUI) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                setWebDataOnUI.GetWebData();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setWebDataOnUI.InitUI();
                    }
                });
            }
        }).start();
    }
}
