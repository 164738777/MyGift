package com.gift.mygift.network.datasource.base;

import com.gift.mygift.network.RxRetrofitHandle;
import com.shizhefei.mvc.IAsyncDataSource;
import com.shizhefei.mvc.RequestHandle;
import com.shizhefei.mvc.ResponseSender;

import rx.Subscription;


/**
 * Created by Qiang on 2016/10/9.
 * 邮箱：anWorkMail_q@126.com
 * 作用：没有分页的DS
 */

public abstract class CommonDS<DATA> implements IAsyncDataSource<DATA> {


    @Override
    public boolean hasMore() {
        return false;
    }

    @Override
    public RequestHandle loadMore(ResponseSender<DATA> sender) throws Exception {
        return null;
    }

    @Override
    public RequestHandle refresh(ResponseSender<DATA> sender) throws Exception {
        return getRequestHandle(sender);
    }

    private RequestHandle getRequestHandle(ResponseSender<DATA> responseSender) {
        return new RxRetrofitHandle(loadData(responseSender));
    }


    /**
     * 在这里进行相关网络get请求,记得配合ListSub使用sender
     * @param responseSender
     * @return
     */
    protected abstract Subscription loadData(ResponseSender<DATA> responseSender);

}
