package com.gift.mygift.adapter.base;

import com.shizhefei.mvc.IDataAdapter;

import java.util.List;

import kale.adapter.CommonRcvAdapter;


/**
 * 作者:  qiang on 2016/11/17 16:14
 * 邮箱:  anworkmail_q@126.com
 * 作用:  通用RecyclerView的 Adapter，搭配kaleItem和mvcHelper使用
 */

public abstract class SuperRcvAdapter<T> extends CommonRcvAdapter<T> implements IDataAdapter<List<T>> {

/*    public SuperRcvAdapter(@Nullable List<T> data) {
        super(data);
    }*/


    protected SuperRcvAdapter() {
        super(null);
    }


    public void update(List<T> data) {
        if (data != null) {
            setData(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public void notifyDataChanged(List<T> ts, boolean isRefresh) {
        if (isRefresh) {
            getData().clear();
        }
        getData().addAll(ts);
        notifyDataSetChanged();
    }

    @Override
    public boolean isEmpty() {
        return getItemCount() == 0;
    }
}
