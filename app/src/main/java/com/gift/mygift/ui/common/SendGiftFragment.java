package com.gift.mygift.ui.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gift.mygift.adapter.base.SuperRcvAdapter;
import com.gift.mygift.adapter.common.SendGiftItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.listener.OnRcvItemTouchListener;
import com.gift.mygift.network.datasource.SendGiftDS;
import com.gift.mygift.tools.ToastTool;
import com.gift.mygift.ui.base.RcvWithUpAndDownFragment;
import com.shizhefei.mvc.MVCHelper;
import com.shizhefei.mvc.MVCUltraHelper;

import java.util.List;

import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/23 11:58
 * 邮箱:  anworkmail_q@126.com
 * 作用:  各种送的Frg(例如送女票...)
 */

public class SendGiftFragment extends RcvWithUpAndDownFragment {

    private int channelID;

    public static SendGiftFragment newInstance(int channelID) {
        SendGiftFragment fragment = new SendGiftFragment();
        fragment.channelID = channelID;
        return fragment;
    }

    private MVCHelper<List<SendGiftData>> mvcHelper;
    private SuperRcvAdapter<SendGiftData> mAdapter = new SuperRcvAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new SendGiftItem();
        }
    };

    @Override
    protected void initView(View view) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcv_list.setHasFixedSize(true);
        rcv_list.setLayoutManager(manager);

        mvcHelper = new MVCUltraHelper<>(rl_list);
        mvcHelper.setDataSource(new SendGiftDS(channelID));
        mvcHelper.setAdapter(mAdapter);
        RecyclerView contentView = mvcHelper.getContentView();
        contentView.addOnItemTouchListener(new OnRcvItemTouchListener(contentView) {
            @Override
            public void onItemClick(View view, int position) {
                SendGiftData sendGiftData = mAdapter.getData().get(position);
                ToastTool.show(getContext(),sendGiftData.id+"");
            }

            @Override
            public void onLongItemClick(View view, int position) {
                ToastTool.show(getContext(),"onLongItemClick~~~~~~~~~");
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
