package com.gift.mygift.network;

import com.shizhefei.mvc.RequestHandle;

import rx.Subscription;

/**
 * Author: Andecy;
 * Time: 2016/4/19;
 * Email: Andecy@foxmail.com;
 * Description: TODO
 */
public class RxRetrofitHandle implements RequestHandle {
    private Subscription mSubscription;
    public RxRetrofitHandle(Subscription subscription) {
        mSubscription = subscription;
    }

    @Override
    public void cancle() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
