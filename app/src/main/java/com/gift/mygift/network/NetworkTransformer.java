package com.gift.mygift.network;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: Andecy;
 * Time: 2016/4/21;
 * Email: Andecy@foxmail.com;
 * Description: 网络线程通用链
 */
public class NetworkTransformer{

    public static <T> Observable.Transformer<T, T> commonSchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
