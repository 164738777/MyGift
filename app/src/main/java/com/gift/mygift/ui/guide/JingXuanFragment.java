package com.gift.mygift.ui.guide;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.gift.mygift.adapter.base.SuperListAdapter;
import com.gift.mygift.adapter.guide.JingXuanBigImageItem;
import com.gift.mygift.constant.Constants;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.network.datasource.SendGiftDS;
import com.gift.mygift.tools.TimeTool;
import com.gift.mygift.ui.base.ListWithUpAndDownFragment;
import com.shizhefei.mvc.IDataAdapter;
import com.shizhefei.mvc.MVCHelper;
import com.shizhefei.mvc.MVCUltraHelper;
import com.shizhefei.mvc.OnRefreshStateChangeListener;

import java.util.ArrayList;
import java.util.List;

import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/23 11:55
 * 邮箱:  anworkmail_q@126.com
 * 作用:  指南有Header的Frg(例如精选)
 */

public class JingXuanFragment extends ListWithUpAndDownFragment {


    public static JingXuanFragment newInstance() {
        return new JingXuanFragment();
    }

    private List<SendGiftData> mSendGiftDatas;

    private MVCHelper<List<SendGiftData>> mvcHelper;
    private SuperListAdapter<SendGiftData> mAdapter = new SuperListAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new JingXuanBigImageItem(mSendGiftDatas);
        }
    };

    @Override
    protected void initView() {
/*        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcv_list.setLayoutManager(manager);*/

        mvcHelper = new MVCUltraHelper<>(rl_list);
        mvcHelper.setDataSource(new SendGiftDS(Constants.API_CHANNEL_JINGXUAN));
        mvcHelper.setAdapter(mAdapter);
        mvcHelper.setOnStateChangeListener(new OnRefreshStateChangeListener<List<SendGiftData>>() {
            @Override
            public void onStartRefresh(IDataAdapter<List<SendGiftData>> adapter) {

            }

            @Override
            public void onEndRefresh(IDataAdapter<List<SendGiftData>> adapter, List<SendGiftData> result) {
                mSendGiftDatas = result;
                if (mSendGiftDatas == null)
                    mSendGiftDatas = new ArrayList<>();
                else if(!mSendGiftDatas.isEmpty()){
                    for (SendGiftData mSendGiftData : mSendGiftDatas) {
                        if (!TextUtils.isEmpty(mSendGiftData.timeText)){
                            break;
                        }else{
                            mSendGiftData.timeText = TimeTool.getTime1(mSendGiftData.published_at);
                        }
                    }
                }
            }
        });
        mvcHelper.refresh();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void preRelease() {
        mvcHelper.destory();
    }
}
