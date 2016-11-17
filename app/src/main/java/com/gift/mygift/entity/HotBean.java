package com.gift.mygift.entity;

import java.util.List;

/**
 * 作者:  qiang on 2016/11/17 21:35
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public class HotBean {
    public List<HotListBean> items;
    public PagingBean paging;

    public class PagingBean{
        public String next_url;
    }
}
