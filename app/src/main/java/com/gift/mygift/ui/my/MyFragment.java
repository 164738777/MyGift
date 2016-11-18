package com.gift.mygift.ui.my;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.gift.mygift.R;
import com.gift.mygift.ui.base.BaseFragment;
import com.socks.library.KLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import static com.gift.mygift.R.id.iv_my_setting;

/**
 * 作者:  qiang on 2016/11/16 14:39
 * 邮箱:  anworkmail_q@126.com
 * 作用:  我的Frg
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.rg_my)
    RadioGroup mRadioGroup;
    @BindView(R.id.sl_my)
    SlidingTabLayout mSliding;
    @BindView(R.id.vp_my)
    ViewPager mViewPager;

    private ArrayList<String> mTitles;
    private FragmentStatePagerAdapter mFrgAdapter;


    @Override
    protected int setContentViewId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_my_shopcar:
                        KLog.w("rb_my_shopcar");
                        break;
                    case R.id.rb_my_shoplist:
                        KLog.w("rb_my_shoplist");
                        break;
                    case R.id.rb_my_coupon:
                        KLog.w("rb_my_coupon");
                        break;
                    case R.id.rb_my_service:
                        KLog.w("rb_my_service");
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
        mTitles = new ArrayList<>();
        mTitles.add("礼物");
        mTitles.add("攻略");

        initViewPager(mTitles);
    }

    private void initViewPager(final ArrayList<String> list) {
        final ArrayList<MyContentFragment> fragments = new ArrayList<>();
        if (fragments.isEmpty()) {
            fragments.add(MyContentFragment.newInstance(MyContentFragment.GIFT));
            fragments.add(MyContentFragment.newInstance(MyContentFragment.GONGNUE));
        }
        mFrgAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        };
        mViewPager.setAdapter(mFrgAdapter);
        mSliding.setViewPager(mViewPager);
    }


    @OnClick({R.id.iv_my_message, iv_my_setting, R.id.iv_my_scan, R.id.iv_my_user})
    public void onImageClick(View view) {
        switch (view.getId()) {
            case R.id.iv_my_message:
                KLog.w("iv_my_message");
                break;
            case R.id.iv_my_setting:
                KLog.w("iv_my_setting");
                break;
            case R.id.iv_my_scan:
                KLog.w("iv_my_scan");
                break;
            case R.id.iv_my_user:
                KLog.w("iv_my_user");
                break;
        }
    }
}
