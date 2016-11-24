package com.gift.mygift.network.datasource;

import com.gift.mygift.constant.Constants;
import com.gift.mygift.entity.HotBean;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.network.ApiFun;
import com.gift.mygift.network.ApiResponse;
import com.gift.mygift.network.NetWork;
import com.gift.mygift.network.NetworkTransformer;
import com.gift.mygift.network.subscriber.ListSubscriber;
import com.shizhefei.mvc.ResponseSender;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.functions.Func1;

/**
 * 作者:  qiang on 2016/11/23 14:42
 * 邮箱:  anworkmail_q@126.com
 * 作用:  各种送、精选大图
 */

public class JingXuanBigImageDS extends LoadMoreDS<List<SendGiftData>> {

    private int channelID;

    public JingXuanBigImageDS(int channelID) {
        this.channelID = channelID;
    }

    @Override
    protected Subscription loadData(ResponseSender<List<SendGiftData>> responseSender, final int page) {
        return NetWork.getApi().getJingXuanList(channelID, Constants.API_GENDER, Constants.API_GENERATION, mPageSize, page, Constants.API_AD)
                .map(new ApiFun<HotBean<SendGiftData>>())
                .map(new Func1<ApiResponse<HotBean<SendGiftData>>, List<SendGiftData>>() {
                    @Override
                    public List<SendGiftData> call(ApiResponse<HotBean<SendGiftData>> hotBeanApiResponse) {
                        List<SendGiftData> items = hotBeanApiResponse.data.items;
                        if (items == null)
                            items = new ArrayList<>();
                        return items;
                    }
                })
                .compose(NetworkTransformer.<List<SendGiftData>>commonSchedulers())
                .subscribe(new ListSubscriber<List<SendGiftData>>(responseSender) {
                    @Override
                    public void onNext(List<SendGiftData> sendGiftDatas) {
                        super.onNext(sendGiftDatas);
                        mPage = page;
                        mPageSize = sendGiftDatas.size();
                    }
                });
    }
}
