package com.gift.mygift.ui.guide.model;

import com.gift.mygift.constant.Constants;
import com.gift.mygift.entity.FirstBannerBean;
import com.gift.mygift.entity.SecondBannerBean;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.network.ApiFun;
import com.gift.mygift.network.ApiResponse;
import com.gift.mygift.network.NetWork;
import com.gift.mygift.network.NetworkTransformer;
import com.gift.mygift.network.subscriber.SilenceSubscriber;
import com.gift.mygift.listener.OnLoadDataListListener;
import com.gift.mygift.ui.guide.contract.JingXuanContract;
import com.gift.mygift.ui.guide.onGuideLoadDataListener;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

/**
 * Created by MVPHelper on 2016/11/24
 */

public class JingXuanModelImpl implements JingXuanContract.Model {


    @Override
    public void getFirstBannerList(final OnLoadDataListListener<List<SendGiftData>> listener) {
        NetWork.getApi().getJingXuanFirstBannerList()
                .map(new ApiFun<FirstBannerBean<SendGiftData>>())
                .map(new Func1<ApiResponse<FirstBannerBean<SendGiftData>>, List<SendGiftData>>() {
                    @Override
                    public List<SendGiftData> call(ApiResponse<FirstBannerBean<SendGiftData>> sApi) {
                        List<SendGiftData> banners = sApi.data.banners;
                        if (banners == null)
                            banners = new ArrayList<>();
                        return banners;
                    }
                })
                .compose(NetworkTransformer.<List<SendGiftData>>commonSchedulers())
                .subscribe(new SilenceSubscriber<List<SendGiftData>>() {
                    @Override
                    public void onNext(List<SendGiftData> list) {
                        listener.onSuccess(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure(e);
                    }
                });
    }

    @Override
    public void getSecondBannerList(final onGuideLoadDataListener listener) {
        NetWork.getApi().getJingXuanSecondBannerList(Constants.API_GENDER, Constants.API_GENERATION)
                .map(new ApiFun<SecondBannerBean<SendGiftData>>())
                .map(new Func1<ApiResponse<SecondBannerBean<SendGiftData>>, List<SendGiftData>>() {
                    @Override
                    public List<SendGiftData> call(ApiResponse<SecondBannerBean<SendGiftData>> sApi) {
                        List<SendGiftData> secondary_banners = sApi.data.secondary_banners;
                        if (secondary_banners == null)
                            secondary_banners = new ArrayList<>();
                        return secondary_banners;
                    }
                })
                .compose(NetworkTransformer.<List<SendGiftData>>commonSchedulers())
                .subscribe(new SilenceSubscriber<List<SendGiftData>>() {
                    @Override
                    public void onNext(List<SendGiftData> sendGiftDatas) {
                        listener.onSecondSuccess(sendGiftDatas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onSecondFail(e);
                    }
                });
    }


}