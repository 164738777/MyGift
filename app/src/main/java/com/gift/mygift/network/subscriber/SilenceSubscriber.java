package com.gift.mygift.network.subscriber;

import android.content.Context;
import android.text.TextUtils;

import com.gift.mygift.R;
import com.gift.mygift.network.ApiException;
import com.gift.mygift.tools.ToastTool;

import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Author: Andecy;
 * Time: 2016/4/21;
 * Email: Andecy@foxmail.com;
 * Description: 悄悄联网-。=
 */
public class SilenceSubscriber<T> extends CommonSubscriber<T> {
    private String errorToast;
    private Context mContext;

    /**
     * 显示自定义错误提示
     *
     * @param context    上下文
     * @param errorToast 错误提示
     */
    public SilenceSubscriber(Context context, String errorToast) {
        this.errorToast = errorToast;
        this.mContext = context;
    }

    /**
     * 显示异常或默认错误提示
     *
     * @param context 上下文
     */
    public SilenceSubscriber(Context context) {
        this.mContext = context;
    }

    /**
     * 不显示任何提示
     */
    public SilenceSubscriber() {
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        if (mContext == null) {
            return;
        }

        if (e instanceof HttpException) {
            ToastTool.show(mContext, mContext.getString(R.string.load_fail_api));
        } else if (e instanceof SocketTimeoutException) {
            ToastTool.show(mContext, mContext.getString(R.string.load_fail_timeout));
        } else if (e instanceof ApiException) {
            ToastTool.show(mContext, e.getLocalizedMessage());
        } else if (!TextUtils.isEmpty(errorToast)) {
            ToastTool.show(mContext, errorToast);
        }
    }

    @Override
    public void onNext(T t) {
    }
}
