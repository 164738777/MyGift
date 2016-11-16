package com.gift.mygift.tools;

import android.app.Application;

import com.socks.library.KLog;

/**
 * 作者:  qiang on 2016/11/16 15:25
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public class GiftApp extends Application {

    private static GiftApp INSTANCE;

    public static GiftApp getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        KLog.init(true);
        //        MultiDex.install(this);//65K方法数限制，解决RxJava在4.4及以下机型找不到类的异常
    }
}
