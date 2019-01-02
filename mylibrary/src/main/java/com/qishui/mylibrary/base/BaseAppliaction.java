package com.qishui.mylibrary.base;

import com.blankj.utilcode.util.Utils;
import com.qishui.commontoolslibrary.base.BaseQiShuiApplication;
import com.qishui.mylibrary.utils.CrashUtils;

/**
 * Created by zhou on 2018/12/20.
 */

public class BaseAppliaction extends BaseQiShuiApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashUtils.init();
        Utils.init(this);
    }
}
