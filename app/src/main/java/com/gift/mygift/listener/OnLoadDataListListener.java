package com.gift.mygift.listener;

/**
 * 作者:  qiang on 2016/11/24 18:30
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface OnLoadDataListListener<T> {
    void onSuccess(T data);
    void onFailure(Throwable e);
}
