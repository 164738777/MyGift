package com.gift.mygift.ui.my;

import android.support.annotation.IntDef;
import android.view.View;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.ui.base.BaseFragment;

import butterknife.BindView;

/**
 * 作者:  qiang on 2016/11/18 13:01
 * 邮箱:  anworkmail_q@126.com
 * 作用:  我的 页面里面的Frg
 */

public class MyContentFragment extends BaseFragment {

    public static final int GIFT = 0;
    public static final int GONGNUE = 1;

    @IntDef({GIFT,GONGNUE})
    public @interface FrgType{}

    @BindView(R.id.tv_my_content_text)
    TextView tv_text;


    private int frgType = 0;

    public static MyContentFragment newInstance(@FrgType int frgType){
        MyContentFragment fragment = new MyContentFragment();
        fragment.frgType = frgType;
        return fragment;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_my_content_withoutlogin;
    }

    @Override
    protected void initView(View view) {
        switch (frgType) {
            case GIFT:
                tv_text.setText(getResources().getText(R.string.my_tv_text_gift));
                break;
            case GONGNUE:
                tv_text.setText(getResources().getText(R.string.my_tv_text_gonglue));
                break;
        }

    }

    @Override
    protected void initData() {

    }
}
