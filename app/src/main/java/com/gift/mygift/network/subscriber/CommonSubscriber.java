package com.gift.mygift.network.subscriber;

import rx.Subscriber;

/**
 * Author: Andecy
 * Time: 2016/6/17
 * Email: andecy@foxmail.com
 * Description: TODO
 */
public abstract class CommonSubscriber<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }
}
