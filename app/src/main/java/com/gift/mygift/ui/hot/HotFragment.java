package com.gift.mygift.ui.hot;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.SuperRcvAdapter;
import com.gift.mygift.adapter.hot.HotItem;
import com.gift.mygift.entity.HotListBean;
import com.gift.mygift.network.datasource.HotDS;
import com.gift.mygift.ui.base.BaseFragment;
import com.shizhefei.mvc.MVCHelper;
import com.shizhefei.mvc.MVCUltraHelper;

import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/16 14:39
 * 邮箱:  anworkmail_q@126.com
 * 作用:  热门Frg
 */

public class HotFragment extends BaseFragment {

    @BindView(R.id.rcv_module_list)
    RecyclerView rcv_list;
    @BindView(R.id.rl_module_list)
    PtrClassicFrameLayout rl_list;

    private MVCHelper<List<HotListBean>> mvcHelper;
    private SuperRcvAdapter<HotListBean> mAdapter = new SuperRcvAdapter<HotListBean>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new HotItem();
        }
    };

    @Override
    protected int setContentViewId() {
        return R.layout.module_list;
    }

    @Override
    protected void initView() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        rcv_list.setLayoutManager(manager);

        mvcHelper = new MVCUltraHelper<>(rl_list);
        mvcHelper.setDataSource(new HotDS());
        mvcHelper.setAdapter(mAdapter);
        mvcHelper.refresh();
    }

    @Override
    protected void preRelease() {
        mvcHelper.destory();
    }
}
