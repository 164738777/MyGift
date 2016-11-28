package com.gift.mygift.network.datasource.sort;

import com.gift.mygift.entity.SortGongLueBean;
import com.gift.mygift.entity.SortGongLueList;
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
 * 作用:  分类 攻略 小图DS
 */

public class SortGongLueDS extends CommonDS<List<SortGongLueList>> {
    @Override
    protected Subscription loadData(ResponseSender<List<SortGongLueList>> responseSender) {
        return NetWork.getSortApi().getSortGongLueList()
                .map(new ApiFun<SortGongLueBean<SortGongLueList>>())
                .map(new Func1<ApiResponse<SortGongLueBean<SortGongLueList>>, List<SortGongLueList>>() {
                    @Override
                    public List<SortGongLueList> call(ApiResponse<SortGongLueBean<SortGongLueList>> sortGongLueBeanApiResponse) {
                        List<SortGongLueList> channel_groups = sortGongLueBeanApiResponse.data.channel_groups;
                        if (channel_groups == null)
                            channel_groups = new ArrayList<>();
                        return channel_groups;
                    }
                })
                .compose(NetworkTransformer.<List<SortGongLueList>>commonSchedulers())
                .subscribe(new ListSubscriber<>(responseSender));
    }
}
