package com.gift.mygift.network.datasource.sort;

import com.gift.mygift.entity.SortGiftBean;
import com.gift.mygift.entity.SortGiftList;
import com.gift.mygift.network.ApiFun;
import com.gift.mygift.network.ApiResponse;
import com.gift.mygift.network.NetWork;
import com.gift.mygift.network.NetworkTransformer;
import com.gift.mygift.network.datasource.base.CommonDS;
import com.gift.mygift.network.subscriber.ListSubscriber;
import com.shizhefei.mvc.ResponseSender;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.functions.Func1;

/**
 * 作者:  qiang on 2016/11/27 21:30
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类 礼物 小图DS
 */

public class SortGiftDS extends CommonDS<List<SortGiftList>> {
    @Override
    protected Subscription loadData(ResponseSender<List<SortGiftList>> responseSender) {
        return NetWork.getSortApi().getSortGiftList()
                .map(new ApiFun<SortGiftBean<SortGiftList>>())
                .map(new Func1<ApiResponse<SortGiftBean<SortGiftList>>, List<SortGiftList>>() {
                    @Override
                    public List<SortGiftList> call(ApiResponse<SortGiftBean<SortGiftList>> sortGiftBeanApiResponse) {
                        List<SortGiftList> categories = sortGiftBeanApiResponse.data.categories;
                        if (categories == null)
                            categories = new ArrayList<>();
                        return categories;
                    }
                })
                .compose(NetworkTransformer.<List<SortGiftList>>commonSchedulers())
                .subscribe(new ListSubscriber<>(responseSender));
    }
}
