package com.gift.mygift.ui.sort;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.SuperListAdapter;
import com.gift.mygift.adapter.sort.SortGiftListItem;
import com.gift.mygift.entity.SortGiftList;
import com.gift.mygift.network.datasource.sort.SortGiftDS;
import com.gift.mygift.tools.ToastTool;
import com.gift.mygift.ui.base.BaseFragment;
import com.shizhefei.mvc.IDataAdapter;
import com.shizhefei.mvc.MVCHelper;
import com.shizhefei.mvc.MVCNormalHelper;
import com.shizhefei.mvc.OnRefreshStateChangeListener;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import kale.adapter.item.AdapterItem;
import q.rorbin.verticaltablayout.TabAdapter;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * 作者:  qiang on 2016/11/25 11:33
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类里面的礼物Frg
 */

public class SortGiftFragment extends BaseFragment {

    //    @BindView(R.id.lv_sort_gift_left)
    //    ListView lv_left;
    @BindView(R.id.vt_sort_gift_left)
    VerticalTabLayout vt_left;
    @BindView(R.id.lv_module_list)
    ListView lv_right;

    private MVCHelper<List<SortGiftList>> mvcHelper;
    private SuperListAdapter<SortGiftList> mAdapter = new SuperListAdapter<SortGiftList>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new SortGiftListItem(getContext());
        }
    };

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_sort_gift;
    }

    @Override
    protected void initListener() {
        vt_left.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                lv_right.setSelection(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {
                if (lv_right.getSelectedItemPosition() != position) {
                    lv_right.setSelection(position);
                }
            }
        });

        lv_right.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                KLog.w("onScrollStateChanged        ");

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //                vt_left.setTabSelected(firstVisibleItem);
                KLog.w("onScroll        " + firstVisibleItem);
            }
        });
    }

    @Override
    protected void initView(View view) {
        lv_right.setVerticalScrollBarEnabled(false);
        lv_right.setFastScrollEnabled(false);
    }

    @Override
    protected void initData() {
        mvcHelper = new MVCNormalHelper<>(lv_right);
        mvcHelper.setDataSource(new SortGiftDS());
        mvcHelper.setAdapter(mAdapter);
        mvcHelper.setOnStateChangeListener(new OnRefreshStateChangeListener<List<SortGiftList>>() {
            @Override
            public void onStartRefresh(IDataAdapter<List<SortGiftList>> adapter) {

            }

            @Override
            public void onEndRefresh(IDataAdapter<List<SortGiftList>> adapter, List<SortGiftList> result) {
                if (result == null || result.isEmpty())
                    return;
                final ArrayList<String> titles = new ArrayList<>();
                for (SortGiftList sortGiftList : result) {
                    titles.add(sortGiftList.name);
                }
                vt_left.setTabAdapter(new TabAdapter() {
                    @Override
                    public int getCount() {
                        return titles.size();
                    }

                    @Override
                    public int getBadge(int position) {
                        return 0;
                    }

                    @Override
                    public QTabView.TabIcon getIcon(int position) {
                        return null;
                    }

                    @Override
                    public QTabView.TabTitle getTitle(int position) {
                        return new QTabView.TabTitle.Builder(getContext())
                                .setTextSize(14)
                                .setContent(titles.get(position))
                                .setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary), Color.BLACK)
                                .build();
                    }

                    @Override
                    public int getBackground(int position) {
                        return R.drawable.slct_sort_gift_tab;
                    }
                });
            }
        });
        mvcHelper.refresh();
    }

    @OnClick(R.id.ll_sort_gift_shenQi)
    public void onClick(View v) {
        ToastTool.show(getContext(), "ll_sort_gift_shenQi");
    }

    @Override
    protected void preRelease() {
        mvcHelper.destory();
    }
}
