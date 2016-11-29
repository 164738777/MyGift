package com.gift.mygift.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.utils.SizeUtils;
import com.gift.mygift.R;
import com.gift.mygift.tools.ToastTool;
import com.shizhefei.mvc.ILoadViewFactory;
import com.shizhefei.view.vary.VaryViewHelper;

import butterknife.ButterKnife;


/**
 * Author: Andecy;
 * Time: 2016/4/20;
 * Email: Andecy@foxmail.com;
 * Description: MvcHelper的加载中视图
 */
public class LoadViewFactory implements ILoadViewFactory {


    @Override
    public ILoadMoreView madeLoadMoreView() {
        return new LoadMoreHelper();
    }

    @Override
    public ILoadView madeLoadView() {
        return new LoadViewHelper();
    }

    private class LoadMoreHelper implements ILoadMoreView {

        TextView footView;

        View.OnClickListener onClickRefreshListener;

        @Override
        public void init(FootViewAdder footViewHolder, View.OnClickListener onClickRefreshListener) {
            View contentView = footViewHolder.getContentView();
            Context context = contentView.getContext();
            TextView textView = new TextView(context);
            textView.setTextColor(Color.GRAY);
            textView.setPadding(0, SizeUtils.dp2px(context, 16), 0, SizeUtils.dp2px(context, 16));
            textView.setGravity(Gravity.CENTER);
            footViewHolder.addFootView(textView);

            footView = textView;
            this.onClickRefreshListener = onClickRefreshListener;
            showNormal();
        }

        @Override
        public void showNormal() {
            footView.setText("点击加载更多");
            footView.setOnClickListener(onClickRefreshListener);
        }

        @Override
        public void showLoading() {
            footView.setText("正在加载中..");
            footView.setOnClickListener(null);
        }

        @Override
        public void showFail(Exception exception) {
            footView.setText("加载失败，点击重新加载");
            footView.setOnClickListener(onClickRefreshListener);
        }

        @Override
        public void showNomore() {
            footView.setText("已经加载完毕");
            footView.setOnClickListener(null);
        }

    }

    private class LoadViewHelper implements ILoadView {
        private VaryViewHelper helper;
        private View.OnClickListener onClickRefreshListener;
        private Context context;

        @Override
        public void init(View switchView, View.OnClickListener onClickRefreshListener) {
            this.context = switchView.getContext().getApplicationContext();
            this.onClickRefreshListener = onClickRefreshListener;
            helper = new VaryViewHelper(switchView);
        }

        @Override
        public void restore() {
            helper.restoreView();
        }

        @Override
        public void showLoading() {

            View loadingView = helper.inflate(R.layout.loading);

            ImageView iv = ButterKnife.findById(loadingView, R.id.iv_loading);

            //QiangBug 加载久了会有时间差值问题
            AnimationDrawable animationDrawable = (AnimationDrawable) iv.getDrawable();
            animationDrawable.start();

            //        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_loading_set);
            //        iv.startAnimation(animation);

            ScaleAnimation animation = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(1500);
            animation.setRepeatCount(Animation.INFINITE);
            iv.startAnimation(animation);

            helper.showLayout(loadingView);
        }

        @Override
        public void tipFail(Exception exception) {
            ToastTool.show(context, "网络加载失败");
        }

        @Override
        public void showFail(Exception exception) {
            View failView = helper.inflate(R.layout.empty);
            TextView tv = ButterKnife.findById(failView, R.id.tv_empty);
            tv.setText("出现错误哦,点我重新加载");
            failView.setOnClickListener(onClickRefreshListener);
            helper.showLayout(failView);

            /*
            SpannableString spannableString = new SpannableString("点击重试");
            spannableString.setSpan(new ForegroundColorSpan(x.app().getResources().getColor(R.color.primary)) {
                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(true);
                }
            }, spannableString.length() - 4, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
           */
        }

        @Override
        public void showEmpty() {
            View failView = helper.inflate(R.layout.empty);
            TextView tv = ButterKnife.findById(failView, R.id.tv_empty);
            tv.setText("木有东西哦,点我刷新再试试");
            failView.setOnClickListener(onClickRefreshListener);
            helper.showLayout(failView);
        }
    }

}
