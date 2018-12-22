package com.qishui.mylibrary.utils;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Zhou
 *         Created on 2018/4/12 9:53.
 *         Email:qishuichixi@163.com
 *         Desc:
 */

public class CrashUtils implements Thread.UncaughtExceptionHandler {

    //默认处理机制
    private Thread.UncaughtExceptionHandler mExceptionHandler;

    //单例
    private static CrashUtils crashUtils;

    public static void init() {

        if (crashUtils == null) {
            synchronized (CrashUtils.class) {
                crashUtils = new CrashUtils();
            }
        }
    }

    public CrashUtils() {
        mExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {

        if (!handleException(throwable) && mExceptionHandler != null) {
            //采用默认处理，如果没有自己处理
            mExceptionHandler.uncaughtException(thread, throwable);
        } else {
            //调转页面

        }

    }

    /**
     * 处理异常
     *
     * @param throwable
     * @return
     */
    private boolean handleException(Throwable throwable) {

        if (throwable == null) {
            return false;
        }
        saveCrashInfo2File(throwable);
        return true;
    }

    /**
     * 收集异常信息和设备
     *
     * @param throwable
     */
    private void saveCrashInfo2File(Throwable throwable) {

        String throwableMessage = getThrowableMessage(throwable);
        Log.e("Zhou", throwableMessage);
    }

    /**
     * 获取异常信息
     *
     * @param throwable
     * @return
     */
    public static String getThrowableMessage(Throwable throwable) {

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        throwable.printStackTrace(printWriter);
        Throwable cause = throwable.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        String temp = writer.toString();

        try {
            printWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
