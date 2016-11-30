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

    private ArrayList<String> titles = new ArrayList<>();
    private int mTabPosition;
    private boolean scrollFlag;
    private boolean setTabFlag;


    @Override
    protected int setContentViewId() {
        return R.layout.fragment_sort_gift;
    }

    @Override
    protected void initListener() {
        vt_left.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                if (!scrollFlag) {
                    lv_right.setSelection(position);
                    mTabPosition = position;
                    setTabFlag = true;
                } else {
                    setTabFlag = false;
                }
            }

            @Override
            public void onTabReselected(TabView tab, int position) {
                if (!scrollFlag && lv_right.getSelectedItemPosition() != position) {
                    lv_right.setSelection(position);
                    mTabPosition = position;
                    setTabFlag = true;
                } else {
                    setTabFlag = false;
                }
            }
        });

    }

    @Override
    protected void initView(View view) {
        lv_right.setVerticalScrollBarEnabled(false);
        lv_right.setFastScrollEnabled(false);
        lv_right.setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void initData() {
        //这样最底部会有   已经加载完毕  的字样
        //        mvcHelper = new MVCNormalHelper<>(lv_right);

        mvcHelper = new MVCNormalHelper<>(lv_right, MVCHelper.loadViewFactory.madeLoadView(), null);
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

        //不能直接用lv_right的setOnScrollListener
        //由于MvcHelper已经设置，所以要一下操作
        ListView lv = mvcHelper.getContentView();
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                scrollFlag = scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (setTabFlag && !scrollFlag) {
                    //设置了Tab但是不是用户来滚动的
                    //lv_right.setSelection();这个方法会默认调用一次setOnScrollListener
                    //用个开关来控制,防止互相调用导致扑街
                    //也就是调用setSelection()这个方法避免调用setOnScrollListener
                    return;
                }

                if (firstVisibleItem > mTabPosition) {
                    //下滑
                    if (firstVisibleItem == totalItemCount - 2 && mTabPosition < titles.size()) {
                        mTabPosition = titles.size() - 1;
                        vt_left.setTabSelected(mTabPosition);
                        return;
                    } else {
                        mTabPosition = firstVisibleItem;
                        vt_left.setTabSelected(mTabPosition);
                    }
                }
                if (firstVisibleItem < mTabPosition) {
                    //上滑
                    mTabPosition = firstVisibleItem;
                    vt_left.setTabSelected(mTabPosition);
                }

                //                KLog.w("onScroll            " + firstVisibleItem + "      " + visibleItemCount + "   " + totalItemCount);
            }
        });
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
