package com.gift.mygift.ui.sort.model;
import com.gift.mygift.constant.Constants;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.entity.SortGongLueZhuanTiBean;
import com.gift.mygift.network.ApiFun;
import com.gift.mygift.network.ApiResponse;
import com.gift.mygift.network.NetWork;
import com.gift.mygift.network.NetworkTransformer;
import com.gift.mygift.network.subscriber.SilenceSubscriber;
import com.gift.mygift.listener.OnLoadDataListListener;
import com.gift.mygift.ui.sort.contract.SortGongLueContract;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

/**
* Created by MVPHelper on 2016/11/28
*/

public class SortGongLueModelImpl implements SortGongLueContract.Model{

    @Override
    public void getZhuanTiBanner(final OnLoadDataListListener<List<SendGiftData>> listener) {
        NetWork.getSortApi().getSortGongLueZhuanTiList(Constants.API_LIMIT,Constants.API_OFFSET)
                .map(new ApiFun<SortGongLueZhuanTiBean<SendGiftData>>())
                .map(new Func1<ApiResponse<SortGongLueZhuanTiBean<SendGiftData>>, List<SendGiftData>>() {
                    @Override
                    public List<SendGiftData> call(ApiResponse<SortGongLueZhuanTiBean<SendGiftData>> sortGongLueZhuanTiBeanApiResponse) {
                        List<SendGiftData> banners = sortGongLueZhuanTiBeanApiResponse.data.collections;
                        if (banners==null)
                            banners = new ArrayList<>();
                        return banners;
                    }
                })
                .compose(NetworkTransformer.<List<SendGiftData>>commonSchedulers())
                .subscribe(new SilenceSubscriber<List<SendGiftData>>(){
                    @Override
                    public void onNext(List<SendGiftData> list) {
                        super.onNext(list);
                        listener.onSuccess(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        listener.onFailure(e);
                    }
                });
    }
}