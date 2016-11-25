package com.gift.mygift.ui.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.gift.mygift.R;
import com.gift.mygift.constant.Constants;
import com.gift.mygift.ui.base.BaseFragment;
import com.gift.mygift.ui.common.SendGiftFragment;
import com.socks.library.KLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者:  qiang on 2016/11/16 14:39
 * 邮箱:  anworkmail_q@126.com
 * 作用:  指南Frg
 */

public class GuideFragment extends BaseFragment {

    @BindView(R.id.sl_guide)
    SlidingTabLayout sl_guide;
    @BindView(R.id.vp_guide)
    ViewPager vp_guide;

    private ArrayList<String> titles;
    private ArrayList<Integer> channelIDs;

    private FragmentStatePagerAdapter mAdapter;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_guide;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        titles = new ArrayList<>();
        titles.add("精选");
        titles.add("海淘");
        titles.add("送女票");
        titles.add("创意生活");
        titles.add("送基友");
        titles.add("送爸妈");
        channelIDs = new ArrayList<>();
        channelIDs.add(Constants.API_CHANNEL_NVPIAO);
        channelIDs.add(Constants.API_CHANNEL_HAITAO);
        channelIDs.add(Constants.API_CHANNEL_CHUANGYISHENGHUO);
        channelIDs.add(Constants.API_CHANNEL_JIYOU);
        channelIDs.add(Constants.API_CHANNEL_BAMA);
    }

    @Override
    protected void setView() {
        mAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position==0)
                    return JingXuanFragment.newInstance();
                else
                    return SendGiftFragment.newInstance(channelIDs.get(position-1));
            }

            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        };
        vp_guide.setAdapter(mAdapter);
        sl_guide.setViewPager(vp_guide);
    }

    @OnClick(R.id.iv_guide_arrow)
    public void onImageClick(View view) {
        switch (view.getId()) {
            case R.id.iv_guide_arrow:
                KLog.w("iv_guide_arrow");
                break;
        }
    }
}
