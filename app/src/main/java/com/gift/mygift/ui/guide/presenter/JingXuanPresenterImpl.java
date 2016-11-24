package com.gift.mygift.ui.guide.presenter;

import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.ui.guide.contract.JingXuanContract;
import com.gift.mygift.ui.guide.model.JingXuanModelImpl;
import com.gift.mygift.ui.guide.onGuideLoadDataListener;

import java.util.List;

/**
* Created by MVPHelper on 2016/11/24
*/

public class JingXuanPresenterImpl implements JingXuanContract.Presenter, onGuideLoadDataListener {

    private JingXuanContract.View mView;
    private JingXuanModelImpl mModel;

    public JingXuanPresenterImpl(JingXuanContract.View mView) {
        this.mView = mView;
        mModel = new JingXuanModelImpl();
    }


    @Override
    public void loadFirstBanner() {
        mModel.getFirstBannerList(this);
    }

    @Override
    public void onSuccess(List<SendGiftData> data) {
        mView.onLoadFirstBanner(data);
    }

    @Override
    public void onFailure(Throwable e) {

    }


    @Override
    public void loadSecondBanner() {
        mModel.getSecondBannerList(this);
    }

    @Override
    public void onSecondSuccess(List<SendGiftData> list) {
        mView.onLoadSecondBanner(list);
    }

    @Override
    public void onSecondFail(Throwable e) {

    }
}