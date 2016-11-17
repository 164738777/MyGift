package com.gift.mygift.ui.home;

import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.tools.ToastTool;
import com.gift.mygift.ui.base.BaseActivity;
import com.socks.library.KLog;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.home_radioGroup)
    RadioGroup radioGroup;
    @BindViews({R.id.rb_guide, R.id.rb_hot, R.id.rb_sort, R.id.rb_my})
    List<RadioButton> radioButtons;

    @BindView(R.id.home_toolbar)
    Toolbar toolbar;
    @BindView(R.id.home_toolbar_tv_title)
    TextView tv_title;
    @BindView(R.id.home_toolbar_cardview)
    CardView cardView;

    @BindView(R.id.home_toolbar_iv_calender)
    ImageView iv_calender;
    @BindView(R.id.home_toolbar_iv_search)
    ImageView iv_search;

    private FragmentController controller;
    private boolean isExit = false;
    private static Handler handler = new Handler();

    @Override
    protected int setContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setTab(checkedId);
            }
        });
    }

    @OnClick({R.id.home_toolbar_iv_calender, R.id.home_toolbar_iv_search})
    public void onCalender(View view) {
        switch (view.getId()) {
            case R.id.home_toolbar_iv_calender:
                KLog.w("home_toolbar_iv_calender");
                break;
            case R.id.home_toolbar_iv_search:
                KLog.w("home_toolbar_iv_search");
                break;
        }

    }

    /**
     * Frg切换的变化
     *
     * @param checkedId
     */
    private void setTab(int checkedId) {
        switch (checkedId) {
            case R.id.rb_guide:
            default:
                controller.showFrg(FragmentController.FRG_GUIDE);
                radioButtons.get(0).setChecked(true);
                toolbar.setVisibility(View.VISIBLE);
                tv_title.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.GONE);
                iv_calender.setVisibility(View.VISIBLE);
                tv_title.setText(getResources().getString(R.string.text_giftsay));
                break;
            case R.id.rb_hot:
                controller.showFrg(FragmentController.FRG_HOT);
                radioButtons.get(1).setChecked(true);
                toolbar.setVisibility(View.VISIBLE);
                tv_title.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.GONE);
                iv_calender.setVisibility(View.GONE);
                tv_title.setText(getResources().getString(R.string.text_hot));
                break;
            case R.id.rb_sort:
                controller.showFrg(FragmentController.FRG_SORT);
                radioButtons.get(2).setChecked(true);
                toolbar.setVisibility(View.VISIBLE);
                tv_title.setVisibility(View.GONE);
                cardView.setVisibility(View.VISIBLE);
                iv_calender.setVisibility(View.GONE);
                break;
            case R.id.rb_my:
                controller.showFrg(FragmentController.FRG_MY);
                radioButtons.get(3).setChecked(true);
                toolbar.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void initView() {

        setSupportActionBar(toolbar);

        controller = new FragmentController(this, R.id.home_container);
        setTab(R.id.rb_guide);
    }


    @Override
    protected void preRelease() {
        FragmentController.onDestroy();
    }

    @Override
    public void onBackPressed() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isExit = false;
            }
        }, 2000);
        if (!isExit) {
            isExit = true;
            ToastTool.show(this, R.string.exit_click_again);
        } else {
            finish();
        }
    }
}
