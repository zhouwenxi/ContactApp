package com.qishui.mylibrary.base;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.qishui.mylibrary.utils.CrashUtils;

/**
 * Created by zhou on 2018/12/20.
 */

public class BaseAppliaction extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CrashUtils.init();
        Utils.init(this);
    }
}
