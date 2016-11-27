package com.gift.mygift.entity;

import java.util.List;

/**
 * 作者:  qiang on 2016/11/27 21:27
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类攻略 小图List的Bean
 */

public class SortGongLueList {

    public int id;
    public String name;
    public int order;
    public int status;

    public List<SendGiftData> channels;
}
