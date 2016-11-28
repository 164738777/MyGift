package com.gift.mygift.ui.sort.presenter;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.ui.base.OnLoadDataListListener;
import com.gift.mygift.ui.sort.contract.SortGongLueContract;
import com.gift.mygift.ui.sort.model.SortGongLueModelImpl;

import java.util.List;

/**
* Created by MVPHelper on 2016/11/28
*/

public class SortGongLuePresenterImpl implements SortGongLueContract.Presenter,OnLoadDataListListener<List<SendGiftData>>{

    private SortGongLueContract.View mView;
    private SortGongLueModelImpl mModel;

    public SortGongLuePresenterImpl(SortGongLueContract.View mView) {
        this.mView = mView;
        mModel = new SortGongLueModelImpl();
    }

    @Override
    public void loadZhuanTiBanner() {
        mModel.getZhuanTiBanner(this);
    }

    @Override
    public void onSuccess(List<SendGiftData> data) {
        mView.loadZhuanTiBannerSuccess(data);
    }

    @Override
    public void onFailure(Throwable e) {

    }

}