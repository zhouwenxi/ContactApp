package com.qishui.mylibrary.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.jaeger.library.StatusBarUtil;
import com.qishui.mylibrary.R;

/**
 * Created by zhou on 2018/12/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(initLayoutID());
        setTopColor();
        intEvent(savedInstanceState);
    }

    protected abstract int initLayoutID();

    protected abstract void intEvent(Bundle savedInstanceState);

    public void setTopColor() {
        StatusBarUtil.setColor(this, 0xFF03B5FF);
    }

    public void setTopDrawLayout(DrawerLayout drawerLayout) {
        StatusBarUtil.setColorForDrawerLayout(this, drawerLayout, 0xFF03B5FF);
    }

    public void startActivity(Class<? extends Activity> clz) {
        startActivity(new Intent(this, clz));
    }

    public void startActivityFinish(Class<? extends Activity> clz) {
        startActivity(new Intent(this, clz));
        finish();
    }

}
