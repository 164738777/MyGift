package com.gift.mygift.ui.home;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gift.mygift.R;
import com.gift.mygift.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;

public class HomeActivity extends BaseActivity {

    private FragmentController controller;

    @BindView(R.id.home_radioGroup)
    RadioGroup radioGroup;
    @BindViews({R.id.rb_guide, R.id.rb_hot, R.id.rb_sort, R.id.rb_my})
    List<RadioButton> radioButtons;

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

    private void setTab(int checkedId) {
        switch (checkedId) {
            case R.id.rb_guide:
            default:
                controller.showFrg(FragmentController.FRG_GUIDE);
                radioButtons.get(0).setChecked(true);
                break;
            case R.id.rb_hot:
                controller.showFrg(FragmentController.FRG_HOT);
                radioButtons.get(1).setChecked(true);
                break;
            case R.id.rb_sort:
                controller.showFrg(FragmentController.FRG_SORT);
                radioButtons.get(2).setChecked(true);
                break;
            case R.id.rb_my:
                controller.showFrg(FragmentController.FRG_MY);
                radioButtons.get(3).setChecked(true);
                break;
        }
    }

    @Override
    protected void initView() {
        controller = new FragmentController(this, R.id.home_container);
        setTab(R.id.rb_guide);
    }


    @Override
    protected void preRelease() {
        FragmentController.onDestroy();
    }
}
