package com.gift.mygift.tools;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Author: Andecy
 * Time: 2016/7/21
 * Email: andecy@foxmail.com
 * Description: Toast工具
 */
public class ToastTool {

    private ToastTool() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    public static void show(Context context, @StringRes int res) {
        show(context, context.getString(res));
    }

    public static void show(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showWithClick(Context context, String msg) {
        if (ClickTool.isFastClick()) {
            return;
        }
        show(context, msg);
    }

    public static void showWithClick(Context context, @StringRes int res) {
        if (ClickTool.isFastClick()) {
            return;
        }
        show(context, context.getString(res));
    }
}
