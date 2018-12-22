package com.qishui.contact.activity;

import android.os.Bundle;
import android.view.View;

import com.qishui.contact.R;
import com.qishui.mylibrary.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected int initLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void intEvent(Bundle savedInstanceState) {

    }

    public void login(View view) {
        startActivityFinish(MainActivity.class);
    }
}
