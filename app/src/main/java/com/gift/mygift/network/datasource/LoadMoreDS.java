package com.gift.mygift.network.datasource;

import com.gift.mygift.network.RxRetrofitHandle;
import com.shizhefei.mvc.IAsyncDataSource;
import com.shizhefei.mvc.RequestHandle;
import com.shizhefei.mvc.ResponseSender;

import rx.Subscription;

import static com.gift.mygift.constant.Constants.PAGEINDEX;
import static com.gift.mygift.constant.Constants.PAGESIZE;


/**
 * Created by Qiang on 2016/10/9.
 * 邮箱：anWorkMail_q@126.com
 * 作用：有分页DS
 */

public abstract class LoadMoreDS<DATA> implements IAsyncDataSource<DATA> {

    protected int mPage = PAGEINDEX;
    protected int mPageSize = PAGESIZE;


    @Override
    public RequestHandle loadMore(ResponseSender<DATA> sender) throws Exception {
        return getRequestHandle(sender, 20 + mPage);
    }

    @Override
    public RequestHandle refresh(ResponseSender<DATA> sender) throws Exception {
        mPage = PAGEINDEX;
        return getRequestHandle(sender, mPage);
    }

    private RequestHandle getRequestHandle(ResponseSender<DATA> responseSender, int page) {
        return new RxRetrofitHandle(loadData(responseSender, page));
    }

    /**
     * 在这里进行相关网络get请求,记得配合ListSub使用sender,以及修改page,pageSize
     * 在onComplete或者onNext里面记得    mPage = page;
     * @param responseSender
     * @param page
     * @return
     */
    protected abstract Subscription loadData(ResponseSender<DATA> responseSender, int page);


    @Override
    public boolean hasMore() {
        return mPageSize >= PAGESIZE;
    }
}
