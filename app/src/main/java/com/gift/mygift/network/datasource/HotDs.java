package com.gift.mygift.network.datasource;

import com.gift.mygift.constant.Constants;
import com.gift.mygift.entity.HotBean;
import com.gift.mygift.entity.HotListBean;
import com.gift.mygift.network.ApiFun;
import com.gift.mygift.network.ApiResponse;
import com.gift.mygift.network.NetWork;
import com.gift.mygift.network.NetworkTransformer;
import com.gift.mygift.network.subscriber.ListSubscriber;
import com.shizhefei.mvc.ResponseSender;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.functions.Func1;

/**
 * 作者:  qiang on 2016/11/17 21:23
 * 邮箱:  anworkmail_q@126.com
 * 作用:  热门首页
 */

public class HotDS extends LoadMoreDS<List<HotListBean>> {
    @Override
    protected Subscription loadData(ResponseSender<List<HotListBean>> responseSender, final int page) {
        return NetWork.getApi().getHotList(Constants.API_GENDER, Constants.API_GENERATION, mPageSize, page)
                .map(new ApiFun<HotBean>())
                .map(new Func1<ApiResponse<HotBean>, List<HotListBean>>() {
                    @Override
                    public List<HotListBean> call(ApiResponse<HotBean> hotBeanApiResponse) {
                        List<HotListBean> items = hotBeanApiResponse.data.items;
                        if (items == null) {
                            items = new ArrayList<>();
                        }
                        return items;
                    }
                })
                .compose(NetworkTransformer.<List<HotListBean>>commonSchedulers())
                .subscribe(new ListSubscriber<List<HotListBean>>(responseSender){
                    @Override
                    public void onNext(List<HotListBean> hotListBeen) {
                        super.onNext(hotListBeen);
                        mPage = page;
                        mPageSize = hotListBeen.size();
                    }
                });
    }
}
