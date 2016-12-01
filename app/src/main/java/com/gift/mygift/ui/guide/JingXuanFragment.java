package com.gift.mygift.ui.guide;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.SuperListAdapter;
import com.gift.mygift.adapter.base.SuperRcvAdapter;
import com.gift.mygift.adapter.guide.JingXuanBigImageItem;
import com.gift.mygift.adapter.guide.JingXuanSecondBannerItem;
import com.gift.mygift.constant.Constants;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.network.datasource.guide.JingXuanBigImageDS;
import com.gift.mygift.tools.GiftApp;
import com.gift.mygift.tools.ImageTool;
import com.gift.mygift.tools.ToastTool;
import com.gift.mygift.ui.base.ListWithUpAndDownFragment;
import com.gift.mygift.ui.guide.contract.JingXuanContract;
import com.gift.mygift.ui.guide.presenter.JingXuanPresenterImpl;
import com.shizhefei.mvc.IDataAdapter;
import com.shizhefei.mvc.MVCHelper;
import com.shizhefei.mvc.MVCUltraHelper;
import com.shizhefei.mvc.OnStateChangeListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
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
    private JingXuanContract.Presenter mPresenter;


    public static JingXuanFragment newInstance() {
        return new JingXuanFragment();
    }


    private MVCHelper<List<SendGiftData>> mvcHelper;
    private SuperListAdapter<SendGiftData> mAdapter = new SuperListAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new JingXuanBigImageItem(getContext());
        }
    };

    private SuperRcvAdapter<SendGiftData> mSecondBannerAdapter = new SuperRcvAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new JingXuanSecondBannerItem();
        }
    };

    private List<SendGiftData> firstBannerList = new ArrayList<>();

    @Override
    protected void initView(View view) {

        mPresenter = new JingXuanPresenterImpl(this);

        initHeaderView();
    }

    private void initHeaderView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.head_jingxuan, null);

        banner = ButterKnife.findById(v, R.id.head_jingxuan_banner);
        banner.setAdapter(new BGABanner.Adapter() {
            @Override
            public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                ImageTool.loadImage((ImageView) view, model.toString());
            }
        });
        banner.setOnItemClickListener(new BGABanner.OnItemClickListener() {
            @Override
            public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
                if (firstBannerList != null && !firstBannerList.isEmpty()) {
                    SendGiftData sendGiftData = firstBannerList.get(position);
                    ToastTool.show(getContext(), sendGiftData.id + "");
                }
            }
        });


        rcv = ButterKnife.findById(v, R.id.rcv_module_rcvlist);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcv.setLayoutManager(manager);
        rcv.setBackgroundColor(ContextCompat.getColor(GiftApp.getInstance(), R.color.white));
        rcv.setAdapter(mSecondBannerAdapter);


        lv_list.addHeaderView(v);
    }

    @Override
    protected void initListener() {
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position - lv_list.getHeaderViewsCount();
                if (pos < 0) {
                    return;
                }
                SendGiftData sendGiftData = mAdapter.getData().get(pos);
                ToastTool.show(getContext(), sendGiftData.id + "");
            }
        });
    }

    @Override
    public void onLoadFirstBanner(List<SendGiftData> SendGiftDatas) {
        firstBannerList = SendGiftDatas;
        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        for (SendGiftData sendGiftData : SendGiftDatas) {
            path.add(sendGiftData.image_url);
            titles.add(sendGiftData.title);
        }
        banner.setData(path, titles);
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
        mvcHelper.setOnStateChangeListener(new OnStateChangeListener<List<SendGiftData>>() {
            @Override
            public void onStartLoadMore(IDataAdapter<List<SendGiftData>> adapter) {

            }

            @Override
            public void onEndLoadMore(IDataAdapter<List<SendGiftData>> adapter, List<SendGiftData> result) {
                if (GiftApp.getInstance().sendGiftDataList == null)
                    GiftApp.getInstance().sendGiftDataList = new ArrayList<>();
                if (result != null && !result.isEmpty())
                    GiftApp.getInstance().sendGiftDataList.addAll(result);
            }

            @Override
            public void onStartRefresh(IDataAdapter<List<SendGiftData>> adapter) {
                mPresenter.loadFirstBanner();
                mPresenter.loadSecondBanner();
            }

            @Override
            public void onEndRefresh(IDataAdapter<List<SendGiftData>> adapter, List<SendGiftData> result) {
                if (result == null)
                    result = new ArrayList<>();
                GiftApp.getInstance().sendGiftDataList = result;
            }
        });
        mvcHelper.refresh();
    }

    @Override
    protected void preRelease() {
        mvcHelper.destory();
    }
}
