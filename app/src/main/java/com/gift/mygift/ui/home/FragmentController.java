package com.gift.mygift.ui.home;

import android.support.annotation.IntDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gift.mygift.ui.guide.GuideFragment;
import com.gift.mygift.ui.hot.HotFragment;
import com.gift.mygift.ui.my.MyFragment;
import com.gift.mygift.ui.sort.SortFragment;
import com.gift.mygift.ui.sort.SortGiftFragment;
import com.gift.mygift.ui.sort.SortGongLueFragment;

import java.util.ArrayList;

/**
 * 作者:  qiang on 2016/11/16 14:31
 * 邮箱:  anworkmail_q@126.com
 * 作用:  Frg中控,用于控制首页的4个Frg页面切换
 */

public class FragmentController {

    private int containerId;
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;

    private FragmentTransaction tran;

    public static final int FRG_GUIDE = 0;
    public static final int FRG_HOT = 1;
    public static final int FRG_SORT = 2;
    public static final int FRG_MY = 3;

    /*分类里面的2个Frg*/
    public static final int FRG_SORT_GONGLUE = 4;
    public static final int FRG_SORT_GIFT = 5;


    @IntDef({FRG_GUIDE, FRG_HOT, FRG_SORT, FRG_MY,FRG_SORT_GIFT,FRG_SORT_GONGLUE})
    private @interface FrgPosition {
    }

    private static FragmentController controller;

    public static FragmentController getInstance(FragmentActivity activity, int containerId) {
        if (controller != null) {
            controller = new FragmentController(activity, containerId);
        }
        return controller;
    }

    public FragmentController(FragmentActivity activity, int containerId) {
        this.containerId = containerId;
        manager = activity.getSupportFragmentManager();
        initFrgList();
    }

    public static void onDestroy() {
        controller = null;
    }

    private void initFrgList() {
        fragments = new ArrayList<>();
        fragments.add(new GuideFragment());
        fragments.add(new HotFragment());
        fragments.add(new SortFragment());
        fragments.add(new MyFragment());
        fragments.add(new SortGongLueFragment());
        fragments.add(new SortGiftFragment());

        tran = manager.beginTransaction();
        for (Fragment fragment : fragments) {
            tran.add(containerId, fragment);
        }
        tran.commit();
        //        tran.commitAllowingStateLoss();
    }

    public void showFrg(@FrgPosition int position) {
        hideFrgs();
        Fragment fragment = fragments.get(position);
        tran.show(fragment);
        tran.commit();
        //        tran.commitAllowingStateLoss();
    }

    /**
     * 隐藏Frg,在show前调用
     */
    private void hideFrgs() {
        tran = manager.beginTransaction();
        for (Fragment fragment : fragments) {
            tran.hide(fragment);
        }
    }
}
