package com.gift.mygift.adapter.base;

import com.shizhefei.mvc.IDataAdapter;

import java.util.List;

import kale.adapter.CommonAdapter;

/**
 * Author: Andecy;
 * Time: 2016/4/19;
 * Email: Andecy@foxmail.com;
 * Description: 通用ListView /GridView 的 Adapter，搭配kaleItem和mvcHelper使用
 */
public abstract class SuperListAdapter<T> extends CommonAdapter<T> implements IDataAdapter<List<T>> {


    protected SuperListAdapter(int viewTypeCount) {
        super(null, viewTypeCount);

    }

    protected SuperListAdapter() {
        super(null, 1);
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

}
