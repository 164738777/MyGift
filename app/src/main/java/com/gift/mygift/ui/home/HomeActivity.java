package com.gift.mygift.ui.home;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
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

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.home_radioGroup)
    RadioGroup radioGroup;
    @BindViews({R.id.rb_guide, R.id.rb_hot, R.id.rb_sort, R.id.rb_my, R.id.home_toolbar_rb_gonglue, R.id.home_toolbar_rb_gift})
    List<RadioButton> radioButtons;

    @BindView(R.id.home_toolbar)
    Toolbar toolbar;
    @BindView(R.id.home_toolbar_tv_title)
    TextView tv_title;
    @BindView(R.id.home_toolbar_cardview)
    CardView cardView;

    @BindView(R.id.rg_main)
    RadioGroup rg_sort;

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
                setMainTab(checkedId);
            }
        });
        rg_sort.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setSortTab(checkedId);
            }
        });
    }

    @OnClick({R.id.home_toolbar_iv_calender, R.id.home_toolbar_iv_search})
    public void onImageClick(View view) {
        switch (view.getId()) {
            case R.id.home_toolbar_iv_calender:
                ToastTool.show(this, "home_toolbar_iv_calender");
                break;
            case R.id.home_toolbar_iv_search:
                ToastTool.show(this, "home_toolbar_iv_search");
                break;
        }

    }


    /**
     * Frg切换的变化
     *
     * @param checkedId
     */
    private void setMainTab(int checkedId) {
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
                //                controller.showFrg(FragmentController.FRG_SORT);
                //                controller.showFrg(FragmentController.FRG_SORT_GONGLUE);
                setSortTab(rg_sort.getCheckedRadioButtonId());
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

    /**
     * 分类Frg切换
     *
     * @param checkedId
     */
    private void setSortTab(int checkedId) {
        switch (checkedId) {
            case R.id.home_toolbar_rb_gonglue:
            default:
                controller.showFrg(FragmentController.FRG_SORT_GONGLUE);
                radioButtons.get(4).setChecked(true);
                radioButtons.get(4).setBackgroundColor(Color.WHITE);
                radioButtons.get(4).setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
                radioButtons.get(5).setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                radioButtons.get(5).setTextColor(Color.WHITE);
                break;
            case R.id.home_toolbar_rb_gift:
                controller.showFrg(FragmentController.FRG_SORT_GIFT);
                radioButtons.get(5).setChecked(true);
                radioButtons.get(5).setBackgroundColor(Color.WHITE);
                radioButtons.get(5).setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
                radioButtons.get(4).setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                radioButtons.get(4).setTextColor(Color.WHITE);
                break;
        }
    }

    @Override
    protected void initView() {

        setSupportActionBar(toolbar);

        controller = new FragmentController(this, R.id.home_container);
        setMainTab(R.id.rb_guide);
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
