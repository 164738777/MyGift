package com.gift.mygift.ui.guide;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.SuperListAdapter;
import com.gift.mygift.adapter.base.SuperRcvAdapter;
import com.gift.mygift.adapter.guide.JingXuanBigImageItem;
import com.gift.mygift.adapter.guide.JingXuanSecondBannerItem;
import com.gift.mygift.constant.Constants;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.network.datasource.guide.JingXuanBigImageDS;
import com.gift.mygift.tools.GiftApp;
import com.gift.mygift.tools.TimeTool;
import com.gift.mygift.ui.base.ListWithUpAndDownFragment;
import com.gift.mygift.ui.guide.contract.JingXuanContract;
import com.gift.mygift.ui.guide.presenter.JingXuanPresenterImpl;
import com.shizhefei.mvc.IDataAdapter;
import com.shizhefei.mvc.MVCHelper;
import com.shizhefei.mvc.MVCUltraHelper;
import com.shizhefei.mvc.OnRefreshStateChangeListener;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/23 11:55
 * 邮箱:  anworkmail_q@126.com
 * 作用:  指南有Header的Frg(例如精选)
 */

public class JingXuanFragment extends ListWithUpAndDownFragment implements JingXuanContract.View {

    private BGABanner banner;
    private RecyclerView rcv;
    private List<SendGiftData> mSendGiftDatas;
    private JingXuanContract.Presenter mPresenter;


    public static JingXuanFragment newInstance() {
        return new JingXuanFragment();
    }


    private MVCHelper<List<SendGiftData>> mvcHelper;
    private SuperListAdapter<SendGiftData> mAdapter = new SuperListAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new JingXuanBigImageItem(mSendGiftDatas);
        }
    };

    private SuperRcvAdapter<SendGiftData> mSecondBannerAdapter = new SuperRcvAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new JingXuanSecondBannerItem();
        }
    };

    @Override
    protected void initView() {
/*        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcv_list.setLayoutManager(manager);*/

        mPresenter = new JingXuanPresenterImpl(this);

        initHeaderView();
    }

    private void initHeaderView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.head_jingxuan, null);
        banner = (BGABanner) v.findViewById(R.id.head_jingxuan_banner);
        rcv = (RecyclerView) v.findViewById(R.id.rcv_module_rcvlist);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcv.setLayoutManager(manager);
        rcv.setBackgroundColor(ContextCompat.getColor(GiftApp.getInstance(), R.color.white));
        lv_list.addHeaderView(v);
        rcv.setAdapter(mSecondBannerAdapter);
    }


    @Override
    public void onLoadSecondBanner(List<SendGiftData> SendGiftDatas) {
        mSecondBannerAdapter.notifyDataChanged(SendGiftDatas, true);
    }

    @Override
    protected void initData() {
        mvcHelper = new MVCUltraHelper<>(rl_list);
        mvcHelper.setDataSource(new JingXuanBigImageDS(Constants.API_CHANNEL_JINGXUAN));
        mvcHelper.setAdapter(mAdapter);
        mvcHelper.setOnStateChangeListener(new OnRefreshStateChangeListener<List<SendGiftData>>() {
            @Override
            public void onStartRefresh(IDataAdapter<List<SendGiftData>> adapter) {
                mPresenter.loadSecondBanner();
            }

            @Override
            public void onEndRefresh(IDataAdapter<List<SendGiftData>> adapter, List<SendGiftData> result) {
                mSendGiftDatas = result;
                if (mSendGiftDatas == null)
                    mSendGiftDatas = new ArrayList<>();
                else if (!mSendGiftDatas.isEmpty()) {
                    for (SendGiftData mSendGiftData : mSendGiftDatas) {
                        if (!TextUtils.isEmpty(mSendGiftData.timeText)) {
                            break;
                        } else {
                            switch (mSendGiftData.type) {
                                case Constants.RESPONSE_TYPE_POST:
                                    mSendGiftData.timeText = TimeTool.getTime1(mSendGiftData.published_at);
                                    break;
                                case Constants.RESPONSE_TYPE_AD:
                                    mSendGiftData.timeText = TimeTool.getTime1(mSendGiftData.start_at);
                                    break;
                            }
                        }
                    }
                }
            }
        });
        mvcHelper.refresh();
    }

    @Override
    protected void preRelease() {
        mvcHelper.destory();
    }
}
