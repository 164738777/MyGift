package com.gift.mygift.network.subscriber;

import com.shizhefei.mvc.ResponseSender;

/**
 * Author: Andecy;
 * Time: 2016/4/19;
 * Email: Andecy@foxmail.com;
 * Description: MvcHelper专用的订阅
 */
public class ListSubscriber<T> extends CommonSubscriber<T>{
    private ResponseSender<T> sender;

    public ListSubscriber(ResponseSender<T> sender) {
        this.sender = sender;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        if (sender!=null){
            sender.sendError(new Exception(e));
        }
    }

    @Override
    public void onNext(T t) {
        if (sender!=null){
            sender.sendData(t);
        }
    }
}
