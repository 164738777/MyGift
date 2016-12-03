package com.gift.mygift.listener;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * 作者:  qiang on 2016/12/2 15:54
 * 邮箱:  anworkmail_q@126.com
 * 作用:  Rcv专用ItemClick监听器
 */

public abstract class OnRcvItemTouchListener implements RecyclerView.OnItemTouchListener {

    private GestureDetectorCompat mGestureDetectorCompat;
    private RecyclerView mRecyclerView;


    public abstract void onItemClick(View view, int position);

    public abstract void onLongItemClick(View view, int position);


    public OnRcvItemTouchListener(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mGestureDetectorCompat = new GestureDetectorCompat(mRecyclerView.getContext(),
                new RcvGestureListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        //拦截触摸事件
        mGestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        //处理触摸事件
        mGestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        //处理触摸冲突
    }


    private class RcvGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            //简单的点击屏幕时执行
            View childView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (childView != null) {
                onItemClick(childView, mRecyclerView.getChildAdapterPosition(childView));
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            //长按屏幕时执行
            View child = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (child != null) {
                onLongItemClick(child, mRecyclerView.getChildAdapterPosition(child));
            }
        }

    }
}
