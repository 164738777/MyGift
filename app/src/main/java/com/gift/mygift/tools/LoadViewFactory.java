package com.gift.mygift.tools;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.shizhefei.mvc.ILoadViewFactory;
import com.shizhefei.view.vary.VaryViewHelperXV;

/**
 * Author: Andecy;
 * Time: 2016/4/20;
 * Email: Andecy@foxmail.com;
 * Description: MvcHelper的加载中视图
 */
public class LoadViewFactory implements ILoadViewFactory {

    public LoadViewFactory() {
    }

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
            textView.setPadding(0, dip2px(context, 16), 0, dip2px(context, 16));
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
        private VaryViewHelperXV helper;
        private View.OnClickListener onClickRefreshListener;
        private Context context;

        @Override
        public void init(View switchView, View.OnClickListener onClickRefreshListener) {
            this.context = switchView.getContext().getApplicationContext();
            this.onClickRefreshListener = onClickRefreshListener;
            helper = new VaryViewHelperXV(switchView);
        }

        @Override
        public void restore() {
            helper.restoreView();
        }

        @Override
        public void showLoading() {
            Context context = helper.getContext();
            //            View loadingView = View.inflate(context, R.layout.loading, null);
            //            ((TextView) loadingView.findViewById(R.id.tv_loading)).setText("拼命加载中...");
            //            helper.showLayout(loadingView);
        }

        @Override
        public void tipFail(Exception exception) {
            ToastTool.show(context, "网络加载失败");
        }

        @Override
        public void showFail(Exception exception) {
            Context context = helper.getContext();
            //            View failView = View.inflate(context, R.layout.empty, null);
            SpannableString spannableString = new SpannableString("点击重试");
/*            spannableString.setSpan(new ForegroundColorSpan(GiftApp.getInstance().getResources().getColor(R.color.primary)) {
                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(true);
                }
            }, spannableString.length() - 4, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/

            //            ((TextView) failView.findViewById(R.id.tv_empty)).setText(spannableString);
            //            ((ImageView) failView.findViewById(R.id.iv_empty)).setImageResource(R.mipmap.ic_empty_net);
            //            failView.findViewById(R.id.ll_empty).setOnClickListener(onClickRefreshListener);
            //            helper.showLayout(failView);
        }

        @Override
        public void showEmpty() {
            Context context = helper.getContext();
            //            View emptyView = View.inflate(context, R.layout.empty, null);
            //            ((TextView) emptyView.findViewById(R.id.tv_empty)).setText("暂无内容");
            //            ((ImageView) emptyView.findViewById(R.id.iv_empty)).setImageResource(R.mipmap.ic_empty);
            //            emptyView.findViewById(R.id.ll_empty).setOnClickListener(onClickRefreshListener);
            //            helper.showLayout(emptyView);
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
