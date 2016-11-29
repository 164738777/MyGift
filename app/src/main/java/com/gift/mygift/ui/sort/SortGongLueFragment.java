package com.gift.mygift.ui.sort;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.SuperListAdapter;
import com.gift.mygift.adapter.base.SuperRcvAdapter;
import com.gift.mygift.adapter.sort.SortGongLueListItem;
import com.gift.mygift.adapter.sort.SortGongLueZhuanTiItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.entity.SortGongLueList;
import com.gift.mygift.network.datasource.sort.SortGongLueDS;
import com.gift.mygift.tools.GiftApp;
import com.gift.mygift.tools.ToastTool;
import com.gift.mygift.ui.base.ListFragment;
import com.gift.mygift.ui.sort.contract.SortGongLueContract;
import com.gift.mygift.ui.sort.presenter.SortGongLuePresenterImpl;
import com.shizhefei.mvc.IDataAdapter;
import com.shizhefei.mvc.MVCHelper;
import com.shizhefei.mvc.MVCNormalHelper;
import com.shizhefei.mvc.OnRefreshStateChangeListener;

import java.util.List;

import butterknife.ButterKnife;
import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/25 11:33
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类里面的攻略Frg
 */

public class SortGongLueFragment extends ListFragment implements SortGongLueContract.View {


    private TextView tv_gongLue_seeAll;
    private RecyclerView rcv_zhuanTi;

    private MVCHelper<List<SortGongLueList>> mvcHelper;
    private SortGongLueContract.Presenter mPresenter;

    private SuperListAdapter<SortGongLueList> mAdapter = new SuperListAdapter<SortGongLueList>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new SortGongLueListItem(getContext());
        }
    };
    private SuperRcvAdapter<SendGiftData> mZhuanTiAdapter = new SuperRcvAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new SortGongLueZhuanTiItem();
        }
    };

    @Override
    protected void initView(View view) {
        mPresenter = new SortGongLuePresenterImpl(this);
        initHeaderView();
    }

    private void initHeaderView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.head_sort_gonglue, null);

        tv_gongLue_seeAll = ButterKnife.findById(v, R.id.tv_gongLue_seeAll);
        tv_gongLue_seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastTool.show(getContext(), "tv_gongLue_seeAll");
            }
        });

        rcv_zhuanTi = ButterKnife.findById(v, R.id.rcv_module_rcvlist);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcv_zhuanTi.setLayoutManager(manager);
        rcv_zhuanTi.setBackgroundColor(ContextCompat.getColor(GiftApp.getInstance(), R.color.white));
        rcv_zhuanTi.setAdapter(mZhuanTiAdapter);
        lv_list.addHeaderView(v);
    }


    @Override
    protected void initData() {
        mvcHelper = new MVCNormalHelper<>(lv_list, MVCHelper.loadViewFactory.madeLoadView(), null);
        mvcHelper.setDataSource(new SortGongLueDS());
        mvcHelper.setAdapter(mAdapter);
        mvcHelper.setOnStateChangeListener(new OnRefreshStateChangeListener<List<SortGongLueList>>() {
            @Override
            public void onStartRefresh(IDataAdapter<List<SortGongLueList>> adapter) {
                mPresenter.loadZhuanTiBanner();
            }

            @Override
            public void onEndRefresh(IDataAdapter<List<SortGongLueList>> adapter, List<SortGongLueList> result) {

            }
        });
        mvcHelper.refresh();

    }


    @Override
    public void loadZhuanTiBannerSuccess(List<SendGiftData> list) {
        mZhuanTiAdapter.notifyDataChanged(list, true);
    }

    @Override
    protected void preRelease() {
        mvcHelper.destory();
    }

}
