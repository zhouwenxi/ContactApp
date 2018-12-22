package com.qishui.contact.activity;

import android.os.Bundle;
import android.os.Handler;

import com.qishui.contact.R;
import com.qishui.mylibrary.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private static final long SIZE = 1000;

    @Override
    protected int initLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void intEvent(Bundle savedInstanceState) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivityFinish(MainActivity.class);
            }
        }, SIZE);

    }
}
