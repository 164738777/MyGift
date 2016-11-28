package com.gift.mygift.entity;

import java.util.List;

/**
 * 作者:  qiang on 2016/11/27 21:27
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类礼物 List的Bean
 */

public class SortGiftList {

    public int id;
    public String name;
    public String icon_url;
    public int order;
    public int status;

    public List<SendGiftData> subcategories;
}
